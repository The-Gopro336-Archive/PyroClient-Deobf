/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItem
 *  net.minecraft.util.EnumHand
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BindSetting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.f6P;
import dev.nuker.pyro.fdX;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class keypearl
extends Module {
    @NotNull
    public BindSetting Field4859 = new BindSetting("pearlKey", "PearlKey", "The key or mouse button to set", -1);
    @NotNull
    public BooleanSetting Field4860 = new BooleanSetting("inventory", "Inventory", null, false);

    @NotNull
    public BindSetting Method2615() {
        return this.Field4859;
    }

    public static void Method7043(keypearl keypearl2, Minecraft minecraft) {
        keypearl2.Field5233 = minecraft;
    }

    public static Minecraft Method7044(keypearl keypearl2) {
        return keypearl2.Field5233;
    }

    @f0g
    @LauncherEventHide
    public void Method183(@Nullable f4t f4t2) {
        if (this.Field4859.Method8796()) {
            int n;
            int n2 = 8;
            for (n = 0; n <= n2; ++n) {
                ItemStack itemStack = this.Field5233.player.inventory.getStackInSlot(n);
                if (itemStack.isEmpty() || !Intrinsics.Method6572((Object)itemStack.getItem(), (Object)Items.ENDER_PEARL)) continue;
                if (this.Field5233.player.inventory.currentItem != n) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n));
                }
                this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                if (this.Field5233.player.inventory.currentItem != n) {
                    this.Field5233.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field5233.player.inventory.currentItem));
                }
                return;
            }
            if (((Boolean)this.Field4860.Method7979()).booleanValue()) {
                n = fdX.Field311.Method496(Items.ENDER_PEARL);
                if (n != -1) {
                    this.Field5233.playerController.windowClick(0, n, 0, ClickType.PICKUP, (EntityPlayer)this.Field5233.player);
                    this.Field5233.playerController.windowClick(0, 44, 0, ClickType.PICKUP, (EntityPlayer)this.Field5233.player);
                    n2 = this.Field5233.player.inventory.currentItem;
                    if (n2 != 8) {
                        this.Field5233.player.inventory.currentItem = 8;
                    }
                    this.Field5233.playerController.processRightClick((EntityPlayer)this.Field5233.player, (World)this.Field5233.world, EnumHand.MAIN_HAND);
                    if (n2 != 8) {
                        this.Field5233.player.inventory.currentItem = n2;
                    }
                    this.Field5233.addScheduledTask((Runnable)new f6P(this, n));
                }
            }
        }
    }

    public keypearl() {
        super("keyPearl", "KeyPearl", "Allows you to automatically throw a pearl from anywhere in your inventory when the key setting is hit");
        this.Method7264(this.Field4859);
        this.Method7264(this.Field4860);
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field4860;
    }
}

