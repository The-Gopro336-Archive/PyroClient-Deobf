/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fbM;

public class fbK {
    public static int[] Field1895 = new int[fbM.Method2638().length];

    static {
        try {
            fbK.Field1895[fbM.FISHING_ROD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fbK.Field1895[fbM.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fbK.Field1895[fbM.ARROW.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

