/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.ForgeEventFactory;

public class f85 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_456 = new BooleanSetting("entities", "Entities", "Choose best sword while hitting entities", true);

   // $FF: renamed from: c (dev.nuker.pyro.f4l) void
   @f0g
   @LauncherEventHide
   public void method_672(f4l var1) {
      int var2 = this.method_674(var1.method_3148());
      if (var2 != -1 && this.c.player.inventory.currentItem != var2) {
         this.c.player.inventory.currentItem = var2;
         this.c.playerController.updateController();
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, net.minecraft.item.ItemStack) float
   public float method_673(BlockPos var1, ItemStack var2) {
      float var3 = this.c.world.getBlockState(var1).getBlockHardness(this.c.world, var1);
      if (var3 < 0.0F) {
         return 0.0F;
      } else {
         return !this.method_677(this.c.world.getBlockState(var1).getBlock(), var1, var2) ? this.method_678(this.c.world.getBlockState(var1), var1, var2) / var3 / 100.0F : this.method_678(this.c.world.getBlockState(var1), var1, var2) / var3 / 30.0F;
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos) int
   public int method_674(BlockPos var1) {
      int var2 = -1;
      float var3 = 1.0F;

      for(int var4 = 0; var4 <= 9; ++var4) {
         ItemStack var5 = this.c.player.inventory.getStackInSlot(var4);
         if (var5 != null && var5 != ItemStack.EMPTY) {
            float var6 = (float)EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, var5);
            float var7 = var5.getDestroySpeed(this.c.world.getBlockState(var1));
            if (var6 + var7 > var3) {
               var3 = var6 + var7;
               var2 = var4;
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.item.ItemStack) float
   public float method_675(IBlockState var1, ItemStack var2) {
      float var3 = 1.0F;
      var3 *= var2.getDestroySpeed(var1);
      return var3;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4h) void
   @f0g
   @LauncherEventHide
   public void method_676(f4h var1) {
      if (var1.c() == f41.field_2120 && (Boolean)this.field_456.c() && var1.method_3143() instanceof EntityLivingBase) {
         int var2 = -1;
         double var3 = 0.0D;

         for(int var5 = 0; var5 < 9; ++var5) {
            ItemStack var6 = this.c.player.inventory.getStackInSlot(var5);
            if (var6 != null && (var6.getItem() instanceof ItemSword || var6.getItem() instanceof ItemTool)) {
               if (var2 == -1) {
                  var2 = var5;
               }

               Iterator var7 = EnchantmentHelper.getEnchantments(var6).keySet().iterator();

               while(var7.hasNext()) {
                  Enchantment var8 = (Enchantment)var7.next();
                  if (var8 instanceof EnchantmentDamage) {
                     EnchantmentDamage var9 = (EnchantmentDamage)var8;
                     if (var9.damageType == 0) {
                        double var10 = (double)EnchantmentHelper.getEnchantmentLevel(var8, var6);
                        if (var10 > var3) {
                           var3 = var10;
                           var2 = var5;
                        }
                     }
                  }
               }
            }
         }

         if (var2 != -1) {
            this.c.player.inventory.currentItem = var2;
            this.c.playerController.updateController();
         }
      }

   }

   // $FF: renamed from: c (net.minecraft.block.Block, net.minecraft.util.math.BlockPos, net.minecraft.item.ItemStack) boolean
   public boolean method_677(Block var1, BlockPos var2, ItemStack var3) {
      IBlockState var4 = this.c.world.getBlockState(var2);
      var4 = var4.getBlock().getActualState(var4, this.c.world, var2);
      if (var4.getMaterial().isToolNotRequired()) {
         return true;
      } else {
         String var5 = var1.getHarvestTool(var4);
         if (!var3.isEmpty() && var5 != null) {
            int var6 = var3.getItem().getHarvestLevel(var3, var5, this.c.player, var4);
            if (var6 < 0) {
               return this.c.player.canHarvestBlock(var4);
            } else {
               return var6 >= var1.getHarvestLevel(var4);
            }
         } else {
            return this.c.player.canHarvestBlock(var4);
         }
      }
   }

   public f85() {
      super("autotool", "AutoTool", "Automatically switches to the best tool");
      this.register(this.field_456);
   }

   // $FF: renamed from: c (net.minecraft.block.state.IBlockState, net.minecraft.util.math.BlockPos, net.minecraft.item.ItemStack) float
   public float method_678(IBlockState var1, BlockPos var2, ItemStack var3) {
      float var4 = this.method_675(var1, var3);
      if (var4 > 1.0F) {
         int var5 = EnchantmentHelper.getEfficiencyModifier(this.c.player);
         if (var5 > 0 && !var3.isEmpty()) {
            var4 += (float)(var5 * var5 + 1);
         }
      }

      if (this.c.player.isPotionActive(MobEffects.HASTE)) {
         var4 *= 1.0F + (float)(this.c.player.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2F;
      }

      if (this.c.player.isPotionActive(MobEffects.MINING_FATIGUE)) {
         float var6;
         switch(this.c.player.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
         case 0:
            var6 = 0.3F;
            break;
         case 1:
            var6 = 0.09F;
            break;
         case 2:
            var6 = 0.0027F;
            break;
         case 3:
         default:
            var6 = 8.1E-4F;
         }

         var4 *= var6;
      }

      if (this.c.player.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier(this.c.player)) {
         var4 /= 5.0F;
      }

      if (!this.c.player.onGround) {
         var4 /= 5.0F;
      }

      var4 = ForgeEventFactory.getBreakSpeed(this.c.player, var1, var4, var2);
      return var4 < 0.0F ? 0.0F : var4;
   }
}
