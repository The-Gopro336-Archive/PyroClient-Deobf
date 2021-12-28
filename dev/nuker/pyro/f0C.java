/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0B;
import dev.nuker.pyro.f0D;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f0C {
    public f0C(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public f0C() {
    }

    @JvmStatic
    @NotNull
    public f0D Method7780(double d, double d2, int n, int n2) {
        double d3 = d;
        double d4 = d2;
        int n3 = 0;
        int n4 = 0;
        if (d3 < (double)n / 2.0) {
            n3 = -1;
        } else {
            n3 = 1;
            d3 = (double)n - d3;
        }
        if (d4 < (double)n2 / 2.0) {
            n4 = -1;
        } else {
            n4 = 1;
            d4 = (double)n2 - d4;
        }
        return new f0D(f0B.Field5465.Method7686(n3, n4), d3, d4);
    }
}

