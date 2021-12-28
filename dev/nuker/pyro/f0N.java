/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonNull
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import dev.nuker.pyro.Setting;
import dev.nuker.pyro.f0N;
import dev.nuker.pyro.f13;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0n
extends Setting {
    @Override
    @NotNull
    public f13 Method5970() {
        return new f0N(this);
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
    }

    public f0n(@NotNull String string, @NotNull String string2, @Nullable String string3) {
        super(string, string2, string3, Unit.Field4531);
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)JsonNull.INSTANCE;
    }
}

