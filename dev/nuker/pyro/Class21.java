/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class Class21
implements Consumer {
    public Module Field3167;

    public Class21(Module module) {
        this.Field3167 = module;
    }

    public void Method182(@NotNull Boolean bl) {
        this.Field3167.Field5236.Method5266((Object)bl);
        Class34.Field4599.Method6753(this.Field3167);
    }

    public void accept(Object object) {
        this.Method182((Boolean)object);
    }
}

