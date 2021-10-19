/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.profiler.Profiler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;

// $FF: renamed from: dev.nuker.pyro.fh
public class class_56 extends class_55 {
   public BlockPos getSpawnPoint() {
      return new BlockPos(0, 64, 0);
   }

   public class_56(WorldSettings var1, class_33 var2) {
      super(var2, var1, 0, EnumDifficulty.HARD, new Profiler());
      this.provider.setWorld(this);
   }
}
