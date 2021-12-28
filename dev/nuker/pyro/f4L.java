/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f41;
import dev.nuker.pyro.f42;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class f4l
extends f42 {
    public BlockPos Field4152;
    public EnumFacing Field4153;

    public EnumFacing Method5786() {
        return this.Field4153;
    }

    public BlockPos Method5787() {
        return this.Field4152;
    }

    public f4l(f41 f412, BlockPos blockPos, EnumFacing enumFacing) {
        super(f412);
        this.Field4152 = blockPos;
        this.Field4153 = enumFacing;
    }

    public void Method5788(BlockPos blockPos) {
        this.Field4152 = blockPos;
    }

    public void Method5789(EnumFacing enumFacing) {
        this.Field4153 = enumFacing;
    }
}

