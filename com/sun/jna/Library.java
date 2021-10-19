package com.sun.jna;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public interface Library {
   String OPTION_TYPE_MAPPER = "type-mapper";
   String OPTION_FUNCTION_MAPPER = "function-mapper";
   String OPTION_INVOCATION_MAPPER = "invocation-mapper";
   String OPTION_STRUCTURE_ALIGNMENT = "structure-alignment";
   String OPTION_STRING_ENCODING = "string-encoding";
   String OPTION_ALLOW_OBJECTS = "allow-objects";
   String OPTION_CALLING_CONVENTION = "calling-convention";
   String OPTION_OPEN_FLAGS = "open-flags";
   String OPTION_CLASSLOADER = "classloader";

   public static class Handler implements InvocationHandler {
      static final Method OBJECT_TOSTRING;
      static final Method OBJECT_HASHCODE;
      static final Method OBJECT_EQUALS;
      private final NativeLibrary nativeLibrary;
      private final Class interfaceClass;
      private final Map options;
      private final InvocationMapper invocationMapper;
      private final Map functions = new WeakHashMap();

      public Handler(String libname, Class interfaceClass, Map options) {
         if (libname != null && "".equals(libname.trim())) {
            throw new IllegalArgumentException("Invalid library name \"" + libname + "\"");
         } else if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException(libname + " does not implement an interface: " + interfaceClass.getName());
         } else {
            this.interfaceClass = interfaceClass;
            this.options = new HashMap(options);
            int callingConvention = AltCallingConvention.class.isAssignableFrom(interfaceClass) ? 63 : 0;
            if (this.options.get("calling-convention") == null) {
               this.options.put("calling-convention", callingConvention);
            }

            if (this.options.get("classloader") == null) {
               this.options.put("classloader", interfaceClass.getClassLoader());
            }

            this.nativeLibrary = NativeLibrary.getInstance(libname, this.options);
            this.invocationMapper = (InvocationMapper)this.options.get("invocation-mapper");
         }
      }

      public NativeLibrary getNativeLibrary() {
         return this.nativeLibrary;
      }

      public String getLibraryName() {
         return this.nativeLibrary.getName();
      }

      public Class getInterfaceClass() {
         return this.interfaceClass;
      }

      public Object invoke(Object proxy, Method method, Object[] inArgs) throws Throwable {
         if (OBJECT_TOSTRING.equals(method)) {
            return "Proxy interface to " + this.nativeLibrary;
         } else if (OBJECT_HASHCODE.equals(method)) {
            return this.hashCode();
         } else if (OBJECT_EQUALS.equals(method)) {
            Object o = inArgs[0];
            return o != null && Proxy.isProxyClass(o.getClass()) ? Function.valueOf(Proxy.getInvocationHandler(o) == this) : Boolean.FALSE;
         } else {
            Library.Handler.FunctionInfo f = (Library.Handler.FunctionInfo)this.functions.get(method);
            if (f == null) {
               synchronized(this.functions) {
                  f = (Library.Handler.FunctionInfo)this.functions.get(method);
                  if (f == null) {
                     boolean isVarArgs = Function.isVarArgs(method);
                     InvocationHandler handler = null;
                     if (this.invocationMapper != null) {
                        handler = this.invocationMapper.getInvocationHandler(this.nativeLibrary, method);
                     }

                     Function function = null;
                     Class[] parameterTypes = null;
                     Map options = null;
                     if (handler == null) {
                        function = this.nativeLibrary.getFunction(method.getName(), method);
                        parameterTypes = method.getParameterTypes();
                        options = new HashMap(this.options);
                        options.put("invoking-method", method);
                     }

                     f = new Library.Handler.FunctionInfo(handler, function, parameterTypes, isVarArgs, options);
                     this.functions.put(method, f);
                  }
               }
            }

            if (f.isVarArgs) {
               inArgs = Function.concatenateVarArgs(inArgs);
            }

            return f.handler != null ? f.handler.invoke(proxy, method, inArgs) : f.function.invoke(method, f.parameterTypes, method.getReturnType(), inArgs, f.options);
         }
      }

      static {
         try {
            OBJECT_TOSTRING = Object.class.getMethod("toString");
            OBJECT_HASHCODE = Object.class.getMethod("hashCode");
            OBJECT_EQUALS = Object.class.getMethod("equals", Object.class);
         } catch (Exception var1) {
            throw new Error("Error retrieving Object.toString() method");
         }
      }

      private static final class FunctionInfo {
         final InvocationHandler handler;
         final Function function;
         final boolean isVarArgs;
         final Map options;
         final Class[] parameterTypes;

         FunctionInfo(InvocationHandler handler, Function function, Class[] parameterTypes, boolean isVarArgs, Map options) {
            this.handler = handler;
            this.function = function;
            this.isVarArgs = isVarArgs;
            this.options = options;
            this.parameterTypes = parameterTypes;
         }
      }
   }
}
