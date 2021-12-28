/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f8s;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f8r
implements Consumer {
    public f8s Field3604;
    public Ref.ObjectRef Field3605;

    public f8r(f8s f8s2, Ref.ObjectRef objectRef) {
        this.Field3604 = f8s2;
        this.Field3605 = objectRef;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }

    public void Method597(EntityPlayerSP entityPlayerSP) {
        if (this.Field3604.Method5414() == 0) {
            if (this.Field3604.Method5420() != null) {
                NetHandlerPlayClient netHandlerPlayClient = f8s.Method5416(this.Field3604).getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.Field3604.Method5420(), (EnumFacing)this.Field3605.Field5552));
                NetHandlerPlayClient netHandlerPlayClient2 = f8s.Method5416(this.Field3604).getConnection();
                if (netHandlerPlayClient2 == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient2.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.Field3604.Method5420(), (EnumFacing)this.Field3605.Field5552));
                return;
            }
        }
        if (this.Field3604.Method5420() != null) {
            LinkedHashMap linkedHashMap = this.Field3604.Method5421();
            BlockPos blockPos = this.Field3604.Method5420();
            if (blockPos == null) {
                Intrinsics.Method6551();
            }
            Object v = linkedHashMap.get((Object)blockPos);
            if (v == null) {
                Intrinsics.Method6551();
            }
            ((AtomicInteger)v).decrementAndGet();
            NetHandlerPlayClient netHandlerPlayClient = f8s.Method5416(this.Field3604).getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.Field3604.Method5420(), (EnumFacing)this.Field3605.Field5552, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
        }
    }
}

