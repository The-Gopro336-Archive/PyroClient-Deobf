/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9v implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9A
   public f9A field_2258;

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3367(@NotNull f0w var1) {
      this.field_2258.method_497();
      this.field_2258.5(((f9w)this.field_2258.method_494().c()).toString());
   }

   public void accept(Object var1) {
      this.method_3367((f0w)var1);
   }

   public f9v(f9A var1) {
      this.field_2258 = var1;
      super();
   }
}
