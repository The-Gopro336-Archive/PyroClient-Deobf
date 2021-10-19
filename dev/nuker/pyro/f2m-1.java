/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public class f2m {
   // $FF: renamed from: c dev.nuker.pyro.f2m
   public static f2m field_2112;

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3196(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("friend").then(f3e.method_3215("add").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f1Y.field_2447)))).then(f3e.method_3215("del").then((ArgumentBuilder)((RequiredArgumentBuilder)f3e.method_3216("name", (ArgumentType)StringArgumentType.string()).executes((Command)f2e.field_2047)).suggests((SuggestionProvider)f2f.field_2049)))).then(f3e.method_3215("list").executes((Command)f2g.field_2051))).then(f3e.method_3215("clear").executes((Command)f2h.field_2053))).then(f3e.method_3215("reload").executes((Command)f2i.field_2042))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215("sync").then((ArgumentBuilder)field_2112.method_3197("future", (Function1)f2j.field_18, (Function1)f2k.field_17))).then((ArgumentBuilder)field_2112.method_3197("impact", (Function1)f2l.field_16, (Function1)f1Z.field_8))).then((ArgumentBuilder)field_2112.method_3197("summit", (Function1)f2c.field_19, (Function1)f20.field_10))).then((ArgumentBuilder)field_2112.method_3197("salhack", (Function1)f21.field_14, (Function1)f22.field_13))).then((ArgumentBuilder)field_2112.method_3197("ares", (Function1)f23.field_12, (Function1)f24.field_11))).then(f3e.method_3215("overwrite_all").executes((Command)f2b.field_2036)))).then(f3e.method_3215("alias").then(f3e.method_3216("name", (ArgumentType)StringArgumentType.greedyString()).executes((Command)f2d.field_2039))));
   }

   static {
      f2m var0 = new f2m();
      field_2112 = var0;
   }

   // $FF: renamed from: c (java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1) com.mojang.brigadier.builder.LiteralArgumentBuilder
   public LiteralArgumentBuilder method_3197(String var1, Function1 var2, Function1 var3) {
      return (LiteralArgumentBuilder)((LiteralArgumentBuilder)f3e.method_3215(var1).then(((LiteralArgumentBuilder)f3e.method_3215("load").executes((Command)(new f1U(var2, var1)))).then(f3e.method_3215("overwrite").executes((Command)(new f1V(var2, var1)))))).then(((LiteralArgumentBuilder)f3e.method_3215("save").executes((Command)(new f1W(var3, var1)))).then(f3e.method_3215("overwrite").executes((Command)(new f1X(var3, var1)))));
   }
}
