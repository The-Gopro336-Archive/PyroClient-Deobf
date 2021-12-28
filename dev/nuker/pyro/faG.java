/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f07;
import dev.nuker.pyro.f0b;
import dev.nuker.pyro.fai;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public class fag
extends Lambda
implements Function0 {
    public fai Field1933;

    public void Method2267() {
        f0b.Field5568.Method7902("elytraflyCreative", f07.MULTIPLY, (float)((Number)this.Field1933.Method2531().Method7979()).doubleValue());
    }

    public Object Method945() {
        this.Method2267();
        return Unit.Field4531;
    }

    public fag(fai fai2) {
        this.Field1933 = fai2;
        super(0);
    }
}

