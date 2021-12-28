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
import dev.nuker.pyro.Class56;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.Setting;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f0x;
import dev.nuker.pyro.f0y;
import dev.nuker.pyro.f11;
import dev.nuker.pyro.f13;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0z
extends Setting {
    @NotNull
    public Class57<Boolean> Field5638;
    @NotNull
    public f0o<E> Field5639;

    public void Method7988(@NotNull Class57 class57) {
        this.Field5638 = class57;
    }

    public f0z(@NotNull f0o f0o2, @NotNull List[] arrlist) {
        List[] arrlist2;
        int n = arrlist.length;
        String string = f0o2.Method7969();
        String string2 = f0o2.Method5989();
        String string3 = f0o2.Method7977();
        f0z f0z2 = this;
        List[] arrlist3 = new List[n];
        int n2 = 0;
        while (n2 < n) {
            List list;
            int n3 = n2;
            int n4 = n2++;
            arrlist2 = arrlist3;
            boolean bl = false;
            arrlist2[n4] = list = CollectionsKt.Method3150(arrlist[n3]);
        }
        arrlist2 = arrlist3;
        super(string3, string2, string, arrlist2);
        this.Field5639 = f0o2;
        this.Field5639.Method7980(new f0x(this));
        for (List list : (List[])this.Method7976().Method5264()) {
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                f0w f0w2;
                f0w f0w3 = f0w2 = (f0w)iterator2.next();
                if (f0w3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.setting.Setting<kotlin.Any>");
                }
                f0w3.Method7980(new f0y(this));
            }
        }
        this.Field5638 = new Class56(false);
    }

    public f0z(@NotNull String string, @NotNull String string2, @Nullable String string3, @NotNull Enum enum_, @NotNull List[] arrlist) {
        this(new f0o(string, string2, string3, enum_), arrlist);
    }

    @NotNull
    public Class57 Method7989() {
        return this.Field5638;
    }

    @Override
    public void Method5964(@NotNull JsonElement jsonElement) {
        JsonObject jsonObject = (JsonObject)jsonElement;
        this.Field5638.Method5266((Object)jsonObject.get("expanded").getAsBoolean());
        this.Field5639.Method5964(jsonObject.get("selection"));
    }

    public void Method7990(@NotNull f0o f0o2) {
        this.Field5639 = f0o2;
    }

    @NotNull
    public f0o Method7991() {
        return this.Field5639;
    }

    @Override
    @NotNull
    public f13 Method5970() {
        List[] arrlist = new List[((Object[])this.Method7976().Method5264()).length];
        int n = 0;
        Object object = this.Method7976().Method5264();
        if (object == null) {
            Intrinsics.Method6551();
        }
        int n2 = ((List[])object).length;
        while (n < n2) {
            Object object2 = this.Method7976().Method5264();
            if (object2 == null) {
                Intrinsics.Method6551();
            }
            List list = ((List[])object2)[n];
            List list2 = new ArrayList();
            int n3 = ((Collection)list).size();
            for (int i = 0; i < n3; ++i) {
                list2.add(((f0w)list.get(i)).Method5970());
            }
            arrlist[n] = list2;
            ++n;
        }
        return new f11(this.Field5639, arrlist, this.Field5638);
    }

    @Override
    @NotNull
    public JsonElement Method5969() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("expanded", (JsonElement)new JsonPrimitive((Boolean)this.Field5638.Method5264()));
        jsonObject.add("selection", this.Field5639.Method5969());
        return (JsonElement)jsonObject;
    }
}

