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

public class f3D {
   // $FF: renamed from: c dev.nuker.pyro.f3D
   public static f3D field_2038;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3103(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("unbind").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.string()).executes((Command)f3C.field_2037)));
   }

   static {
      f3D var0 = new f3D();
      field_2038 = var0;
   }
}
