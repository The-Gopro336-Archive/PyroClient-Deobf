package com.formdev.flatlaf.util;

import java.awt.Color;

public class ColorFunctions {
   public static Color applyFunctions(Color color, ColorFunctions.ColorFunction... functions) {
      float[] hsl = HSLColor.fromRGB(color);
      float alpha = (float)color.getAlpha() / 255.0F;
      ColorFunctions.ColorFunction[] var4 = functions;
      int var5 = functions.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ColorFunctions.ColorFunction function = var4[var6];
         function.apply(hsl);
      }

      return HSLColor.toRGB(hsl, alpha);
   }

   public static float clamp(float value) {
      return value < 0.0F ? 0.0F : (value > 100.0F ? 100.0F : value);
   }

   public static class HSLIncreaseDecrease implements ColorFunctions.ColorFunction {
      public final int hslIndex;
      public final boolean increase;
      public final float amount;
      public final boolean relative;
      public final boolean autoInverse;

      public HSLIncreaseDecrease(int hslIndex, boolean increase, float amount, boolean relative, boolean autoInverse) {
         this.hslIndex = hslIndex;
         this.increase = increase;
         this.amount = amount;
         this.relative = relative;
         this.autoInverse = autoInverse;
      }

      public void apply(float[] hsl) {
         float amount2 = this.increase ? this.amount : -this.amount;
         amount2 = this.autoInverse && this.shouldInverse(hsl) ? -amount2 : amount2;
         hsl[this.hslIndex] = ColorFunctions.clamp(this.relative ? hsl[this.hslIndex] * ((100.0F + amount2) / 100.0F) : hsl[this.hslIndex] + amount2);
      }

      protected boolean shouldInverse(float[] hsl) {
         return this.increase ? hsl[this.hslIndex] >= 50.0F : hsl[this.hslIndex] < 50.0F;
      }
   }

   public interface ColorFunction {
      void apply(float[] var1);
   }
}
