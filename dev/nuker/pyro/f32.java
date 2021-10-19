/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f32 {
   // $FF: renamed from: c dev.nuker.pyro.f32
   public static f32 field_1998;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3074(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("plugins").executes((Command)f31.field_2017));
   }

   static {
      f32 var0 = new f32();
      field_1998 = var0;
   }
}
