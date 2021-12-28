/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import dev.nuker.pyro.fdF;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fdo
implements Consumer {
    public fdF Field399;

    public fdo(fdF fdF2) {
        this.Field399 = fdF2;
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }

    public void Method374(@NotNull f0w f0w2) {
        if (((Boolean)f0w2.Method7979()).booleanValue()) {
            this.Field399.Method279().Method7975(false);
            this.Field399.Method282().Method7975(false);
        }
    }
}

