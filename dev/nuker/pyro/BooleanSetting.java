/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.nuker.pyro.Setting;
import dev.nuker.pyro.f0K;
import dev.nuker.pyro.f13;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BooleanSetting
extends Setting {
    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        this.Method7976().Method5266(jsonElement.getAsBoolean());
    }

    public BooleanSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, boolean bl) {
        super(string, string2, string3, bl);
    }

    @Override
    @NotNull
    public f13 Method5970() {
        return new f0K(this);
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)new JsonPrimitive((Boolean)this.Method7976().Method5264());
    }
}

