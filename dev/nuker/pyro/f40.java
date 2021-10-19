/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

public class f40 extends f42 {
   // $FF: renamed from: c net.minecraft.util.math.AxisAlignedBB
   @NotNull
   public AxisAlignedBB field_2099;

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB) void
   public void method_3182(@NotNull AxisAlignedBB var1) {
      this.field_2099 = var1;
   }

   public f40(@NotNull AxisAlignedBB var1, @NotNull f41 var2) {
      super(var2);
      this.field_2099 = var1;
   }

   // $FF: renamed from: c () net.minecraft.util.math.AxisAlignedBB
   @NotNull
   public AxisAlignedBB method_3183() {
      return this.field_2099;
   }
}
