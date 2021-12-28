/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import java.util.function.Consumer;

public class Class27
implements Consumer {
    public Module Field3204;

    public void Method5120(boolean bl) {
        Class34.Field4599.Method6753(this.Field3204);
    }

    public void accept(Object object) {
        this.Method5120((Boolean)object);
    }

    public Class27(Module module) {
        this.Field3204 = module;
    }
}

