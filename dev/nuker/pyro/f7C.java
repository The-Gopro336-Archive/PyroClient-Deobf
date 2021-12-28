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
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f7G;
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
import net.minecraft.util.math.Vec3d;

public class f7C
implements Consumer {
    public f7G Field3175;
    public BlockPos Field3176;
    public EnumFacing Field3177;
    public Ref.FloatRef Field3178;
    public Ref.FloatRef Field3179;
    public Ref.FloatRef Field3180;

    public void Method597(EntityPlayerSP entityPlayerSP) {
        NetHandlerPlayClient netHandlerPlayClient = f7G.Method5021(this.Field3175).getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.Field3176, this.Field3177, EnumHand.MAIN_HAND, this.Field3178.Field5298, this.Field3179.Field5298, this.Field3180.Field5298));
        NetHandlerPlayClient netHandlerPlayClient2 = f7G.Method5021(this.Field3175).getConnection();
        if (netHandlerPlayClient2 == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        Pyro.Field6182.Method8989("Pressed button!");
        Vec3d vec3d = this.Field3175.Method4988();
        if (vec3d == null) {
            Intrinsics.Method6551();
        }
        this.Field3175.Method2283(vec3d);
        PyroStatic.Field6445.Field5236.Method5266(true);
    }

    public f7C(f7G f7G2, BlockPos blockPos, EnumFacing enumFacing, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3) {
        this.Field3175 = f7G2;
        this.Field3176 = blockPos;
        this.Field3177 = enumFacing;
        this.Field3178 = floatRef;
        this.Field3179 = floatRef2;
        this.Field3180 = floatRef3;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }
}

