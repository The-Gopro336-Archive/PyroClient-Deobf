/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.RayTraceResult
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f76;
import dev.nuker.pyro.few;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;

public class f75
implements Consumer {
    public f76 Field3108;
    public Ref.IntRef Field3109;

    public void Method597(EntityPlayerSP entityPlayerSP) {
        if (!f76.Method4934((f76)this.Field3108).world.collidesWithAnyBlock(f76.Method4934((f76)this.Field3108).player.getEntityBoundingBox().expand(0.0, -1.1, 0.0))) {
            RayTraceResult rayTraceResult = few.Method835().Method849(f76.Method4934((f76)this.Field3108).player.rotationYaw, 90.0f);
            float f = (float)(rayTraceResult.hitVec.x - (double)rayTraceResult.getBlockPos().getX());
            float f2 = (float)(rayTraceResult.hitVec.y - (double)rayTraceResult.getBlockPos().getY());
            float f3 = (float)(rayTraceResult.hitVec.z - (double)rayTraceResult.getBlockPos().getZ());
            Pyro.Field6182.Method8989("Glitching down");
            if (this.Field3109.Field284 != -1) {
                NetHandlerPlayClient netHandlerPlayClient = f76.Method4934(this.Field3108).getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketHeldItemChange(this.Field3109.Field284));
            }
            NetHandlerPlayClient netHandlerPlayClient = f76.Method4934(this.Field3108).getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(rayTraceResult.getBlockPos(), rayTraceResult.sideHit, EnumHand.MAIN_HAND, f, f2, f3));
            NetHandlerPlayClient netHandlerPlayClient2 = f76.Method4934(this.Field3108).getConnection();
            if (netHandlerPlayClient2 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient2.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            NetHandlerPlayClient netHandlerPlayClient3 = f76.Method4934(this.Field3108).getConnection();
            if (netHandlerPlayClient3 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient3.sendPacket((Packet)new CPacketPlayer.Position(f76.Method4934((f76)this.Field3108).player.posX, f76.Method4934((f76)this.Field3108).player.posY + ((Number)this.Field3108.Method238().Method7979()).doubleValue(), f76.Method4934((f76)this.Field3108).player.posZ, false));
            if (this.Field3109.Field284 != -1) {
                NetHandlerPlayClient netHandlerPlayClient4 = f76.Method4934(this.Field3108).getConnection();
                if (netHandlerPlayClient4 == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient4.sendPacket((Packet)new CPacketHeldItemChange(f76.Method4934((f76)this.Field3108).player.inventory.currentItem));
            }
        }
    }

    public f75(f76 f762, Ref.IntRef intRef) {
        this.Field3108 = f762;
        this.Field3109 = intRef;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }
}

