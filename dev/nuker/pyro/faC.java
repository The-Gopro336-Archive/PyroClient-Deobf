/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class faC extends far {
   // $FF: renamed from: c double
   public double field_1195 = 0.2873D;
   // $FF: renamed from: c int
   public int field_1196 = 1;
   // $FF: renamed from: 0 double
   public double field_1197 = 0.0D;
   // $FF: renamed from: 0 int
   public int field_1198;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = c.player.posX - c.player.prevPosX;
         double var4 = c.player.posZ - c.player.prevPosZ;
         this.field_1197 = Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   public void meth0() {
      this.field_1195 = 0.2873D;
      this.field_1197 = 0.0D;
      this.field_1195 = 0.0D;
      this.field_1196 = 4;
      this.field_1198 = 0;
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB) net.minecraft.block.Block
   public Block method_1698(AxisAlignedBB var1) {
      for(int var2 = MathHelper.floor(var1.minX); var2 < MathHelper.floor(var1.maxX) + 1; ++var2) {
         for(int var3 = MathHelper.floor(var1.minZ); var3 < MathHelper.floor(var1.maxZ) + 1; ++var3) {
            Block var4 = c.world.getBlockState(new BlockPos(var2, (int)var1.minY, var3)).getBlock();
            if (var4 != null) {
               return var4;
            }
         }
      }

      return null;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      if (var1.c() == f41.field_2120 && !(Boolean)PyroStatic.field_2473.c.method_3034() && !var1.c()) {
         if (fec.method_1758()) {
            var1.0();
            ++this.field_1198;
            this.field_1198 %= 5;
            EntityPlayerSP var10000;
            if (this.field_1198 != 0) {
               f0b.field_2415.method_3669("speedhax");
            } else if (fec.method_1773()) {
               if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                  f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.09F);
               }

               var10000 = c.player;
               var10000.motionX *= 1.0199999809265137D;
               var10000 = c.player;
               var10000.motionZ *= 1.0199999809265137D;
            }

            if (c.player.onGround && fec.method_1773()) {
               this.field_1196 = 2;
            }

            if (this.method_1699(c.player.posY - (double)((int)c.player.posY)) == this.method_1699(0.138D)) {
               var10000 = c.player;
               var10000.motionY -= 0.08D;
               var1.method_3120(var1.method_3119() - 0.09316090325960147D);
               var10000 = c.player;
               var10000.posY -= 0.09316090325960147D;
            }

            if (this.field_1196 != 1 || c.player.moveForward == 0.0F && c.player.moveStrafing == 0.0F) {
               if (this.field_1196 == 2) {
                  this.field_1196 = 3;
                  c.player.motionY = 0.399399995803833D;
                  var1.method_3120(0.399399995803833D);
                  this.field_1195 *= 2.149D;
               } else if (this.field_1196 == 3) {
                  this.field_1196 = 4;
                  double var2 = 0.66D * (this.field_1197 - 1());
                  this.field_1195 = this.field_1197 - var2;
               } else {
                  if (c.world.getCollisionBoxes(c.player, c.player.getEntityBoundingBox().offset(0.0D, c.player.motionY, 0.0D)).size() > 0 || c.player.collidedVertically) {
                     this.field_1196 = 1;
                  }

                  this.field_1195 = this.field_1197 - this.field_1197 / 159.0D;
               }
            } else {
               this.field_1196 = 2;
               this.field_1195 = 1.38D * 1() - 0.01D;
            }

            this.field_1195 = Math.max(this.field_1195, 1());
            float var9 = c.player.movementInput.moveForward;
            float var3 = c.player.movementInput.moveStrafe;
            float var4 = c.player.rotationYaw;
            if (var9 == 0.0F && var3 == 0.0F) {
               var1.method_3125(0.0D);
               var1.method_3127(0.0D);
            } else if (var9 != 0.0F) {
               if (var3 >= 1.0F) {
                  var4 += (float)(var9 > 0.0F ? -45 : 45);
                  var3 = 0.0F;
               } else if (var3 <= -1.0F) {
                  var4 += (float)(var9 > 0.0F ? 45 : -45);
                  var3 = 0.0F;
               }

               if (var9 > 0.0F) {
                  var9 = 1.0F;
               } else if (var9 < 0.0F) {
                  var9 = -1.0F;
               }
            }

            double var5 = Math.cos(Math.toRadians((double)(var4 + 90.0F)));
            double var7 = Math.sin(Math.toRadians((double)(var4 + 90.0F)));
            var1.method_3125((double)var9 * this.field_1195 * var5 + (double)var3 * this.field_1195 * var7);
            var1.method_3127((double)var9 * this.field_1195 * var7 - (double)var3 * this.field_1195 * var5);
            c.player.stepHeight = 0.6F;
            if (var9 == 0.0F && var3 == 0.0F) {
               var1.method_3125(0.0D);
               var1.method_3127(0.0D);
            }

         }
      }
   }

   // $FF: renamed from: c (double) double
   public double method_1699(double var1) {
      BigDecimal var3 = new BigDecimal(var1);
      var3 = var3.setScale(3, RoundingMode.HALF_UP);
      return var3.doubleValue();
   }

   public faC() {
      this.field_1195 = 0.0D;
      this.field_1196 = 4;
   }
}
