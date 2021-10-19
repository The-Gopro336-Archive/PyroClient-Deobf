/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.client.CPacketPlayer;

public class f9C extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_338;

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_481(f4t var1) {
      this.5(String.valueOf(this.field_338.c()));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_482(f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketPlayer && this.c.player != null && !this.c.player.isElytraFlying() && this.c.player.fallDistance > 3.0F) {
         CPacketPlayerAccessor var2 = (CPacketPlayerAccessor)((CPacketPlayer)var1.c());
         if (((f9B)this.field_338.c()).equals(f9B.field_1887)) {
            this.c.player.onGround = true;
            this.c.player.capabilities.isFlying = true;
            this.c.player.capabilities.allowFlying = true;
            var2.setOnGround(false);
            this.c.player.velocityChanged = true;
            this.c.player.capabilities.isFlying = false;
            this.c.player.jump();
         }

         if (((f9B)this.field_338.c()).equals(f9B.field_1885)) {
            var2.setOnGround(true);
         }

         if (((f9B)this.field_338.c()).equals(f9B.field_1886)) {
            var2.setPosY(var2.getPosY() + 1.0D);
         }

         this.c.player.fallDistance = 0.0F;
      }

   }

   public f9C() {
      super("nofall", "NoFall", "Allows you to prevent fall damage in certain circumstances");
      this.field_338 = new f0o("mode", "Mode", (String)null, f9B.field_1885);
      this.register(this.field_338);
   }
}
