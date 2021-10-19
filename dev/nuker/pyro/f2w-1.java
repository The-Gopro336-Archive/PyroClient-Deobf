/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class f2w {
   // $FF: renamed from: c com.mojang.brigadier.exceptions.SimpleCommandExceptionType
   public static SimpleCommandExceptionType field_2133;
   // $FF: renamed from: c dev.nuker.pyro.f2w
   public static f2w field_2134;

   static {
      f2w var0 = new f2w();
      field_2134 = var0;
      field_2133 = new SimpleCommandExceptionType((Message)(new LiteralMessage("Unknown command; cannot provide help")));
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3209(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("help").executes((Command)(new f2t(var0)))).then(f3e.method_3216("command", (ArgumentType)StringArgumentType.greedyString()).suggests((SuggestionProvider)(new f2u(var0))).executes((Command)(new f2v(var0)))));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f2w) com.mojang.brigadier.exceptions.SimpleCommandExceptionType
   public static SimpleCommandExceptionType method_3210(f2w var0) {
      return field_2133;
   }
}
