/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.far;
import dev.nuker.pyro.fec;
import org.jetbrains.annotations.NotNull;

public class fas
extends far {
    @Override
    public void Method461() {
    }

    @Override
    public void Method2364(@NotNull f4p f4p2) {
    }

    @Override
    public void Method2363(@NotNull f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre && fec.Method727()) {
            if (!far.Field313.player.isSneaking()) {
                far.Field313.player.cameraPitch = 0.0f;
                if (far.Field313.player.onGround) {
                    far.Field313.player.motionY = 0.3425;
                    far.Field313.player.motionX *= 1.5893;
                    far.Field313.player.motionZ *= 1.5893;
                } else {
                    far.Field313.player.motionY = -0.19;
                }
            }
        }
    }

    @Override
    public void Method455() {
    }
}

