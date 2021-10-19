/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f3j {
   // $FF: renamed from: c dev.nuker.pyro.f3j
   public static f3j field_2144;

   static {
      f3j var0 = new f3j();
      field_2144 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3219(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("reload").then(f3e.method_3215("font").executes((Command)f3f.field_2162))).then(f3e.method_3215("modules").executes((Command)f3g.field_2163))).then(f3e.method_3215("hud").executes((Command)f3h.field_2165))).then(f3e.method_3215("macros").executes((Command)f3i.field_2167)));
   }
}
