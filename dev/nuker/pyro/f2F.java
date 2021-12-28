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
import dev.nuker.pyro.Class12;
import dev.nuker.pyro.FriendManager;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f2f
implements SuggestionProvider {
    public static f2f Field3875 = new f2f();

    public CompletableFuture Method5478(@Nullable CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        for (Class12 class12 : FriendManager.Field2145.Method8942().Method2781()) {
            String string;
            String string2;
            String string3 = class12.Method4896();
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
            suggestionsBuilder.Method2701(class12.Method4896());
        }
        return suggestionsBuilder.Method2700();
    }
}

