/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f41;
import dev.nuker.pyro.f42;
import net.minecraft.network.Packet;

public class f4a
extends f42 {
    public Packet<?> Field4138;

    public f4a(Packet packet, f41 f412) {
        super(f412);
        this.Field4138 = packet;
    }

    public Packet Method5784() {
        return this.Field4138;
    }
}

