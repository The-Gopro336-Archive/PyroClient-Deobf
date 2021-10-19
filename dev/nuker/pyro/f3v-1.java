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

public class f3v {
   // $FF: renamed from: c dev.nuker.pyro.f3v
   public static f3v field_2180;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3250(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("setpitch").then(f3e.method_3216("pitch", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f3u.field_2173)));
   }

   static {
      f3v var0 = new f3v();
      field_2180 = var0;
   }
}
