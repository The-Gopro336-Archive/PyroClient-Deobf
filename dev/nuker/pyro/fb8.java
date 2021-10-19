/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fb8 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fb8
   public static fb8 field_1496 = new fb8();

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2665(@NotNull f0w var1) {
      ClickGui.Companion.getSettings().method_3502((f00)var1.method_3318());
   }

   public void accept(Object var1) {
      this.method_2665((f0w)var1);
   }
}
