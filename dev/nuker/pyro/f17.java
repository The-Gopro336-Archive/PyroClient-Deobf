/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class f17 {
   // $FF: renamed from: 3 double
   public double field_2395;
   // $FF: renamed from: 4 double
   public double field_2396;
   // $FF: renamed from: c int
   public int field_2397;

   // $FF: renamed from: 4 (double) void
   public void method_3642(double var1) {
      this.field_2396 = var1;
   }

   // $FF: renamed from: 3 (double) void
   public void method_3643(double var1) {
      this.field_2395 = var1;
   }

   // $FF: renamed from: c (int) void
   public void method_3644(int var1) {
      this.field_2397 = var1;
   }

   // $FF: renamed from: 4 () int
   public int method_3645() {
      return this.field_2397;
   }

   // $FF: renamed from: 3 () double
   public double method_3646() {
      return this.field_2396;
   }

   // $FF: renamed from: 5 () double
   public double method_3647() {
      return this.field_2395;
   }

   public f17(double var1, double var3, int var5) {
      this.field_2395 = var1;
      this.field_2396 = var3;
      this.field_2397 = var5;
   }

   // $FF: renamed from: c (double, double) dev.nuker.pyro.f17
   @NotNull
   public f17 method_3648(double var1, double var3) {
      return new f17(this.field_2395 - var1, this.field_2396 - var3, this.field_2397);
   }
}
