/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public class f2I
implements Function {
    public static f2I Field3736 = new f2I();

    public Object apply(Object object) {
        return this.Method5472((Module)object);
    }

    public Boolean Method5472(@NotNull Module module) {
        return (Boolean)module.Field5236.Method5264();
    }
}

