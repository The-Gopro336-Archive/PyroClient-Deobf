/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0F;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class f0U
implements Supplier {
    public f0F Field5549;

    public Object get() {
        return this.Method7884();
    }

    @NotNull
    public Integer Method7884() {
        return (Integer)this.Field5549.Method7807().get();
    }

    public f0U(f0F f0F2) {
        this.Field5549 = f0F2;
    }
}

