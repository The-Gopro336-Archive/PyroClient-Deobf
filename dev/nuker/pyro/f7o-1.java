/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class f7o implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.f7o
   public static f7o field_1849 = new f7o();

   // $FF: renamed from: c (java.util.Map.Entry) boolean
   public boolean method_3020(@NotNull Entry var1) {
      return System.currentTimeMillis() - ((f7j)var1.getValue()).method_3023() > TimeUnit.SECONDS.toMillis(30L);
   }

   public boolean test(Object var1) {
      return this.method_3020((Entry)var1);
   }
}
