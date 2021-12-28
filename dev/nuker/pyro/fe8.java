/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

public class fe8 {
    public long Field305 = -1L;

    public long Method488() {
        return this.Field305;
    }

    public void Method489(long l) {
        this.Field305 = l;
    }

    public void Method490() {
        this.Field305 = System.currentTimeMillis();
    }

    public boolean Method491(double d) {
        return (double)(System.currentTimeMillis() - this.Field305) >= d;
    }
}

