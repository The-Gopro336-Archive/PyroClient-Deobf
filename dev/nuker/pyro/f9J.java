/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.f9I;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9J
extends Module {
    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (f492.Method5619() == f41.Pre && f492.Method5784() instanceof CPacketPlayerTryUseItemOnBlock) {
            if (!this.Field5233.player.isSneaking()) {
                this.Method557(true);
            }
        }
    }

    public f9J() {
        super("sneak", "Sneak", "Makes you always sneaking serverside");
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        if (!bl && this.Field5233.player != null && !this.Field5233.player.movementInput.sneak) {
            this.Method557(true);
        }
    }

    public void Method557(boolean bl) {
        NetHandlerPlayClient netHandlerPlayClient = this.Field5233.getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field5233.player, bl ? CPacketEntityAction.Action.STOP_SNEAKING : CPacketEntityAction.Action.START_SNEAKING));
    }

    @f0g
    @LauncherEventHide
    public void Method203(@NotNull f4u f4u2) {
        f41 f412 = f4u2.Method5619();
        if (f412 != null) {
            switch (f9I.Field3569[f412.ordinal()]) {
                case 1: {
                    if (this.Field5233.player.isSneaking()) break;
                    if (fec.Method727()) {
                        this.Method557(false);
                        this.Method557(true);
                        break;
                    }
                    this.Method557(false);
                    break;
                }
                case 2: {
                    if (!fec.Method727()) break;
                    this.Method557(false);
                    break;
                }
            }
        }
    }
}

