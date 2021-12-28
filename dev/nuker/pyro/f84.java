/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4u;
import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f84
extends Module {
    @f0g
    @LauncherEventHide
    public void Method203(f4u f4u2) {
        if (f4u2.Method5619() == f41.Pre && (double)this.Field5233.player.getHealth() <= 0.0) {
            this.Field5233.player.respawnPlayer();
        }
    }

    public f84() {
        super("autorespawn", "AutoRespawn", null);
    }
}

