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
import dev.nuker.pyro.f2R;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f2Q
implements SuggestionProvider {
    public static f2Q Field3761 = new f2Q();

    public CompletableFuture Method5478(@Nullable CommandContext commandContext, @NotNull SuggestionsBuilder suggestionsBuilder) {
        String string = suggestionsBuilder.Method2698();
        boolean bl = false;
        if (StringsKt.Method10002(string, ".", false, 2, null)) {
            string = string + "|";
            bl = true;
        }
        Collection collection = StringsKt.Method11514(string, new String[]{"\\."}, false, 0, 6, null);
        boolean bl2 = false;
        Collection collection2 = collection;
        String[] arrstring = collection2.toArray(new String[0]);
        if (arrstring == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] arrstring2 = arrstring;
        if (bl) {
            arrstring2[arrstring2.length - 1] = "";
        }
        int n = arrstring2.length - 1;
        List list = Class34.Field4599.Method6756();
        int n2 = arrstring2.length;
        block0: for (int i = 0; i < n2; ++i) {
            String string2 = arrstring2[i];
            if (n == 0) {
                for (Module module : Class34.Field4599.Method6756()) {
                    if (!StringsKt.Method9998(module.Method7279(), suggestionsBuilder.Method2698(), false, 2, null)) continue;
                    suggestionsBuilder.Method2701(module.Method7279());
                }
                continue;
            }
            for (Module module : Class34.Field4599.Method6756()) {
                if (!Intrinsics.Method6572(module.Method7279(), arrstring2[0])) continue;
                f2R.Method5482(f2R.Field3764, suggestionsBuilder, 1, arrstring2, module.Field5234.values());
                continue block0;
            }
        }
        return suggestionsBuilder.Method2700();
    }
}

