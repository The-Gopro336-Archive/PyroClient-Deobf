/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumHand
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.util.EnumHand;

public class f7S
extends Module {
    public float Field3318 = 0.0f;

    @f0g(value=-30)
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method7947()) {
            return;
        }
        f4u2.Method7948();
        f4u2.Method5653(this.Field3318 += 20.0f);
        f4u2.Method5647((float)(Math.random() * 90.0));
        if (this.Field3318 > 360.0f) {
            this.Field3318 = 0.0f;
        }
        if (this.Field5233.player.ticksExisted % 2 == 0) {
            this.Field5233.player.swingArm(EnumHand.MAIN_HAND);
        } else {
            this.Field5233.player.swingArm(EnumHand.OFF_HAND);
        }
    }

    public f7S() {
        super("antiaim", "AntiAim", "Spinbot");
    }
}

