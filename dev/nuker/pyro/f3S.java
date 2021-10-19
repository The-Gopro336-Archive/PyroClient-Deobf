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

public class f3S {
   // $FF: renamed from: c dev.nuker.pyro.f3S
   public static f3S field_2104;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3190(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("xray").then(f3e.method_3215("list").executes((Command)f3N.field_2113))).then(f3e.method_3215("add").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3O.field_2115)).suggests((SuggestionProvider)f3P.field_2119)))).then(f3e.method_3215("del").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3Q.field_2124)).suggests((SuggestionProvider)f3R.field_2056))));
   }

   static {
      f3S var0 = new f3S();
      field_2104 = var0;
   }
}
