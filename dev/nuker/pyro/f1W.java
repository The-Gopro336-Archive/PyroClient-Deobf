/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.fdZ;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1w
implements Command {
    public static f1w Field3811 = new f1w();

    public int Method152(CommandContext commandContext) {
        int n = IntegerArgumentType.Method9838(commandContext, "entityId");
        Minecraft minecraft = fdZ.Field313;
        Entity entity = minecraft.world.getEntityByID(n);
        if (entity != null) {
            NetHandlerPlayClient netHandlerPlayClient = minecraft.getConnection();
            if (netHandlerPlayClient == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient.sendPacket((Packet)new CPacketEntityAction((Entity)minecraft.player, CPacketEntityAction.Action.START_SNEAKING));
            NetHandlerPlayClient netHandlerPlayClient2 = minecraft.getConnection();
            if (netHandlerPlayClient2 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient2.sendPacket((Packet)new CPacketUseEntity(entity, EnumHand.MAIN_HAND, new Vec3d(Math.random(), Math.random(), Math.random())));
            NetHandlerPlayClient netHandlerPlayClient3 = minecraft.getConnection();
            if (netHandlerPlayClient3 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient3.sendPacket((Packet)new CPacketUseEntity(entity, EnumHand.MAIN_HAND));
            NetHandlerPlayClient netHandlerPlayClient4 = minecraft.getConnection();
            if (netHandlerPlayClient4 == null) {
                Intrinsics.Method6551();
            }
            netHandlerPlayClient4.sendPacket((Packet)new CPacketEntityAction((Entity)minecraft.player, CPacketEntityAction.Action.STOP_SNEAKING));
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Attempted to interact with entityId " + n));
        }
        return 0;
    }
}

