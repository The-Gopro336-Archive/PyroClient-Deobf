/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Function;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Nullable;

public class f8I implements Function {
   // $FF: renamed from: c dev.nuker.pyro.f8J
   public f8J field_1843;

   public Object apply(Object var1) {
      return this.method_3018((Entity)var1);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) float
   public float method_3018(@Nullable Entity var1) {
      return f8J.method_617(this.field_1843).player.getDistance(var1);
   }

   public f8I(f8J var1) {
      this.field_1843 = var1;
      super();
   }
}
