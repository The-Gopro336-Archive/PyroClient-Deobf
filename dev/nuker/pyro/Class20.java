/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0w;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class Class20
implements Consumer {
    public Module Field3128;

    public Class20(Module module) {
        this.Field3128 = module;
    }

    public void Method374(@NotNull f0w f0w2) {
        Class34.Field4599.Method6753(this.Field3128);
    }

    public void accept(Object object) {
        this.Method374((f0w)object);
    }
}

