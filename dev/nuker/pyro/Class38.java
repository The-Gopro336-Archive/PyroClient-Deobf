/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Module;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;

public class Class38
implements Predicate {
    public static Class38 Field4588 = new Class38();

    public Boolean Method6737(@NotNull Module module) {
        return (Boolean)module.Field5236.Method5264();
    }

    public boolean test(Object object) {
        return this.Method6737((Module)object);
    }
}

