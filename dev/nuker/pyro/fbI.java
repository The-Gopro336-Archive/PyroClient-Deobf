/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f00;
import dev.nuker.pyro.fbl;
import kotlin.NoWhenBranchMatchedException;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class fbi {
    @NotNull
    public AxisAlignedBB Field2092;
    @NotNull
    public BlockPos Field2093;
    public boolean Field2094;
    public fbl Field2095;

    @NotNull
    public AxisAlignedBB Method2735() {
        return this.Field2092;
    }

    @NotNull
    public BlockPos Method2736() {
        return this.Field2093;
    }

    public int Method2737() {
        int n;
        boolean bl = this.Field2094;
        if (bl) {
            n = ((f00)this.Field2095.Method2368().Method7979()).Method7515();
        } else if (!bl) {
            n = ((f00)this.Field2095.Method2752().Method7979()).Method7515();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return n;
    }

    public int Method2738() {
        int n;
        boolean bl = this.Field2094;
        if (bl) {
            n = ((f00)this.Field2095.Method216().Method7979()).Method7515();
        } else if (!bl) {
            n = ((f00)this.Field2095.Method2746().Method7979()).Method7515();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return n;
    }

    public fbi(@NotNull fbl fbl2, @NotNull AxisAlignedBB axisAlignedBB, BlockPos blockPos, boolean bl) {
        this.Field2095 = fbl2;
        this.Field2092 = axisAlignedBB;
        this.Field2093 = blockPos;
        this.Field2094 = bl;
    }

    public boolean Method2739() {
        return this.Field2094;
    }
}

