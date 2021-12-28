/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f40;
import dev.nuker.pyro.f41;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;

public class f4z
extends f40 {
    public float Field4247;

    public f4z(@NotNull AxisAlignedBB axisAlignedBB, float f, @NotNull f41 f412) {
        super(axisAlignedBB, f412);
        this.Field4247 = f;
    }

    public float Method5646() {
        return this.Field4247;
    }

    public void Method5647(float f) {
        this.Field4247 = f;
    }
}

