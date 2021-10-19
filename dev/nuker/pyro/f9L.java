/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9L implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9T
   public f9T field_1934;

   public f9L(f9T var1) {
      this.field_1934 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3055(@NotNull f0w var1) {
      this.field_1934.method_337();
      this.field_1934.method_335();
   }

   public void accept(Object var1) {
      this.method_3055((f0w)var1);
   }
}
