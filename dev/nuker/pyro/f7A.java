/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketChunkData
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fe3;
import java.util.function.Predicate;
import net.minecraft.network.play.server.SPacketChunkData;
import org.jetbrains.annotations.NotNull;

public class f7a
implements Predicate {
    public SPacketChunkData Field3330;

    public f7a(SPacketChunkData sPacketChunkData) {
        this.Field3330 = sPacketChunkData;
    }

    public boolean test(Object object) {
        return this.Method5155((fe3)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method5155(@NotNull fe3 fe32) {
        Integer n = (Integer)fe32.Method466();
        int n2 = this.Field3330.getChunkX();
        if (n == null) return false;
        if (n != n2) return false;
        Integer n3 = (Integer)fe32.Method465();
        n2 = this.Field3330.getChunkZ();
        if (n3 == null) return false;
        if (n3 != n2) return false;
        return true;
    }
}

