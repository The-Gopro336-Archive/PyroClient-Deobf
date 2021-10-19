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

public class f2f implements SuggestionProvider {
   // $FF: renamed from: c dev.nuker.pyro.f2f
   public static f2f field_2049 = new f2f();

   public CompletableFuture getSuggestions(@Nullable CommandContext var1, @NotNull SuggestionsBuilder var2) {
      Iterator var4 = FriendManager.Companion.getINSTANCE().getFriends().iterator();

      while(var4.hasNext()) {
         class_17 var3 = (class_17)var4.next();
         String var5 = var3.method_3416();
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
            var2.suggest(var3.method_3416());
         }
      }

      return var2.buildFuture();
   }
}
