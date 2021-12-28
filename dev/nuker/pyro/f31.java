/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketTabComplete
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fdZ;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketTabComplete;

public class f31
implements Command {
    public static f31 Field3781 = new f31();

    public int Method152(CommandContext commandContext) {
        PyroStatic.Field6549.Field5236.Method5266(true);
        NetHandlerPlayClient netHandlerPlayClient = fdZ.Field313.getConnection();
        if (netHandlerPlayClient == null) {
            Intrinsics.Method6551();
        }
        netHandlerPlayClient.sendPacket((Packet)new CPacketTabComplete("/", null, false));
        Pyro.Field6182.Method8989("Discovering plugins...");
        return 0;
    }
}

