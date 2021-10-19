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
import com.mojang.brigadier.suggestion.SuggestionProvider;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public class f2M {
   // $FF: renamed from: c dev.nuker.pyro.f2M
   public static f2M field_2009;

   // $FF: renamed from: c (java.lang.String) java.util.Optional
   public Optional method_3090(String var1) {
      return class_37.field_2633.method_3981().stream().filter((Predicate)(new f2F(var1))).findFirst();
   }

   // $FF: renamed from: c (java.util.function.Function) com.mojang.brigadier.suggestion.SuggestionProvider
   public SuggestionProvider method_3091(Function var1) {
      return (SuggestionProvider)(new f2E(var1));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f2M, java.lang.String) java.util.Optional
   public static Optional method_3092(f2M var0, String var1) {
      return var0.method_3090(var1);
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3093(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)f3e.method_3215("enable").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.string()).suggests(field_2009.method_3091((Function)f2G.field_1993)).executes((Command)f2H.field_1995)));
      var0.register((LiteralArgumentBuilder)f3e.method_3215("disable").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.string()).suggests(field_2009.method_3091((Function)f2I.field_1981)).executes((Command)f2J.field_1983)));
      var0.register((LiteralArgumentBuilder)f3e.method_3215("toggle").then(f3e.method_3216("module", (ArgumentType)StringArgumentType.string()).suggests(field_2009.method_3091((Function)f2K.field_1985)).executes((Command)f2L.field_1987)));
   }

   static {
      f2M var0 = new f2M();
      field_2009 = var0;
   }
}
