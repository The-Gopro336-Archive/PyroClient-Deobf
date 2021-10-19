/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

public class f4z extends f40 {
   // $FF: renamed from: c float
   public float field_2100;

   public f4z(@NotNull AxisAlignedBB var1, float var2, @NotNull f41 var3) {
      super(var1, var3);
      this.field_2100 = var2;
   }

   // $FF: renamed from: c () float
   public float method_3184() {
      return this.field_2100;
   }

   // $FF: renamed from: c (float) void
   public void method_3185(float var1) {
      this.field_2100 = var1;
   }
}
