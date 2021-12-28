/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.Setting;
import dev.nuker.pyro.f0S;
import dev.nuker.pyro.f13;
import dev.nuker.pyro.fdZ;
import net.minecraft.client.gui.inventory.GuiInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class BindSetting
extends Setting {
    @Override
    @NotNull
    public f13 Method5970() {
        return new f0S(this);
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)new JsonPrimitive((Number)this.Method7976().Method5264());
    }

    public BindSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, int n) {
        super(string, string2, string3, n);
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        this.Method7976().Method5266(jsonElement.getAsInt());
    }

    public boolean Method8796() {
        if (fdZ.Field313.currentScreen != null) {
            boolean bl;
            boolean bl2 = ((Boolean)PyroStatic.Field6432.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6432.Field3588.Method7979()).booleanValue() ? true : (bl = false);
            if (!(fdZ.Field313.currentScreen instanceof GuiInventory)) {
                return false;
            }
            if (!bl) {
                return false;
            }
        }
        if (((Number)this.Method7979()).intValue() != -1 && ((Number)this.Method7979()).intValue() != 0) {
            if (((Number)this.Method7979()).intValue() > 0) {
                return Keyboard.isKeyDown((int)((Number)this.Method7979()).intValue());
            }
            return Mouse.isButtonDown((int)(-((Number)this.Method7979()).intValue()));
        }
        return false;
    }
}

