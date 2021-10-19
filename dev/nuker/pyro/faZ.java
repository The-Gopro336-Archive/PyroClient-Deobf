/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Comparator;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class faZ implements Comparator {
   // $FF: renamed from: c dev.nuker.pyro.fbc
   public fbc field_1485;

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.entity.Entity) int
   public int method_2658(@NotNull Entity var1, @NotNull Entity var2) {
      return Double.compare((double)var1.getDistance(fbc.method_996(this.field_1485).getRenderViewEntity()), (double)var2.getDistance(fbc.method_996(this.field_1485).getRenderViewEntity()));
   }

   public int compare(Object var1, Object var2) {
      return this.method_2658((Entity)var1, (Entity)var2);
   }

   public faZ(fbc var1) {
      this.field_1485 = var1;
      super();
   }
}
