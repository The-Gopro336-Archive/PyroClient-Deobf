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
import dev.nuker.pyro.Setting;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0L;
import dev.nuker.pyro.f13;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0l
extends Setting {
    @JvmField
    @NotNull
    public Class56<Boolean> Field5620 = new Class56(false);

    @Override
    @NotNull
    public f13 Method5970() {
        return new f0L(this);
    }

    public void Method7965(@NotNull f00 f002) {
        super.Method7968(f002);
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        this.Method7976().Method5266(f00.Field5379.Method7934(jsonElement.getAsJsonObject()));
    }

    public f0l(@NotNull String string, @NotNull String string2, @Nullable String string3, @NotNull f00 f002) {
        super(string, string2, string3, f002);
        this.Method7965(f002.Method7513());
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        return (JsonElement)((f00)this.Method7976().Method5264()).Method7526();
    }

    @Override
    public Object Method7966() {
        return this.Method7967();
    }

    @NotNull
    public f00 Method7967() {
        return ((f00)super.Method7966()).Method7513();
    }

    @Override
    public void Method7968(Object object) {
        this.Method7965((f00)object);
    }
}

