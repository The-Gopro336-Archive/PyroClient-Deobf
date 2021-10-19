/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.RenderManagerAccessor;
import javax.annotation.Nullable;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class fdN extends fdZ {
   // $FF: renamed from: 9 (net.minecraft.entity.Entity) boolean
   public static boolean method_1853(Entity var0) {
      return method_1854(var0, false);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, boolean) boolean
   public static boolean method_1854(Entity var0, boolean var1) {
      if (var0 == null) {
         return false;
      } else {
         double var2 = var0.posY - (var1 ? 0.03D : (method_1866(var0) ? 0.2D : 0.5D));

         for(int var4 = MathHelper.floor(var0.posX); var4 < MathHelper.ceil(var0.posX); ++var4) {
            for(int var5 = MathHelper.floor(var0.posZ); var5 < MathHelper.ceil(var0.posZ); ++var5) {
               BlockPos var6 = new BlockPos(var4, MathHelper.floor(var2), var5);
               if (Minecraft.getMinecraft().world.getBlockState(var6).getBlock() instanceof BlockLiquid) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   // $FF: renamed from: 4 (net.minecraft.entity.Entity) boolean
   public static boolean method_1855(Entity var0) {
      if (var0 instanceof EntityPigZombie) {
         if (((EntityPigZombie)var0).isArmsRaised() || ((EntityPigZombie)var0).isAngry()) {
            return true;
         }
      } else {
         if (var0 instanceof EntityWolf) {
            return ((EntityWolf)var0).isAngry() && !Minecraft.getMinecraft().player.equals(((EntityWolf)var0).getOwner());
         }

         if (var0 instanceof EntityEnderman) {
            return ((EntityEnderman)var0).isScreaming();
         }
      }

      return method_1862(var0);
   }

   // $FF: renamed from: 0 (float) double
   public static double method_1856(float var0) {
      return (double)MathHelper.sin(-var0 * 0.017453292F);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) boolean
   public static boolean method_1857(Entity var0) {
      return var0 instanceof EntityLivingBase;
   }

   // $FF: renamed from: c (float) double
   public static double method_1858(float var0) {
      return (double)MathHelper.cos(var0 * 0.017453292F);
   }

   // $FF: renamed from: 3 (net.minecraft.entity.Entity) boolean
   public static boolean method_1859(Entity var0) {
      double var1 = c.player.getDistanceSq(var0);
      if (!c.player.canEntityBeSeen(var0)) {
         return var1 <= 9.0D;
      } else {
         return var1 <= 36.0D;
      }
   }

   // $FF: renamed from: 2 (net.minecraft.entity.Entity) boolean
   public static boolean method_1860(Entity var0) {
      return var0 != null && var0.getEntityId() == -100 && Minecraft.getMinecraft().player != var0;
   }

   // $FF: renamed from: 0 (net.minecraft.entity.Entity, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1861(Entity var0, float var1) {
      return (new Vec3d(var0.lastTickPosX, var0.lastTickPosY, var0.lastTickPosZ)).add(method_1876(var0, (double)var1));
   }

   // $FF: renamed from: 6 (net.minecraft.entity.Entity) boolean
   public static boolean method_1862(Entity var0) {
      return var0.isCreatureType(EnumCreatureType.MONSTER, false) && !method_1868(var0);
   }

   // $FF: renamed from: 0 (net.minecraft.entity.Entity) int
   public static int method_1863(Entity var0) {
      int var1 = 16777215;
      ScorePlayerTeam var2;
      if ((var2 = (ScorePlayerTeam)var0.getTeam()) != null) {
         FontRenderer var10000 = c.fontRenderer;
         String var3;
         if ((var3 = FontRenderer.getFormatFromString(var2.getPrefix())).length() >= 2) {
            var1 = c.fontRenderer.getColorCode(var3.charAt(1));
         }
      }

      return var1;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec3d
   public static Vec3d method_1864(Entity var0, Vec3d var1) {
      return method_1873(var0, var1.x, var1.y, var1.z);
   }

   // $FF: renamed from: a (net.minecraft.entity.Entity) boolean
   public static boolean method_1865(Entity var0) {
      if (var0 == null) {
         return false;
      } else {
         double var1 = var0.posY + 0.01D;

         for(int var3 = MathHelper.floor(var0.posX); var3 < MathHelper.ceil(var0.posX); ++var3) {
            for(int var4 = MathHelper.floor(var0.posZ); var4 < MathHelper.ceil(var0.posZ); ++var4) {
               BlockPos var5 = new BlockPos(var3, (int)var1, var4);
               if (Minecraft.getMinecraft().world.getBlockState(var5).getBlock() instanceof BlockLiquid) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   // $FF: renamed from: b (net.minecraft.entity.Entity) boolean
   public static boolean method_1866(Entity var0) {
      return var0 instanceof EntityPlayer;
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.entity.player.EntityPlayer) boolean
   public static boolean method_1867(Entity var0, EntityPlayer var1) {
      double var2 = var1.getDistanceSq(var0);
      if (!var1.canEntityBeSeen(var0)) {
         return var2 <= 9.0D;
      } else {
         return var2 <= 36.0D;
      }
   }

   // $FF: renamed from: 7 (net.minecraft.entity.Entity) boolean
   public static boolean method_1868(Entity var0) {
      return var0 instanceof EntityPigZombie || var0 instanceof EntityWolf || var0 instanceof EntityEnderman;
   }

   // $FF: renamed from: c (double, double, double, net.minecraft.entity.player.EntityPlayer) double[]
   public static double[] method_1869(double var0, double var2, double var4, EntityPlayer var6) {
      double var7 = var6.posX - var0;
      double var9 = var6.posY - var2;
      double var11 = var6.posZ - var4;
      double var13 = Math.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
      var7 /= var13;
      var9 /= var13;
      var11 /= var13;
      double var15 = Math.asin(var9);
      double var17 = Math.atan2(var11, var7);
      var15 = var15 * 180.0D / 3.141592653589793D;
      var17 = var17 * 180.0D / 3.141592653589793D;
      var17 += 90.0D;
      return new double[]{var17, var15};
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.util.math.BlockPos) net.minecraft.util.math.BlockPos
   public static BlockPos method_1870(Entity var0, @Nullable BlockPos var1) {
      Vec3d var2 = var0.getPositionVector();
      return var1 == null ? new BlockPos(var2.x, var2.y, var2.z) : (new BlockPos(var2.x, var2.y, var2.z)).add(var1);
   }

   // $FF: renamed from: 5 (net.minecraft.entity.Entity) boolean
   public static boolean method_1871(Entity var0) {
      return Minecraft.getMinecraft().player != null && var0 != null && var0.equals(Minecraft.getMinecraft().player.getRidingEntity());
   }

   // $FF: renamed from: c (net.minecraft.entity.EntityLivingBase) boolean
   public static boolean method_1872(EntityLivingBase var0) {
      return method_1863(var0) == method_1863(c.player);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, double, double, double) net.minecraft.util.math.Vec3d
   public static Vec3d method_1873(Entity var0, double var1, double var3, double var5) {
      return new Vec3d((var0.posX - var0.lastTickPosX) * var1, (var0.posY - var0.lastTickPosY) * var3, (var0.posZ - var0.lastTickPosZ) * var5);
   }

   // $FF: renamed from: 1 (net.minecraft.entity.Entity) boolean
   public static boolean method_1874(Entity var0) {
      if (var0 instanceof EntityWolf && ((EntityWolf)var0).isAngry()) {
         return false;
      } else if (!(var0 instanceof EntityAnimal) && !(var0 instanceof EntityAgeable) && !(var0 instanceof EntityTameable) && !(var0 instanceof EntityAmbientCreature) && !(var0 instanceof EntitySquid)) {
         return var0 instanceof EntityIronGolem && ((EntityIronGolem)var0).getRevengeTarget() == null;
      } else {
         return true;
      }
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1875(Entity var0, float var1) {
      return method_1861(var0, var1).subtract(((RenderManagerAccessor)Minecraft.getMinecraft().getRenderManager()).getRenderPosX(), ((RenderManagerAccessor)Minecraft.getMinecraft().getRenderManager()).getRenderPosY(), ((RenderManagerAccessor)Minecraft.getMinecraft().getRenderManager()).getRenderPosZ());
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, double) net.minecraft.util.math.Vec3d
   public static Vec3d method_1876(Entity var0, double var1) {
      return method_1873(var0, var1, var1, var1);
   }

   // $FF: renamed from: 8 (net.minecraft.entity.Entity) boolean
   public static boolean method_1877(Entity var0) {
      return var0.isCreatureType(EnumCreatureType.CREATURE, false) && !method_1868(var0) || var0.isCreatureType(EnumCreatureType.AMBIENT, false) || var0 instanceof EntityVillager || var0 instanceof EntityIronGolem || method_1868(var0) && !method_1855(var0);
   }
}
