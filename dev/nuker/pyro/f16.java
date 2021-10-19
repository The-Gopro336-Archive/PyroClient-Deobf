/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f16 extends f18 {
   // $FF: renamed from: c double
   public double field_2402;
   // $FF: renamed from: 0 double
   public double field_2403;

   // $FF: renamed from: 0 (double) void
   public void method_3657(double var1) {
      this.field_2403 = var1;
   }

   // $FF: renamed from: c () double
   public double method_3658() {
      return this.field_2403;
   }

   // $FF: renamed from: c (double, double) dev.nuker.pyro.f17
   @NotNull
   public f17 method_3648(double var1, double var3) {
      return (f17)(new f16(this.field_2402 - var1, this.field_2403 - var3, this.5() - var1, this.3() - var3, this.4()));
   }

   // $FF: renamed from: c (double) void
   public void method_3659(double var1) {
      this.field_2402 = var1;
   }

   public f16(double var1, double var3, double var5, double var7, int var9) {
      super(var5, var7, var9);
      this.field_2402 = var1;
      this.field_2403 = var3;
   }

   // $FF: renamed from: 0 () double
   public double method_3660() {
      return this.field_2402;
   }
}
