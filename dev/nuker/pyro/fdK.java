/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.awt.Color;
import java.util.Random;

public class fdK {
   // $FF: renamed from: c int[]
   public static int[] field_973 = new int[]{16711680, 16728064, 16744192, 16776960, 8453888, 65280, 65535, 33023, 255};
   // $FF: renamed from: c java.util.Random
   public static Random field_974 = new Random();

   // $FF: renamed from: c (int) double[]
   public static double[] method_1417(int var0) {
      return new double[]{(double)(var0 >> 16 & 255) / 255.0D, (double)(var0 >> 8 & 255) / 255.0D, (double)(var0 & 255) / 255.0D, (double)(var0 >> 24 & 255) / 255.0D, (double)(var0 >> 24 & 255) / 255.0D};
   }

   // $FF: renamed from: c (java.awt.Color, java.awt.Color, float) java.awt.Color
   public static Color method_1418(Color var0, Color var1, float var2) {
      if (var2 < 0.0F) {
         return var1;
      } else if (var2 > 1.0F) {
         return var0;
      } else {
         float var3 = 1.0F - var2;
         float[] var4 = new float[3];
         float[] var5 = new float[3];
         var0.getColorComponents(var4);
         var1.getColorComponents(var5);
         return new Color(var4[0] * var2 + var5[0] * var3, var4[1] * var2 + var5[1] * var3, var4[2] * var2 + var5[2] * var3);
      }
   }

   // $FF: renamed from: 0 () int
   public static int method_1419() {
      return Color.HSBtoRGB((float)Math.random(), (float)Math.random() / 4.0F + 0.75F, (float)Math.random() / 2.0F + 0.25F);
   }

   // $FF: renamed from: c () int
   public static int method_1420() {
      float var0 = field_974.nextFloat();
      float var1 = (float)field_974.nextInt(5000) / 10000.0F + 0.5F;
      float var2 = (float)field_974.nextInt(5000) / 10000.0F + 0.5F;
      return Color.HSBtoRGB(var0, var1, var2);
   }

   // $FF: renamed from: c (java.lang.String) int
   public static int method_1421(String var0) {
      if (var0.startsWith("#")) {
         var0 = var0.substring(1);
      }

      if (var0.toLowerCase().startsWith("0x")) {
         var0 = var0.substring(2);
      }

      try {
         return (int)Long.parseLong(var0, 16);
      } catch (Exception var2) {
         return -1;
      }
   }
}
