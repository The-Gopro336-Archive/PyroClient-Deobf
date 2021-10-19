/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9N implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9T
   public f9T field_1937;

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3057(@NotNull f0w var1) {
      this.field_1937.method_337();
      this.field_1937.method_335();
   }

   public f9N(f9T var1) {
      this.field_1937 = var1;
      super();
   }

   public void accept(Object var1) {
      this.method_3057((f0w)var1);
   }
}
