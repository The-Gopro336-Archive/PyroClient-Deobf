/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.world.EnumDifficulty;

public class fdL {
   // $FF: renamed from: c int[]
   public static int[] field_975 = new int[EnumDifficulty.values().length];

   static {
      try {
         field_975[EnumDifficulty.PEACEFUL.ordinal()] = 1;
      } catch (NoSuchFieldError var3) {
      }

      try {
         field_975[EnumDifficulty.EASY.ordinal()] = 2;
      } catch (NoSuchFieldError var2) {
      }

      try {
         field_975[EnumDifficulty.HARD.ordinal()] = 3;
      } catch (NoSuchFieldError var1) {
      }

   }
}
