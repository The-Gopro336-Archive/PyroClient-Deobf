/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class feh {
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   public BlockPos field_1360;
   // $FF: renamed from: c net.minecraft.util.EnumFacing
   public EnumFacing field_1361;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_1362;
   // $FF: renamed from: c dev.nuker.pyro.fex
   public fex field_1363 = null;

   public feh(BlockPos var1, EnumFacing var2) {
      this.field_1360 = var1;
      this.field_1361 = var2;
      this.field_1362 = new Vec3d((double)var1.getX() + 0.5D, (double)var1.getY() + 0.5D, (double)var1.getZ() + 0.5D);
   }

   public feh(BlockPos var1, EnumFacing var2, Vec3d var3, fex var4) {
      this.field_1360 = var1;
      this.field_1361 = var2;
      this.field_1362 = var3;
      this.field_1363 = var4;
   }

   // $FF: renamed from: 2 () net.minecraft.util.math.BlockPos
   public BlockPos method_2038() {
      return this.field_1360;
   }

   // $FF: renamed from: 0 () net.minecraft.util.EnumFacing
   public EnumFacing method_2039() {
      return this.field_1361;
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) dev.nuker.pyro.feh
   public static feh method_2040(BlockPos var0) {
      if (feg.method_1780(var0.add(0, -1, 0))) {
         return new feh(var0.add(0, -1, 0), EnumFacing.UP);
      } else if (feg.method_1780(var0.add(-1, 0, 0))) {
         return new feh(var0.add(-1, 0, 0), EnumFacing.EAST);
      } else if (feg.method_1780(var0.add(1, 0, 0))) {
         return new feh(var0.add(1, 0, 0), EnumFacing.WEST);
      } else if (feg.method_1780(var0.add(0, 0, -1))) {
         return new feh(var0.add(0, 0, -1), EnumFacing.SOUTH);
      } else {
         return feg.method_1780(var0.add(0, 0, 1)) ? new feh(var0.add(0, 0, 1), EnumFacing.NORTH) : null;
      }
   }

   // $FF: renamed from: c () net.minecraft.util.math.Vec3d
   public Vec3d method_2041() {
      return this.field_1362;
   }

   public feh(BlockPos var1, EnumFacing var2, Vec3d var3) {
      this.field_1360 = var1;
      this.field_1361 = var2;
      this.field_1362 = var3;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.fex
   public fex method_2042() {
      return this.field_1363;
   }
}
