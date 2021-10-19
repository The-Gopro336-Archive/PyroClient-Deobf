/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fdG implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fdH
   public fdH field_1231;

   public void accept(Object var1) {
      this.method_1884((f0w)var1);
   }

   public fdG(fdH var1) {
      this.field_1231 = var1;
      super();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_1884(@NotNull f0w var1) {
      if ((Boolean)this.field_1231.c.method_3034()) {
         f0b.field_2415.method_3669("timer");
         f0b.field_2415.method_3667("timer", f07.field_2303, (float)((Number)this.field_1231.method_1284().c()).doubleValue());
      }

   }
}
