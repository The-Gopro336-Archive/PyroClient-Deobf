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

public class f1x {
   // $FF: renamed from: c dev.nuker.pyro.f1x
   public static f1x field_2018;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3097(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("donkey").then(f3e.method_3216("entityId", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f1w.field_2032)));
   }

   static {
      f1x var0 = new f1x();
      field_2018 = var0;
   }
}
