/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f84 extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_679(f4u var1) {
      if (var1.c() == f41.field_2120 && (double)this.c.player.getHealth() <= 0.0D) {
         this.c.player.respawnPlayer();
      }

   }

   public f84() {
      super("autorespawn", "AutoRespawn", (String)null);
   }
}
