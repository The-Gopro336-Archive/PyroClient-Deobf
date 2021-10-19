/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f2O {
   // $FF: renamed from: c dev.nuker.pyro.f2O
   public static f2O field_2013;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3094(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("modulelist").executes((Command)f2N.field_2011));
   }

   static {
      f2O var0 = new f2O();
      field_2013 = var0;
   }
}
