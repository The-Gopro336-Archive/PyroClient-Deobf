/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.EnumFacing;
import org.jetbrains.annotations.NotNull;

public class fdQ {
    @NotNull
    public static HashMap<EnumFacing, Integer> Field280;
    public static fdQ Field281;

    static {
        fdQ fdQ2;
        Field281 = fdQ2 = new fdQ();
        Field280 = new HashMap();
        ((Map)Field280).put(EnumFacing.DOWN, 1);
        ((Map)Field280).put(EnumFacing.WEST, 16);
        ((Map)Field280).put(EnumFacing.NORTH, 4);
        ((Map)Field280).put(EnumFacing.SOUTH, 8);
        ((Map)Field280).put(EnumFacing.EAST, 32);
        ((Map)Field280).put(EnumFacing.UP, 2);
    }

    @NotNull
    public HashMap Method454() {
        return Field280;
    }
}

