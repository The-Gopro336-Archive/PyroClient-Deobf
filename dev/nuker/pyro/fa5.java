/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fa3;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

public class fa5
implements Function {
    public static fa5 Field1625 = new fa5();

    public Object apply(Object object) {
        return this.Method2324((fa3)object);
    }

    public double Method2324(@NotNull fa3 fa32) {
        return fa32.Method2296() + fa32.Method2294();
    }
}

