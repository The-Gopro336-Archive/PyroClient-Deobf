/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f17 {
    public double Field5558;
    public double Field5559;
    public int Field5560;

    public void Method7892(double d) {
        this.Field5559 = d;
    }

    public void Method7893(double d) {
        this.Field5558 = d;
    }

    public void Method7894(int n) {
        this.Field5560 = n;
    }

    public int Method7895() {
        return this.Field5560;
    }

    public double Method7896() {
        return this.Field5559;
    }

    public double Method7897() {
        return this.Field5558;
    }

    public f17(double d, double d2, int n) {
        this.Field5558 = d;
        this.Field5559 = d2;
        this.Field5560 = n;
    }

    @NotNull
    public f17 Method7865(double d, double d2) {
        return new f17(this.Field5558 - d, this.Field5559 - d2, this.Field5560);
    }
}

