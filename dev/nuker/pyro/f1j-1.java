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

public class f1j {
   // $FF: renamed from: c dev.nuker.pyro.f1j
   public static f1j field_1984;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3070(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("bind").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.string()).then(f3e.method_3216("key", (ArgumentType)StringArgumentType.string()).executes((Command)f1i.field_1982))));
   }

   static {
      f1j var0 = new f1j();
      field_1984 = var0;
   }
}
