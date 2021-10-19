/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.util.math.BlockPos;

public class fd2 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fd4
   public fd4 field_969;

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_1407(Boolean var1) {
      fd4.method_1382(this.field_969, BlockPos.ORIGIN);
   }

   public fd2(fd4 var1) {
      this.field_969 = var1;
      super();
   }

   public void accept(Object var1) {
      this.method_1407((Boolean)var1);
   }
}
