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

public class f3t {
   // $FF: renamed from: c dev.nuker.pyro.f3t
   public static f3t field_2172;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3245(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("search").then(f3e.method_3215("list").executes((Command)f3o.field_2176))).then(f3e.method_3215("add").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3p.field_2177)).suggests((SuggestionProvider)f3q.field_2178)))).then(f3e.method_3215("remove").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3r.field_2168)).suggests((SuggestionProvider)f3s.field_2171))));
   }

   static {
      f3t var0 = new f3t();
      field_2172 = var0;
   }
}
