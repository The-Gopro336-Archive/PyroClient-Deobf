/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import org.jetbrains.annotations.NotNull;

public class f3d {
   // $FF: renamed from: c dev.nuker.pyro.f3d
   public static f3d field_2140;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3212(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("profile").then(f3e.method_3215("select").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).suggests((SuggestionProvider)f35.field_2007).executes((Command)f36.field_2025)))).then(f3e.method_3215("delete").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).suggests((SuggestionProvider)f37.field_2028).executes((Command)f38.field_2031)))).then(f3e.method_3215("new").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f39.field_2034)))).then(f3e.method_3215("copy").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3a.field_2143)))).then(f3e.method_3215("replace").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3b.field_2137))));
   }

   static {
      f3d var0 = new f3d();
      field_2140 = var0;
   }
}
