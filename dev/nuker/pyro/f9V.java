/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f9A;
import dev.nuker.pyro.f9w;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9v
implements Consumer {
    public f9A Field4502;

    public void Method374(@NotNull f0w f0w2) {
        this.Field4502.Method5281();
        this.Field4502.Method7274(((f9w)((Object)this.Field4502.Method5280().Method7979())).toString());
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }

    public f9v(f9A f9A2) {
        this.Field4502 = f9A2;
    }
}

