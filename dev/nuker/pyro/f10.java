/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0F;
import java.util.function.Supplier;

public class f10
implements Supplier {
    public f0F Field5505;

    public int Method7822() {
        return ((Number)this.Field5505.Method7807().get()).intValue() - 1;
    }

    public f10(f0F f0F2) {
        this.Field5505 = f0F2;
    }

    public Object get() {
        return this.Method7822();
    }
}

