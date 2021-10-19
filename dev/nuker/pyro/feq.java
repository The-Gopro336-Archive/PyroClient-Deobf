/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class feq {
   // $FF: renamed from: c java.util.ArrayList
   public ArrayList field_1382;
   // $FF: renamed from: 0 java.util.ArrayList
   public ArrayList field_1383;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1384;
   // $FF: renamed from: c int
   public int field_1385;
   // $FF: renamed from: c float
   public float field_1386;
   // $FF: renamed from: 0 float
   public float field_1387;
   // $FF: renamed from: 1 float
   public float field_1388;

   // $FF: renamed from: c (float) void
   public void method_2058(float var1) {
      this.field_1388 = var1;
   }

   // $FF: renamed from: 0 (int) int
   public int method_2059(int var1) {
      int var2 = var1;
      if (var1 > this.field_1382.size() - 1) {
         var2 = this.field_1382.size() - 1;
      }

      return ((Number)this.field_1383.get(((Number)this.field_1382.get(var2)).intValue())).intValue();
   }

   public feq(int var1, float var2, float var3, float var4) {
      this.field_1385 = var1;
      this.field_1386 = var2;
      this.field_1387 = var3;
      this.field_1388 = var4;
      this.field_1382 = new ArrayList();
      this.field_1383 = new ArrayList();
      this.field_1384 = new fe8();
      int var5 = 0;

      for(short var6 = 359; var5 <= var6; ++var5) {
         this.field_1383.add(feo.method_2034((float)var5, this.field_1386, this.field_1387, this.field_1388).getRGB());
         this.field_1382.add(var5);
      }

   }

   // $FF: renamed from: 1 () void
   public void method_2060() {
      if (this.field_1384.method_1980((double)this.field_1385)) {
         this.field_1384.method_1979();
         this.method_2065();
      }

   }

   // $FF: renamed from: 1 (float) void
   public void method_2061(float var1) {
      this.field_1387 = var1;
   }

   // $FF: renamed from: 2 () float
   public float method_2062() {
      return this.field_1386;
   }

   // $FF: renamed from: 3 () float
   public float method_2063() {
      return this.field_1387;
   }

   // $FF: renamed from: c (int) void
   public void method_2064(int var1) {
      this.field_1385 = var1;
   }

   // $FF: renamed from: 0 () void
   public void method_2065() {
      if (!this.field_1382.isEmpty()) {
         this.field_1382.remove(this.field_1382.get(0));
         int var1 = ((Number)this.field_1382.get(this.field_1382.size() - 1)).intValue() + 1;
         if (var1 >= this.field_1383.size() - 1) {
            var1 = 0;
         }

         this.field_1382.add(var1);
      }
   }

   public feq(int var1, float var2, float var3, float var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = 1.0F;
      }

      this(var1, var2, var3, var4);
   }

   // $FF: renamed from: 0 (float) void
   public void method_2066(float var1) {
      this.field_1386 = var1;
   }

   // $FF: renamed from: c () float
   public float method_2067() {
      return this.field_1388;
   }
}
