/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f3q
implements SuggestionProvider {
    public static f3q Field4096 = new f3q();

    public CompletableFuture Method5478(@Nullable CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        for (Block block : Block.REGISTRY) {
            String string;
            String string2;
            ((ResourceLocation)Block.REGISTRY.getNameForObject((Object)block)).toString();
            String string3 = string2;
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

