/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fe8;
import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f02 {
    public float Field5380 = -1337.0f;
    public float Field5381 = -1337.0f;
    public float Field5382 = -1337.0f;
    public float Field5383 = -1337.0f;
    public fe8 Field5384 = new fe8();

    public void Method7536(float f) {
        this.Field5381 = f;
    }

    public float Method7537() {
        return this.Field5381;
    }

    public void Method7538(float f) {
        this.Field5383 = f;
        this.Field5384.Method490();
    }

    public void Method7539(float f) {
        this.Field5380 = f;
    }

    public float Method7540() {
        return this.Field5380;
    }

    public float Method7541() {
        return this.Field5383;
    }

    public void Method7542(float f) {
        this.Field5382 = f;
        this.Field5384.Method490();
    }

    @f0g
    @LauncherEventHide
    public void Method7543(f4t f4t2) {
        if (this.Field5384.Method491(100.0)) {
            this.Field5384.Method490();
            this.Field5380 = -1337.0f;
            this.Field5381 = -1337.0f;
            this.Field5382 = -1337.0f;
            this.Field5383 = -1337.0f;
        }
    }

    public float Method7544() {
        return this.Field5382;
    }

    public void Method7545() {
        Pyro.Method8978().Method7915(this);
    }
}

