/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class10;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class31 {
    @NotNull
    public List<Class31> Field4576 = new ArrayList();
    @Nullable
    public String[] Field4577;
    public static Class10 Field4578 = new Class10(null);

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @NotNull
    public String toString() {
        if (this.Field4577 == null) {
            Intrinsics.Method6551();
        }
        var1_1 = this.Field4577.length + this.Field4576.size() > 1 ? "\u252c" : "\u2500";
        var2_2 = 0;
        if (this.Field4577 == null) {
            Intrinsics.Method6551();
        }
        var3_3 = this.Field4577.length;
        while (var2_2 < var3_3) {
            if (this.Field4577 == null) {
                Intrinsics.Method6551();
            }
            var4_4 = this.Field4577[var2_2];
            v0 = new StringBuilder().append(var1_1).append(var2_2 == 0 ? "" : "\u2502").append((String)var4_4);
            if (this.Field4577 == null) {
                Intrinsics.Method6551();
            }
            var1_1 = v0.append(var2_2 == this.Field4577.length + this.Field4576.size() - 1 ? "" : "\n").toString();
            ++var2_2;
        }
        var2_2 = 0;
        var3_3 = ((Collection)this.Field4576).size();
        while (var2_2 < var3_3) {
            var4_4 = this.Field4576.get(var2_2);
            v1 = new StringBuilder().append(var1_1);
            if (var2_2 != 0) ** GOTO lbl-1000
            if (this.Field4577 == null) {
                Intrinsics.Method6551();
            }
            if (this.Field4577.length == 0) {
                v2 = "";
            } else lbl-1000:
            // 2 sources

            {
                v2 = var2_2 == this.Field4576.size() - 1 ? "\u2514" : "\u251c";
            }
            var1_1 = v1.append(v2).toString();
            var6_7 = StringsKt.Method11514(var4_4.toString(), new String[]{"\n"}, false, 0, 6, null);
            var7_8 = 0;
            var8_9 = var6_7;
            if (var8_9.toArray(new String[0]) == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            var7_8 = var5_5.length;
            for (var6_6 = 0; var6_6 < var7_8; ++var6_6) {
                var8_9 = var5_5[var6_6];
                var1_1 = var1_1 + StringsKt.Method120("\n                    " + (var6_6 == 0 ? "" : (var2_2 == this.Field4576.size() - 1 ? " " : "\u2502")) + (String)var8_9 + "\n                    \n                    ");
            }
            ++var2_2;
        }
        return var1_1;
    }

    @Nullable
    public String[] Method6720() {
        return this.Field4577;
    }

    public int Method6721() {
        return this.Field4576.size();
    }

    @NotNull
    public List Method6722() {
        return this.Field4576;
    }

    public void Method6723(@NotNull Class31 class31) {
        this.Field4576.add(class31);
    }

    public void Method6724(@NotNull List list) {
        this.Field4576 = list;
    }

    public void Method6725(@NotNull String string) {
        this.Method6723(Field4578.Method4805(string));
    }

    public void Method6726(@Nullable String[] arrstring) {
        this.Field4577 = arrstring;
    }
}

