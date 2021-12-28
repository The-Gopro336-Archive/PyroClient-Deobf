/*
 * Decompiled with CFR 0.150.
 */
package dev.nuker.pyro;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import dev.nuker.pyro.f66;
import dev.nuker.pyro.f67;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

public class f37
implements SuggestionProvider {
    public static f37 Field3807 = new f37();

    public CompletableFuture Method5478(CommandContext commandContext, SuggestionsBuilder suggestionsBuilder) {
        for (f66 f662 : f67.Field4191.Method5825()) {
            String string;
            String string2;
            String string3 = f662.Method5810();
            boolean bl = false;
            String string4 = string3;
            if (string4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string4.toLowerCase();
            string3 = suggestionsBuilder.Method2698();
            bl = false;
            String string5 = string3;
            if (string5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string5.toLowerCase();
            if (!StringsKt.Method9998(string2, string, false, 2, null)) continue;
            suggestionsBuilder.Method2701(f662.Method5810());
        }
        return suggestionsBuilder.Method2700();
    }
}

