/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentDamage
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.MobEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  net.minecraftforge.event.ForgeEventFactory
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4h;
import dev.nuker.pyro.f4l;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class f85
extends Module {
    public BooleanSetting Field3322 = new BooleanSetting("entities", "Entities", "Choose best sword while hitting entities", true);

    @f0g
    @LauncherEventHide
    public void Method563(f4l f4l2) {
        int n = this.Method2748(f4l2.Method5787());
        if (n != -1 && this.Field5233.player.inventory.currentItem != n) {
            this.Field5233.player.inventory.currentItem = n;
            this.Field5233.playerController.updateController();
        }
    }

    public float Method5156(BlockPos blockPos, ItemStack itemStack) {
        float f = this.Field5233.world.getBlockState(blockPos).getBlockHardness((World)this.Field5233.world, blockPos);
        if (f < 0.0f) {
            return 0.0f;
        }
        if (!this.Method5158(this.Field5233.world.getBlockState(blockPos).getBlock(), blockPos, itemStack)) {
            return this.Method5159(this.Field5233.world.getBlockState(blockPos), blockPos, itemStack) / f / 100.0f;
        }
        return this.Method5159(this.Field5233.world.getBlockState(blockPos), blockPos, itemStack) / f / 30.0f;
    }

    public int Method2748(BlockPos blockPos) {
        int n = -1;
        float f = 1.0f;
        for (int i = 0; i <= 9; ++i) {
            float f2;
            float f3;
            ItemStack itemStack = this.Field5233.player.inventory.getStackInSlot(i);
            if (itemStack == null) continue;
            if (itemStack == ItemStack.EMPTY || !((f3 = (float)EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.EFFICIENCY, (ItemStack)itemStack)) + (f2 = itemStack.getDestroySpeed(this.Field5233.world.getBlockState(blockPos))) > f)) continue;
            f = f3 + f2;
            n = i;
        }
        return n;
    }

    public float Method5157(IBlockState iBlockState, ItemStack itemStack) {
        float f = 1.0f;
        return f *= itemStack.getDestroySpeed(iBlockState);
    }

    @f0g
    @LauncherEventHide
    public void Method4961(f4h f4h2) {
        if (f4h2.Method5619() == f41.Pre && ((Boolean)this.Field3322.Method7979()).booleanValue() && f4h2.Method5637() instanceof EntityLivingBase) {
            int n = -1;
            double d = 0.0;
            for (int i = 0; i < 9; ++i) {
                ItemStack itemStack = this.Field5233.player.inventory.getStackInSlot(i);
                if (itemStack == null) continue;
                if (!(itemStack.getItem() instanceof ItemSword) && !(itemStack.getItem() instanceof ItemTool)) continue;
                if (n == -1) {
                    n = i;
                }
                for (Enchantment enchantment : EnchantmentHelper.getEnchantments((ItemStack)itemStack).keySet()) {
                    double d2;
                    if (!(enchantment instanceof EnchantmentDamage)) continue;
                    EnchantmentDamage enchantmentDamage = (EnchantmentDamage)enchantment;
                    if (enchantmentDamage.damageType != 0 || !((d2 = (double)EnchantmentHelper.getEnchantmentLevel((Enchantment)enchantment, (ItemStack)itemStack)) > d)) continue;
                    d = d2;
                    n = i;
                }
            }
            if (n != -1) {
                this.Field5233.player.inventory.currentItem = n;
                this.Field5233.playerController.updateController();
            }
        }
    }

    public boolean Method5158(Block block, BlockPos blockPos, ItemStack itemStack) {
        String string;
        IBlockState iBlockState;
        block6: {
            block5: {
                iBlockState = this.Field5233.world.getBlockState(blockPos);
                iBlockState = iBlockState.getBlock().getActualState(iBlockState, (IBlockAccess)this.Field5233.world, blockPos);
                if (iBlockState.getMaterial().isToolNotRequired()) {
                    return true;
                }
                string = block.getHarvestTool(iBlockState);
                if (itemStack.isEmpty()) break block5;
                if (string != null) break block6;
            }
            return this.Field5233.player.canHarvestBlock(iBlockState);
        }
        int n = itemStack.getItem().getHarvestLevel(itemStack, string, (EntityPlayer)this.Field5233.player, iBlockState);
        if (n < 0) {
            return this.Field5233.player.canHarvestBlock(iBlockState);
        }
        return n >= block.getHarvestLevel(iBlockState);
    }

    public f85() {
        super("autotool", "AutoTool", "Automatically switches to the best tool");
        this.Method7264(this.Field3322);
    }

    public float Method5159(IBlockState iBlockState, BlockPos blockPos, ItemStack itemStack) {
        int n;
        float f = this.Method5157(iBlockState, itemStack);
        if (f > 1.0f && (n = EnchantmentHelper.getEfficiencyModifier((EntityLivingBase)this.Field5233.player)) > 0) {
            if (!itemStack.isEmpty()) {
                f += (float)(n * n + 1);
            }
        }
        if (this.Field5233.player.isPotionActive(MobEffects.HASTE)) {
            f *= 1.0f + (float)(this.Field5233.player.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2f;
        }
        if (this.Field5233.player.isPotionActive(MobEffects.MINING_FATIGUE)) {
            float f2;
            switch (this.Field5233.player.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
                case 0: {
                    f2 = 0.3f;
                    break;
                }
                case 1: {
                    f2 = 0.09f;
                    break;
                }
                case 2: {
                    f2 = 0.0027f;
                    break;
                }
                default: {
                    f2 = 8.1E-4f;
                }
            }
            f *= f2;
        }
        if (this.Field5233.player.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier((EntityLivingBase)this.Field5233.player)) {
            f /= 5.0f;
        }
        if (!this.Field5233.player.onGround) {
            f /= 5.0f;
        }
        return (f = ForgeEventFactory.getBreakSpeed((EntityPlayer)this.Field5233.player, (IBlockState)iBlockState, (float)f, (BlockPos)blockPos)) < 0.0f ? 0.0f : f;
    }
}

