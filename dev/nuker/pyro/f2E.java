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
import dev.nuker.pyro.Class34;
import dev.nuker.pyro.Module;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f2E
implements SuggestionProvider {
    public Function Field3753;

    public CompletableFuture Method5478(@Nullable CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        for (Module module : Class34.Field4599.Method6756()) {
            if (!StringsKt.Method9998(module.Method7279(), suggestionsBuilder.Method2698(), false, 2, null)) continue;
            if (!((Boolean)this.Field3753.apply(module)).booleanValue()) continue;
            suggestionsBuilder.Method2701(module.Method7279());
        }
        return suggestionsBuilder.Method2700();
    }

    public f2E(Function function) {
        this.Field3753 = function;
    }
}

