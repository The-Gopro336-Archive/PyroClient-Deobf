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

public class f3x {
   // $FF: renamed from: c dev.nuker.pyro.f3x
   public static f3x field_2182;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3251(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("setyaw").then(f3e.method_3216("yaw", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f3w.field_2181)));
   }

   static {
      f3x var0 = new f3x();
      field_2182 = var0;
   }
}
