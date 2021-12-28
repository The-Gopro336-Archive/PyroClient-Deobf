/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketDestroyEntities
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketDestroyEntities;
import org.jetbrains.annotations.NotNull;

public class f77
extends Module {
    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketDestroyEntities) {
            Packet packet = f4e2.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketDestroyEntities");
            }
            SPacketDestroyEntities sPacketDestroyEntities = (SPacketDestroyEntities)packet;
            for (int n : sPacketDestroyEntities.getEntityIDs()) {
                Entity entity = this.Field5233.world.getEntityByID(n);
                if (entity == null || !(entity.getDistance((Entity)this.Field5233.player) > (float)1000)) continue;
                Pyro.Field6182.Method8989("Entity despawned far away at " + entity.getPosition().toString());
            }
        }
    }

    public f77() {
        super("coordtpexploit", "CoordTpExploit", null);
    }
}

