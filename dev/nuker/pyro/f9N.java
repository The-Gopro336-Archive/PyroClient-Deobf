/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f9T;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9N
implements Consumer {
    public f9T Field3617;

    public void Method374(@NotNull f0w f0w2) {
        this.Field3617.Method4989();
        this.Field3617.Method5281();
    }

    public f9N(f9T f9T2) {
        this.Field3617 = f9T2;
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }
}

