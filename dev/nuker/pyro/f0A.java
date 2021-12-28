/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0B;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

public class f0A {
    public f0A(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public f0B Method7686(int n, int n2) {
        for (f0B f0B2 : f0B.Method7691()) {
            if (f0B2.Method7689() != n || f0B2.Method7688() != n2) continue;
            return f0B2;
        }
        return null;
    }

    public f0A() {
    }
}

