/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f0o extends Setting {
   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      Object var10000 = this.getValue().method_3034();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      String var1 = ((Enum)var10000).name();
      boolean var2 = false;
      if (var1 == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         String var5 = var1.toUpperCase();
         return (JsonElement)(new JsonPrimitive(var5));
      }
   }

   public f0o(@NotNull String var1, @NotNull String var2, @Nullable String var3, @NotNull Enum var4) {
      super(var1, var2, var3, var4);
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0O(this));
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      class_6 var10000 = this.getValue();
      Object[] var2 = ((Enum)this.getValue().method_3034()).getClass().getEnumConstants();
      class_6 var14 = var10000;
      boolean var3 = false;
      boolean var5 = false;
      Object[] var6 = var2;
      int var7 = var2.length;
      int var8 = 0;

      Object var16;
      while(true) {
         if (var8 >= var7) {
            var16 = null;
            break;
         }

         Object var9 = var6[var8];
         Enum var10 = (Enum)var9;
         boolean var11 = false;
         String var12 = var10.name();
         boolean var13 = false;
         if (var12 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
         }

         if (Intrinsics.areEqual((Object)var12.toUpperCase(), (Object)var1.getAsString())) {
            var16 = var9;
            break;
         }

         ++var8;
      }

      Object var15 = var16;
      Enum var10001 = (Enum)var15;
      if ((Enum)var15 == null) {
         var10001 = (Enum)this.1();
      }

      var14.method_3033(var10001);
   }
}
