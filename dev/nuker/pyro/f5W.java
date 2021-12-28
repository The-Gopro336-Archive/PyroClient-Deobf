/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f5G;
import dev.nuker.pyro.f5o;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.feq;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5w
extends f5o {
    @NotNull
    public BooleanSetting Field3071 = new BooleanSetting("rainbow", "Rainbow", null, true);
    @NotNull
    public IntegerSetting Field3072 = new IntegerSetting("distance", "Distance", null, 3, 0, 20, 0, 64, null);
    public int Field3073;
    @NotNull
    public feq Field3074;

    @NotNull
    public BooleanSetting Method4945() {
        return this.Field3071;
    }

    @NotNull
    public feq Method4946() {
        return this.Field3074;
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        this.Field3073 = 0;
        super.Method4875(f5t2, n, scaledResolution, f, f2);
    }

    public void Method4947(@NotNull feq feq2) {
        this.Field3074 = feq2;
    }

    public int Method4948(@NotNull f5G f5G2) {
        if (((Boolean)this.Field3071.Method7979()).booleanValue()) {
            this.Field3074.Method870();
            this.Field3073 += ((Number)this.Field3072.Method7979()).intValue();
            if (this.Field3073 > 360) {
                this.Field3073 = 0;
            }
            return this.Field3074.Method869(this.Field3073);
        }
        return f5G2.Method5742();
    }

    public f5w(int n) {
        super("arrayList", n);
        this.Method4959(new f0t(this.Field3071, this.Field3072));
        this.Field3074 = new feq(50, 100.0f, 50.0f, 0.0f, 8, null);
    }

    @NotNull
    public IntegerSetting Method4949() {
        return this.Field3072;
    }

    public int Method2679() {
        return this.Field3073;
    }

    public void Method2377(int n) {
        this.Field3073 = n;
    }
}

