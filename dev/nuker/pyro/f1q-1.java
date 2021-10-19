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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f1q implements SuggestionProvider {
   // $FF: renamed from: c dev.nuker.pyro.f1q
   public static f1q field_1999 = new f1q();

   public CompletableFuture getSuggestions(@Nullable CommandContext var1, @NotNull SuggestionsBuilder var2) {
      Iterator var4 = PyroStatic.field_2595.method_472().method_3048().iterator();

      while(var4.hasNext()) {
         String var3 = (String)var4.next();
         boolean var6 = false;
         if (var3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var10000 = StringsKt.substringAfter$default(var3.toLowerCase(), "minecraft:", (String)null, 2, (Object)null);
         String var5 = var2.getRemaining();
         String var7 = var10000;
         var6 = false;
         if (var5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var8 = var5.toLowerCase();
         if (StringsKt.startsWith$default(var7, StringsKt.substringAfter$default(var8, "minecraft:", (String)null, 2, (Object)null), false, 2, (Object)null)) {
            var2.suggest(var3);
         }
      }

      return var2.buildFuture();
   }
}
