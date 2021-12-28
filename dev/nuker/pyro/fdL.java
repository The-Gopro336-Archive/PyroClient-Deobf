/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.EnumDifficulty
 */
package dev.nuker.pyro;

import net.minecraft.world.EnumDifficulty;

public class fdL {
    public static int[] Field232 = new int[EnumDifficulty.values().length];

    static {
        try {
            fdL.Field232[EnumDifficulty.PEACEFUL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fdL.Field232[EnumDifficulty.EASY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fdL.Field232[EnumDifficulty.HARD.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

