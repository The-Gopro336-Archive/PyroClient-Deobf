/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f2E implements SuggestionProvider {
   // $FF: renamed from: c java.util.function.Function
   public Function field_1989;

   public CompletableFuture getSuggestions(@Nullable CommandContext var1, @NotNull SuggestionsBuilder var2) {
      Iterator var4 = class_37.field_2633.method_3981().iterator();

      while(var4.hasNext()) {
         Module var3 = (Module)var4.next();
         if (StringsKt.startsWith$default(var3.method_141(), var2.getRemaining(), false, 2, (Object)null) && (Boolean)this.field_1989.apply(var3)) {
            var2.suggest(var3.method_141());
         }
      }

      return var2.buildFuture();
   }

   public f2E(Function var1) {
      this.field_1989 = var1;
      super();
   }
}
