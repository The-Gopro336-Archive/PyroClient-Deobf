/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f17;
import org.jetbrains.annotations.NotNull;

public class f15
extends f17 {
    public double Field5544;
    public double Field5545;
    public double Field5546;
    public double Field5547;

    public f15(double d, double d2, double d3, double d4, double d5, double d6, int n) {
        super(d3, d4, n);
        this.Field5544 = d;
        this.Field5545 = d2;
        this.Field5546 = d5;
        this.Field5547 = d6;
    }

    public void Method7874(double d) {
        this.Field5547 = d;
    }

    public double Method7875() {
        return this.Field5545;
    }

    public void Method7876(double d) {
        this.Field5545 = d;
    }

    public void Method7877(double d) {
        this.Field5544 = d;
    }

    public void Method7878(double d) {
        this.Field5546 = d;
    }

    public double Method7879() {
        return this.Field5547;
    }

    @Override
    @NotNull
    public f17 Method7865(double d, double d2) {
        return new f15(this.Field5544 - d, this.Field5545 - d2, this.Method7897() - d, this.Method7896() - d2, this.Field5546, this.Field5547, this.Method7895());
    }

    public double Method7880() {
        return this.Field5546;
    }

    public double Method7881() {
        return this.Field5544;
    }
}

