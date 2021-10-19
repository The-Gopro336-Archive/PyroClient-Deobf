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

public class f1h {
   // $FF: renamed from: c dev.nuker.pyro.f1h
   public static f1h field_1980;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3068(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("autodupe").then(f3e.method_3215("host").then(f3e.method_3216("port", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f19.field_2404)))).then(f3e.method_3215("connect").then(((RequiredArgumentBuilder)f3e.method_3216("port", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f1a.field_1973)).then(f3e.method_3216("host", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1b.field_1975))))).then(f3e.method_3215("ping").executes((Command)f1d.field_1988))).then(f3e.method_3215("startPos").executes((Command)f1e.field_1990))).then(f3e.method_3215("quarryPos").executes((Command)f1f.field_1992))).then(f3e.method_3215("button").executes((Command)f1g.field_1994)));
   }

   static {
      f1h var0 = new f1h();
      field_1980 = var0;
   }
}
