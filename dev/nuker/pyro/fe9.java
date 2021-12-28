/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.IBlockAccess
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class fe9
extends fdZ {
    public boolean Method343(Entity entity, boolean bl) {
        BlockPos blockPos = new BlockPos(MathHelper.floor((double)entity.posX), MathHelper.floor((double)entity.posY), MathHelper.floor((double)entity.posZ));
        BlockPos[] arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.west(), blockPos.east(), blockPos.north().up(), blockPos.south().up(), blockPos.west().up(), blockPos.east().up(), blockPos.up().up().east(), blockPos.up().up()};
        BlockPos[] arrblockPos2 = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.west(), blockPos.east(), blockPos.up().up()};
        for (BlockPos blockPos2 : bl ? arrblockPos : arrblockPos2) {
            IBlockState iBlockState = fe9.Field313.world.getBlockState(blockPos2);
            if (!fe9.Field313.world.isAirBlock(blockPos2) && !(iBlockState.getBlock() instanceof BlockLiquid) && !iBlockState.getBlock().isReplaceable((IBlockAccess)fe9.Field313.world, blockPos2)) continue;
            return false;
        }
        return true;
    }

    public static boolean Method501(Entity entity, Block block) {
        BlockPos blockPos = new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
        BlockPos[] arrblockPos = new BlockPos[]{blockPos.north(), blockPos.south(), blockPos.east(), blockPos.west()};
        int n = 0;
        for (BlockPos blockPos2 : arrblockPos) {
            IBlockState iBlockState = fe9.Field313.world.getBlockState(blockPos2);
            if (iBlockState.getBlock() == Blocks.AIR || !iBlockState.isFullBlock()) continue;
            if (block.equals((Object)Blocks.OBSIDIAN)) {
                if (!iBlockState.getBlock().equals((Object)Blocks.OBSIDIAN) && !iBlockState.getBlock().equals((Object)Blocks.BEDROCK)) continue;
                ++n;
                continue;
            }
            if (!iBlockState.getBlock().equals((Object)block)) continue;
            ++n;
        }
        return n >= 4;
    }

    public static boolean Method502(EntityPlayer entityPlayer) {
        return entityPlayer != null && entityPlayer.getHeldItemMainhand().getItem() instanceof ItemFood && entityPlayer.isHandActive();
    }

    public static float Method503(int n) {
        float f = 100.0f;
        for (ItemStack itemStack : fe9.Field313.player.getArmorInventoryList()) {
            if (n == 0 && itemStack.getItem() != Items.DIAMOND_HELMET || n == 1 && itemStack.getItem() != Items.DIAMOND_CHESTPLATE || n == 2 && itemStack.getItem() != Items.DIAMOND_LEGGINGS) continue;
            if (n == 3) {
                if (itemStack.getItem() != Items.DIAMOND_BOOTS) continue;
            }
            if (n == 5 && (!(itemStack.getItem() instanceof ItemArmor) || itemStack.isEmpty())) continue;
            f = (float)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float)itemStack.getMaxDamage() * 100.0f;
        }
        return f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean Method504(EntityPlayer entityPlayer, Item item) {
        if (entityPlayer == null) return false;
        if (!(entityPlayer.getHeldItemMainhand().getItem() instanceof ItemFood)) return false;
        if (!entityPlayer.isHandActive()) return false;
        if (!entityPlayer.getHeldItemMainhand().getItem().equals((Object)item)) return false;
        return true;
    }

    public static int Method497(Item item) {
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = fe9.Field313.player.inventory.getStackInSlot(i);
            if (itemStack == ItemStack.EMPTY) continue;
            if (itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public static int Method505(Item item) {
        for (int i = 0; i < fe9.Field313.player.inventoryContainer.getInventory().size(); ++i) {
            ItemStack itemStack;
            if (i == 0) continue;
            if (i == 5) continue;
            if (i == 6) continue;
            if (i == 7 || i == 8 || (itemStack = (ItemStack)fe9.Field313.player.inventoryContainer.getInventory().get(i)).isEmpty() || !itemStack.getItem().equals((Object)item)) continue;
            return i;
        }
        return -1;
    }

    public static int Method496(Item item) {
        if (fe9.Field313.player == null) {
            return 0;
        }
        for (int i = 9; i < 36; ++i) {
            Item item2 = fe9.Field313.player.inventory.getStackInSlot(i).getItem();
            if (item2 != item) continue;
            return i;
        }
        return -1;
    }

    public static BlockPos Method506(Entity entity) {
        if (entity == null) {
            return BlockPos.ORIGIN;
        }
        return new BlockPos(Math.floor(entity.posX), Math.floor(entity.posY), Math.floor(entity.posZ));
    }

    public static float Method507(EntityPlayer entityPlayer) {
        return entityPlayer.getHealth() + entityPlayer.getAbsorptionAmount();
    }

    public static float Method508(ItemStack itemStack) {
        return (float)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float)itemStack.getMaxDamage() * 100.0f;
    }

    public static void Method509(Item item) {
        if (fe9.Field313.player.getHeldItemMainhand().getItem() == item) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            ItemStack itemStack = fe9.Field313.player.inventory.getStackInSlot(i);
            if (itemStack.isEmpty() || itemStack.getItem() != item) continue;
            fe9.Field313.player.inventory.currentItem = i;
            fe9.Field313.playerController.updateController();
            break;
        }
    }
}

