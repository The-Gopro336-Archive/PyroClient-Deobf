/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.play.server.SPacketPlayerPosLook
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f9k;
import dev.nuker.pyro.f9l;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f9m
extends Module {
    public f0o<f9l> Field4474 = new f0o("mode", "Mode", null, f9l.WaterStrafe);
    public int Field4475 = 0;
    public boolean Field4476 = false;

    public void Method6412(f0w f0w2) {
        this.Method7274(String.valueOf(this.Field4474.Method7979()));
    }

    @f0g
    @LauncherEventHide
    public void Method244(f4e f4e2) {
        if (f4e2.Method5784() instanceof SPacketPlayerPosLook) {
            if (f4e2.Method5619() == f41.Pre) {
                this.Field4476 = true;
            }
        }
    }

    @f0g(value=4)
    @LauncherEventHide
    public void Method559(f4p f4p2) {
        if (f4p2.Method7947() || f4p2.Method5619() != f41.Pre) {
            return;
        }
        if (!this.Field5233.player.isInWater()) {
            if (!this.Field5233.player.isInLava()) {
                this.Field4476 = false;
                return;
            }
        }
        switch (f9k.Field4436[((f9l)((Object)this.Field4474.Method7979())).ordinal()]) {
            case 1: {
                if (!fec.Method727()) break;
                ++this.Field4475;
                if (this.Field4475 == 4) {
                    f4p2.Method7948();
                    fec.Method744(f4p2, 0.4f);
                    break;
                }
                if (this.Field4475 < 5) break;
                f4p2.Method7948();
                fec.Method744(f4p2, 0.3f);
                this.Field4475 = 0;
                break;
            }
            case 2: {
                f4p2.Method7948();
                fec.Method744(f4p2, far.Method2606());
                break;
            }
            case 3: {
                if (this.Field4476) {
                    return;
                }
                f4p2.Method7948();
                fec.Method744(f4p2, 0.215);
                break;
            }
        }
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Method7274(String.valueOf(this.Field4474.Method7979()));
        this.Field4476 = false;
    }

    public f9m() {
        super("fastswim", "FastSwim", "Allows you to move faster in water");
        this.Method7264(this.Field4474);
        this.Field4474.Method7980(this::Method6412);
    }
}

