package com.sun.jna;

import com.sun.jna.win32.DLLCallback;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class CallbackReference extends WeakReference {
   static final Map callbackMap = new WeakHashMap();
   static final Map directCallbackMap = new WeakHashMap();
   static final Map pointerCallbackMap = new WeakHashMap();
   static final Map allocations = new WeakHashMap();
   private static final Map allocatedMemory = Collections.synchronizedMap(new WeakHashMap());
   private static final Method PROXY_CALLBACK_METHOD;
   private static final Map initializers;
   Pointer cbstruct;
   Pointer trampoline;
   CallbackProxy proxy;
   Method method;
   int callingConvention;

   static CallbackThreadInitializer setCallbackThreadInitializer(Callback cb, CallbackThreadInitializer initializer) {
      synchronized(initializers) {
         return initializer != null ? (CallbackThreadInitializer)initializers.put(cb, initializer) : (CallbackThreadInitializer)initializers.remove(cb);
      }
   }

   private static ThreadGroup initializeThread(Callback cb, CallbackReference.AttachOptions args) {
      CallbackThreadInitializer init = null;
      if (cb instanceof CallbackReference.DefaultCallbackProxy) {
         cb = ((CallbackReference.DefaultCallbackProxy)cb).getCallback();
      }

      synchronized(initializers) {
         init = (CallbackThreadInitializer)initializers.get(cb);
      }

      ThreadGroup group = null;
      if (init != null) {
         group = init.getThreadGroup(cb);
         args.name = init.getName(cb);
         args.daemon = init.isDaemon(cb);
         args.detach = init.detach(cb);
         args.write();
      }

      return group;
   }

   public static Callback getCallback(Class type, Pointer p) {
      return getCallback(type, p, false);
   }

   private static Callback getCallback(Class type, Pointer p, boolean direct) {
      if (p == null) {
         return null;
      } else if (!type.isInterface()) {
         throw new IllegalArgumentException("Callback type must be an interface");
      } else {
         Map map = direct ? directCallbackMap : callbackMap;
         synchronized(pointerCallbackMap) {
            Callback cb = null;
            Reference ref = (Reference)pointerCallbackMap.get(p);
            if (ref != null) {
               cb = (Callback)ref.get();
               if (cb != null && !type.isAssignableFrom(cb.getClass())) {
                  throw new IllegalStateException("Pointer " + p + " already mapped to " + cb + ".\nNative code may be re-using a default function pointer, in which case you may need to use a common Callback class wherever the function pointer is reused.");
               } else {
                  return cb;
               }
            } else {
               int ctype = AltCallingConvention.class.isAssignableFrom(type) ? 63 : 0;
               Map foptions = new HashMap(Native.getLibraryOptions(type));
               foptions.put("invoking-method", getCallbackMethod(type));
               CallbackReference.NativeFunctionHandler h = new CallbackReference.NativeFunctionHandler(p, ctype, foptions);
               cb = (Callback)Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, h);
               map.remove(cb);
               pointerCallbackMap.put(p, new WeakReference(cb));
               return cb;
            }
         }
      }
   }

   private CallbackReference(Callback callback, int callingConvention, boolean direct) {
      super(callback);
      TypeMapper mapper = Native.getTypeMapper(callback.getClass());
      this.callingConvention = callingConvention;
      boolean ppc = Platform.isPPC();
      if (direct) {
         Method m = getCallbackMethod(callback);
         Class[] ptypes = m.getParameterTypes();

         for(int i = 0; i < ptypes.length; ++i) {
            if (ppc && (ptypes[i] == Float.TYPE || ptypes[i] == Double.TYPE)) {
               direct = false;
               break;
            }

            if (mapper != null && mapper.getFromNativeConverter(ptypes[i]) != null) {
               direct = false;
               break;
            }
         }

         if (mapper != null && mapper.getToNativeConverter(m.getReturnType()) != null) {
            direct = false;
         }
      }

      String encoding = Native.getStringEncoding(callback.getClass());
      long peer = 0L;
      Class[] nativeParamTypes;
      Class returnType;
      int flags;
      if (direct) {
         this.method = getCallbackMethod(callback);
         nativeParamTypes = this.method.getParameterTypes();
         returnType = this.method.getReturnType();
         flags = 1;
         if (callback instanceof DLLCallback) {
            flags |= 2;
         }

         peer = Native.createNativeCallback(callback, this.method, nativeParamTypes, returnType, callingConvention, flags, encoding);
      } else {
         if (callback instanceof CallbackProxy) {
            this.proxy = (CallbackProxy)callback;
         } else {
            this.proxy = new CallbackReference.DefaultCallbackProxy(getCallbackMethod(callback), mapper, encoding);
         }

         nativeParamTypes = this.proxy.getParameterTypes();
         returnType = this.proxy.getReturnType();
         if (mapper != null) {
            for(flags = 0; flags < nativeParamTypes.length; ++flags) {
               FromNativeConverter rc = mapper.getFromNativeConverter(nativeParamTypes[flags]);
               if (rc != null) {
                  nativeParamTypes[flags] = rc.nativeType();
               }
            }

            ToNativeConverter tn = mapper.getToNativeConverter(returnType);
            if (tn != null) {
               returnType = tn.nativeType();
            }
         }

         for(flags = 0; flags < nativeParamTypes.length; ++flags) {
            nativeParamTypes[flags] = this.getNativeType(nativeParamTypes[flags]);
            if (!isAllowableNativeType(nativeParamTypes[flags])) {
               String msg = "Callback argument " + nativeParamTypes[flags] + " requires custom type conversion";
               throw new IllegalArgumentException(msg);
            }
         }

         returnType = this.getNativeType(returnType);
         if (!isAllowableNativeType(returnType)) {
            String msg = "Callback return type " + returnType + " requires custom type conversion";
            throw new IllegalArgumentException(msg);
         }

         flags = callback instanceof DLLCallback ? 2 : 0;
         peer = Native.createNativeCallback(this.proxy, PROXY_CALLBACK_METHOD, nativeParamTypes, returnType, callingConvention, flags, encoding);
      }

      this.cbstruct = peer != 0L ? new Pointer(peer) : null;
      allocatedMemory.put(this, new WeakReference(this));
   }

   private Class getNativeType(Class cls) {
      if (Structure.class.isAssignableFrom(cls)) {
         Structure.validate(cls);
         if (!Structure.ByValue.class.isAssignableFrom(cls)) {
            return Pointer.class;
         }
      } else {
         if (NativeMapped.class.isAssignableFrom(cls)) {
            return NativeMappedConverter.getInstance(cls).nativeType();
         }

         if (cls == String.class || cls == WString.class || cls == String[].class || cls == WString[].class || Callback.class.isAssignableFrom(cls)) {
            return Pointer.class;
         }
      }

      return cls;
   }

   private static Method checkMethod(Method m) {
      if (m.getParameterTypes().length > 256) {
         String msg = "Method signature exceeds the maximum parameter count: " + m;
         throw new UnsupportedOperationException(msg);
      } else {
         return m;
      }
   }

   static Class findCallbackClass(Class type) {
      if (!Callback.class.isAssignableFrom(type)) {
         throw new IllegalArgumentException(type.getName() + " is not derived from com.sun.jna.Callback");
      } else if (type.isInterface()) {
         return type;
      } else {
         Class[] ifaces = type.getInterfaces();
         int i = 0;

         while(true) {
            if (i < ifaces.length) {
               if (!Callback.class.isAssignableFrom(ifaces[i])) {
                  ++i;
                  continue;
               }

               try {
                  getCallbackMethod(ifaces[i]);
                  return ifaces[i];
               } catch (IllegalArgumentException var4) {
               }
            }

            if (Callback.class.isAssignableFrom(type.getSuperclass())) {
               return findCallbackClass(type.getSuperclass());
            }

            return type;
         }
      }
   }

   private static Method getCallbackMethod(Callback callback) {
      return getCallbackMethod(findCallbackClass(callback.getClass()));
   }

   private static Method getCallbackMethod(Class cls) {
      Method[] pubMethods = cls.getDeclaredMethods();
      Method[] classMethods = cls.getMethods();
      Set pmethods = new HashSet(Arrays.asList(pubMethods));
      pmethods.retainAll(Arrays.asList(classMethods));
      Iterator i = pmethods.iterator();

      while(i.hasNext()) {
         Method m = (Method)i.next();
         if (Callback.FORBIDDEN_NAMES.contains(m.getName())) {
            i.remove();
         }
      }

      Method[] methods = (Method[])pmethods.toArray(new Method[pmethods.size()]);
      if (methods.length == 1) {
         return checkMethod(methods[0]);
      } else {
         for(int i = 0; i < methods.length; ++i) {
            Method m = methods[i];
            if ("callback".equals(m.getName())) {
               return checkMethod(m);
            }
         }

         String msg = "Callback must implement a single public method, or one public method named 'callback'";
         throw new IllegalArgumentException(msg);
      }
   }

   private void setCallbackOptions(int options) {
      this.cbstruct.setInt((long)Pointer.SIZE, options);
   }

   public Pointer getTrampoline() {
      if (this.trampoline == null) {
         this.trampoline = this.cbstruct.getPointer(0L);
      }

      return this.trampoline;
   }

   protected void finalize() {
      this.dispose();
   }

   protected synchronized void dispose() {
      if (this.cbstruct != null) {
         try {
            Native.freeNativeCallback(this.cbstruct.peer);
         } finally {
            this.cbstruct.peer = 0L;
            this.cbstruct = null;
            allocatedMemory.remove(this);
         }
      }

   }

   static void disposeAll() {
      Collection refs = new LinkedList(allocatedMemory.keySet());
      Iterator var1 = refs.iterator();

      while(var1.hasNext()) {
         CallbackReference r = (CallbackReference)var1.next();
         r.dispose();
      }

   }

   private Callback getCallback() {
      return (Callback)this.get();
   }

   private static Pointer getNativeFunctionPointer(Callback cb) {
      if (Proxy.isProxyClass(cb.getClass())) {
         Object handler = Proxy.getInvocationHandler(cb);
         if (handler instanceof CallbackReference.NativeFunctionHandler) {
            return ((CallbackReference.NativeFunctionHandler)handler).getPointer();
         }
      }

      return null;
   }

   public static Pointer getFunctionPointer(Callback cb) {
      return getFunctionPointer(cb, false);
   }

   private static Pointer getFunctionPointer(Callback cb, boolean direct) {
      Pointer fp = null;
      if (cb == null) {
         return null;
      } else if ((fp = getNativeFunctionPointer(cb)) != null) {
         return fp;
      } else {
         Map options = Native.getLibraryOptions(cb.getClass());
         int callingConvention = cb instanceof AltCallingConvention ? 63 : (options != null && options.containsKey("calling-convention") ? (Integer)options.get("calling-convention") : 0);
         Map map = direct ? directCallbackMap : callbackMap;
         synchronized(pointerCallbackMap) {
            CallbackReference cbref = (CallbackReference)map.get(cb);
            if (cbref == null) {
               cbref = new CallbackReference(cb, callingConvention, direct);
               map.put(cb, cbref);
               pointerCallbackMap.put(cbref.getTrampoline(), new WeakReference(cb));
               if (initializers.containsKey(cb)) {
                  cbref.setCallbackOptions(1);
               }
            }

            return cbref.getTrampoline();
         }
      }
   }

   private static boolean isAllowableNativeType(Class cls) {
      return cls == Void.TYPE || cls == Void.class || cls == Boolean.TYPE || cls == Boolean.class || cls == Byte.TYPE || cls == Byte.class || cls == Short.TYPE || cls == Short.class || cls == Character.TYPE || cls == Character.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Double.TYPE || cls == Double.class || Structure.ByValue.class.isAssignableFrom(cls) && Structure.class.isAssignableFrom(cls) || Pointer.class.isAssignableFrom(cls);
   }

   private static Pointer getNativeString(Object value, boolean wide) {
      if (value != null) {
         NativeString ns = new NativeString(value.toString(), wide);
         allocations.put(value, ns);
         return ns.getPointer();
      } else {
         return null;
      }
   }

   static {
      try {
         PROXY_CALLBACK_METHOD = CallbackProxy.class.getMethod("callback", Object[].class);
      } catch (Exception var1) {
         throw new Error("Error looking up CallbackProxy.callback() method");
      }

      initializers = new WeakHashMap();
   }

   private static class NativeFunctionHandler implements InvocationHandler {
      private final Function function;
      private final Map options;

      public NativeFunctionHandler(Pointer address, int callingConvention, Map options) {
         this.options = options;
         this.function = new Function(address, callingConvention, (String)options.get("string-encoding"));
      }

      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         if (Library.Handler.OBJECT_TOSTRING.equals(method)) {
            String str = "Proxy interface to " + this.function;
            Method m = (Method)this.options.get("invoking-method");
            Class cls = CallbackReference.findCallbackClass(m.getDeclaringClass());
            str = str + " (" + cls.getName() + ")";
            return str;
         } else if (Library.Handler.OBJECT_HASHCODE.equals(method)) {
            return this.hashCode();
         } else if (Library.Handler.OBJECT_EQUALS.equals(method)) {
            Object o = args[0];
            return o != null && Proxy.isProxyClass(o.getClass()) ? Function.valueOf(Proxy.getInvocationHandler(o) == this) : Boolean.FALSE;
         } else {
            if (Function.isVarArgs(method)) {
               args = Function.concatenateVarArgs(args);
            }

            return this.function.invoke(method.getReturnType(), args, this.options);
         }
      }

      public Pointer getPointer() {
         return this.function;
      }
   }

   private class DefaultCallbackProxy implements CallbackProxy {
      private final Method callbackMethod;
      private ToNativeConverter toNative;
      private final FromNativeConverter[] fromNative;
      private final String encoding;

      public DefaultCallbackProxy(Method callbackMethod, TypeMapper mapper, String encoding) {
         this.callbackMethod = callbackMethod;
         this.encoding = encoding;
         Class[] argTypes = callbackMethod.getParameterTypes();
         Class returnType = callbackMethod.getReturnType();
         this.fromNative = new FromNativeConverter[argTypes.length];
         if (NativeMapped.class.isAssignableFrom(returnType)) {
            this.toNative = NativeMappedConverter.getInstance(returnType);
         } else if (mapper != null) {
            this.toNative = mapper.getToNativeConverter(returnType);
         }

         for(int i = 0; i < this.fromNative.length; ++i) {
            if (NativeMapped.class.isAssignableFrom(argTypes[i])) {
               this.fromNative[i] = new NativeMappedConverter(argTypes[i]);
            } else if (mapper != null) {
               this.fromNative[i] = mapper.getFromNativeConverter(argTypes[i]);
            }
         }

         if (!callbackMethod.isAccessible()) {
            try {
               callbackMethod.setAccessible(true);
            } catch (SecurityException var8) {
               throw new IllegalArgumentException("Callback method is inaccessible, make sure the interface is public: " + callbackMethod);
            }
         }

      }

      public Callback getCallback() {
         return CallbackReference.this.getCallback();
      }

      private Object invokeCallback(Object[] args) {
         Class[] paramTypes = this.callbackMethod.getParameterTypes();
         Object[] callbackArgs = new Object[args.length];

         for(int ix = 0; ix < args.length; ++ix) {
            Class type = paramTypes[ix];
            Object arg = args[ix];
            if (this.fromNative[ix] != null) {
               FromNativeContext context = new CallbackParameterContext(type, this.callbackMethod, args, ix);
               callbackArgs[ix] = this.fromNative[ix].fromNative(arg, context);
            } else {
               callbackArgs[ix] = this.convertArgument(arg, type);
            }
         }

         Object result = null;
         Callback cb = this.getCallback();
         if (cb != null) {
            try {
               result = this.convertResult(this.callbackMethod.invoke(cb, callbackArgs));
            } catch (IllegalArgumentException var8) {
               Native.getCallbackExceptionHandler().uncaughtException(cb, var8);
            } catch (IllegalAccessException var9) {
               Native.getCallbackExceptionHandler().uncaughtException(cb, var9);
            } catch (InvocationTargetException var10) {
               Native.getCallbackExceptionHandler().uncaughtException(cb, var10.getTargetException());
            }
         }

         for(int i = 0; i < callbackArgs.length; ++i) {
            if (callbackArgs[i] instanceof Structure && !(callbackArgs[i] instanceof Structure.ByValue)) {
               ((Structure)callbackArgs[i]).autoWrite();
            }
         }

         return result;
      }

      public Object callback(Object[] args) {
         try {
            return this.invokeCallback(args);
         } catch (Throwable var3) {
            Native.getCallbackExceptionHandler().uncaughtException(this.getCallback(), var3);
            return null;
         }
      }

      private Object convertArgument(Object value, Class dstType) {
         if (value instanceof Pointer) {
            if (dstType == String.class) {
               value = ((Pointer)value).getString(0L, this.encoding);
            } else if (dstType == WString.class) {
               value = new WString(((Pointer)value).getWideString(0L));
            } else if (dstType == String[].class) {
               value = ((Pointer)value).getStringArray(0L, this.encoding);
            } else if (dstType == WString[].class) {
               value = ((Pointer)value).getWideStringArray(0L);
            } else if (Callback.class.isAssignableFrom(dstType)) {
               value = CallbackReference.getCallback(dstType, (Pointer)value);
            } else if (Structure.class.isAssignableFrom(dstType)) {
               Structure s;
               if (Structure.ByValue.class.isAssignableFrom(dstType)) {
                  s = Structure.newInstance(dstType);
                  byte[] buf = new byte[s.size()];
                  ((Pointer)value).read(0L, (byte[])buf, 0, buf.length);
                  s.getPointer().write(0L, (byte[])buf, 0, buf.length);
                  s.read();
                  value = s;
               } else {
                  s = Structure.newInstance(dstType, (Pointer)value);
                  s.conditionalAutoRead();
                  value = s;
               }
            }
         } else if ((Boolean.TYPE == dstType || Boolean.class == dstType) && value instanceof Number) {
            value = Function.valueOf(((Number)value).intValue() != 0);
         }

         return value;
      }

      private Object convertResult(Object value) {
         if (this.toNative != null) {
            value = this.toNative.toNative(value, new CallbackResultContext(this.callbackMethod));
         }

         if (value == null) {
            return null;
         } else {
            Class cls = value.getClass();
            if (Structure.class.isAssignableFrom(cls)) {
               return Structure.ByValue.class.isAssignableFrom(cls) ? value : ((Structure)value).getPointer();
            } else if (cls != Boolean.TYPE && cls != Boolean.class) {
               if (cls != String.class && cls != WString.class) {
                  if (cls != String[].class && cls != WString.class) {
                     return Callback.class.isAssignableFrom(cls) ? CallbackReference.getFunctionPointer((Callback)value) : value;
                  } else {
                     StringArray sa = cls == String[].class ? new StringArray((String[])((String[])value), this.encoding) : new StringArray((WString[])((WString[])value));
                     CallbackReference.allocations.put(value, sa);
                     return sa;
                  }
               } else {
                  return CallbackReference.getNativeString(value, cls == WString.class);
               }
            } else {
               return Boolean.TRUE.equals(value) ? Function.INTEGER_TRUE : Function.INTEGER_FALSE;
            }
         }
      }

      public Class[] getParameterTypes() {
         return this.callbackMethod.getParameterTypes();
      }

      public Class getReturnType() {
         return this.callbackMethod.getReturnType();
      }
   }

   static class AttachOptions extends Structure {
      public static final List FIELDS = createFieldsOrder(new String[]{"daemon", "detach", "name"});
      public boolean daemon;
      public boolean detach;
      public String name;

      AttachOptions() {
         this.setStringEncoding("utf8");
      }

      protected List getFieldOrder() {
         return FIELDS;
      }
   }
}
