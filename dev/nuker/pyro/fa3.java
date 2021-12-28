/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fa6;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fa3 {
    public double Field1617;
    @Nullable
    public fa3 Field1618;
    @NotNull
    public BlockPos Field1619;
    public double Field1620;
    public fa6 Field1621;

    public fa3(@Nullable fa6 fa62, @NotNull fa3 fa32, BlockPos blockPos, double d) {
        this.Field1621 = fa62;
        this.Field1618 = fa32;
        this.Field1619 = blockPos;
        this.Field1620 = d;
        double d2 = this.Field1619.distanceSq((Vec3i)fa62.Method2337());
        fa3 fa33 = this;
        boolean bl = false;
        double d3 = Math.sqrt(d2);
        fa33.Field1617 = d3 * fa62.Method2332();
    }

    public void Method2291(double d) {
        this.Field1620 = d;
    }

    @Nullable
    public fa3 Method2292() {
        return this.Field1618;
    }

    public boolean Method2293(@NotNull BlockPos blockPos) {
        return Intrinsics.Method6572((Object)this.Field1619, (Object)blockPos);
    }

    public double Method2294() {
        return this.Field1620;
    }

    @NotNull
    public BlockPos Method2295() {
        return this.Field1619;
    }

    public double Method2296() {
        return this.Field1617;
    }

    public void Method2297(@Nullable fa3 fa32) {
        this.Field1618 = fa32;
    }
}

