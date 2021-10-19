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

public class f2X {
   // $FF: renamed from: c dev.nuker.pyro.f2X
   public static f2X field_2033;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3101(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("nuker").then(f3e.method_3215("list").executes((Command)f2S.field_2003))).then(f3e.method_3215("add").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2T.field_2006)).suggests((SuggestionProvider)f2U.field_2024)))).then(f3e.method_3215("remove").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("block", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2V.field_2027)).suggests((SuggestionProvider)f2W.field_2030))));
   }

   static {
      f2X var0 = new f2X();
      field_2033 = var0;
   }
}
