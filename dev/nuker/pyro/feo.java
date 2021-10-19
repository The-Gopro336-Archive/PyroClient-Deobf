/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.awt.Color;

public class feo {
   // $FF: renamed from: c float
   public float field_1356;
   // $FF: renamed from: c float[]
   public float[] field_1357;
   // $FF: renamed from: c java.awt.Color
   public Color field_1358;

   // $FF: renamed from: c (float[], float) java.awt.Color
   public static Color method_2019(float[] var0, float var1) {
      return method_2034(var0[0], var0[1], var0[2], var1);
   }

   public feo(Color var1) {
      this.field_1358 = var1;
      this.field_1357 = method_2023(var1);
      this.field_1356 = (float)var1.getAlpha() / 255.0F;
   }

   // $FF: renamed from: 2 () float
   public float method_2020() {
      return this.field_1357[0];
   }

   // $FF: renamed from: 0 () float
   public float method_2021() {
      return this.field_1357[1];
   }

   // $FF: renamed from: 1 () java.awt.Color
   public Color method_2022() {
      return method_2031((this.field_1357[0] + 180.0F) % 360.0F, this.field_1357[1], this.field_1357[2]);
   }

   // $FF: renamed from: c (java.awt.Color) float[]
   public static float[] method_2023(Color var0) {
      float[] var1 = var0.getRGBColorComponents((float[])null);
      float var2 = var1[0];
      float var3 = var1[1];
      float var4 = var1[2];
      float var5 = Math.min(var2, Math.min(var3, var4));
      float var6 = Math.max(var2, Math.max(var3, var4));
      float var7 = 0.0F;
      float var8;
      if (var6 == var5) {
         var7 = 0.0F;
         var8 = var6;
      } else if (var6 == var2) {
         var7 = (60.0F * (var3 - var4) / (var6 - var5) + 360.0F) % 360.0F;
         var8 = var6;
      } else if (var6 == var3) {
         var7 = 60.0F * (var4 - var2) / (var6 - var5) + 120.0F;
         var8 = var6;
      } else {
         if (var6 == var4) {
            var7 = 60.0F * (var2 - var3) / (var6 - var5) + 240.0F;
         }

         var8 = var6;
      }

      float var9 = (var8 + var5) / 2.0F;
      float var10;
      if (var6 == var5) {
         var10 = 0.0F;
      } else {
         float var11 = method_2029(var9, 0.5F);
         if (var11 <= 0.0F) {
            var10 = (var6 - var5) / (var6 + var5);
         } else {
            var10 = (var6 - var5) / (2.0F - var6 - var5);
         }
      }

      return new float[]{var7, var10 * 100.0F, var9 * 100.0F};
   }

   // $FF: renamed from: 5 () float[]
   public float[] method_2024() {
      return this.field_1357;
   }

   public feo(float var1, float var2, float var3, float var4) {
      boolean var5 = true;
      float[] var6 = new float[]{var1, var2, var3};
      this.field_1357 = var6;
      this.field_1356 = var4;
      this.field_1358 = method_2019(this.field_1357, var4);
   }

   public feo(float[] var1, float var2) {
      this.field_1357 = var1;
      this.field_1356 = var2;
      this.field_1358 = method_2019(var1, var2);
   }

   // $FF: renamed from: c (float[]) java.awt.Color
   public static Color method_2025(float[] var0) {
      return method_2019(var0, 1.0F);
   }

   public feo(float var1, float var2, float var3) {
      this(var1, var2, var3, 1.0F);
   }

   // $FF: renamed from: 2 (float) java.awt.Color
   public Color method_2026(float var1) {
      return method_2034(this.field_1357[0], var1, this.field_1357[2], this.field_1356);
   }

   // $FF: renamed from: 1 (float) java.awt.Color
   public Color method_2027(float var1) {
      var1 = (100.0F + var1) / 100.0F;
      var1 = Math.min(100.0F, this.field_1357[2] * var1);
      return method_2034(this.field_1357[0], this.field_1357[1], var1, this.field_1356);
   }

   public feo(float[] var1) {
      this(var1, 1.0F);
   }

   // $FF: renamed from: 3 () float
   public float method_2028() {
      return this.field_1357[2];
   }

   // $FF: renamed from: c (float, float) float
   public static float method_2029(float var0, float var1) {
      if (var0 == var1) {
         return 0.0F;
      } else {
         return var1 > var0 ? 2.0F : -1.0F;
      }
   }

   // $FF: renamed from: 3 (float) java.awt.Color
   public Color method_2030(float var1) {
      return method_2034(var1, this.field_1357[1], this.field_1357[2], this.field_1356);
   }

   // $FF: renamed from: c (float, float, float) java.awt.Color
   public static Color method_2031(float var0, float var1, float var2) {
      return method_2034(var0, var1, var2, 1.0F);
   }

   // $FF: renamed from: 4 () java.awt.Color
   public Color method_2032() {
      return this.field_1358;
   }

   // $FF: renamed from: c (float) java.awt.Color
   public Color method_2033(float var1) {
      var1 = (100.0F - var1) / 100.0F;
      var1 = Math.max(0.0F, this.field_1357[2] * var1);
      return method_2034(this.field_1357[0], this.field_1357[1], var1, this.field_1356);
   }

   // $FF: renamed from: c (float, float, float, float) java.awt.Color
   public static Color method_2034(float var0, float var1, float var2, float var3) {
      if (!(var1 < 0.0F) && !(var1 > 100.0F)) {
         if (!(var2 < 0.0F) && !(var2 > 100.0F)) {
            if (!(var3 < 0.0F) && !(var3 > 1.0F)) {
               var0 = (var0 %= 360.0F) / 360.0F;
               var1 /= 100.0F;
               var2 /= 100.0F;
               float var4;
               if ((double)var2 < 0.0D) {
                  var4 = var2 * (1.0F + var1);
               } else {
                  var4 = var2 + var1 - var1 * var2;
               }

               var1 = 2.0F * var2 - var4;
               var2 = Math.max(0.0F, method_2035(var1, var4, var0 + 0.33333334F));
               float var5 = Math.max(0.0F, method_2035(var1, var4, var0));
               var1 = Math.max(0.0F, method_2035(var1, var4, var0 - 0.33333334F));
               var2 = Math.min(var2, 1.0F);
               float var6 = Math.min(var5, 1.0F);
               var1 = Math.min(var1, 1.0F);
               return new Color(var2, var6, var1, var3);
            } else {
               throw new IllegalArgumentException("Color parameter outside of expected range - Alpha");
            }
         } else {
            throw new IllegalArgumentException("Color parameter outside of expected range - Lightness");
         }
      } else {
         throw new IllegalArgumentException("Color parameter outside of expected range - Saturation");
      }
   }

   // $FF: renamed from: 0 (float, float, float) float
   public static float method_2035(float var0, float var1, float var2) {
      if (var2 < 0.0F) {
         ++var2;
      }

      if (var2 > 1.0F) {
         --var2;
      }

      if (6.0F * var2 < 1.0F) {
         return var0 + (var1 - var0) * 6.0F * var2;
      } else if (2.0F * var2 < 1.0F) {
         return var1;
      } else {
         return 3.0F * var2 < 2.0F ? var0 + (var1 - var0) * 6.0F * (0.6666667F - var2) : var0;
      }
   }

   // $FF: renamed from: c () float
   public float method_2036() {
      return this.field_1356;
   }

   // $FF: renamed from: 0 (float) java.awt.Color
   public Color method_2037(float var1) {
      return method_2034(this.field_1357[0], this.field_1357[1], var1, this.field_1356);
   }

   public String toString() {
      return (new StringBuilder()).insert(0, "HSLColor[h=").append(this.field_1357[0]).append(",s=").append(this.field_1357[1]).append(",l=").append(this.field_1357[2]).append(",alpha=").append(this.field_1356).append("]").toString();
   }
}
