/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.init.MobEffects;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.util.MovementInput;
import net.minecraft.util.math.BlockPos;

public class fec extends fdZ {
   // $FF: renamed from: 5 () double
   public static double method_1749() {
      float var0 = c.player.rotationYaw;
      if (c.player.moveForward < 0.0F) {
         var0 += 180.0F;
      }

      float var1 = 1.0F;
      if (c.player.moveForward < 0.0F) {
         var1 = -0.5F;
      } else if (c.player.moveForward > 0.0F) {
         var1 = 0.5F;
      }

      if (c.player.moveStrafing > 0.0F) {
         var0 -= 90.0F * var1;
      }

      if (c.player.moveStrafing < 0.0F) {
         var0 += 90.0F * var1;
      }

      return Math.toRadians((double)var0);
   }

   // $FF: renamed from: 9 () double
   public static double method_1750() {
      return method_1756().posX;
   }

   // $FF: renamed from: 6 () double
   public static double method_1751() {
      return method_1756().posY;
   }

   // $FF: renamed from: 4 () boolean
   public static boolean method_1752() {
      return c.player != null && (c.player.movementInput.moveForward != 0.0F || c.player.movementInput.moveStrafe != 0.0F) || c.player.movementInput.jump || c.player.movementInput.sneak;
   }

   // $FF: renamed from: 3 (double) void
   public static void method_1753(double var0) {
      if (c.player.getRidingEntity() != null) {
         MovementInput var2 = c.player.movementInput;
         double var3 = (double)var2.moveForward;
         double var5 = (double)var2.moveStrafe;
         float var7 = c.player.rotationYaw;
         if (var3 == 0.0D && var5 == 0.0D) {
            c.player.getRidingEntity().motionX = 0.0D;
            c.player.getRidingEntity().motionZ = 0.0D;
            return;
         }

         if (var3 != 0.0D) {
            if (var5 > 0.0D) {
               var7 += (float)(var3 > 0.0D ? -45 : 45);
            } else if (var5 < 0.0D) {
               var7 += (float)(var3 > 0.0D ? 45 : -45);
            }

            var5 = 0.0D;
            if (var3 > 0.0D) {
               var3 = 1.0D;
            } else if (var3 < 0.0D) {
               var3 = -1.0D;
            }
         }

         c.player.getRidingEntity().motionX = var3 * var0 * Math.cos(Math.toRadians((double)(var7 + 90.0F))) + var5 * var0 * Math.sin(Math.toRadians((double)(var7 + 90.0F)));
         c.player.getRidingEntity().motionZ = var3 * var0 * Math.sin(Math.toRadians((double)(var7 + 90.0F))) - var5 * var0 * Math.cos(Math.toRadians((double)(var7 + 90.0F)));
      }

   }

   // $FF: renamed from: 4 (double) double[]
   public static double[] method_1754(double var0) {
      double var2 = (double)method_1760().moveForward;
      double var4 = (double)method_1760().moveStrafe;
      float var6 = method_1761();
      if (var2 == 0.0D && var4 == 0.0D) {
         return new double[]{0.0D, 0.0D};
      } else {
         if (var2 != 0.0D) {
            if (var4 > 0.0D) {
               var6 += (float)(var2 > 0.0D ? -45 : 45);
            } else if (var4 < 0.0D) {
               var6 += (float)(var2 > 0.0D ? 45 : -45);
            }

            var4 = 0.0D;
            if (var2 > 0.0D) {
               var2 = 1.0D;
            } else if (var2 < 0.0D) {
               var2 = -1.0D;
            }
         }

         return new double[]{var2 * var0 * Math.cos(Math.toRadians((double)(var6 + 90.0F))) + var4 * var0 * Math.sin(Math.toRadians((double)(var6 + 90.0F))), var2 * var0 * Math.sin(Math.toRadians((double)(var6 + 90.0F))) - var4 * var0 * Math.cos(Math.toRadians((double)(var6 + 90.0F)))};
      }
   }

   // $FF: renamed from: f () void
   public static void method_1755() {
      method_1776(method_1764());
   }

   // $FF: renamed from: 2 () net.minecraft.client.entity.EntityPlayerSP
   public static EntityPlayerSP method_1756() {
      return c.player;
   }

   // $FF: renamed from: 0 (double) void
   public static void method_1757(double var0) {
      double var2 = Math.toRadians((double)c.player.rotationYaw);
      c.player.setPosition(c.player.posX + -Math.sin(var2) * var0, c.player.posY, c.player.posZ + Math.cos(var2) * var0);
   }

   // $FF: renamed from: a () boolean
   public static boolean method_1758() {
      return c.player != null && (c.player.movementInput.moveForward != 0.0F || c.player.movementInput.moveStrafe != 0.0F);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) double
   public static double method_1759(Entity var0) {
      double var1 = Math.pow(var0.posX - var0.lastTickPosX, 2.0D);
      double var3 = Math.pow(var0.posZ - var0.lastTickPosZ, 2.0D);
      return (double)(Math.round(Math.floor(Math.sqrt(var1 + var3) * 20.0D * 60.0D * 60.0D) / 100.0D) / 10L);
   }

   // $FF: renamed from: 0 () net.minecraft.util.MovementInput
   public static MovementInput method_1760() {
      return method_1756().movementInput;
   }

   // $FF: renamed from: d () float
   public static float method_1761() {
      return method_1756().rotationYaw;
   }

   // $FF: renamed from: b () void
   public static void method_1762() {
      for(int var0 = 0; var0 < 70; ++var0) {
         c.player.connection.sendPacket(new Position(c.player.posX, c.player.posY + 0.06D, c.player.posZ, false));
         c.player.connection.sendPacket(new Position(c.player.posX, c.player.posY, c.player.posZ, false));
      }

      c.player.connection.sendPacket(new Position(c.player.posX, c.player.posY + 0.1D, c.player.posZ, false));
   }

   // $FF: renamed from: c (double) double[]
   public static double[] method_1763(double var0) {
      if (!method_1758()) {
         return null;
      } else {
         double var2 = method_1749();
         double var4 = -Math.sin(var2) * var0;
         double var6 = Math.cos(var2) * var0;
         return new double[]{var4, var6};
      }
   }

   // $FF: renamed from: e () float
   public static float method_1764() {
      return (float)Math.sqrt(c.player.motionX * c.player.motionX + c.player.motionZ * c.player.motionZ);
   }

   // $FF: renamed from: 2 (double) void
   public static void method_1765(double var0) {
      method_1756().posX = var0;
   }

   // $FF: renamed from: 1 (float) void
   public static void method_1766(float var0) {
      method_1756().rotationPitch = var0;
   }

   // $FF: renamed from: 3 () float
   public static float method_1767() {
      return method_1756().rotationPitch;
   }

   // $FF: renamed from: 0 (float) void
   public static void method_1768(float var0) {
      method_1756().rotationYaw = var0;
   }

   // $FF: renamed from: 5 (double) void
   public static void method_1769(double var0) {
      method_1756().posZ = var0;
   }

   // $FF: renamed from: 1 (double) void
   public static void method_1770(double var0) {
      method_1756().posY = var0;
   }

   public static float meth1() {
      return (float)Math.cbrt(c.player.motionX * c.player.motionX + c.player.motionY * c.player.motionY + c.player.motionZ * c.player.motionZ);
   }

   // $FF: renamed from: 8 () double
   public static double method_1771() {
      double var0 = 0.2873D;
      int var2;
      if (c.player.isPotionActive(MobEffects.SPEED)) {
         var2 = c.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
         var0 *= 1.0D + 0.2D * (double)(var2 + 1);
      }

      if (c.player.isPotionActive(MobEffects.JUMP_BOOST)) {
         var2 = c.player.getActivePotionEffect(MobEffects.SPEED).getAmplifier();
         var0 /= 1.0D + 0.2D * (double)(var2 + 1);
      }

      return var0;
   }

   // $FF: renamed from: c () double
   public static double method_1772() {
      return method_1756().posZ;
   }

   // $FF: renamed from: 7 () boolean
   public static boolean method_1773() {
      return c.player.motionX != 0.0D && c.player.motionZ != 0.0D && c.player.motionY != 0.0D;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p, double) void
   public static void method_1774(f4p var0, double var1) {
      double var3 = (double)method_1760().moveForward;
      double var5 = (double)method_1760().moveStrafe;
      float var7 = method_1761();
      if (var3 == 0.0D && var5 == 0.0D) {
         var0.method_3125(0.0D);
         var0.method_3127(0.0D);
      } else {
         if (var3 != 0.0D) {
            if (var5 > 0.0D) {
               var7 += (float)(var3 > 0.0D ? -45 : 45);
            } else if (var5 < 0.0D) {
               var7 += (float)(var3 > 0.0D ? 45 : -45);
            }

            var5 = 0.0D;
            if (var3 > 0.0D) {
               var3 = 1.0D;
            } else if (var3 < 0.0D) {
               var3 = -1.0D;
            }
         }

         var0.method_3125(var3 * var1 * Math.cos(Math.toRadians((double)(var7 + 90.0F))) + var5 * var1 * Math.sin(Math.toRadians((double)(var7 + 90.0F))));
         var0.method_3127(var3 * var1 * Math.sin(Math.toRadians((double)(var7 + 90.0F))) - var5 * var1 * Math.cos(Math.toRadians((double)(var7 + 90.0F))));
      }

   }

   // $FF: renamed from: c (double[], net.minecraft.util.math.BlockPos, double) void
   public static void method_1775(double[] var0, BlockPos var1, double var2) {
      double var4 = var0[0];
      double var6 = var0[1];
      double var8 = var0[2];
      double var10 = (double)var1.getX() + 0.0D;
      double var12 = (double)var1.getY() + 1.0D;
      double var14 = (double)var1.getZ() + 0.0D;
      double var16 = Math.abs(var4 - var10) + Math.abs(var6 - var12) + Math.abs(var8 - var14);
      int var18 = 0;

      for(double var19 = var16; var19 > var2; var19 = var16) {
         var16 = Math.abs(var4 - var10) + Math.abs(var6 - var12) + Math.abs(var8 - var14);
         if (var18 > 120) {
            return;
         }

         double var21 = var4 - var10;
         double var23 = var6 - var12;
         double var25 = var8 - var14;
         double var27 = (var18 & 1) == 0 ? 1.273197475E-314D : 0.0D;
         double var29 = Math.min(Math.abs(var21), var27);
         if (var21 < 0.0D) {
            var4 += var29;
            var19 = var23;
         } else {
            if (var21 > 0.0D) {
               var4 -= var29;
            }

            var19 = var23;
         }

         var21 = Math.min(Math.abs(var19), 0.0D);
         if (var23 < 0.0D) {
            var6 += var21;
            var19 = var25;
         } else {
            if (var23 > 0.0D) {
               var6 -= var21;
            }

            var19 = var25;
         }

         var21 = Math.min(Math.abs(var19), var27);
         if (var25 < 0.0D) {
            var8 += var21;
         } else if (var25 > 0.0D) {
            var8 -= var21;
         }

         ++var18;
         c.player.connection.sendPacket(new Position(var4, var6, var8, true));
      }

   }

   // $FF: renamed from: c (float) void
   public static void method_1776(float var0) {
      if (method_1758()) {
         double var1 = method_1749();
         c.player.motionX = -Math.sin(var1) * (double)var0;
         c.player.motionZ = Math.cos(var1) * (double)var0;
      }
   }
}
