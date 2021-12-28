/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0F;
import java.util.function.Supplier;

public class f0T
implements Supplier {
    public f0F Field5543;

    public int Method7822() {
        return ((Number)this.Field5543.Method7807().get()).intValue() - 1;
    }

    public Object get() {
        return this.Method7822();
    }

    public f0T(f0F f0F2) {
        this.Field5543 = f0F2;
    }
}

