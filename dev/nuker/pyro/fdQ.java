/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.EnumFacing;
import org.jetbrains.annotations.NotNull;

public class fdQ {
   // $FF: renamed from: c java.util.HashMap
   @NotNull
   public static HashMap field_1283;
   // $FF: renamed from: c dev.nuker.pyro.fdQ
   public static fdQ field_1284;

   static {
      fdQ var0 = new fdQ();
      field_1284 = var0;
      field_1283 = new HashMap();
      ((Map)field_1283).put(EnumFacing.DOWN, 1);
      ((Map)field_1283).put(EnumFacing.WEST, 16);
      ((Map)field_1283).put(EnumFacing.NORTH, 4);
      ((Map)field_1283).put(EnumFacing.SOUTH, 8);
      ((Map)field_1283).put(EnumFacing.EAST, 32);
      ((Map)field_1283).put(EnumFacing.UP, 2);
   }

   // $FF: renamed from: c () java.util.HashMap
   @NotNull
   public HashMap method_1956() {
      return field_1283;
   }
}
