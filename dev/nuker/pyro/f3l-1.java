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

public class f3l {
   // $FF: renamed from: c dev.nuker.pyro.f3l
   public static f3l field_2149;

   static {
      f3l var0 = new f3l();
      field_2149 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3222(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("runtime").then(f3e.method_3216("type", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3k.field_2147)));
   }
}
