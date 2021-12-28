/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.nuker.pyro.PyroStatic;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f3R
implements SuggestionProvider {
    public static f3R Field3893 = new f3R();

    public CompletableFuture Method5478(@Nullable CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        Iterator iterator2 = PyroStatic.Field6424.Method2613().Method2604().iterator();
        while (iterator2.hasNext()) {
            String string;
            String string2;
            String string3 = string2 = (String)iterator2.next();
            boolean bl = false;
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string3 = suggestionsBuilder.Method2698();
            String string5 = StringsKt.Method11419(string4.toLowerCase(), "minecraft:", null, 2, null);
            bl = false;
            String string6 = string3;
            if (string6 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string6.toLowerCase();
            if (!StringsKt.Method9998(string5, StringsKt.Method11419(string, "minecraft:", null, 2, null), false, 2, null)) continue;
            suggestionsBuilder.Method2701(string2);
        }
        return suggestionsBuilder.Method2700();
    }
}

