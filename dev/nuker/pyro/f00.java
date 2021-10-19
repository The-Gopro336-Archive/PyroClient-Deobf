/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.awt.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f00 {
   // $FF: renamed from: c float
   public float field_2294;
   public float var0;
   public float var1;
   public float var2;
   // $FF: renamed from: c dev.nuker.pyro.f00
   @NotNull
   public static f00 field_2295 = new f00(0, 0, 0, 0);
   // $FF: renamed from: c dev.nuker.pyro.f0c
   public static f0c field_2296 = new f0c((DefaultConstructorMarker)null);

   public void meth6(float var1x) {
      this.field_2294 = var1x;
   }

   public void meth1(float var1x) {
      float[] var2x = this.method_3452();
      var2x[2] = var1x;
      float[] var3 = field_2296.method_3692(var2x);
      this.method_3453(var3[0]);
      this.var0 = var3[1];
      this.var1 = var3[2];
   }

   public float meth5() {
      return this.field_2294 < (float)0 ? (float)((int)((double)((float)(System.currentTimeMillis() % (long)1048576) * -this.field_2294) * 0.4D) % 255) / 255.0F : this.field_2294;
   }

   // $FF: renamed from: a () float
   public float method_3445() {
      return this.var0;
   }

   @NotNull
   public float[] meth6() {
      return new float[]{this.meth5(), this.var0, this.var1, this.var2};
   }

   public void meth5(float var1x) {
      float[] var2x = this.method_3452();
      var2x[0] = var1x;
      float[] var3 = field_2296.method_3692(var2x);
      this.method_3453(var3[0]);
      this.var0 = var3[1];
      this.var1 = var3[2];
   }

   public f00(@NotNull float[] var1x) {
      this(var1x[0], var1x[1], var1x[2], var1x[3]);
   }

   @NotNull
   public f00 meth0() {
      return new f00(this.field_2294, this.var0, this.var1, this.var2);
   }

   public float meth7() {
      return this.method_3452()[0];
   }

   public int meth1() {
      return this.meth8().getRGB();
   }

   public void meth0(float var1x) {
      this.var2 = var1x;
   }

   // $FF: renamed from: g () float
   public float method_3446() {
      return this.method_3452()[1];
   }

   // $FF: renamed from: d () float
   public float method_3447() {
      return this.var1;
   }

   // $FF: renamed from: c (int) java.awt.Color
   @NotNull
   public Color method_3448(int var1x) {
      return field_2296.method_3694(this.meth02(var1x));
   }

   public f00(int var1x, int var2x, int var3, int var4) {
      this((float)var1x / 255.0F, (float)var2x / 255.0F, (float)var3 / 255.0F, (float)var4 / 255.0F);
   }

   public boolean meth4() {
      return this.field_2294 < (float)0;
   }

   public void meth2(float var1x) {
      this.method_3453(-var1x);
   }

   public float meth9() {
      return this.var2;
   }

   // $FF: renamed from: f () float
   public float method_3449() {
      return Math.max(0.0F, -this.field_2294);
   }

   @NotNull
   public Color meth8() {
      return field_2296.method_3694(this.meth6());
   }

   public float meth1(int var1x) {
      return this.field_2294 < (float)0 ? (float)((int)((double)((float)((System.currentTimeMillis() + (long)var1x) % (long)1048576) * -this.field_2294) * 0.4D) % 255) / 255.0F : this.field_2294;
   }

   // $FF: renamed from: e () com.google.gson.JsonObject
   @NotNull
   public JsonObject method_3450() {
      JsonObject var1x = new JsonObject();
      var1x.add("hue_", (JsonElement)(new JsonPrimitive((Number)this.field_2294)));
      var1x.add("saturation", (JsonElement)(new JsonPrimitive((Number)this.var0)));
      var1x.add("value", (JsonElement)(new JsonPrimitive((Number)this.var1)));
      var1x.add("alpha", (JsonElement)(new JsonPrimitive((Number)this.var2)));
      return var1x;
   }

   public void meth3(float var1x) {
      float[] var2x = this.method_3452();
      var2x[1] = var1x;
      float[] var3 = field_2296.method_3692(var2x);
      this.method_3453(var3[0]);
      this.var0 = var3[1];
      this.var1 = var3[2];
   }

   public static f00 meth32() {
      return field_2295;
   }

   public f00(float var1x, float var2x, float var3, float var4) {
      this.field_2294 = var1x;
      this.var0 = var2x;
      this.var1 = var3;
      this.var2 = var4;
   }

   @NotNull
   public float[] meth02(int var1x) {
      return new float[]{this.meth1(var1x), this.var0, this.var1, this.var2};
   }

   // $FF: renamed from: c () float
   public float method_3451() {
      return this.field_2294;
   }

   public float meth22() {
      return this.method_3452()[2];
   }

   public void meth72(float var1x) {
      this.var1 = var1x;
   }

   // $FF: renamed from: b () float[]
   @NotNull
   public float[] method_3452() {
      return field_2296.method_3689(this.meth5(), this.var0, this.var1, this.var2);
   }

   public void meth42(float var1x) {
      this.var0 = var1x;
   }

   // $FF: renamed from: c (float) void
   public void method_3453(float var1x) {
      this.field_2294 = var1x;
   }
}
