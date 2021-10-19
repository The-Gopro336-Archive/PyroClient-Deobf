/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

public enum fa2 {
   // $FF: renamed from: c dev.nuker.pyro.fa2
   field_1424,
   // $FF: renamed from: 0 dev.nuker.pyro.fa2
   field_1425,
   // $FF: renamed from: 1 dev.nuker.pyro.fa2
   field_1426,
   // $FF: renamed from: 2 dev.nuker.pyro.fa2
   field_1427,
   // $FF: renamed from: 3 dev.nuker.pyro.fa2
   field_1428,
   // $FF: renamed from: 4 dev.nuker.pyro.fa2
   field_1429,
   // $FF: renamed from: 5 dev.nuker.pyro.fa2
   field_1430,
   // $FF: renamed from: 6 dev.nuker.pyro.fa2
   field_1431,
   // $FF: renamed from: 7 dev.nuker.pyro.fa2
   field_1432,
   // $FF: renamed from: 8 dev.nuker.pyro.fa2
   field_1433;

   // $FF: renamed from: c dev.nuker.pyro.fa2[]
   public static fa2[] field_1434 = new fa2[]{field_1424 = new fa2("NORTH", 0, new BlockPos(0, 0, -1), 1.0D), field_1425 = new fa2("SOUTH", 1, new BlockPos(0, 0, 1), 1.0D), field_1426 = new fa2("WEST", 2, new BlockPos(-1, 0, 0), 1.0D), field_1427 = new fa2("EAST", 3, new BlockPos(1, 0, 0), 1.0D), field_1428 = new fa2("UP", 4, new BlockPos(0, 1, 0), 1.5D), field_1429 = new fa2("DOWN", 5, new BlockPos(0, -1, 0), 1.5D), field_1430 = new fa2("NORTHWEST", 6, new BlockPos(-1, 0, -1), 1.41421356237D), field_1431 = new fa2("NORTHEAST", 7, new BlockPos(1, 0, -1), 1.41421356237D), field_1432 = new fa2("SOUTHWEST", 8, new BlockPos(-1, 0, 1), 1.41421356237D), field_1433 = new fa2("SOUTHEAST", 9, new BlockPos(1, 0, 1), 1.41421356237D)};
   // $FF: renamed from: c net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos field_1435;
   // $FF: renamed from: c double
   public double field_1436;

   // $FF: renamed from: c () net.minecraft.util.math.BlockPos
   @NotNull
   public BlockPos method_2602() {
      return this.field_1435;
   }

   // $FF: renamed from: 0 () double
   public double method_2603() {
      return this.field_1436;
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fa2
   public static fa2 method_2604(String var0) {
      return (fa2)Enum.valueOf(fa2.class, var0);
   }

   public fa2(BlockPos var3, double var4) {
      this.field_1435 = var3;
      this.field_1436 = var4;
   }
}
