/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketKeepAlive
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f7r;
import java.util.function.Consumer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;

public class f7q
implements Consumer {
    public f7r Field3446;

    public void accept(Object object) {
        this.Method5246((CPacketKeepAlive)object);
    }

    public f7q(f7r f7r2) {
        this.Field3446 = f7r2;
    }

    public void Method5246(CPacketKeepAlive cPacketKeepAlive) {
        f7r.Method5276((f7r)this.Field3446).player.connection.sendPacket((Packet)cPacketKeepAlive);
    }
}

