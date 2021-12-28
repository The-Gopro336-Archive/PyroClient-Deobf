/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fee {
    @NotNull
    public BlockPos Field446;
    @NotNull
    public EnumFacing Field447;

    public fee(@NotNull BlockPos blockPos, @NotNull EnumFacing enumFacing) {
        this.Field446 = blockPos;
        this.Field447 = enumFacing;
    }

    public void Method675(@NotNull EnumFacing enumFacing) {
        this.Field447 = enumFacing;
    }

    public void Method676(@NotNull BlockPos blockPos) {
        this.Field446 = blockPos;
    }

    @NotNull
    public EnumFacing Method677() {
        return this.Field447;
    }

    @NotNull
    public BlockPos Method678() {
        return this.Field446;
    }
}

