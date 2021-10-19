/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f30 {
   // $FF: renamed from: c dev.nuker.pyro.f30
   public static f30 field_2014;

   static {
      f30 var0 = new f30();
      field_2014 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3095(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("path").then(f3e.method_3216("x", (ArgumentType)IntegerArgumentType.integer()).then(f3e.method_3216("y", (ArgumentType)IntegerArgumentType.integer(0, 255)).then(f3e.method_3216("z", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f3c.field_2139)))));
   }
}
