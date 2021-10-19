/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.gui.ClickGui;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

public class fb7 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.fb7
   public static fb7 field_1493 = new fb7();

   public void accept(Object var1) {
      this.method_2664((f0w)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0w) void
   public void method_2664(@NotNull f0w var1) {
      ClickGui.Companion.getSettings().method_3495((f00)var1.method_3318());
   }
}
