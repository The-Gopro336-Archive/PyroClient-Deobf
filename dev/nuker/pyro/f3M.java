/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f3n;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.jetbrains.annotations.Nullable;

public class f3m
implements Command {
    public static f3m Field4025 = new f3m();

    public int Method152(@Nullable CommandContext commandContext) {
        block0: {
            f3n.Field4075.Method5727(StringArgumentType.Method5880(commandContext, "message"));
            NetHandlerPlayClient netHandlerPlayClient = Minecraft.getMinecraft().getConnection();
            if (netHandlerPlayClient == null) break block0;
            netHandlerPlayClient.sendPacket((Packet)new CPacketChatMessage(f3n.Field4075.Method5728()));
        }
        return 0;
    }
}

