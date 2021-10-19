/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f2y {
   // $FF: renamed from: c dev.nuker.pyro.f2y
   public static f2y field_2125;

   static {
      f2y var0 = new f2y();
      field_2125 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3201(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("legit").executes((Command)f2x.field_2135));
   }
}
