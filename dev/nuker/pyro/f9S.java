/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f9t;

public class f9s {
    public static int[] Field4472 = new int[f9t.Method6426().length];

    static {
        try {
            f9s.Field4472[f9t.Dolphin.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            f9s.Field4472[f9t.Solid.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            f9s.Field4472[f9t.Trampoline.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

