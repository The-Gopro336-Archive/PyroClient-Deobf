/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.security;

import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

public class UnsafeSecurity$checkLaunchFlags$1 implements Predicate {
   public String $flag;

   public boolean test(@Nullable String s) {
      CharSequence var10000 = (CharSequence)this.$flag;
      if (s == null) {
         Intrinsics.throwNpe();
      }

      return StringsKt.contains$default(var10000, (CharSequence)s, false, 2, (Object)null);
   }

   public UnsafeSecurity$checkLaunchFlags$1(String var1) {
      this.$flag = var1;
      super();
   }

   public boolean test(Object var1) {
      return this.test((String)var1);
   }
}
