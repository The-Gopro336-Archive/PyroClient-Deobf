/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import org.jetbrains.annotations.NotNull;

public class fbZ extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_699;

   public fbZ() {
      super("weather", "Weather", "Sets the weather you see");
      this.field_699 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)fbY.field_1625)));
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1034() {
      return this.field_699;
   }
}
