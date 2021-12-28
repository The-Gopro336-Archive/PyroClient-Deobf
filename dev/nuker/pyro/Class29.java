/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.nuker.pyro.Class28;
import dev.nuker.pyro.Class6;
import dev.nuker.pyro.Class7;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f67;
import dev.nuker.pyro.fdZ;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class29
extends fdZ {
    public ConcurrentHashMap<Integer, Class6> Field3214 = new ConcurrentHashMap();
    @NotNull
    public static Class29 Field3215;
    public static Class7 Field3216;

    public void Method2680(int n) {
        if (this.Field3214.containsKey(n)) {
            Class6 class6;
            Class6 class62 = class6 = this.Field3214.get(n);
            if (class62 == null) {
                Intrinsics.Method6551();
            }
            class62.Method7345().forEach(Class28.Field3192);
        }
    }

    public void Method5128(int n, @NotNull String string) {
        if (this.Field3214.containsKey(n)) {
            Class6 class6;
            Class6 class62 = class6 = this.Field3214.get(n);
            if (class62 == null) {
                Intrinsics.Method6551();
            }
            class62.Method7345().add(string);
        } else {
            List list = new ArrayList();
            list.add(string);
            Class6 class6 = new Class6(n, list);
            ((Map)this.Field3214).put(n, class6);
        }
        this.Method462();
    }

    public void Method455() {
        this.Field3214.clear();
        if (this.Method5131().exists()) {
            Iterable iterable = ((JsonObject)Pyro.Field6181.fromJson(FilesKt.Method8750(this.Method5131(), Charsets.Field5722), JsonObject.class)).entrySet();
            boolean bl = false;
            for (Object t : iterable) {
                Collection<String> collection;
                Map.Entry entry = (Map.Entry)t;
                boolean bl2 = false;
                Object object = entry;
                boolean bl3 = false;
                String string = (String)object.getKey();
                object = entry;
                bl3 = false;
                JsonElement jsonElement = (JsonElement)object.getValue();
                object = string;
                Map map = this.Field3214;
                bl3 = false;
                int n = Integer.parseInt((String)object);
                object = string;
                Integer n2 = n;
                bl3 = false;
                int n3 = Integer.parseInt((String)object);
                object = (Iterable)jsonElement.getAsJsonArray();
                bl3 = false;
                Object object2 = object;
                Collection collection2 = new ArrayList(CollectionsKt.Method9458(object, 10));
                boolean bl4 = false;
                Iterator iterator2 = object2.iterator();
                while (iterator2.hasNext()) {
                    Object t2 = iterator2.next();
                    JsonElement jsonElement2 = (JsonElement)t2;
                    collection = collection2;
                    boolean bl5 = false;
                    String string2 = jsonElement2.getAsString();
                    collection.add(string2);
                }
                collection = (List)collection2;
                List list = CollectionsKt.Method3150((Collection)collection);
                int n4 = n3;
                map.put(n2, new Class6(n4, list));
            }
        }
    }

    @Nullable
    public Class6 Method5129(int n) {
        return this.Field3214.get(n);
    }

    public void Method5130(int n, @Nullable String string) {
        if (this.Field3214.containsKey(n)) {
            Class6 class6;
            Class6 class62 = class6 = this.Field3214.get(n);
            if (class62 == null) {
                Intrinsics.Method6551();
            }
            if (class62.Method7345().isEmpty()) {
                this.Field3214.remove(n);
            } else {
                Collection collection = class6.Method7345();
                boolean bl = false;
                Collection collection2 = collection;
                if (collection2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                TypeIntrinsics.Method5561(collection2).remove(string);
                if (class6.Method7345().isEmpty()) {
                    this.Field3214.remove(n);
                }
            }
        }
        this.Method462();
    }

    public void Method462() {
        Collection<Pair<Integer, List>> collection;
        Map map = this.Field3214;
        Gson gson = Pyro.Field6181;
        File file = this.Method5131();
        boolean bl = false;
        Map map2 = map;
        Collection collection2 = new ArrayList(map.size());
        boolean bl2 = false;
        Map map3 = map2;
        boolean bl3 = false;
        Iterator iterator2 = map3.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry;
            Map.Entry entry2 = entry = iterator2.next();
            collection = collection2;
            boolean bl4 = false;
            Map.Entry entry3 = entry2;
            boolean bl5 = false;
            int n = ((Number)entry3.getKey()).intValue();
            entry3 = entry2;
            bl5 = false;
            Class6 class6 = (Class6)entry3.getValue();
            Integer n2 = n;
            Class6 class62 = class6;
            if (class62 == null) {
                Intrinsics.Method6551();
            }
            Pair<Integer, List> pair = TuplesKt.Method2826(n2, class62.Method7345());
            collection.add(pair);
        }
        collection = (List)collection2;
        FilesKt.Method8752(file, gson.toJson(MapsKt.Method8608((Iterable)collection)), Charsets.Field5722);
    }

    public void Method2377(int n) {
        if (this.Field3214.containsKey(n)) {
            Class6 class6 = this.Field3214.get(n);
            this.Field3214.remove(n);
        }
        this.Method462();
    }

    static {
        Field3216 = new Class7(null);
        Field3215 = new Class29();
    }

    @NotNull
    public File Method5131() {
        return new File(f67.Field4191.Method5824().Method5809(), "macros.json");
    }

    public static Class29 Method5132() {
        return Field3215;
    }
}

