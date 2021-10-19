package com.sun.jna.win32;

import com.sun.jna.Function;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import com.sun.jna.Pointer;
import java.lang.reflect.Method;

public class StdCallFunctionMapper implements FunctionMapper {
   protected int getArgumentNativeStackSize(Class cls) {
      if (NativeMapped.class.isAssignableFrom(cls)) {
         cls = NativeMappedConverter.getInstance(cls).nativeType();
      }

      if (cls.isArray()) {
         return Pointer.SIZE;
      } else {
         try {
            return Native.getNativeSize(cls);
         } catch (IllegalArgumentException var3) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + cls);
         }
      }
   }

   public String getFunctionName(NativeLibrary library, Method method) {
      String name = method.getName();
      int pop = 0;
      Class[] argTypes = method.getParameterTypes();
      Class[] var6 = argTypes;
      int var7 = argTypes.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         Class cls = var6[var8];
         pop += this.getArgumentNativeStackSize(cls);
      }

      String decorated = name + "@" + pop;
      byte conv = 63;

      try {
         Function func = library.getFunction(decorated, conv);
         name = func.getName();
      } catch (UnsatisfiedLinkError var11) {
         try {
            Function func = library.getFunction("_" + decorated, conv);
            name = func.getName();
         } catch (UnsatisfiedLinkError var10) {
         }
      }

      return name;
   }
}
