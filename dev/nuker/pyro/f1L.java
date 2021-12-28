/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.nuker.pyro.f1k;
import dev.nuker.pyro.f3e;
import dev.nuker.pyro.fdZ;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class f1l {
    public static f1l Field3772;

    public static boolean Method5491(f1l f1l2, EntityAnimal entityAnimal) {
        return f1l2.Method5495(entityAnimal);
    }

    public boolean Method5492(EntityAnimal entityAnimal, ItemStack itemStack) {
        if (entityAnimal instanceof AbstractHorse) {
            return itemStack.getItem() instanceof ItemAppleGold;
        }
        return entityAnimal.isBreedingItem(itemStack);
    }

    static {
        f1l f1l2;
        Field3772 = f1l2 = new f1l();
    }

    public void Method5493(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("breed").Method12044(f1k.Field3747));
    }

    public static boolean Method5494(f1l f1l2, EntityAnimal entityAnimal, ItemStack itemStack) {
        return f1l2.Method5492(entityAnimal, itemStack);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method5495(EntityAnimal entityAnimal) {
        if (entityAnimal.isChild()) return false;
        if (entityAnimal.isInLove()) return false;
        float f = fdZ.Field313.player.getDistance((Entity)entityAnimal);
        int n = fdZ.Field313.player.canEntityBeSeen((Entity)entityAnimal) ? 6 : 3;
        if (!(f < (float)n)) return false;
        return true;
    }
}

