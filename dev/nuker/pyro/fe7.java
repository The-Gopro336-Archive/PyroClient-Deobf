/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import java.util.concurrent.TimeUnit;

public class fe7 {
    public long Field256;

    public void Method442() {
        this.Field256 = System.nanoTime();
    }

    public long Method443(TimeUnit timeUnit) {
        return timeUnit.convert(System.nanoTime() - this.Field256, TimeUnit.NANOSECONDS);
    }

    public long Method444() {
        return this.Field256;
    }

    public long Method445() {
        return this.Method443(TimeUnit.MILLISECONDS);
    }

    public boolean Method446(long l) {
        return this.Method447(l, TimeUnit.MILLISECONDS);
    }

    public boolean Method447(long l, TimeUnit timeUnit) {
        long l2 = timeUnit.convert(System.nanoTime() - this.Field256, TimeUnit.NANOSECONDS);
        if (l2 >= l) {
            this.Method442();
        }
        return l2 >= l;
    }
}

