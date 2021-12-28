/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;

public class fev
extends fdZ {
    public static float Method825(float f, float f2) {
        return Math.abs(((f - f2 + 180.0f) % 360.0f + 360.0f) % 360.0f - 180.0f);
    }
}

