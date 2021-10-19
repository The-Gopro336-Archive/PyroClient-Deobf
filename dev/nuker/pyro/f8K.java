/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f8K extends Module {
   public f8K() {
      super("autowalk", "AutoWalk", "Holds down the forward key", true);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4A) void
   @f0g(2)
   @LauncherEventHide
   public void method_551(f4A var1) {
      this.c.player.movementInput.moveForward = 1.0F;
      var1.0();
   }
}
