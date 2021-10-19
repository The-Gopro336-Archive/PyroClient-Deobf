package com.sun.jna;

import java.lang.reflect.Method;

abstract class VarArgsChecker {
   private VarArgsChecker() {
   }

   static VarArgsChecker create() {
      try {
         Method isVarArgsMethod = Method.class.getMethod("isVarArgs");
         return (VarArgsChecker)(isVarArgsMethod != null ? new VarArgsChecker.RealVarArgsChecker() : new VarArgsChecker.NoVarArgsChecker());
      } catch (NoSuchMethodException var1) {
         return new VarArgsChecker.NoVarArgsChecker();
      } catch (SecurityException var2) {
         return new VarArgsChecker.NoVarArgsChecker();
      }
   }

   abstract boolean isVarArgs(Method var1);

   abstract int fixedArgs(Method var1);

   // $FF: synthetic method
   VarArgsChecker(Object x0) {
      this();
   }

   private static final class NoVarArgsChecker extends VarArgsChecker {
      private NoVarArgsChecker() {
         super(null);
      }

      boolean isVarArgs(Method m) {
         return false;
      }

      int fixedArgs(Method m) {
         return 0;
      }

      // $FF: synthetic method
      NoVarArgsChecker(Object x0) {
         this();
      }
   }

   private static final class RealVarArgsChecker extends VarArgsChecker {
      private RealVarArgsChecker() {
         super(null);
      }

      boolean isVarArgs(Method m) {
         return m.isVarArgs();
      }

      int fixedArgs(Method m) {
         return m.isVarArgs() ? m.getParameterTypes().length - 1 : 0;
      }

      // $FF: synthetic method
      RealVarArgsChecker(Object x0) {
         this();
      }
   }
}
