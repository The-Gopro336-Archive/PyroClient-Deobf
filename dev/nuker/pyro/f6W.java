/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f6w
extends Module {
    @NotNull
    public DoubleSetting Field3281 = (DoubleSetting)this.Method7264(new DoubleSetting("delay", "Delay", null, 0.0, 0.0, 2.0, 0.0, 64, null));
    public boolean Field3282;
    @NotNull
    public fe8 Field3283 = new fe8();

    @f0g
    @LauncherEventHide
    public void Method277(@Nullable f43 f432) {
        if (this.Field5233.player == null || this.Field5233.world == null) {
            return;
        }
        this.Method7274(String.valueOf(this.Method2499()));
        if (((Boolean)PyroStatic.Field6490.Field5236.Method5264()).booleanValue() && PyroStatic.Field6490.Method2412()) {
            return;
        }
        if (this.Field5233.currentScreen instanceof GuiContainer && !(this.Field5233.currentScreen instanceof GuiInventory)) {
            return;
        }
        if (!this.Field3282) {
            this.Field3283.Method490();
        }
        if (this.Field5233.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING) {
            return;
        }
        if (this.Field5233.player.isCreative()) {
            return;
        }
        int n = 0;
        int n2 = n = 44;
        while (n2 >= 9) {
            if (this.Field5233.player.inventoryContainer.getSlot(n).getStack().getItem() == Items.TOTEM_OF_UNDYING) {
                this.Field3282 = true;
                if (this.Field3283.Method491(((Number)this.Field3281.Method7979()).doubleValue() * (double)1000.0f)) {
                    if (this.Field5233.player.inventory.getItemStack().getItem() != Items.TOTEM_OF_UNDYING) {
                        this.Field5233.playerController.windowClick(0, n, 0, ClickType.PICKUP, (EntityPlayer)this.Field5233.player);
                    }
                }
                if (this.Field3283.Method491(((Number)this.Field3281.Method7979()).doubleValue() * (double)2000.0f)) {
                    if (this.Field5233.player.inventory.getItemStack().getItem() == Items.TOTEM_OF_UNDYING) {
                        this.Field5233.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)this.Field5233.player);
                        if (this.Field5233.player.inventory.getItemStack().isEmpty()) {
                            this.Field3282 = false;
                            return;
                        }
                    }
                }
                if (this.Field3283.Method491(((Number)this.Field3281.Method7979()).doubleValue() * (double)3000.0f)) {
                    if (!this.Field5233.player.inventory.getItemStack().isEmpty()) {
                        if (this.Field5233.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING) {
                            this.Field5233.playerController.windowClick(0, n, 0, ClickType.PICKUP, (EntityPlayer)this.Field5233.player);
                            this.Field3282 = false;
                            return;
                        }
                    }
                }
            }
            n2 = --n;
        }
    }

    public f6w() {
        super("autototem", "AutoTotem", "Automatically swaps your offhand to a totem if one is currently not present");
    }

    @NotNull
    public fe8 Method5148() {
        return this.Field3283;
    }

    public void Method557(boolean bl) {
        this.Field3282 = bl;
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field3281;
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Field3282 = false;
    }

    public boolean Method2390() {
        return this.Field3282;
    }

    public int Method2499() {
        int n = 0;
        int n2 = 44;
        for (int i = 1; i <= n2; ++i) {
            if (!this.Field5233.player.inventoryContainer.getSlot(i).getHasStack()) continue;
            ItemStack itemStack = this.Field5233.player.inventoryContainer.getSlot(i).getStack();
            if (itemStack.isEmpty() || !Intrinsics.Method6572((Object)itemStack.getItem(), (Object)Items.TOTEM_OF_UNDYING)) continue;
            ++n;
        }
        if (this.Field5233.player.getHeldItem(EnumHand.OFF_HAND).getItem() == Items.TOTEM_OF_UNDYING) {
            ++n;
        }
        return n;
    }

    public void Method4965(@NotNull fe8 fe82) {
        this.Field3283 = fe82;
    }
}

