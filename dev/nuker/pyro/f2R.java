/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public class f2R {
   // $FF: renamed from: c dev.nuker.pyro.f2R
   public static f2R field_2000;

   // $FF: renamed from: c (java.lang.String) java.util.Optional
   public Optional method_3075(String var1) {
      return class_37.field_2633.method_3981().stream().filter((Predicate)(new f2P(var1))).findFirst();
   }

   static {
      f2R var0 = new f2R();
      field_2000 = var0;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f2R, com.mojang.brigadier.suggestion.SuggestionsBuilder, int, java.lang.String[], java.util.Collection) void
   public static void method_3076(f2R var0, SuggestionsBuilder var1, int var2, String[] var3, Collection var4) {
      var0.method_3077(var1, var2, var3, var4);
   }

   // $FF: renamed from: c (com.mojang.brigadier.suggestion.SuggestionsBuilder, int, java.lang.String[], java.util.Collection) void
   public void method_3077(SuggestionsBuilder var1, int var2, String[] var3, Collection var4) {
      if (var3.length <= var2) {
      }

      String var5 = "" + '[' + var2 + "] ";
      int var6 = 0;

      for(int var7 = var2; var6 < var7; ++var6) {
      }

      Iterator var23 = var4.iterator();

      while(true) {
         while(var23.hasNext()) {
            f0w var22 = (f0w)var23.next();
            if (var22 instanceof f0z) {
               boolean var8 = false;
               Enum[] var11 = (Enum[])((Enum)((f0z)var22).method_3334().c()).getClass().getEnumConstants();
               int var12 = var11.length;

               for(int var10 = 0; var10 < var12; ++var10) {
                  Enum var9 = var11[var10];
                  StringCompanionObject var14 = StringCompanionObject.INSTANCE;
                  String var15 = "[%s]";
                  Object[] var10000 = new Object[1];
                  String var16 = var9.name();
                  byte var20 = 0;
                  Object[] var19 = var10000;
                  Object[] var18 = var10000;
                  boolean var17 = false;
                  if (var16 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                  }

                  String var21 = var16.toLowerCase();
                  var19[var20] = var21;
                  var17 = false;
                  String var13 = String.format(var15, Arrays.copyOf(var18, var18.length));
                  if (StringsKt.startsWith$default(var22.method_3315() + var13, var3[var2], false, 2, (Object)null) && StringsKt.startsWith$default(var3[var2], var22.method_3315(), false, 2, (Object)null)) {
                     var8 = true;
                     if (!Intrinsics.areEqual((Object)(var22.method_3315() + var13), (Object)var3[var2])) {
                        var1.suggest(var5 + var22.method_3315() + var13);
                     }
                  }

                  if (!var8 && StringsKt.startsWith$default(var22.method_3315(), var3[var2], false, 2, (Object)null)) {
                     var1.suggest(var5 + var22.method_3315());
                  }
               }
            } else {
               if (var22 instanceof f0t) {
                  this.method_3077(var1, var2 + 1, var3, (Collection)((f0t)var22).c());
               }

               var1.suggest(var5 + var22.method_3315() + (var22 instanceof f0t ? "." : ""));
            }
         }

         return;
      }
   }

   // $FF: renamed from: c (com.mojang.brigadier.CommandDispatcher) void
   @JvmStatic
   public static void method_3078(@NotNull CommandDispatcher var0) {
      var0.register((LiteralArgumentBuilder)f3e.method_3215("setting").then((ArgumentBuilder)f3e.method_3216("setting", (ArgumentType)StringArgumentType.string()).suggests((SuggestionProvider)f2Q.field_1997)));
   }
}
