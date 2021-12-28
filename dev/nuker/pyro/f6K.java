/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f6m;
import dev.nuker.pyro.fex;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f6k
implements Consumer {
    public f6m Field3231;
    public Ref.ObjectRef Field3232;
    public Ref.ObjectRef Field3233;
    public Ref.ObjectRef Field3234;

    public void Method597(EntityPlayerSP entityPlayerSP) {
        NetHandlerPlayClient netHandlerPlayClient = f6m.Method5099(this.Field3231).getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock((BlockPos)this.Field3232.Field5552, (EnumFacing)this.Field3233.Field5552, EnumHand.OFF_HAND, (float)((fex)this.Field3234.Field5552).Method892().x, (float)((fex)this.Field3234.Field5552).Method892().y, (float)((fex)this.Field3234.Field5552).Method892().z));
        NetHandlerPlayClient netHandlerPlayClient2 = f6m.Method5099(this.Field3231).getConnection();
        if (netHandlerPlayClient2 == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
    }

    public f6k(f6m f6m2, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        this.Field3231 = f6m2;
        this.Field3232 = objectRef;
        this.Field3233 = objectRef2;
        this.Field3234 = objectRef3;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }
}

