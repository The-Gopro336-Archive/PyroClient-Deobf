/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f17;
import dev.nuker.pyro.f18;
import org.jetbrains.annotations.NotNull;

public class f16
extends f18 {
    public double Field5550;
    public double Field5551;

    public void Method7877(double d) {
        this.Field5551 = d;
    }

    public double Method7879() {
        return this.Field5551;
    }

    @Override
    @NotNull
    public f17 Method7865(double d, double d2) {
        return new f16(this.Field5550 - d, this.Field5551 - d2, this.Method7897() - d, this.Method7896() - d2, this.Method7895());
    }

    public void Method7876(double d) {
        this.Field5550 = d;
    }

    public f16(double d, double d2, double d3, double d4, int n) {
        super(d3, d4, n);
        this.Field5550 = d;
        this.Field5551 = d2;
    }

    public double Method7875() {
        return this.Field5550;
    }
}

