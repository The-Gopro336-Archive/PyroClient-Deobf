/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.entity.MoverType;

public class f4p extends f42 {
   // $FF: renamed from: c net.minecraft.entity.MoverType
   public MoverType field_2063;
   // $FF: renamed from: c double
   public double field_2064;
   // $FF: renamed from: 0 double
   public double field_2065;
   // $FF: renamed from: 1 double
   public double field_2066;
   // $FF: renamed from: 0 boolean
   public boolean field_2067;

   // $FF: renamed from: 3 () double
   public double method_3119() {
      return this.field_2065;
   }

   // $FF: renamed from: 1 (double) void
   public void method_3120(double var1) {
      this.field_2065 = var1;
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_3121() {
      return this.field_2067;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_3122(boolean var1) {
      this.field_2067 = var1;
   }

   // $FF: renamed from: c () double
   public double method_3123() {
      return this.field_2066;
   }

   // $FF: renamed from: 1 () net.minecraft.entity.MoverType
   public MoverType method_3124() {
      return this.field_2063;
   }

   // $FF: renamed from: 0 (double) void
   public void method_3125(double var1) {
      this.field_2064 = var1;
   }

   // $FF: renamed from: c (net.minecraft.entity.MoverType) void
   public void method_3126(MoverType var1) {
      this.field_2063 = var1;
   }

   public f4p(f41 var1, MoverType var2, double var3, double var5, double var7, boolean var9) {
      super(var1);
      this.field_2063 = var2;
      this.field_2064 = var3;
      this.field_2065 = var5;
      this.field_2066 = var7;
      this.field_2067 = var9;
   }

   // $FF: renamed from: c (double) void
   public void method_3127(double var1) {
      this.field_2066 = var1;
   }

   // $FF: renamed from: 2 () double
   public double method_3128() {
      return this.field_2064;
   }
}
