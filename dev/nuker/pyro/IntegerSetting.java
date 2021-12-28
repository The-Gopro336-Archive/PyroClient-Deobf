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
import dev.nuker.pyro.f0R;
import dev.nuker.pyro.f13;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IntegerSetting
extends Setting {
    public int Field4307;
    public int Field4308;
    public int Field4309;

    @JvmOverloads
    public IntegerSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, int n, int n2, int n3) {
        this(string, string2, string3, n, n2, n3, 0, 64, null);
    }

    public void Method5962(int n) {
        this.Field4308 = n;
    }

    public void Method5963(int n) {
        this.Field4307 = n;
    }

    @JvmOverloads
    public IntegerSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, int n, int n2, int n3, int n4) {
        super(string, string2, string3, n);
        this.Field4307 = n2;
        this.Field4308 = n3;
        this.Field4309 = n4;
    }

    public IntegerSetting(String string, String string2, String string3, int n, int n2, int n3, int n4, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 0x40) != 0) {
            n4 = n3 - n2;
        }
        this(string, string2, string3, n, n2, n3, n4);
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        this.Method7976().Method5266(jsonElement.getAsInt());
    }

    public int Method5965() {
        return this.Field4309;
    }

    public int Method5966() {
        return this.Field4308;
    }

    public void Method5967(int n) {
        this.Field4309 = n;
    }

    public int Method5968() {
        return this.Field4307;
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)new JsonPrimitive((Number)this.Method7976().Method5264());
    }

    @Override
    @NotNull
    public f13 Method5970() {
        return new f0R(this);
    }
}

