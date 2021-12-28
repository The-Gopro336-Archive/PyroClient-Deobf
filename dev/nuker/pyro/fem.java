/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class fem
extends fdZ {
    public static int Method751(Block block) {
        for (int i = 0; i < 9; ++i) {
            if (!(fem.Field313.player.inventory.getStackInSlot(i).getItem() instanceof ItemBlock) || !((ItemBlock)fem.Field313.player.inventory.getStackInSlot(i).getItem()).getBlock().equals((Object)block)) continue;
            return i;
        }
        return -1;
    }

    public static int Method492(Item item) {
        for (int i = 0; i < 9; ++i) {
            if (!fem.Field313.player.inventory.getStackInSlot(i).getItem().equals((Object)item)) continue;
            return i;
        }
        return -1;
    }
}

