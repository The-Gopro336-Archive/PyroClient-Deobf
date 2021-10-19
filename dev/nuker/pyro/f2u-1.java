/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
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
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class f2u implements SuggestionProvider {
   // $FF: renamed from: c com.mojang.brigadier.CommandDispatcher
   public CommandDispatcher field_2128;

   public CompletableFuture getSuggestions(@NotNull CommandContext var1, @NotNull SuggestionsBuilder var2) {
      String var3 = var2.getRemaining();
      boolean var7;
      String var10000;
      if (StringsKt.lastIndexOf$default((CharSequence)var3, " ", 0, false, 6, (Object)null) == -1) {
         var10000 = "";
      } else {
         byte var5 = 0;
         int var6 = StringsKt.lastIndexOf$default((CharSequence)var3, " ", 0, false, 6, (Object)null);
         var7 = false;
         var10000 = var3.substring(var5, var6);
      }

      var3 = var10000;
      ParseResults var4 = this.field_2128.parse(var3, var1.getSource());
      if (var4.getContext().getNodes().isEmpty()) {
         CharSequence var14 = (CharSequence)var3;
         boolean var16 = false;
         if (var14.length() != 0) {
            throw (Throwable)f2w.method_3210(f2w.field_2134).create();
         }
      }

      CharSequence var17 = (CharSequence)var3;
      var7 = false;
      CommandNode var15 = var17.length() == 0 ? (CommandNode)this.field_2128.getRoot() : ((ParsedCommandNode)Iterables.getLast((Iterable)var4.getContext().getNodes())).getNode();
      Iterator var19 = var15.getChildren().iterator();

      while(var19.hasNext()) {
         CommandNode var18 = (CommandNode)var19.next();
         var10000 = var18.getName();
         String var8 = var2.getRemaining();
         int var10001 = var3.length();
         CharSequence var9 = (CharSequence)var3;
         int var12 = var10001;
         String var11 = var10000;
         boolean var10 = false;
         boolean var13 = var9.length() == 0;
         int var20 = var12 + (var13 ? 0 : 1);
         var10 = false;
         if (var8 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         String var21 = var8.substring(var20);
         if (StringsKt.startsWith$default(var11, var21, false, 2, (Object)null)) {
            var2.suggest(var18.getName());
         }
      }

      return var2.buildFuture();
   }

   public f2u(CommandDispatcher var1) {
      this.field_2128 = var1;
      super();
   }
}
