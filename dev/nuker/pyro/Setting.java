/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f0w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Setting
extends f0w {
    @NotNull
    public String Field4328;

    @NotNull
    public String Method5989() {
        return this.Field4328;
    }

    public Setting(@NotNull String string, @NotNull String string2, Object object) {
        this(string, string2, null, object);
    }

    public void Method5990(@NotNull String string) {
        this.Field4328 = string;
    }

    public Setting(@NotNull String string, @NotNull String string2, @Nullable String string3, Object object) {
        super(string, string3, object);
        this.Field4328 = string2;
    }
}

