/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumHand
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4l;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fdl;
import dev.nuker.pyro.mixin.PlayerControllerMPAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;

public class fdm
extends Module {
    public f0o<fdl> Field345 = new f0o("mode", "Mode", null, fdl.Normal);
    public DoubleSetting Field346 = new DoubleSetting("startDamage", "Start Damage", null, 0.0, 0.0, 1.0);
    public DoubleSetting Field347 = new DoubleSetting("enddamage", "End Damage", null, 0.7f, 0.0, 1.0);

    public fdm() {
        super("speedmine", "Speedmine", "Allows you to mine blocks faster");
        this.Method7264(this.Field345);
        this.Method7264(this.Field346);
        this.Method7264(this.Field347);
    }

    @f0g
    @LauncherEventHide
    public void Method563(f4l f4l2) {
        if (f4l2.Method5619() == f41.Pre && this.Field345.Method7979() == fdl.Packet) {
            f4l2.Method7948();
            this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
            this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, f4l2.Method5787(), f4l2.Method5786()));
            this.Field5233.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, f4l2.Method5787(), f4l2.Method5786()));
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        this.Method7274(String.valueOf(this.Field345.Method7979()));
        if (this.Field345.Method7979() == fdl.Normal) {
            PlayerControllerMPAccessor playerControllerMPAccessor = (PlayerControllerMPAccessor)this.Field5233.playerController;
            playerControllerMPAccessor.Method66(0);
            if ((Double)this.Field346.Method7979() != 0.0) {
                if ((double)playerControllerMPAccessor.Method65() <= (Double)this.Field346.Method7979()) {
                    double d = (Double)this.Field346.Method7979();
                    playerControllerMPAccessor.Method64((float)d);
                }
            }
            if ((double)playerControllerMPAccessor.Method65() >= (Double)this.Field347.Method7979()) {
                playerControllerMPAccessor.Method64(1.0f);
            }
        }
    }
}

