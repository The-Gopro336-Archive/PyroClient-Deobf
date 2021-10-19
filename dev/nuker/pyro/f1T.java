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

public class f1T {
   // $FF: renamed from: c dev.nuker.pyro.f1T
   public static f1T field_2450;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3719(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("forcemount").then(f3e.method_3216("entityId", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f1S.field_2439)));
   }

   static {
      f1T var0 = new f1T();
      field_2450 = var0;
   }
}
