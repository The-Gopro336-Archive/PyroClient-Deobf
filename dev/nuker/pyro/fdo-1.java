/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fdo implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_1322;

   public fdo(fdF var1) {
      this.field_1322 = var1;
      super();
   }

   public void accept(Object var1) {
      this.method_1991((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_1991(@NotNull f0w var1) {
      if ((Boolean)var1.method_3318()) {
         this.field_1322.method_1291().c(false);
         this.field_1322.method_1304().c(false);
      }

   }
}
