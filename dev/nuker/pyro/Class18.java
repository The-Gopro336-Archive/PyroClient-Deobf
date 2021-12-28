/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import java.util.function.Consumer;

public class Class18
implements Consumer {
    public Module Field2987;

    public Class18(Module module) {
        this.Field2987 = module;
    }

    public void Method4877(Integer n) {
        this.Field2987.Method7254(n);
    }

    public void accept(Object object) {
        this.Method4877((Integer)object);
    }
}

