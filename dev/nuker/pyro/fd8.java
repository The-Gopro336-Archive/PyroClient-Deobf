/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.inventory.EntityEquipmentSlot;

public class fd8 {
   // $FF: renamed from: c int[]
   public static int[] field_972 = new int[EntityEquipmentSlot.values().length];

   static {
      try {
         field_972[EntityEquipmentSlot.HEAD.ordinal()] = 1;
      } catch (NoSuchFieldError var4) {
      }

      try {
         field_972[EntityEquipmentSlot.CHEST.ordinal()] = 2;
      } catch (NoSuchFieldError var3) {
      }

      try {
         field_972[EntityEquipmentSlot.LEGS.ordinal()] = 3;
      } catch (NoSuchFieldError var2) {
      }

      try {
         field_972[EntityEquipmentSlot.FEET.ordinal()] = 4;
      } catch (NoSuchFieldError var1) {
      }

   }
}
