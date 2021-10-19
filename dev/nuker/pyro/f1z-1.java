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

public class f1z {
   // $FF: renamed from: c dev.nuker.pyro.f1z
   public static f1z field_2022;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3099(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("drawn").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1y.field_2020)));
   }

   static {
      f1z var0 = new f1z();
      field_2022 = var0;
   }
}
