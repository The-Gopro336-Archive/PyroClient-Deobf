/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f9F extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f4s) void
   @f0g
   @LauncherEventHide
   public void method_415(f4s var1) {
      if (!var1.c()) {
         if (this.c.player.onGround && !this.c.player.isSneaking() && !this.c.player.isElytraFlying()) {
            if (this.c.world.getCollisionBoxes(this.c.player, this.c.player.getEntityBoundingBox().offset(0.0D, -0.5D, 0.0D).expand(-0.001D, 0.0D, -0.001D)).isEmpty()) {
               this.c.player.jump();
            }
         }
      }
   }

   public f9F() {
      super("parkour", "Parkour", "Automatically jumps off the edge of the block");
   }
}
