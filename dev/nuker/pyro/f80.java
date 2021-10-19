/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f80 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f81
   public f81 field_1774;

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_2999(@NotNull Boolean var1) {
      this.field_1774.method_721(true);
   }

   public void accept(Object var1) {
      this.method_2999((Boolean)var1);
   }

   public f80(f81 var1) {
      this.field_1774 = var1;
      super();
   }
}
