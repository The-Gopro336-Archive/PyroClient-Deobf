/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import java.util.function.Consumer;

public class Class24
implements Consumer {
    public Module Field3219;

    public void Method182(Boolean bl) {
        Class34.Field4599.Method6753(this.Field3219);
    }

    public void accept(Object object) {
        this.Method182((Boolean)object);
    }

    public Class24(Module module) {
        this.Field3219 = module;
    }
}

