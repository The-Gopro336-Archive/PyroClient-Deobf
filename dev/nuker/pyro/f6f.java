/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.EnchantmentProtection$Type
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f6g;
import dev.nuker.pyro.f6i;
import net.minecraft.enchantment.EnchantmentProtection;

public class f6f {
    public static int[] Field3129;
    public static int[] Field3130;
    public static int[] Field3131;

    static {
        Field3131 = new int[f6i.Method5133().length];
        try {
            f6f.Field3131[f6i.Blast.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            f6f.Field3131[f6i.Prot.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field3130 = new int[EnchantmentProtection.Type.values().length];
        try {
            f6f.Field3130[EnchantmentProtection.Type.ALL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            f6f.Field3130[EnchantmentProtection.Type.EXPLOSION.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        Field3129 = new int[f6g.Method5069().length];
        try {
            f6f.Field3129[f6g.FlyEnabled.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            f6f.Field3129[f6g.Key.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

