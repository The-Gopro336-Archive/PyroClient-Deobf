/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Class6 {
    public int Field5308;
    @NotNull
    public List<String> Field5309;

    @NotNull
    public List Method7345() {
        return this.Field5309;
    }

    public void Method7346(@NotNull List list) {
        this.Field5309 = list;
    }

    public int Method7347() {
        return this.Field5308;
    }

    public Class6(int n, @NotNull List list) {
        this.Field5308 = n;
        this.Field5309 = list;
    }
}

