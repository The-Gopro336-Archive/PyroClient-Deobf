/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketSpawnPlayer
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnPlayer;
import org.jetbrains.annotations.NotNull;

public class f69
extends Module {
    @NotNull
    public BooleanSetting Field4239 = (BooleanSetting)this.Method7264(new BooleanSetting("gwen", "Gwen", "Tries to remove bots on the GWEN anticheat (Mineplex)", true));

    @NotNull
    public BooleanSetting Method215() {
        return this.Field4239;
    }

    @f0g
    @LauncherEventHide
    public void Method244(@NotNull f4e f4e2) {
        if (f4e2.Method5619() == f41.Pre && ((Boolean)this.Field4239.Method7979()).booleanValue() && f4e2.Method5784() instanceof SPacketSpawnPlayer) {
            Packet packet = f4e2.Method5784();
            if (packet == null) {
                throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketSpawnPlayer");
            }
            SPacketSpawnPlayer sPacketSpawnPlayer = (SPacketSpawnPlayer)packet;
            double d = sPacketSpawnPlayer.getX() / 32.0;
            double d2 = sPacketSpawnPlayer.getY() / 32.0;
            double d3 = sPacketSpawnPlayer.getZ() / 32.0;
            double d4 = this.Field5233.player.posX - d;
            double d5 = this.Field5233.player.posY - d2;
            double d6 = this.Field5233.player.posZ - d3;
            double d7 = d4 * d4 + d5 * d5 + d6 * d6;
            boolean bl = false;
            double d8 = Math.sqrt(d7);
            if (d8 <= (double)17 && d != this.Field5233.player.posX && d2 != this.Field5233.player.posY && d3 != this.Field5233.player.posZ) {
                Pyro.Field6182.Method8989("Removed a bot. [GWEN]");
                f4e2.Method7948();
            }
        }
    }

    public f69() {
        super("antibots", "AntiBots", "Attempts to remove bots on hypixel/mineplex servers");
    }
}

