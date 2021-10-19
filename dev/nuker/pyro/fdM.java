/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;

public class fdM extends fdZ {
   // $FF: renamed from: c float
   public static float field_1229 = 5.0F;
   // $FF: renamed from: 0 float
   public static float field_1230 = 6.0F;

   // $FF: renamed from: c (float) float
   public static float method_1878(float var0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (double, double, double, net.minecraft.entity.EntityLivingBase, float, boolean) float
   public static float method_1879(double var0, double var2, double var4, EntityLivingBase var6, float var7, boolean var8) {
      if (var6 == c.player && c.player.capabilities.isCreativeMode) {
         return 0.0F;
      } else {
         double var9 = var6.getDistance(var0, var2, var4) / (double)(var7 * 2.0F);
         if (var9 > 1.0D) {
            return 0.0F;
         } else {
            double var11 = (double)c.world.getBlockDensity(new Vec3d(var0, var2, var4), var6.getEntityBoundingBox());
            double var13 = (1.0D - var9) * var11;
            float var15 = method_1878((float)((int)((var13 * var13 + var13) / 2.0D * 7.0D * (double)(var7 * 2.0F) + 1.0D)));
            DamageSource var16 = DamageSource.causeExplosionDamage(new Explosion(c.world, c.player, var0, var2, var4, var7, var8, true));
            float var17 = CombatRules.getDamageAfterAbsorb(var15, (float)var6.getTotalArmorValue(), (float)var6.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
            int var18 = EnchantmentHelper.getEnchantmentModifierDamage(var6.getArmorInventoryList(), var16);
            if (var18 > 0) {
               var17 = CombatRules.getDamageAfterMagicAbsorb(var17, (float)var18);
            }

            PotionEffect var19 = var6.getActivePotionEffect(MobEffects.RESISTANCE);
            if (var19 != null) {
               var17 = var17 * (float)(25 - (var19.getAmplifier() + 1) * 5) / 25.0F;
            }

            return Math.max(var17, 0.0F);
         }
      }
   }

   // $FF: renamed from: c (net.minecraft.tileentity.TileEntityBed, net.minecraft.entity.EntityLivingBase) float
   public static float method_1880(TileEntityBed var0, EntityLivingBase var1) {
      BlockPos var2 = var0.getPos();
      return method_1879((double)var2.getX() + 0.5D, (double)var2.getY() + 0.5D, (double)var2.getZ() + 0.5D, var1, field_1229, true);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, net.minecraft.entity.EntityLivingBase) float
   public static float method_1881(BlockPos var0, EntityLivingBase var1) {
      return method_1879((double)var0.getX() + 0.5D, (double)(var0.getY() + 1), (double)var0.getZ() + 0.5D, var1, field_1230, false);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.entity.EntityLivingBase) float
   public static float method_1882(BlockPos var0, EntityLivingBase var1) {
      return method_1879((double)var0.getX() + 0.5D, (double)var0.getY() + 0.5D, (double)var0.getZ() + 0.5D, var1, field_1229, true);
   }

   // $FF: renamed from: c (net.minecraft.entity.item.EntityEnderCrystal, net.minecraft.entity.EntityLivingBase) float
   public static float method_1883(EntityEnderCrystal var0, EntityLivingBase var1) {
      return method_1879(var0.posX, var0.posY, var0.posZ, var1, field_1230, false);
   }
}
