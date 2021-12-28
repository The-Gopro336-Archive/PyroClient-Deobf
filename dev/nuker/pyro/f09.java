/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f06;

public class f09
extends f06 {
    public Runnable Field5389;
    public float Field5390;

    public f09(Runnable runnable, float f, float f2) {
        this.Field5389 = runnable;
        this.Field5390 = f;
        super(f2);
    }

    @Override
    public void Method7607() {
        this.Field5389.run();
    }
}

