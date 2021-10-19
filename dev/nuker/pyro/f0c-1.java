/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.gson.JsonObject;
import java.awt.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f0c {
   // $FF: renamed from: 0 (float, float, float) float
   public float method_3684(float var1, float var2, float var3) {
      float var4 = var1 < var2 ? var1 : var2;
      return var4 < var3 ? var4 : var3;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f00
   @NotNull
   public f00 method_3685() {
      return f00.meth32();
   }

   // $FF: renamed from: 0 (float, float, float, float) dev.nuker.pyro.f00
   @NotNull
   public f00 method_3686(float var1, float var2, float var3, float var4) {
      return new f00(((f0c)this).method_3692(new float[]{var1, var2, var3, var4}));
   }

   // $FF: renamed from: c (int, int, int, int) dev.nuker.pyro.f00
   @NotNull
   public f00 method_3687(int var1, int var2, int var3, int var4) {
      return ((f0c)this).method_3686((float)var1 / 255.0F, (float)var2 / 255.0F, (float)var3 / 255.0F, (float)var4 / 255.0F);
   }

   // $FF: renamed from: c (float, float, float) float
   public float method_3688(float var1, float var2, float var3) {
      float var4 = var1 > var2 ? var1 : var2;
      return var4 > var3 ? var4 : var3;
   }

   // $FF: renamed from: c (float, float, float, float) float[]
   @NotNull
   public float[] method_3689(float var1, float var2, float var3, float var4) {
      float[] var6 = new float[]{var3, var3, var3, 0.0F};
      if (var2 > 0.0F) {
         float var5 = var1 < 1.0F ? var1 * 6.0F : 0.0F;
         int var7 = (int)var5;
         float var8 = var5 - (float)var7;
         switch(var7) {
         case 0:
            var6[1] *= 1.0F - var2 * (1.0F - var8);
            var6[2] *= 1.0F - var2;
            break;
         case 1:
            var6[0] *= 1.0F - var2 * var8;
            var6[2] *= 1.0F - var2;
            break;
         case 2:
            var6[0] *= 1.0F - var2;
            var6[2] *= 1.0F - var2 * (1.0F - var8);
            break;
         case 3:
            var6[0] *= 1.0F - var2;
            var6[1] *= 1.0F - var2 * var8;
            break;
         case 4:
            var6[0] *= 1.0F - var2 * (1.0F - var8);
            var6[1] *= 1.0F - var2;
            break;
         case 5:
            var6[1] *= 1.0F - var2;
            var6[2] *= 1.0F - var2 * var8;
         }
      }

      var6[3] = var4;
      return var6;
   }

   // $FF: renamed from: c (com.google.gson.JsonObject) dev.nuker.pyro.f00
   @NotNull
   public f00 method_3690(@NotNull JsonObject var1) {
      float var2 = var1.get("hue_").getAsFloat();
      float var3 = var1.get("saturation").getAsFloat();
      float var4 = var1.get("value").getAsFloat();
      float var5 = var1.get("alpha").getAsFloat();
      return new f00(var2, var3, var4, var5);
   }

   public f0c() {
   }

   // $FF: renamed from: c (float, float, float, float, float) float
   public float method_3691(float var1, float var2, float var3, float var4, float var5) {
      float var6 = var4 - var5;
      if (var6 > 0.0F) {
         if (var4 == var1) {
            var6 = (var2 - var3) / var6;
            if (var6 < 0.0F) {
               var6 += 6.0F;
            }
         } else if (var4 == var2) {
            var6 = 2.0F + (var3 - var1) / var6;
         } else {
            var6 = 4.0F + (var1 - var2) / var6;
         }

         var6 /= 6.0F;
      }

      return var6;
   }

   public f0c(DefaultConstructorMarker var1) {
      this();
   }

   // $FF: renamed from: c (float[]) float[]
   @NotNull
   public float[] method_3692(@NotNull float[] var1) {
      float[] var2 = new float[4];
      float var3 = ((f0c)this).method_3688(var1[0], var1[1], var1[2]);
      float var4 = ((f0c)this).method_3684(var1[0], var1[1], var1[2]);
      float var5 = var3 - var4;
      if (var5 > 0.0F) {
         var5 /= var3;
      }

      var2[0] = ((f0c)this).method_3691(var1[0], var1[1], var1[2], var3, var4);
      var2[1] = var5;
      var2[2] = var3;
      var2[3] = var1[3];
      return var2;
   }

   // $FF: renamed from: c (java.awt.Color) dev.nuker.pyro.f00
   @NotNull
   public f00 method_3693(@NotNull Color var1) {
      return ((f0c)this).method_3687(var1.getRed(), var1.getGreen(), var1.getBlue(), var1.getAlpha());
   }

   // $FF: renamed from: 0 (float[]) java.awt.Color
   @NotNull
   public Color method_3694(@NotNull float[] var1) {
      float[] var2 = ((f0c)this).method_3689(var1[0], var1[1], var1[2], var1[3]);
      return new Color(var2[0], var2[1], var2[2], var1[3]);
   }

   // $FF: renamed from: c (int) float[]
   @NotNull
   public float[] method_3695(int var1) {
      int var2 = var1 >>> 24 & 255;
      int var3 = var1 >>> 16 & 255;
      int var4 = var1 >>> 8 & 255;
      int var5 = var1 & 255;
      return ((f0c)this).method_3692(new float[]{(float)var3 / 255.0F, (float)var4 / 255.0F, (float)var5 / 255.0F, (float)var2 / 255.0F});
   }

   // $FF: renamed from: 0 (int) dev.nuker.pyro.f00
   @NotNull
   public f00 method_3696(int var1) {
      int var2 = var1 >>> 24 & 255;
      int var3 = var1 >>> 16 & 255;
      int var4 = var1 >>> 8 & 255;
      int var5 = var1 & 255;
      return ((f0c)this).method_3687(var3, var4, var5, var2);
   }
}
