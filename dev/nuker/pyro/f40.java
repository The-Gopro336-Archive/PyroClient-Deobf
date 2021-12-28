/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f41;
import dev.nuker.pyro.f42;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

public class f40
extends f42 {
    @NotNull
    public AxisAlignedBB Field3909;

    public void Method5607(@NotNull AxisAlignedBB axisAlignedBB) {
        this.Field3909 = axisAlignedBB;
    }

    public f40(@NotNull AxisAlignedBB axisAlignedBB, @NotNull f41 f412) {
        super(f412);
        this.Field3909 = axisAlignedBB;
    }

    @NotNull
    public AxisAlignedBB Method5608() {
        return this.Field3909;
    }
}

