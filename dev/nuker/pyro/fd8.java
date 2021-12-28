/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.EntityEquipmentSlot
 */
package dev.nuker.pyro;

import net.minecraft.inventory.EntityEquipmentSlot;

public class fd8 {
    public static int[] Field197 = new int[EntityEquipmentSlot.values().length];

    static {
        try {
            fd8.Field197[EntityEquipmentSlot.HEAD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fd8.Field197[EntityEquipmentSlot.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fd8.Field197[EntityEquipmentSlot.LEGS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            fd8.Field197[EntityEquipmentSlot.FEET.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

