/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0B;
import dev.nuker.pyro.f0C;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0D {
    @Nullable
    public f0B Field5486 = f0B.TOP_LEFT;
    public double Field5487;
    public double Field5488;
    public static f0C Field5489 = new f0C(null);

    public f0D(@Nullable f0B f0B2, double d, double d2) {
        this.Field5486 = f0B2;
        this.Field5487 = d;
        this.Field5488 = d2;
    }

    public void Method7790(@Nullable f0B f0B2) {
        this.Field5486 = f0B2;
    }

    public double Method7791() {
        return this.Field5487;
    }

    @Nullable
    public f0B Method7792() {
        return this.Field5486;
    }

    public double Method7793(int n) {
        f0B f0B2 = this.Field5486;
        if (f0B2 == null) {
            Intrinsics.Method6551();
        }
        return f0B2.Method7690(this.Field5487, n);
    }

    @JvmStatic
    @NotNull
    public static f0D Method7794(double d, double d2, int n, int n2) {
        return Field5489.Method7780(d, d2, n, n2);
    }

    public double Method7795() {
        return this.Field5488;
    }

    public void Method7796(double d) {
        this.Field5487 = d;
    }

    public double Method7797(int n) {
        f0B f0B2 = this.Field5486;
        if (f0B2 == null) {
            Intrinsics.Method6551();
        }
        return f0B2.Method7687(this.Field5488, n);
    }

    public void Method7798(double d) {
        this.Field5488 = d;
    }
}

