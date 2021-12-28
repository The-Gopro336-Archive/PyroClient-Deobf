/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f3Y;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class f4c {
    @NotNull
    public List<Class<? extends f3Y>> Field4121;

    public void Method5762(@NotNull List list) {
        this.Field4121 = list;
    }

    @NotNull
    public List Method5763() {
        return this.Field4121;
    }

    @NotNull
    public f3Y Method5764(int n) {
        return this.Field4121.get(n).newInstance();
    }

    public f4c(@NotNull List list) {
        this.Field4121 = list;
    }
}

