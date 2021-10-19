/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f3z {
   // $FF: renamed from: c dev.nuker.pyro.f3z
   public static f3z field_2179;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3249(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("stashsort").then(f3e.method_3215("nearest").executes((Command)f3y.field_2183)));
   }

   static {
      f3z var0 = new f3z();
      field_2179 = var0;
   }
}
