/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
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
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class f6l
implements Consumer {
    public f6m Field3236;
    public Ref.IntRef Field3237;
    public Ref.ObjectRef Field3238;
    public Ref.ObjectRef Field3239;

    public void Method597(EntityPlayerSP entityPlayerSP) {
        if (this.Field3237.Field284 != f6m.Method5099((f6m)this.Field3236).player.inventory.currentItem) {
            f6m.Method5099((f6m)this.Field3236).player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.Field3237.Field284));
        }
        NetHandlerPlayClient netHandlerPlayClient = f6m.Method5099(this.Field3236).getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock((BlockPos)this.Field3238.Field5552, EnumFacing.UP, EnumHand.MAIN_HAND, (float)((fex)this.Field3239.Field5552).Method892().x, (float)((fex)this.Field3239.Field5552).Method892().y, (float)((fex)this.Field3239.Field5552).Method892().z));
        NetHandlerPlayClient netHandlerPlayClient2 = f6m.Method5099(this.Field3236).getConnection();
        if (netHandlerPlayClient2 == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        if (this.Field3237.Field284 != f6m.Method5099((f6m)this.Field3236).player.inventory.currentItem) {
            f6m.Method5099((f6m)this.Field3236).player.connection.sendPacket((Packet)new CPacketHeldItemChange(f6m.Method5099((f6m)this.Field3236).player.inventory.currentItem));
        }
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }

    public f6l(f6m f6m2, Ref.IntRef intRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.Field3236 = f6m2;
        this.Field3237 = intRef;
        this.Field3238 = objectRef;
        this.Field3239 = objectRef2;
    }
}

