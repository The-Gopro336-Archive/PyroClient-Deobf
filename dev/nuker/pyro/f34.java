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

public class f34 {
   // $FF: renamed from: c dev.nuker.pyro.f34
   public static f34 field_2004;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3080(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)f3e.method_3215("prefix").then(f3e.method_3216("prefix", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f33.field_2001)));
   }

   static {
      f34 var0 = new f34();
      field_2004 = var0;
   }
}
