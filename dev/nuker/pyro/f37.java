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
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

public class f37 implements SuggestionProvider {
   // $FF: renamed from: c dev.nuker.pyro.f37
   public static f37 field_2028 = new f37();

   public CompletableFuture getSuggestions(CommandContext var1, SuggestionsBuilder var2) {
      Iterator var4 = f67.field_2201.method_3278().iterator();

      while(var4.hasNext()) {
         f66 var3 = (f66)var4.next();
         String var5 = var3.method_3273();
         boolean var6 = false;
         if (var5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var10000 = var5.toLowerCase();
         var5 = var2.getRemaining();
         String var7 = var10000;
         var6 = false;
         if (var5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var8 = var5.toLowerCase();
         if (StringsKt.startsWith$default(var7, var8, false, 2, (Object)null)) {
            var2.suggest(var3.method_3273());
         }
      }

      return var2.buildFuture();
   }
}
