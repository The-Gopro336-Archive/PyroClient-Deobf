/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9M implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9T
   public f9T field_1935;

   public f9M(f9T var1) {
      this.field_1935 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3056(@NotNull f0w var1) {
      this.field_1935.method_337();
      this.field_1935.method_335();
   }

   public void accept(Object var1) {
      this.method_3056((f0w)var1);
   }
}
