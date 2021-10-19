package com.sun.jna;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface Callback {
   String METHOD_NAME = "callback";
   List FORBIDDEN_NAMES = Collections.unmodifiableList(Arrays.asList("hashCode", "equals", "toString"));

   public interface UncaughtExceptionHandler {
      void uncaughtException(Callback var1, Throwable var2);
   }
}
