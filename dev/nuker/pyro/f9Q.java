/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import org.jetbrains.annotations.NotNull;

public class f9q
extends Module {
    @NotNull
    public BooleanSetting Field4470 = (BooleanSetting)this.Method7264(new BooleanSetting("inAir", "InAir", null, false));
    @NotNull
    public DoubleSetting Field4471 = (DoubleSetting)this.Method7264(new DoubleSetting("height", "Height", null, 0.5, 0.0, 1.0, 0.0, 64, null));

    @f0g(value=-1)
    @LauncherEventHide
    public void Method559(@NotNull f4p f4p2) {
        block2: {
            block3: {
                if (f4p2.Method7947() || f4p2.Method5619() != f41.Pre) break block2;
                if (!this.Field5233.player.movementInput.jump) break block2;
                if (((Boolean)this.Field4470.Method7979()).booleanValue()) break block3;
                if (!this.Field5233.player.onGround) break block2;
            }
            f4p2.Method7948();
            f4p2.Method5834(((Number)this.Field4471.Method7979()).doubleValue());
            this.Field5233.player.motionY = f4p2.Method5815();
        }
    }

    @NotNull
    public DoubleSetting Method238() {
        return this.Field4471;
    }

    public f9q() {
        super("HighJump", "HighJump", "Allows you to jump higher than normal");
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field4470;
    }
}

