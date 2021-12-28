/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f7p;

public class f7j {
    public double Field3449;
    public double Field3450;
    public double Field3451;
    public long Field3452;
    public f7p Field3453;

    public f7j(f7p f7p2, double d, double d2, double d3, long l) {
        this.Field3453 = f7p2;
        this.Field3449 = d;
        this.Field3450 = d2;
        this.Field3451 = d3;
        this.Field3452 = l;
    }

    public void Method5248(long l) {
        this.Field3452 = l;
    }

    public long Method5249() {
        return this.Field3452;
    }

    public double Method5250() {
        return this.Field3449;
    }

    public void Method5251(double d) {
        this.Field3450 = d;
    }

    public void Method5252(double d) {
        this.Field3451 = d;
    }

    public double Method5253() {
        return this.Field3450;
    }

    public double Method5254() {
        return this.Field3451;
    }

    public void Method5255(double d) {
        this.Field3449 = d;
    }
}

