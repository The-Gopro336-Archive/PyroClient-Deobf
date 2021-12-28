/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketHeldItemChange
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdi;
import dev.nuker.pyro.fdk;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.fee;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.few;
import dev.nuker.pyro.mixin.MinecraftAccessor;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class fdj
implements Consumer {
    public fdk Field392;
    public boolean Field393;

    public fdj(fdk fdk2, boolean bl) {
        this.Field392 = fdk2;
        this.Field393 = bl;
    }

    public void accept(Object object) {
        this.Method597((EntityPlayerSP)object);
    }

    public void Method597(EntityPlayerSP entityPlayerSP) {
        if (this.Field392.Method537() != null && this.Field392.Method550().Method491(((Number)this.Field392.Method220().Method7979()).doubleValue()) && this.Field392.Method539() != -1) {
            boolean bl;
            boolean bl2;
            Vec3d vec3d;
            RayTraceResult rayTraceResult = few.Method835().Method849(this.Field392.Method535(), this.Field392.Method546());
            Vec3d vec3d2 = vec3d = rayTraceResult != null ? rayTraceResult.hitVec : new Vec3d(0.5, 0.5, 0.5);
            if ((fdi)((Object)this.Field392.Method543().Method7979()) != fdi.Instant && ((Boolean)this.Field392.Method281().Method7979()).booleanValue() && this.Field392.Method304()) {
                Minecraft minecraft = fdk.Method536(this.Field392);
                if (minecraft == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.MinecraftAccessor");
                }
                MinecraftAccessor minecraftAccessor = (MinecraftAccessor)minecraft;
                minecraftAccessor.Method6088(3);
                if (fdk.Method536((fdk)this.Field392).player.movementInput.jump && !fec.Method727()) {
                    minecraftAccessor.Method6088(0);
                    fdk.Method536((fdk)this.Field392).player.motionY = this.Field392.Method555(this.Field393);
                }
            }
            boolean bl3 = bl2 = fdk.Method536((fdk)this.Field392).player.inventory.currentItem != this.Field392.Method539();
            if (this.Field392.Method539() == -420) {
                bl2 = false;
            }
            boolean bl4 = fdk.Method536((fdk)this.Field392).player.isSprinting();
            int n = fdk.Method536((fdk)this.Field392).player.inventory.currentItem;
            fee fee2 = this.Field392.Method537();
            if (fee2 == null) {
                Intrinsics.Method6551();
            }
            boolean bl5 = !feg.Field454.Method696(fee2.Method678()) ? true : (bl = false);
            if (bl2) {
                fdk.Method536((fdk)this.Field392).player.inventory.currentItem = this.Field392.Method539();
                NetHandlerPlayClient netHandlerPlayClient = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketHeldItemChange(this.Field392.Method539()));
            }
            if (bl4) {
                NetHandlerPlayClient netHandlerPlayClient = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketEntityAction((Entity)fdk.Method536((fdk)this.Field392).player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl) {
                NetHandlerPlayClient netHandlerPlayClient = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient.sendPacket((Packet)new CPacketEntityAction((Entity)fdk.Method536((fdk)this.Field392).player, CPacketEntityAction.Action.START_SNEAKING));
            }
            EnumHand enumHand = this.Field392.Method539() == -420 ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
            fee fee3 = this.Field392.Method537();
            if (fee3 == null) {
                Intrinsics.Method6551();
            }
            BlockPos blockPos = fee3.Method678();
            fee fee4 = this.Field392.Method537();
            if (fee4 == null) {
                Intrinsics.Method6551();
            }
            fdk.Method536((fdk)this.Field392).playerController.processRightClickBlock(fdk.Method536((fdk)this.Field392).player, fdk.Method536((fdk)this.Field392).world, blockPos, fee4.Method677(), vec3d, enumHand);
            NetHandlerPlayClient netHandlerPlayClient = fdk.Method536(this.Field392).getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketAnimation(enumHand));
            if (bl) {
                NetHandlerPlayClient netHandlerPlayClient2 = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient2 == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient2.sendPacket((Packet)new CPacketEntityAction((Entity)fdk.Method536((fdk)this.Field392).player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl4) {
                NetHandlerPlayClient netHandlerPlayClient3 = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient3 == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient3.sendPacket((Packet)new CPacketEntityAction((Entity)fdk.Method536((fdk)this.Field392).player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl2) {
                fdk.Method536((fdk)this.Field392).player.inventory.currentItem = n;
                NetHandlerPlayClient netHandlerPlayClient4 = fdk.Method536(this.Field392).getConnection();
                if (netHandlerPlayClient4 == null) {
                    Intrinsics.Method6551();
                }
                netHandlerPlayClient4.sendPacket((Packet)new CPacketHeldItemChange(n));
            }
        }
    }
}

