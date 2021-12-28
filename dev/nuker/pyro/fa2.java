/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fa2
extends Enum {
    public static /* enum */ fa2 NORTH;
    public static /* enum */ fa2 SOUTH;
    public static /* enum */ fa2 WEST;
    public static /* enum */ fa2 EAST;
    public static /* enum */ fa2 UP;
    public static /* enum */ fa2 DOWN;
    public static /* enum */ fa2 NORTHWEST;
    public static /* enum */ fa2 NORTHEAST;
    public static /* enum */ fa2 SOUTHWEST;
    public static /* enum */ fa2 SOUTHEAST;
    public static /* synthetic */ fa2[] Field1614;
    @NotNull
    public BlockPos Field1615;
    public double Field1616;

    @NotNull
    public BlockPos Method2287() {
        return this.Field1615;
    }

    public double Method2288() {
        return this.Field1616;
    }

    public static fa2 Method2289(String string) {
        return Enum.valueOf(fa2.class, string);
    }

    static {
        fa2[] arrfa2 = new fa2[10];
        fa2[] arrfa22 = arrfa2;
        arrfa2[0] = NORTH = new fa2("NORTH", 0, new BlockPos(0, 0, -1), 1.0);
        arrfa2[1] = SOUTH = new fa2("SOUTH", 1, new BlockPos(0, 0, 1), 1.0);
        arrfa2[2] = WEST = new fa2("WEST", 2, new BlockPos(-1, 0, 0), 1.0);
        arrfa2[3] = EAST = new fa2("EAST", 3, new BlockPos(1, 0, 0), 1.0);
        arrfa2[4] = UP = new fa2("UP", 4, new BlockPos(0, 1, 0), 1.5);
        arrfa2[5] = DOWN = new fa2("DOWN", 5, new BlockPos(0, -1, 0), 1.5);
        arrfa2[6] = NORTHWEST = new fa2("NORTHWEST", 6, new BlockPos(-1, 0, -1), 1.41421356237);
        arrfa2[7] = NORTHEAST = new fa2("NORTHEAST", 7, new BlockPos(1, 0, -1), 1.41421356237);
        arrfa2[8] = SOUTHWEST = new fa2("SOUTHWEST", 8, new BlockPos(-1, 0, 1), 1.41421356237);
        arrfa2[9] = SOUTHEAST = new fa2("SOUTHEAST", 9, new BlockPos(1, 0, 1), 1.41421356237);
        Field1614 = arrfa2;
    }

    public static fa2[] Method2290() {
        return (fa2[])Field1614.clone();
    }

    /*
     * WARNING - void declaration
     */
    public fa2() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.Field1615 = var3_1;
        this.Field1616 = var4_2;
    }
}

