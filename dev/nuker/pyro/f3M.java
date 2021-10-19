/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f3M {
   // $FF: renamed from: c dev.nuker.pyro.f3M
   public static f3M field_2046;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3104(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("waypoint").then(f3e.method_3215("add").then(((RequiredArgumentBuilder)f3e.method_3216("name", (ArgumentType)StringArgumentType.string()).executes((Command)f3I.field_2054)).then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("x", (ArgumentType)DoubleArgumentType.doubleArg()).then((ArgumentBuilder)f3e.method_3216("y", (ArgumentType)DoubleArgumentType.doubleArg()))).then((ArgumentBuilder)f3e.method_3216("z", (ArgumentType)DoubleArgumentType.doubleArg()))).executes((Command)f3J.field_2043))))).then(f3e.method_3215("remove").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.string()).executes((Command)f3K.field_2044)))).then(f3e.method_3215("list").executes((Command)f3L.field_2045)));
   }

   static {
      f3M var0 = new f3M();
      field_2046 = var0;
   }
}
