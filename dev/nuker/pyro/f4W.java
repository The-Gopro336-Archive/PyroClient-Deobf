/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f42;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public class f4w
extends f42 {
    @NotNull
    public EnumHand Field4236;
    @NotNull
    public BlockPos Field4237;

    @NotNull
    public EnumHand Method5856() {
        return this.Field4236;
    }

    public void Method5857(@NotNull EnumHand enumHand) {
        this.Field4236 = enumHand;
    }

    @NotNull
    public BlockPos Method5858() {
        return this.Field4237;
    }

    public f4w(@NotNull EnumHand enumHand, @NotNull BlockPos blockPos) {
        this.Field4236 = enumHand;
        this.Field4237 = blockPos;
    }
}

