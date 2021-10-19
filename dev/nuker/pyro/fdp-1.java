/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fdp implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdF
   public fdF field_1323;

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_1992(@NotNull f0w var1) {
      if ((Boolean)var1.method_3318()) {
         this.field_1323.method_1295().c(false);
         this.field_1323.method_1291().c(false);
      }

   }

   public void accept(Object var1) {
      this.method_1992((f0w)var1);
   }

   public fdp(fdF var1) {
      this.field_1323 = var1;
      super();
   }
}
