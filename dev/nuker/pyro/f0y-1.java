/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f0y implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f0z
   public f0z field_2448;

   public f0y(f0z var1) {
      this.field_2448 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3717(@NotNull f0w var1) {
      this.field_2448.getValue().method_3035();
   }

   public void accept(Object var1) {
      this.method_3717((f0w)var1);
   }
}
