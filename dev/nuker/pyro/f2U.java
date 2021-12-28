/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Iterables
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.google.common.collect.Iterables;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.ParsedCommandNode;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.mojang.brigadier.tree.CommandNode;
import dev.nuker.pyro.f2w;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class f2u
implements SuggestionProvider {
    public CommandDispatcher Field3940;

    public CompletableFuture Method5478(@NotNull CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        boolean bl;
        int n;
        ParseResults parseResults;
        String string;
        String string2 = suggestionsBuilder.Method2698();
        if (StringsKt.Method11501(string2, " ", 0, false, 6, null) == -1) {
            string = "";
        } else {
            parseResults = string2;
            int n2 = 0;
            n = StringsKt.Method11501(string2, " ", 0, false, 6, null);
            bl = false;
            string = ((String)((Object)parseResults)).substring(n2, n);
        }
        string2 = string;
        parseResults = this.Field3940.Method8404(string2, commandContext.Method6876());
        if (parseResults.Method8971().Method7119().isEmpty()) {
            CharSequence charSequence = string2;
            n = 0;
            if (!(charSequence.length() == 0)) {
                throw (Throwable)f2w.Method5639(f2w.Field3947).Method3035();
            }
        }
        CommandNode commandNode = string2;
        bl = false;
        CommandNode commandNode2 = commandNode.length() == 0 ? (CommandNode)this.Field3940.Method8413() : ((ParsedCommandNode)Iterables.getLast((Iterable)parseResults.Method8971().Method7119())).Method5996();
        Iterator iterator2 = commandNode2.Method1747().iterator();
        while (iterator2.hasNext()) {
            String string3;
            String string4;
            commandNode = iterator2.next();
            String string5 = commandNode.getName();
            suggestionsBuilder.Method2698();
            CharSequence charSequence = string2;
            int n3 = string2.length();
            String string6 = string5;
            boolean bl2 = false;
            boolean bl3 = charSequence.length() == 0;
            int n4 = n3 + (bl3 ? 0 : 1);
            bl2 = false;
            String string7 = string4;
            if (string7 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            string7.substring(n4);
            if (!StringsKt.Method9998(string6, string3, false, 2, null)) continue;
            suggestionsBuilder.Method2701(commandNode.getName());
        }
        return suggestionsBuilder.Method2700();
    }

    public f2u(CommandDispatcher commandDispatcher) {
        this.Field3940 = commandDispatcher;
    }
}

