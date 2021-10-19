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
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class f3H {
   // $FF: renamed from: c dev.nuker.pyro.f3H
   public static f3H field_2052;

   static {
      f3H var0 = new f3H();
      field_2052 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3106(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)f3e.method_3215("watermark").then(f3e.method_3216("watermark", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3G.field_2050)));
   }
}
