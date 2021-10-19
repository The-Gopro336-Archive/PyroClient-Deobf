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

public class IntegerSetting extends Setting {
   // $FF: renamed from: c int
   public int field_2223;
   // $FF: renamed from: 0 int
   public int field_2224;
   // $FF: renamed from: 1 int
   public int field_2225;

   @JvmOverloads
   public IntegerSetting(@NotNull String var1, @NotNull String var2, @Nullable String var3, int var4, int var5, int var6) {
      this(var1, var2, var3, var4, var5, var6, 0, 64, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 1 (int) void
   public void method_3337(int var1) {
      this.field_2224 = var1;
   }

   // $FF: renamed from: 0 (int) void
   public void method_3338(int var1) {
      this.field_2223 = var1;
   }

   @JvmOverloads
   public IntegerSetting(@NotNull String var1, @NotNull String var2, @Nullable String var3, int var4, int var5, int var6, int var7) {
      super(var1, var2, var3, var4);
      this.field_2223 = var5;
      this.field_2224 = var6;
      this.field_2225 = var7;
   }

   public IntegerSetting(String var1, String var2, String var3, int var4, int var5, int var6, int var7, int var8, DefaultConstructorMarker var9) {
      if ((var8 & 64) != 0) {
         var7 = var6 - var5;
      }

      this(var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: renamed from: c (com.google.gson.JsonElement) void
   public void method_3310(@NotNull JsonElement var1) {
      this.getValue().method_3033(var1.getAsInt());
   }

   // $FF: renamed from: 0 () int
   public int method_3339() {
      return this.field_2225;
   }

   // $FF: renamed from: c () int
   public int method_3340() {
      return this.field_2224;
   }

   // $FF: renamed from: c (int) void
   public void method_3341(int var1) {
      this.field_2225 = var1;
   }

   // $FF: renamed from: 1 () int
   public int method_3342() {
      return this.field_2223;
   }

   // $FF: renamed from: 0 () com.google.gson.JsonElement
   @NotNull
   public JsonElement method_3316() {
      return (JsonElement)(new JsonPrimitive((Number)this.getValue().method_3034()));
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f13
   @NotNull
   public f13 method_3309() {
      return (f13)(new f0R(this));
   }
}
