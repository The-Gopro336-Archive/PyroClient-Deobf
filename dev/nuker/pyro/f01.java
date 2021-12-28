/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.gui.ClickGui$Window;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f01
extends Module {
    @Override
    @NotNull
    public JsonObject Method7255() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("enabled", (JsonElement)new JsonPrimitive((Boolean)this.Field5236.Method5264()));
        jsonObject.add("expanded", (JsonElement)new JsonPrimitive((Boolean)this.Field5237.Method5264()));
        jsonObject.add("keybind", (JsonElement)new JsonPrimitive((Number)this.Method7271()));
        return jsonObject;
    }

    @Override
    public void Method7261(@NotNull ClickGui$Window clickGui$Window) {
        this.Method2616();
        super.Method7261(clickGui$Window);
    }

    @Override
    public void Method7257(@Nullable JsonObject jsonObject) {
        if (jsonObject != null) {
            this.Field5236.Method5266(jsonObject.get("enabled").getAsBoolean());
            this.Field5237.Method5266(jsonObject.get("expanded").getAsBoolean());
            this.Method7254(jsonObject.get("keybind").getAsInt());
        }
    }

    public void Method2616() {
    }

    public f01(@NotNull String string, @NotNull String string2, @Nullable String string3) {
        super(string, string2, string3);
    }
}

