/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.faa;
import dev.nuker.pyro.fec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public class fa9
extends Lambda
implements Function0 {
    public faa Field1623;

    public fa9(faa faa2) {
        this.Field1623 = faa2;
        super(0);
    }

    public double Method2321() {
        double d = ((Number)this.Field1623.Method2477().Method7979()).doubleValue();
        float f = fec.Method733();
        double d2 = d - (double)f;
        double d3 = (double)f + ((Number)this.Field1623.Method2466().Method7979()).doubleValue();
        boolean bl = false;
        double d4 = Math.min(d, d3);
        String string = d + " - " + f + " : " + ((double)f + ((Number)this.Field1623.Method2466().Method7979()).doubleValue()) + " : " + d2 + " - " + d4;
        boolean bl2 = false;
        System.out.println((Object)string);
        return d4;
    }

    public Object Method945() {
        return this.Method2321();
    }
}

