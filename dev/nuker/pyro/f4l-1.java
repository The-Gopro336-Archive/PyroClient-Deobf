/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class f4l extends f42 {
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_2077;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   public EnumFacing field_2078;

   // $FF: renamed from: 0 () net.minecraft.util.EnumFacing
   public EnumFacing method_3147() {
      return this.field_2078;
   }

   // $FF: renamed from: c () net.minecraft.util.math.BlockPos
   public BlockPos method_3148() {
      return this.field_2077;
   }

   public f4l(f41 var1, BlockPos var2, EnumFacing var3) {
      super(var1);
      this.field_2077 = var2;
      this.field_2078 = var3;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) void
   public void method_3149(BlockPos var1) {
      this.field_2077 = var1;
   }

   // $FF: renamed from: c (net.minecraft.util.EnumFacing) void
   public void method_3150(EnumFacing var1) {
      this.field_2078 = var1;
   }
}
