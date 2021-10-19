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
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f1o implements SuggestionProvider {
   // $FF: renamed from: c dev.nuker.pyro.f1o
   public static f1o field_2015 = new f1o();

   public CompletableFuture getSuggestions(@Nullable CommandContext var1, @NotNull SuggestionsBuilder var2) {
      Iterator var4 = Item.REGISTRY.iterator();

      while(var4.hasNext()) {
         Item var3 = (Item)var4.next();
         String var5 = String.valueOf(Item.REGISTRY.getNameForObject(var3));
         boolean var7 = false;
         if (var5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var10000 = StringsKt.substringAfter$default(var5.toLowerCase(), "minecraft:", (String)null, 2, (Object)null);
         String var6 = var2.getRemaining();
         String var8 = var10000;
         var7 = false;
         if (var6 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var9 = var6.toLowerCase();
         if (StringsKt.startsWith$default(var8, StringsKt.substringAfter$default(var9, "minecraft:", (String)null, 2, (Object)null), false, 2, (Object)null)) {
            var2.suggest(var5);
         }
      }

      return var2.buildFuture();
   }
}
