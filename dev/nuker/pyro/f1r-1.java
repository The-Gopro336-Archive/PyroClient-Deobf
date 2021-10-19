/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import org.jetbrains.annotations.NotNull;

public class f1r {
   // $FF: renamed from: c dev.nuker.pyro.f1r
   public static f1r field_2002;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3079(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("cheststealer").then(f3e.method_3215("list").executes((Command)f1m.field_2010))).then(f3e.method_3215("add").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1n.field_2012)).suggests((SuggestionProvider)f1o.field_2015)))).then(f3e.method_3215("remove").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1p.field_1996)).suggests((SuggestionProvider)f1q.field_1999))));
   }

   static {
      f1r var0 = new f1r();
      field_2002 = var0;
   }
}
