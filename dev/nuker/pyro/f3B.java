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
import org.jetbrains.annotations.NotNull;

public class f3B {
   // $FF: renamed from: c dev.nuker.pyro.f3B
   public static f3B field_2035;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3102(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("toggle").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3A.field_2041)));
   }

   static {
      f3B var0 = new f3B();
      field_2035 = var0;
   }
}
