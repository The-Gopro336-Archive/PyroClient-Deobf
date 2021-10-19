/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f1v {
   // $FF: renamed from: c dev.nuker.pyro.f1v
   public static f1v field_2029;

   static {
      f1v var0 = new f1v();
      field_2029 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3100(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("rpc").then(((RequiredArgumentBuilder)f3e.method_3216("line", (ArgumentType)IntegerArgumentType.integer(1, 2)).executes((Command)f1t.field_2023)).then(f3e.method_3216("text", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1u.field_2026))));
   }
}
