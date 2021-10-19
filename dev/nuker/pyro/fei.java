/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.RayTraceResult.Type;

public class fei extends fdZ {
   // $FF: renamed from: c dev.nuker.pyro.Rotation
   public Rotation field_1213 = null;
   // $FF: renamed from: c dev.nuker.pyro.feh
   public feh field_1214 = null;

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, boolean, boolean) boolean
   public boolean method_1745(BlockPos var1, boolean var2, boolean var3) {
      if (!feg.method_1790(var1)) {
         return false;
      } else {
         Vec3d var4 = new Vec3d(c.player.posX, c.player.getEntityBoundingBox().minY + (double)c.player.getEyeHeight(), c.player.posZ);
         fer var5 = null;
         EnumFacing[] var6 = EnumFacing.values();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            EnumFacing var9 = var6[var8];
            BlockPos var10 = var1.offset(var9);
            if (feg.method_1780(var10)) {
               Vec3d var11 = new Vec3d(var9.getDirectionVec());

               for(double var12 = 0.1D; var12 < 0.9D; var12 += 0.1D) {
                  for(double var14 = 0.1D; var14 < 0.9D; var14 += 0.1D) {
                     for(double var16 = 0.1D; var16 < 0.9D; var16 += 0.1D) {
                        Vec3d var18 = (new Vec3d(var1)).addVector(var12, var14, var16);
                        double var19 = var4.squareDistanceTo(var18);
                        Vec3d var21 = var18.add(new Vec3d(var11.x * 0.5D, var11.y * 0.5D, var11.z * 0.5D));
                        if (!var2 || !(var4.squareDistanceTo(var21) > 18.0D) && !(var19 > var4.squareDistanceTo(var18.add(var11))) && c.world.rayTraceBlocks(var4, var21, false, true, false) == null) {
                           double var22 = var21.x - var4.x;
                           double var24 = var21.y - var4.y;
                           double var26 = var21.z - var4.z;
                           double var28 = (double)MathHelper.sqrt(var22 * var22 + var26 * var26);
                           Rotation var30 = new Rotation(MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(var26, var22)) - 90.0F), MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(var24, var28)))));
                           Vec3d var31 = few.method_1716().method_1714(var30);
                           Vec3d var32 = var4.addVector(var31.x * 4.0D, var31.y * 4.0D, var31.z * 4.0D);
                           if (!var3) {
                              RayTraceResult var33 = c.world.rayTraceBlocks(var4, var32, false, false, true);
                              if (var33.typeOfHit != Type.BLOCK || !var33.getBlockPos().equals(var10)) {
                                 continue;
                              }
                           }

                           if (var5 == null || few.method_1716().method_1739(var30) < few.method_1716().method_1739(var5.method_2070())) {
                              var5 = new fer(new feh(var10, var9.getOpposite(), var21), var30);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (var5 == null) {
            return false;
         } else {
            this.field_1213 = var5.method_2070();
            this.field_1214 = var5.method_2071();
            return true;
         }
      }
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, boolean, boolean) void
   public void method_1746(BlockPos var1, boolean var2, boolean var3) {
      if (feg.method_1790(var1) && !this.method_1745(var1, !var3, var3)) {
         if (var2) {
            if (!feg.method_1780(var1)) {
               for(int var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if (this.method_1745(var1.add(var4, 0, var5), !var3, var3)) {
                        return;
                     }
                  }
               }

            }
         }
      }
   }
}
