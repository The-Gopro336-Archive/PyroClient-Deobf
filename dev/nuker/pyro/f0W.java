/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import dev.nuker.pyro.Class56;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.f0v;
import dev.nuker.pyro.f13;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0w {
    @NotNull
    public Class57<T> Field5625;
    public List<Consumer<f0w<T>>> Field5626;
    @NotNull
    public String Field5627;
    @Nullable
    public String Field5628;
    public T Field5629;

    public Object Method7966() {
        return this.Field5629;
    }

    @Nullable
    public String Method7969() {
        return this.Field5628;
    }

    public void Method7970(@NotNull String string) {
        this.Field5627 = string;
    }

    public void Method7971(@Nullable String string) {
        this.Field5628 = string;
    }

    public f0w(@NotNull String string, Object object) {
        this(string, null, object);
    }

    public void Method7968(Object object) {
        this.Field5629 = object;
    }

    @NotNull
    public f13 Method5970() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    public void Method5964(@NotNull JsonElement jsonElement) {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    public static void Method7972(f0w f0w2, List list) {
        f0w2.Field5626 = list;
    }

    public static List Method7973(f0w f0w2) {
        return f0w2.Field5626;
    }

    public void Method7974(@NotNull Consumer consumer) {
        this.Field5626.add(consumer);
    }

    public void Method7975(Object object) {
        this.Field5625.Method5266(object);
    }

    @NotNull
    public Class57 Method7976() {
        return this.Field5625;
    }

    @NotNull
    public String Method7977() {
        return this.Field5627;
    }

    @NotNull
    public JsonElement Method5969() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }

    public f0w(@NotNull String string, @Nullable String string2, Object object) {
        this.Field5627 = string;
        this.Field5628 = string2;
        this.Field5629 = object;
        this.Field5626 = new ArrayList();
        this.Field5625 = new Class56(this.Method7966(), new f0v(this));
    }

    public void Method7978(@NotNull Class57 class57) {
        this.Field5625 = class57;
    }

    public Object Method7979() {
        return this.Field5625.Method5264();
    }

    public void Method7980(@NotNull Consumer consumer) {
        this.Field5626.add(consumer);
    }
}

