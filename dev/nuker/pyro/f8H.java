/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class f8H implements Predicate {
   // $FF: renamed from: c dev.nuker.pyro.f8J
   public f8J field_1840;

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public boolean method_3017(@NotNull Entity var1) {
      return this.field_1840.method_619(var1);
   }

   public f8H(f8J var1) {
      this.field_1840 = var1;
      super();
   }

   public boolean test(Object var1) {
      return this.method_3017((Entity)var1);
   }
}
