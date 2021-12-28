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

public class fdn
implements Consumer {
    public fdF Field361;

    public void accept(Object object) {
        this.Method374((f0w)object);
    }

    public fdn(fdF fdF2) {
        this.Field361 = fdF2;
    }

    public void Method374(@NotNull f0w f0w2) {
        if (((Boolean)f0w2.Method7979()).booleanValue()) {
            this.Field361.Method284().Method7975(false);
            this.Field361.Method282().Method7975(false);
        }
    }
}

