/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f81;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f80
implements Consumer {
    public f81 Field3195;

    public void Method182(@NotNull Boolean bl) {
        this.Field3195.Method557(true);
    }

    public void accept(Object object) {
        this.Method182((Boolean)object);
    }

    public f80(f81 f812) {
        this.Field3195 = f812;
    }
}

