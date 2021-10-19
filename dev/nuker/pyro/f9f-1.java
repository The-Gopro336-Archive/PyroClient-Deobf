/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class f9f implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f9h
   public f9h field_2230;

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_3343(@NotNull f0w var1) {
      f9h.method_287(this.field_2230);
   }

   public void accept(Object var1) {
      this.method_3343((f0w)var1);
   }

   public f9f(f9h var1) {
      this.field_2230 = var1;
      super();
   }
}
