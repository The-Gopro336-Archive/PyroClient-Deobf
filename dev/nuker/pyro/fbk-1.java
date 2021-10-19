/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.EnumFacing;

public class fbk {
   // $FF: renamed from: c int[]
   public static int[] field_1646 = new int[EnumFacing.values().length];
   // $FF: renamed from: 0 int[]
   public static int[] field_1647;

   static {
      field_1646[EnumFacing.NORTH.ordinal()] = 1;
      field_1646[EnumFacing.SOUTH.ordinal()] = 2;
      field_1646[EnumFacing.WEST.ordinal()] = 3;
      field_1646[EnumFacing.EAST.ordinal()] = 4;
      field_1647 = new int[fbj.values().length];
      field_1647[fbj.field_1640.ordinal()] = 1;
      field_1647[fbj.field_1642.ordinal()] = 2;
      field_1647[fbj.field_1643.ordinal()] = 3;
      field_1647[fbj.field_1641.ordinal()] = 4;
      field_1647[fbj.field_1644.ordinal()] = 5;
   }
}
