/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// $FF: renamed from: dev.nuker.pyro.f8
public class class_17 {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_2277;
   // $FF: renamed from: 0 java.lang.String
   @Nullable
   public String field_2278;

   // $FF: renamed from: 1 () java.lang.String
   @Nullable
   public String method_3409() {
      return this.field_2278;
   }

   public class_17(@NotNull String var1, @Nullable String var2) {
      this.field_2277 = var1;
      this.field_2278 = var2;
   }

   // $FF: renamed from: c () java.lang.String
   @Nullable
   public String method_3410() {
      return this.field_2278;
   }

   // $FF: renamed from: 0 (java.lang.String) void
   public void method_3411(@NotNull String var1) {
      this.field_2277 = var1;
   }

   // $FF: renamed from: 0 () java.lang.String
   @NotNull
   public String method_3412() {
      return this.field_2277;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f8, java.lang.String, java.lang.String, int, java.lang.Object) dev.nuker.pyro.f8
   public static class_17 method_3413(class_17 var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.field_2277;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.field_2278;
      }

      return var0.method_3415(var1, var2);
   }

   @NotNull
   public String toString() {
      return "Friend(name=" + this.field_2277 + ", alias=" + this.field_2278 + ")";
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3414(@Nullable String var1) {
      this.field_2278 = var1;
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) dev.nuker.pyro.f8
   @NotNull
   public class_17 method_3415(@NotNull String var1, @Nullable String var2) {
      return new class_17(var1, var2);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof class_17) {
            class_17 var2 = (class_17)var1;
            if (Intrinsics.areEqual((Object)this.field_2277, (Object)var2.field_2277) && Intrinsics.areEqual((Object)this.field_2278, (Object)var2.field_2278)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public int hashCode() {
      String var10000 = this.field_2277;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.field_2278;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   // $FF: renamed from: 2 () java.lang.String
   @NotNull
   public String method_3416() {
      return this.field_2277;
   }
}
