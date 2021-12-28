/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f07;
import org.jetbrains.annotations.NotNull;

public class f08 {
    @NotNull
    public f07 Field5387;
    public float Field5388;

    @NotNull
    public f07 Method7603() {
        return this.Field5387;
    }

    public float Method7604() {
        return this.Field5388;
    }

    public void Method7605(@NotNull f07 f072) {
        this.Field5387 = f072;
    }

    public void Method7606(float f) {
        this.Field5388 = f;
    }

    public f08(@NotNull f07 f072, float f) {
        this.Field5387 = f072;
        this.Field5388 = f;
    }
}

