/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.util.math.BlockPos;

public class fd3 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fd4
   public fd4 field_85;

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_113(Boolean var1) {
      fd4.method_1382(this.field_85, BlockPos.ORIGIN);
   }

   public void accept(Object var1) {
      this.method_113((Boolean)var1);
   }

   public fd3(fd4 var1) {
      this.field_85 = var1;
      super();
   }
}
