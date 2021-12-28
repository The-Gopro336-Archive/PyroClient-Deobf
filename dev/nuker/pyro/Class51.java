/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  net.minecraft.network.EnumPacketDirection
 *  net.minecraft.network.NetworkManager
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class54;
import io.netty.channel.Channel;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

public class Class51
extends NetworkManager {
    public Class51(EnumPacketDirection enumPacketDirection) {
        super(enumPacketDirection);
    }

    public Channel Method6388() {
        return new Class54(this);
    }
}

