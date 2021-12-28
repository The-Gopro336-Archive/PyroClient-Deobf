/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.mixin.BlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8z
extends Module {
    @NotNull
    public DoubleSetting Field3646 = (DoubleSetting)this.Method7264(new DoubleSetting("delay", "Delay", null, 1.0, 0.0, 5.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field3647 = (BooleanSetting)this.Method7264(new BooleanSetting("inInventory", "InInventory", null, true));
    @NotNull
    public fe8 Field3648 = new fe8();
    public boolean Field3649;

    public int Method184(ItemStack itemStack) {
        if (this.Field5233.player == null) {
            return 0;
        }
        int n = ((Collection)this.Field5233.player.inventoryContainer.getInventory()).size();
        for (int i = 0; i < n; ++i) {
            if (i == 0) continue;
            if (i == 5 || i == 6 || i == 7 || i == 8) continue;
            if (i > 35) break;
            ItemStack itemStack2 = (ItemStack)this.Field5233.player.inventoryContainer.getInventory().get(i);
            if (itemStack2.isEmpty() || !Intrinsics.Method6572((Object)itemStack2.getItem(), (Object)itemStack.getItem()) || !Intrinsics.Method6572(itemStack2.getDisplayName(), itemStack.getDisplayName())) continue;
            if (itemStack2.getItem() instanceof ItemBlock) {
                Item item = itemStack2.getItem();
                if (item == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                }
                Block block = ((ItemBlock)item).getBlock();
                if (block == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.BlockAccessor");
                }
                BlockAccessor blockAccessor = (BlockAccessor)block;
                Item item2 = itemStack.getItem();
                if (item2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.item.ItemBlock");
                }
                Block block2 = ((ItemBlock)item2).getBlock();
                if (block2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.BlockAccessor");
                }
                BlockAccessor blockAccessor2 = (BlockAccessor)block2;
                if (Intrinsics.Method6572((Object)blockAccessor.Method1050(), (Object)blockAccessor2.Method1050()) ^ true) continue;
            }
            if (itemStack2.getItemDamage() != itemStack.getItemDamage()) continue;
            return i;
        }
        return -1;
    }

    public f8z() {
        super("refill", "Refill", "Replenishes your hotbar if the stack is compatible from your inventory");
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field3647;
    }

    @NotNull
    public fe8 Method4964() {
        return this.Field3648;
    }

    public boolean Method5412(ItemStack itemStack, int n) {
        int n2 = this.Method184(itemStack);
        if (n2 != -1) {
            ItemStack itemStack2 = (ItemStack)this.Field5233.player.inventoryContainer.getInventory().get(n2);
            this.Field5233.playerController.windowClick(0, n2, 0, ClickType.QUICK_MOVE, (EntityPlayer)this.Field5233.player);
            return true;
        }
        return false;
    }

    public boolean Method2390() {
        return this.Field3649;
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        block8: {
            block7: {
                if (!this.Field3648.Method491(((Number)this.Field3646.Method7979()).doubleValue() * (double)1000)) {
                    return;
                }
                this.Field3648.Method490();
                if (this.Field3649) break block7;
                if (!this.Field5233.player.isHandActive()) break block8;
            }
            return;
        }
        if (this.Field5233.currentScreen instanceof GuiContainer) {
            return;
        }
        if (this.Field5233.currentScreen instanceof GuiInventory && !((Boolean)this.Field3647.Method7979()).booleanValue()) {
            return;
        }
        int n = 8;
        for (int i = 0; i <= n; ++i) {
            ItemStack itemStack = this.Field5233.player.inventory.getStackInSlot(i);
            if (itemStack.isEmpty() || !itemStack.isStackable() || itemStack.getCount() >= itemStack.getMaxStackSize()) continue;
            if (!this.Method5412(itemStack, i + 36)) continue;
            return;
        }
    }

    public void Method557(boolean bl) {
        this.Field3649 = bl;
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field3646;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field3648 = fe82;
    }
}

