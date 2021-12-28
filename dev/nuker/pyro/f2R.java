/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.f0z;
import dev.nuker.pyro.f2P;
import dev.nuker.pyro.f2Q;
import dev.nuker.pyro.f3e;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class f2R {
    public static f2R Field3764;

    public Optional Method5481(String string) {
        return Class34.Field4599.Method6756().stream().filter(new f2P(string)).findFirst();
    }

    static {
        f2R f2R2;
        Field3764 = f2R2 = new f2R();
    }

    public static void Method5482(f2R f2R2, SuggestionsBuilder suggestionsBuilder, int n, String[] arrstring, Collection collection) {
        f2R2.Method5483(suggestionsBuilder, n, arrstring, collection);
    }

    public void Method5483(SuggestionsBuilder suggestionsBuilder, int n, String[] arrstring, Collection collection) {
        if (arrstring.length <= n) {
            // empty if block
        }
        String string = "" + '[' + n + "] ";
        int n2 = n;
        for (int i = 0; i < n2; ++i) {
        }
        for (f0w f0w2 : collection) {
            if (f0w2 instanceof f0z) {
                boolean bl = false;
                for (Enum enum_ : (Enum[])((Enum)((f0z)f0w2).Method7991().Method7979()).getClass().getEnumConstants()) {
                    String string2;
                    String string3;
                    Object[] arrobject;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
                    String string4 = "[%s]";
                    Object[] arrobject2 = enum_.name();
                    int n3 = 0;
                    Object[] arrobject3 = arrobject = new Object[1];
                    boolean bl2 = false;
                    if (arrobject2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    arrobject2.toLowerCase();
                    arrobject[n3] = string3;
                    arrobject2 = arrobject3;
                    bl2 = false;
                    String.format(string4, Arrays.copyOf(arrobject2, arrobject2.length));
                    if (StringsKt.Method9998(f0w2.Method7977() + string2, arrstring[n], false, 2, null) && StringsKt.Method9998(arrstring[n], f0w2.Method7977(), false, 2, null)) {
                        bl = true;
                        if (!Intrinsics.Method6572(f0w2.Method7977() + string2, arrstring[n])) {
                            suggestionsBuilder.Method2701(string + f0w2.Method7977() + string2);
                        }
                    }
                    if (bl) continue;
                    if (!StringsKt.Method9998(f0w2.Method7977(), arrstring[n], false, 2, null)) continue;
                    suggestionsBuilder.Method2701(string + f0w2.Method7977());
                }
                continue;
            }
            if (f0w2 instanceof f0t) {
                this.Method5483(suggestionsBuilder, n + 1, arrstring, (Collection)((f0t)f0w2).Method7979());
            }
            suggestionsBuilder.Method2701(string + f0w2.Method7977() + (f0w2 instanceof f0t ? "." : ""));
        }
    }

    @JvmStatic
    public static void Method5484(@NotNull CommandDispatcher commandDispatcher) {
        commandDispatcher.Method8399((LiteralArgumentBuilder)f3e.Method5657("setting").Method12041(f3e.Method5658("setting", StringArgumentType.Method5878()).Method1114(f2Q.Field3761)));
    }
}

