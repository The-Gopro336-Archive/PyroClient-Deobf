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

public class f2o {
   // $FF: renamed from: c dev.nuker.pyro.f2o
   public static f2o field_2118;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3199(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("grab").then(f3e.method_3216("type", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2n.field_2114)));
   }

   static {
      f2o var0 = new f2o();
      field_2118 = var0;
   }
}
