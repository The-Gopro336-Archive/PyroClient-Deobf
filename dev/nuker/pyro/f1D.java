/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f1D {
   // $FF: renamed from: c dev.nuker.pyro.f1D
   public static f1D field_2429;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3697(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("entitydesync").then(f3e.method_3215("dismount").executes((Command)f1A.field_2408))).then(f3e.method_3215("remount").executes((Command)f1B.field_2410))).then(f3e.method_3215("reset").executes((Command)f1C.field_2417)));
   }

   static {
      f1D var0 = new f1D();
      field_2429 = var0;
   }
}
