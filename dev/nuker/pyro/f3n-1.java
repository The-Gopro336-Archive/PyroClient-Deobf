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
import org.jetbrains.annotations.Nullable;

public class f3n {
   // $FF: renamed from: c java.lang.String
   @Nullable
   public static String field_2174;
   // $FF: renamed from: c dev.nuker.pyro.f3n
   public static f3n field_2175;

   static {
      f3n var0 = new f3n();
      field_2175 = var0;
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   public void method_3246(@NotNull CommandDispatcher var1) {
      var1.register((LiteralArgumentBuilder)f3e.method_3215("say").then(f3e.method_3216("message", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f3m.field_2153)));
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3247(@Nullable String var1) {
      field_2174 = var1;
   }

   // $FF: renamed from: c () java.lang.String
   @Nullable
   public String method_3248() {
      return field_2174;
   }
}
