/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fb9 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fb9
   public static fb9 field_1482 = new fb9();

   public void accept(Object var1) {
      this.method_2656((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2656(@NotNull f0w var1) {
      ClickGui.Companion.getSettings().method_3498((f00)var1.method_3318());
   }
}
