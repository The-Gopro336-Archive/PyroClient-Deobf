/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import org.jetbrains.annotations.NotNull;

public class f2q {
   // $FF: renamed from: c dev.nuker.pyro.f2q
   public static f2q field_2055;

   static {
      f2q var0 = new f2q();
      field_2055 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3107(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("gui").then(f3e.method_3216("scale", (ArgumentType)DoubleArgumentType.doubleArg()).executes((Command)f2p.field_2123)));
   }
}
