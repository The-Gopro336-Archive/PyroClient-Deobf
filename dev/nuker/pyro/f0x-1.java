/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f0x implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f0z
   public f0z field_2446;

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3716(@NotNull f0w var1) {
      this.field_2446.getValue().method_3035();
   }

   public void accept(Object var1) {
      this.method_3716((f0w)var1);
   }

   public f0x(f0z var1) {
      this.field_2446 = var1;
      super();
   }
}
