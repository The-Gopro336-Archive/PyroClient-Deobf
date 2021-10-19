/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fbb implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fbb
   public static fbb field_1635 = new fbb();

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2825(@NotNull f0w var1) {
      ClickGui.Companion.getSettings();
      f0H.field_2337 = ((Number)var1.method_3318()).doubleValue();
   }

   public void accept(Object var1) {
      this.method_2825((f0w)var1);
   }
}
