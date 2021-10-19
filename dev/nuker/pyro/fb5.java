/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fb5 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fb5
   public static fb5 field_1487 = new fb5();

   public void accept(Object var1) {
      this.method_2660((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2660(@NotNull f0w var1) {
      ClickGui.Companion.getSettings().method_3503((f00)var1.method_3318());
   }
}
