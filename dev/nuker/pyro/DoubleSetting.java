/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DoubleSetting extends Setting {
   // $FF: renamed from: c double
   public double field_2217;
   // $FF: renamed from: 0 double
   public double field_2218;
   // $FF: renamed from: 1 double
   public double field_2219;

   // $FF: renamed from: 0 () double
   public double method_3325() {
      return this.field_2219;
   }

   public double getValue() {
      return this.field_2217;
   }

   @JvmOverloads
   public DoubleSetting(@NotNull String var1, @NotNull String var2, @Nullable String var3, double var4, double var6, double var8, double var10) {
      super(var1, var2, var3, var4);
      this.field_2217 = var6;
      this.field_2218 = var8;
      this.field_2219 = var10;
   }

   // $FF: renamed from: 1 (double) void
   public void method_3326(double var1) {
      this.field_2218 = var1;
   }

   // $FF: renamed from: 0 (double) void
   public void method_3327(double var1) {
      this.field_2217 = var1;
   }

   @JvmOverloads
   public DoubleSetting(@NotNull String var1, @NotNull String var2, @Nullable String var3, double var4, double var6, double var8) {
      this(var1, var2, var3, var4, var6, var8, 0.0D, 64, (DefaultConstructorMarker)null);
   }

   public DoubleSetting(String var1, String var2, String var3, double var4, double var6, double var8, double var10, int var12, DefaultConstructorMarker var13) {
      if ((var12 & 64) != 0) {
         var10 = var8 - var6;
      }

      this(var1, var2, var3, var4, var6, var8, var10);
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0M(this));
   }

   // $FF: renamed from: 1 () double
   public double method_3328() {
      return this.field_2218;
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      this.getValue().method_3033(var1.getAsDouble());
   }

   // $FF: renamed from: c (double) void
   public void method_3329(double var1) {
      this.field_2219 = var1;
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      return (JsonElement)(new JsonPrimitive((Number)this.getValue().method_3034()));
   }
}
