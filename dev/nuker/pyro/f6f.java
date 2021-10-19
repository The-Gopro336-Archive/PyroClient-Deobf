/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.enchantment.EnchantmentProtection.Type;

public class f6f {
   // $FF: renamed from: c int[]
   public static int[] field_1736;
   // $FF: renamed from: 0 int[]
   public static int[] field_1737;
   // $FF: renamed from: 1 int[]
   public static int[] field_1738 = new int[f6i.values().length];

   static {
      try {
         field_1738[f6i.field_1784.ordinal()] = 1;
      } catch (NoSuchFieldError var6) {
      }

      try {
         field_1738[f6i.field_1785.ordinal()] = 2;
      } catch (NoSuchFieldError var5) {
      }

      field_1737 = new int[Type.values().length];

      try {
         field_1737[Type.ALL.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field_1737[Type.EXPLOSION.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      field_1736 = new int[f6g.values().length];

      try {
         field_1736[f6g.field_1740.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
      }

      try {
         field_1736[f6g.field_1741.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
      }

   }
}
