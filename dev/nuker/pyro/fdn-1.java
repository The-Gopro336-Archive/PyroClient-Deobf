/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fdn implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_1313;

   public void accept(Object var1) {
      this.method_1987((f0w)var1);
   }

   public fdn(fdF var1) {
      this.field_1313 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_1987(@NotNull f0w var1) {
      if ((Boolean)var1.method_3318()) {
         this.field_1313.method_1295().c(false);
         this.field_1313.method_1304().c(false);
      }

   }
}
