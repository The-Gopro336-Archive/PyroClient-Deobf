/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.util.EnumHand
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f7w;
import dev.nuker.pyro.f7x;
import dev.nuker.pyro.mixin.CPacketAnimationAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import org.jetbrains.annotations.NotNull;

public class f7y
extends Module {
    @NotNull
    public f0o<f7w> Field3486 = (f0o)this.Method7264(new f0o("mode", "Mode", null, f7w.Cancel));

    @NotNull
    public f0o Method2672() {
        return this.Field3486;
    }

    public f7y() {
        super("swing", "Swing", null);
    }

    @f0g
    @LauncherEventHide
    public void Method2393(@NotNull f49 f492) {
        if (this.Field5233.player != null && f492.Method5619() == f41.Pre) {
            if (f492.Method5784() instanceof CPacketAnimation) {
                Packet packet = f492.Method5784();
                if (packet == null) {
                    throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketAnimation");
                }
                CPacketAnimation cPacketAnimation = (CPacketAnimation)packet;
                switch (f7x.Field3484[((f7w)((Object)this.Field3486.Method7979())).ordinal()]) {
                    case 1: {
                        f492.Method7948();
                        break;
                    }
                    case 2: {
                        CPacketAnimation cPacketAnimation2 = cPacketAnimation;
                        if (cPacketAnimation2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketAnimationAccessor");
                        }
                        ((CPacketAnimationAccessor)cPacketAnimation2).Method4319(EnumHand.OFF_HAND);
                        break;
                    }
                }
            }
        }
    }
}

