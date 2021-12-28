/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.server.SPacketConfirmTransaction
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fdV;
import dev.nuker.pyro.fdW;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.server.SPacketConfirmTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdX
extends fdZ {
    public short Field306 = (short)-1;
    public fdW Field307;
    public ConcurrentLinkedQueue<fdW> Field308 = new ConcurrentLinkedQueue();
    public boolean Field309;
    public fe8 Field310 = new fe8();
    @JvmField
    @NotNull
    public static fdX Field311;
    public static fdV Field312;

    public int Method492(@NotNull Item item) {
        if (fdZ.Field313.player == null) {
            return 0;
        }
        int n = 0;
        int n2 = 44;
        for (int i = 0; i <= n2; ++i) {
            ItemStack itemStack = fdZ.Field313.player.inventory.getStackInSlot(i);
            if (itemStack.getItem() != item) continue;
            n += itemStack.getCount();
        }
        return n;
    }

    @f0g
    @LauncherEventHide
    public void Method493(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketConfirmTransaction && this.Field309 && this.Field306 != -1) {
            Packet packet = f4e2.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketConfirmTransaction");
            }
            SPacketConfirmTransaction sPacketConfirmTransaction = (SPacketConfirmTransaction)packet;
            int n = sPacketConfirmTransaction.getWindowId();
            short s = sPacketConfirmTransaction.getActionNumber();
            boolean bl = sPacketConfirmTransaction.wasAccepted();
            if (n == 0 && s == this.Field306) {
                if (this.Field307 != null) {
                    if (bl) {
                        fdW fdW2 = this.Field307;
                        if (fdW2 == null) {
                            Intrinsics.Method6551();
                        }
                        int n2 = fdW2.Method476();
                        fdW2.Method485(n2 + 1);
                        fdW fdW3 = this.Field307;
                        if (fdW3 == null) {
                            Intrinsics.Method6551();
                        }
                        switch (fdW3.Method476()) {
                            case 1: {
                                fdW fdW4 = this.Field307;
                                if (fdW4 == null) {
                                    Intrinsics.Method6551();
                                }
                                int n3 = fdW4.Method486();
                                fdW fdW5 = this.Field307;
                                if (fdW5 == null) {
                                    Intrinsics.Method6551();
                                }
                                int n4 = fdW5.Method482();
                                fdW fdW6 = this.Field307;
                                if (fdW6 == null) {
                                    Intrinsics.Method6551();
                                }
                                this.Field306 = this.Method500(n3, n4, 0, fdW6.Method474(), (EntityPlayer)fdZ.Field313.player);
                                break;
                            }
                            case 2: {
                                if (!fdZ.Field313.player.inventory.getItemStack().isEmpty()) {
                                    fdW fdW7 = this.Field307;
                                    if (fdW7 == null) {
                                        Intrinsics.Method6551();
                                    }
                                    int n5 = fdW7.Method486();
                                    fdW fdW8 = this.Field307;
                                    if (fdW8 == null) {
                                        Intrinsics.Method6551();
                                    }
                                    int n6 = fdW8.Method479();
                                    fdW fdW9 = this.Field307;
                                    if (fdW9 == null) {
                                        Intrinsics.Method6551();
                                    }
                                    this.Field306 = this.Method500(n5, n6, 0, fdW9.Method474(), (EntityPlayer)fdZ.Field313.player);
                                    break;
                                }
                                fdW fdW10 = this.Field307;
                                if (fdW10 == null) {
                                    Intrinsics.Method6551();
                                }
                                fdW10.Method477().accept(true);
                                this.Field309 = false;
                                this.Field306 = (short)-1;
                                this.Field307 = null;
                                fdZ.Field313.playerController.updateController();
                                break;
                            }
                            case 3: {
                                fdW fdW11 = this.Field307;
                                if (fdW11 == null) {
                                    Intrinsics.Method6551();
                                }
                                fdW11.Method477().accept(true);
                                this.Field309 = false;
                                this.Field306 = (short)-1;
                                this.Field307 = null;
                                fdZ.Field313.playerController.updateController();
                                break;
                            }
                        }
                    } else {
                        fdW fdW12 = this.Field307;
                        if (fdW12 == null) {
                            Intrinsics.Method6551();
                        }
                        fdW12.Method477().accept(false);
                        this.Field309 = false;
                        this.Field306 = (short)-1;
                        this.Field307 = null;
                        fdZ.Field313.playerController.updateController();
                    }
                }
            }
        }
    }

    public void Method494(int n, int n2, int n3, @NotNull ClickType clickType, int n4, @NotNull Consumer consumer) {
        this.Field308.add(new fdW(this, n, n2, n3, clickType, n4, consumer));
    }

    public fdX() {
        Pyro.Method8978().Method7915(this);
    }

    @f0g
    @LauncherEventHide
    public void Method495(@Nullable f4J f4J2) {
        while (!this.Field308.isEmpty()) {
            fdW fdW2 = this.Field308.poll();
            fdW2.Method477().accept(false);
        }
    }

    public int Method496(@NotNull Item item) {
        if (fdZ.Field313.player == null) {
            return 0;
        }
        int n = 44;
        for (int i = 0; i <= n; ++i) {
            ItemStack itemStack = fdZ.Field313.player.inventory.getStackInSlot(i);
            if (itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    public int Method497(@NotNull Item item) {
        if (fdZ.Field313.player == null) {
            return 0;
        }
        int n = 8;
        for (int i = 0; i <= n; ++i) {
            ItemStack itemStack = fdZ.Field313.player.inventory.getStackInSlot(i);
            if (itemStack.getItem() != item) continue;
            return i;
        }
        return -1;
    }

    static {
        Field312 = new fdV(null);
        Field311 = new fdX();
    }

    @f0g
    @LauncherEventHide
    public void Method498(@Nullable f4t f4t2) {
        if (PyroStatic.Field6428.Method2390()) {
            this.Field307 = null;
            this.Field306 = (short)-1;
            this.Field309 = false;
            return;
        }
        if (this.Field309) {
            if (this.Field310.Method491(1000.0)) {
                this.Field307 = null;
                this.Field309 = false;
                this.Field306 = (short)-1;
            }
            return;
        }
        while (!this.Field308.isEmpty()) {
            fdW fdW2 = this.Field308.peek();
            if (fdW2.Method475() > 0) {
                fdW fdW3 = fdW2;
                int n = fdW3.Method475();
                fdW3.Method480(n + -1);
                continue;
            }
            fdW2 = this.Field308.poll();
            if (fdW2.Method474() == ClickType.PICKUP) {
                this.Field309 = true;
                this.Field310.Method490();
                this.Field306 = this.Method500(fdW2.Method486(), fdW2.Method479(), 0, fdW2.Method474(), (EntityPlayer)fdZ.Field313.player);
                this.Field307 = fdW2;
                break;
            }
            this.Field307 = null;
            this.Field309 = false;
            this.Field306 = (short)-1;
            fdZ.Field313.playerController.windowClick(fdW2.Method486(), fdW2.Method479(), fdW2.Method482(), fdW2.Method474(), (EntityPlayer)fdZ.Field313.player);
            fdW2.Method477().accept(true);
            fdZ.Field313.playerController.updateController();
            break;
        }
    }

    public void Method499(int n, int n2, int n3, @NotNull ClickType clickType, @NotNull Consumer consumer) {
        this.Field308.add(new fdW(this, n, n2, n3, clickType, 0, consumer));
    }

    public short Method500(int n, int n2, int n3, @Nullable ClickType clickType, @NotNull EntityPlayer entityPlayer) {
        short s = entityPlayer.openContainer.getNextTransactionID(entityPlayer.inventory);
        ItemStack itemStack = entityPlayer.openContainer.slotClick(n2, n3, clickType, entityPlayer);
        NetHandlerPlayClient netHandlerPlayClient = fdZ.Field313.getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketClickWindow(n, n2, n3, clickType, itemStack, s));
        return s;
    }
}

