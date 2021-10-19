/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f2Q implements SuggestionProvider {
   // $FF: renamed from: c dev.nuker.pyro.f2Q
   public static f2Q field_1997 = new f2Q();

   public CompletableFuture getSuggestions(@Nullable CommandContext var1, @NotNull SuggestionsBuilder var2) {
      String var3 = var2.getRemaining();
      boolean var4 = false;
      if (StringsKt.endsWith$default(var3, ".", false, 2, (Object)null)) {
         var3 = var3 + "|";
         var4 = true;
      }

      Collection var6 = (Collection)StringsKt.split$default((CharSequence)var3, new String[]{"\\."}, false, 0, 6, (Object)null);
      boolean var7 = false;
      Object[] var10000 = var6.toArray(new String[0]);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      } else {
         String[] var5 = (String[])var10000;
         if (var4) {
            var5[var5.length - 1] = "";
         }

         int var13 = var5.length - 1;
         List var14 = class_37.field_2633.method_3981();
         int var8 = 0;

         for(int var9 = var5.length; var8 < var9; ++var8) {
            String var15 = var5[var8];
            Module var11;
            Iterator var12;
            if (var13 == 0) {
               var12 = class_37.field_2633.method_3981().iterator();

               while(var12.hasNext()) {
                  var11 = (Module)var12.next();
                  if (StringsKt.startsWith$default(var11.method_141(), var2.getRemaining(), false, 2, (Object)null)) {
                     var2.suggest(var11.method_141());
                  }
               }
            } else {
               var12 = class_37.field_2633.method_3981().iterator();

               while(var12.hasNext()) {
                  var11 = (Module)var12.next();
                  if (Intrinsics.areEqual((Object)var11.method_141(), (Object)var5[0])) {
                     f2R.method_3076(f2R.field_2000, var2, 1, var5, var11.field_87.values());
                     break;
                  }
               }
            }
         }

         return var2.buildFuture();
      }
   }
}
