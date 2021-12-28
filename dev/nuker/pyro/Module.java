/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonPrimitive
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Class18;
import dev.nuker.pyro.Class19;
import dev.nuker.pyro.Class20;
import dev.nuker.pyro.Class21;
import dev.nuker.pyro.Class22;
import dev.nuker.pyro.Class23;
import dev.nuker.pyro.Class24;
import dev.nuker.pyro.Class25;
import dev.nuker.pyro.Class26;
import dev.nuker.pyro.Class27;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Class56;
import dev.nuker.pyro.Class57;
import dev.nuker.pyro.Class8;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.gui.ClickGui$Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Module {
    @JvmField
    public Minecraft Field5233;
    @JvmField
    @NotNull
    public Map<String, f0w<?>> Field5234;
    @JvmField
    @NotNull
    public Map<String, f0w<?>> Field5235;
    @JvmField
    @NotNull
    public Class57<Boolean> Field5236;
    @JvmField
    @NotNull
    public Class57<Boolean> Field5237;
    @JvmField
    @NotNull
    public Class57<Integer> Field5238;
    public int Field5239;
    @Nullable
    public String Field5240;
    public int Field5241;
    @Nullable
    public String Field5242;
    @NotNull
    public Class57<Boolean> Field5243;
    @NotNull
    public String Field5244;
    @NotNull
    public String Field5245;
    @Nullable
    public String Field5246;

    public void Method7253(int n) {
        if (n == this.Method7271()) {
            this.Field5236.Method5266((Object)(!((Boolean)this.Field5236.Method5264()).booleanValue() ? 1 : 0));
        }
        this.Method7281(Minecraft.getMinecraft().player, (Boolean)this.Field5236.Method5264(), n);
    }

    public void Method7254(int n) {
        this.Field5239 = n;
        Class34.Field4599.Method6753(this);
    }

    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        if (bl) {
            Pyro.Method8978().Method7915(this);
        } else {
            Pyro.Method8978().Method7921(this);
        }
    }

    @NotNull
    public JsonObject Method7255() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("enabled", (JsonElement)new JsonPrimitive((Boolean)this.Field5236.Method5264()));
        jsonObject.add("expanded", (JsonElement)new JsonPrimitive((Boolean)this.Field5237.Method5264()));
        jsonObject.add("keybind", (JsonElement)new JsonPrimitive((Number)this.Method7271()));
        jsonObject.add("hidden", (JsonElement)new JsonPrimitive((Boolean)this.Field5243.Method5264()));
        JsonObject jsonObject2 = new JsonObject();
        Object object = this.Field5234;
        boolean bl = false;
        Iterator<Map.Entry<String, f0w<?>>> iterator2 = object.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, f0w<?>> entry;
            Map.Entry<String, f0w<?>> entry2 = entry = iterator2.next();
            boolean bl2 = false;
            object = entry2.getKey();
            entry2 = entry;
            bl2 = false;
            f0w<?> f0w2 = entry2.getValue();
            jsonObject2.add((String)object, f0w2.Method5969());
        }
        jsonObject.add("settings", (JsonElement)jsonObject2);
        return jsonObject;
    }

    public void Method7256(@NotNull Class57 class57) {
        this.Field5243 = class57;
    }

    public void Method7257(@Nullable JsonObject jsonObject) {
        if (jsonObject == null) {
            this.Field5236.Method5266((Object)false);
            this.Field5237.Method5266((Object)false);
            this.Method7254(-1);
            Iterable iterable = this.Field5234.values();
            boolean bl = false;
            for (Object t : iterable) {
                f0w f0w2 = (f0w)t;
                boolean bl2 = false;
                f0w2.Method7976().Method5266(f0w2.Method7966());
            }
        } else {
            this.Field5236.Method5266((Object)jsonObject.get("enabled").getAsBoolean());
            this.Field5237.Method5266((Object)jsonObject.get("expanded").getAsBoolean());
            this.Method7254(jsonObject.get("keybind").getAsInt());
            try {
                this.Field5243.Method5266((Object)jsonObject.get("hidden").getAsBoolean());
            }
            catch (Exception exception) {
                // empty catch block
            }
            exception = jsonObject.getAsJsonObject("settings");
            Object object = this.Field5234;
            boolean bl = false;
            Iterator<Map.Entry<String, f0w<?>>> iterator2 = object.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<String, f0w<?>> entry;
                Map.Entry<String, f0w<?>> entry2 = entry = iterator2.next();
                boolean bl3 = false;
                object = entry2.getKey();
                entry2 = entry;
                bl3 = false;
                f0w<?> f0w3 = entry2.getValue();
                if (!exception.has((String)object)) continue;
                try {
                    f0w3.Method5964(exception.get((String)object));
                }
                catch (Exception exception) {}
            }
        }
    }

    @Nullable
    public f0w Method7258(@Nullable String string) {
        return string != null ? this.Field5234.get(string) : null;
    }

    @Nullable
    public String Method7259() {
        return this.Field5240;
    }

    @Nullable
    public String Method7260() {
        return this.Field5240;
    }

    public void Method195(@Nullable Vec3d vec3d, float f) {
    }

    public void Method7261(@NotNull ClickGui$Window clickGui$Window) {
        List list = new ArrayList();
        for (f0w<?> f0w2 : this.Field5234.values()) {
            list.add(f0w2.Method5970());
        }
        clickGui$Window.Method12548(this.Field5245, (Boolean)this.Field5236.Method5264(), list, new Class21(this), new Class56(this.Method7271(), new Class18(this)), this.Field5237, this.Field5238);
    }

    public void Method7262(int n) {
        this.Field5241 = n;
    }

    public void Method7263(@Nullable String string) {
        this.Field5240 = string;
    }

    public f0w Method7264(f0w f0w2) {
        f0w f0w3 = f0w2;
        if (f0w3 instanceof f0t) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.Field4235 = true;
            Iterable iterable = this.Method7278((List)((f0t)f0w2).Method7976().Method5264(), f0w2.Method7977());
            boolean bl = false;
            for (Object t : iterable) {
                f0w f0w4 = (f0w)t;
                boolean bl2 = false;
                if (booleanRef.Field4235) {
                    f0w4.Method7970(f0w2.Method7977());
                }
                booleanRef.Field4235 = false;
                this.Field5234.put(f0w4.Method7977(), f0w4);
                f0w4.Method7974(new Class25(this, booleanRef, f0w2));
            }
        } else if (f0w3 instanceof f0z) {
            int n = ((List[])((f0z)f0w2).Method7976().Method5264()).length;
            for (int i = 0; i < n; ++i) {
                String string;
                List list = ((List[])((f0z)f0w2).Method7976().Method5264())[i];
                Object object = ((Enum[])((Enum)((f0z)f0w2).Method7991().Method7979()).getClass().getEnumConstants())[i].name();
                StringBuilder stringBuilder = new StringBuilder().append(f0w2.Method7977()).append('[');
                List list2 = list;
                Module module = this;
                boolean bl = false;
                String string2 = object;
                if (string2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                string2.toUpperCase();
                List list3 = module.Method7278(list2, stringBuilder.append(string).append(']').toString());
                object = list3;
                bl = false;
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    Object t = iterator2.next();
                    f0w f0w5 = (f0w)t;
                    boolean bl3 = false;
                    this.Field5234.put(f0w5.Method7977(), f0w5);
                    f0w5.Method7974(new Class22(this));
                }
            }
            this.Field5234.put(f0w2.Method7977(), ((f0z)f0w2).Method7991());
            ((f0z)f0w2).Method7991().Method7974(new Class23(this));
        } else {
            f0w f0w6 = f0w2;
            if (f0w6 == null) {
                Intrinsics.Method6551();
            }
            this.Field5234.put(f0w6.Method7977(), f0w2);
            f0w2.Method7974(new Class20(this));
        }
        return f0w2;
    }

    @NotNull
    public String Method7265() {
        return this.Field5245;
    }

    public void Method7266(@NotNull String string) {
        this.Field5245 = string;
    }

    @Nullable
    public String Method7267() {
        return this.Field5242;
    }

    public void Method7268(int n) {
        if (this.Method7271() == -1 || this.Method7271() == 0 || n == 0 || n == 1) {
            return;
        }
        if (-n == this.Method7271()) {
            this.Field5236.Method5266((Object)(!((Boolean)this.Field5236.Method5264()).booleanValue() ? 1 : 0));
        }
        this.Method7281(Minecraft.getMinecraft().player, (Boolean)this.Field5236.Method5264(), -n);
    }

    @NotNull
    public Class57 Method7269() {
        return this.Field5243;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @NotNull
    public List Method7270(@NotNull Collection var1_1) {
        var3_2 = var1_1;
        var4_3 = false;
        var5_5 = var3_2;
        var6_8 = false;
        var7_10 = new Class19();
        var2_11 = CollectionsKt.Method3129(var5_5, var7_10);
        var4_3 = false;
        var3_2 = new LinkedHashMap<K, V>();
        var5_6 = false;
        var4_4 = new ArrayList<E>();
        var6_9 = var2_11.iterator();
        while (var6_9.hasNext() != false) {
            block24: {
                block23: {
                    block22: {
                        var5_7 = var6_9.next();
                        var7_10 = var5_7.Method7977();
                        var8_12 = StringsKt.Method11421(StringsKt.Method11425((String)var7_10, '.', null, 2, null), '[', null, 2, null);
                        v0 = var9_13 = StringsKt.Method11505((CharSequence)var7_10, '.', false, 2, null) != false ? StringsKt.Method11421((String)var7_10, '.', null, 2, null) + '.' + var8_12 : var8_12;
                        if (var3_2.get(var9_13) != null) continue;
                        var11_15 = var2_11;
                        var12_16 = 0;
                        if (var11_15 instanceof Collection && ((Collection)var11_15).isEmpty()) {
                            v1 = false;
                        } else {
                            var13_19 = var11_15.iterator();
                            while (var13_19.hasNext()) {
                                var14_22 = var13_19.next();
                                var15_25 = (f0w)var14_22;
                                var16_27 = false;
                                if (!StringsKt.Method9998(var15_25.Method7977(), (String)var7_10 + '[', false, 2, null)) continue;
                                v1 = true;
                                break block22;
                            }
                            v1 = var10_14 = false;
                        }
                    }
                    if (var10_14) ** GOTO lbl-1000
                    var12_17 = var2_11;
                    var13_20 = false;
                    if (var12_17 instanceof Collection && ((Collection)var12_17).isEmpty()) {
                        v2 = true;
                    } else {
                        var14_22 = var12_17.iterator();
                        while (var14_22.hasNext()) {
                            var16_28 = var15_25 = var14_22.next();
                            var17_30 = false;
                            if (!StringsKt.Method9998(var16_28.Method7977(), (String)var7_10 + '.', false, 2, null)) continue;
                            v2 = false;
                            break block23;
                        }
                        v2 = true;
                    }
                }
                if (v2) {
                    v3 = var5_7;
                } else if (var10_14) {
                    if (!(var5_7 instanceof f0o)) {
                        throw (Throwable)new IllegalStateException(this.Field5245 + " has incorrect setting reference - " + (String)var7_10 + " should be an enum setting");
                    }
                    v4 = (f0o)var5_7;
                    v5 = ((f0o)var5_7).Method7966();
                    if (v5 == null) {
                        Intrinsics.Method6551();
                    }
                    var12_16 = ((Enum)v5).getClass().getEnumConstants().length;
                    var30_42 = v4;
                    var13_19 = new List[var12_16];
                    var14_23 = 0;
                    while (var14_23 < var12_16) {
                        var15_26 = var14_23;
                        var32_44 = var14_23++;
                        var31_43 = var13_19;
                        var16_27 = false;
                        var17_30 = false;
                        var31_43[var32_44] = var33_45 = CollectionsKt.Method1013();
                    }
                    var34_46 = var31_43 = var13_19;
                    var35_47 = var30_42;
                    v3 = new f0z(var35_47, var34_46);
                } else {
                    v3 = new f0t(var5_7, new f0w[0]);
                }
                var11_15 = v3;
                var3_2.put(var9_13, var11_15);
                if (!StringsKt.Method11505(var5_7.Method7977(), '.', false, 2, null)) ** GOTO lbl104
                var12_18 = StringsKt.Method11421(var5_7.Method7977(), '.', null, 2, null);
                if (StringsKt.Method11468(var12_18, ']', false, 2, null)) {
                    var12_18 = StringsKt.Method11421(var12_18, '[', null, 2, null);
                }
                if ((var15_25 = (var14_24 = (f0w)var3_2.get(var13_21 = var12_18))) instanceof f0z) {
                    var16_29 = StringsKt.Method11413(StringsKt.Method11425((String)var7_10, '[', null, 2, null), ']', null, 2, null);
                    ((Enum)((f0z)var14_24).Method7991().Method7966()).getClass().getEnumConstants();
                    var19_33 = false;
                    var20_34 = var18_32;
                    var21_35 = var20_34.length;
                } else {
                    if (var15_25 instanceof f0t) {
                        v6 = var11_15;
                        if (v6 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.setting.Setting<*>");
                        }
                        ((List)((f0t)var14_24).Method7976().Method5264()).add(v6);
                        continue;
                    }
                    if (var15_25 == null) {
                        throw (Throwable)new IllegalStateException(var12_18 + " has incorrect setting parent - " + var13_21 + ": Expected Swappable or List but got null");
                    }
                    v7 = new StringBuilder().append(var12_18).append(" has incorrect setting parent - ");
                    v8 = var14_24;
                    if (v8 != null) throw (Throwable)new IllegalStateException(v7.append(v8.Method7977()).append(": Expected Swappable or List but got ").append(var14_24.getClass()).toString());
                    Intrinsics.Method6551();
                    throw (Throwable)new IllegalStateException(v7.append(v8.Method7977()).append(": Expected Swappable or List but got ").append(var14_24.getClass()).toString());
lbl104:
                    // 1 sources

                    var4_4.add(var11_15);
                    continue;
                }
                for (var22_36 = 0; var22_36 < var21_35; ++var22_36) {
                    var23_37 = var20_34[var22_36];
                    var24_38 = (Enum)var23_37;
                    var25_39 = false;
                    var26_40 = var24_38.name();
                    var27_41 = false;
                    v9 = var26_40;
                    if (v9 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (!Intrinsics.Method6572(v9.toUpperCase(), var16_29)) continue;
                    v10 = var23_37;
                    break block24;
                }
                v10 = null;
            }
            if ((Enum)v10 == null) throw (Throwable)new IllegalStateException(var12_18 + " has incorrect setting reference - " + StringsKt.Method11421((String)var7_10, '[', null, 2, null) + " is missing constant " + StringsKt.Method11413(StringsKt.Method11425((String)var7_10, '[', null, 2, null), ']', null, 2, null));
            ((List[])((f0z)var14_24).Method7979())[var17_31.ordinal()].add(var11_15);
        }
        return var4_4;
    }

    public int Method7271() {
        return this.Field5239;
    }

    public void Method7272(@Nullable String string) {
        this.Field5246 = string;
    }

    public void Method7273(@NotNull String string) {
        this.Field5244 = string;
    }

    public void Method7274(@Nullable String string) {
        if (Intrinsics.Method6572(this.Field5240, string) ^ true) {
            if (this.Field5240 == null) {
                this.Field5240 = string;
                Class8.Field5278.Method7308(this);
            } else {
                this.Field5240 = string;
                Class8.Field5278.Method7304(this);
            }
        }
    }

    public void Method7275(@Nullable String string) {
        this.Field5242 = string;
    }

    @NotNull
    public String Method7276() {
        if (this.Field5240 == null) {
            return this.Field5245;
        }
        return this.Field5245 + " " + (Object)ChatFormatting.GRAY + this.Field5240;
    }

    public int Method7277() {
        return this.Field5241;
    }

    public Module(@NotNull String string, @NotNull String string2, @Nullable String string3) {
        this(string, string2, string3, false);
    }

    @NotNull
    public List Method7278(@NotNull List list, @NotNull String string) {
        boolean bl = false;
        List list2 = new ArrayList();
        Iterable iterable = list;
        boolean bl2 = false;
        for (Object t : iterable) {
            boolean bl3;
            Object object;
            boolean bl4;
            Iterable iterable2;
            int n;
            f0w f0w2 = (f0w)t;
            boolean bl5 = false;
            f0w f0w3 = f0w2;
            if (f0w3 instanceof f0t) {
                n = 1;
                f0w f0w4 = f0w2;
                iterable2 = this.Method7278((List)((f0t)f0w2).Method7976().Method5264(), string + '.' + f0w2.Method7977());
                bl4 = false;
                for (Object object2 : iterable2) {
                    object = (f0w)object2;
                    bl3 = false;
                    if (n != 0) {
                        ((f0w)object).Method7970(string + '.' + f0w4.Method7977());
                    }
                    n = 0;
                    list2.add(object);
                }
                continue;
            }
            if (f0w3 instanceof f0z) {
                int n2 = ((List[])((f0z)f0w2).Method7976().Method5264()).length;
                for (n = 0; n < n2; ++n) {
                    String string2;
                    Object object2;
                    iterable2 = ((List[])((f0z)f0w2).Method7976().Method5264())[n];
                    bl4 = true;
                    f0w f0w5 = f0w2;
                    object = ((Enum[])((Enum)((f0z)f0w2).Method7991().Method7979()).getClass().getEnumConstants())[n].name();
                    StringBuilder stringBuilder = new StringBuilder().append(string).append('.').append(f0w2.Method7977()).append('[');
                    List list3 = iterable2;
                    Module module = this;
                    bl3 = false;
                    Object object3 = object;
                    if (object3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    ((String)object3).toUpperCase();
                    object2 = module.Method7278(list3, stringBuilder.append(string2).append(']').toString());
                    object = (Iterable)object2;
                    bl3 = false;
                    Iterator iterator2 = object.iterator();
                    while (iterator2.hasNext()) {
                        Object t2 = iterator2.next();
                        f0w f0w6 = (f0w)t2;
                        boolean bl6 = false;
                        list2.add(f0w6);
                    }
                }
                ((f0z)f0w2).Method7991().Method7970(string + '.' + f0w2.Method7977());
                list2.add(((f0z)f0w2).Method7991());
                continue;
            }
            f0w2.Method7970(string + '.' + f0w2.Method7977());
            list2.add(f0w2);
        }
        return list2;
    }

    @NotNull
    public String Method7279() {
        return this.Field5244;
    }

    public Module(@NotNull String string, @NotNull String string2, @Nullable String string3, boolean bl) {
        this.Field5244 = string;
        this.Field5245 = string2;
        this.Field5246 = string3;
        this.Field5233 = Minecraft.getMinecraft();
        this.Field5234 = new LinkedHashMap();
        this.Field5235 = new LinkedHashMap();
        this.Field5239 = -1;
        this.Field5241 = -1;
        this.Field5236 = new Class56(false, new Class26(this));
        this.Field5243 = new Class56(bl, new Class27(this));
        this.Field5237 = new Class56(false, new Class24(this));
        this.Field5238 = new Class56(0);
    }

    @Nullable
    public String Method7280() {
        return this.Field5246;
    }

    public void Method7281(@Nullable EntityPlayerSP entityPlayerSP, boolean bl, int n) {
    }
}

