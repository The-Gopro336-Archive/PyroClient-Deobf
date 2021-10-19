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

public class f2s {
   // $FF: renamed from: c dev.nuker.pyro.f2s
   public static f2s field_2105;

   static {
      f2s var0 = new f2s();
      field_2105 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3191(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("hclip").then(f3e.method_3216("distance", (ArgumentType)IntegerArgumentType.integer()).executes((Command)f2r.field_2103)));
   }
}
