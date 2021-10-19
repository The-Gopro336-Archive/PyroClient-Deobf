/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f15 extends f17 {
   // $FF: renamed from: c double
   public double field_2398;
   // $FF: renamed from: 0 double
   public double field_2399;
   // $FF: renamed from: 1 double
   public double field_2400;
   // $FF: renamed from: 2 double
   public double field_2401;

   public f15(double var1, double var3, double var5, double var7, double var9, double var11, int var13) {
      super(var5, var7, var13);
      this.field_2398 = var1;
      this.field_2399 = var3;
      this.field_2400 = var9;
      this.field_2401 = var11;
   }

   // $FF: renamed from: 1 (double) void
   public void method_3649(double var1) {
      this.field_2401 = var1;
   }

   // $FF: renamed from: 0 () double
   public double method_3650() {
      return this.field_2399;
   }

   // $FF: renamed from: c (double) void
   public void method_3651(double var1) {
      this.field_2399 = var1;
   }

   // $FF: renamed from: 0 (double) void
   public void method_3652(double var1) {
      this.field_2398 = var1;
   }

   // $FF: renamed from: 2 (double) void
   public void method_3653(double var1) {
      this.field_2400 = var1;
   }

   // $FF: renamed from: c () double
   public double method_3654() {
      return this.field_2401;
   }

   // $FF: renamed from: c (double, double) dev.nuker.pyro.f17
   @NotNull
   public f17 method_3648(double var1, double var3) {
      return (f17)(new f15(this.field_2398 - var1, this.field_2399 - var3, this.5() - var1, this.3() - var3, this.field_2400, this.field_2401, this.4()));
   }

   // $FF: renamed from: 2 () double
   public double method_3655() {
      return this.field_2400;
   }

   // $FF: renamed from: 1 () double
   public double method_3656() {
      return this.field_2398;
   }
}
