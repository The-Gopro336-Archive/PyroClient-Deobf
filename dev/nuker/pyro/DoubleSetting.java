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
import dev.nuker.pyro.f0M;
import dev.nuker.pyro.f13;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoubleSetting
extends Setting {
    public double Field7567;
    public double Field7568;
    public double Field7569;

    public double Method12507() {
        return this.Field7569;
    }

    public double Method12508() {
        return this.Field7567;
    }

    @JvmOverloads
    public DoubleSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, double d, double d2, double d3, double d4) {
        super(string, string2, string3, d);
        this.Field7567 = d2;
        this.Field7568 = d3;
        this.Field7569 = d4;
    }

    public void Method12509(double d) {
        this.Field7568 = d;
    }

    public void Method12510(double d) {
        this.Field7567 = d;
    }

    @JvmOverloads
    public DoubleSetting(@NotNull String string, @NotNull String string2, @Nullable String string3, double d, double d2, double d3) {
        this(string, string2, string3, d, d2, d3, 0.0, 64, null);
    }

    public DoubleSetting(String string, String string2, String string3, double d, double d2, double d3, double d4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x40) != 0) {
            d4 = d3 - d2;
        }
        this(string, string2, string3, d, d2, d3, d4);
    }

    @Override
    @NotNull
    public f13 Method5970() {
        return new f0M(this);
    }

    public double Method12511() {
        return this.Field7568;
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        this.Method7976().Method5266(jsonElement.getAsDouble());
    }

    public void Method12512(double d) {
        this.Field7569 = d;
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)new JsonPrimitive((Number)this.Method7976().Method5264());
    }
}

