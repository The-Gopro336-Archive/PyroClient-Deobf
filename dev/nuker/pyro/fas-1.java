/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

public class fas extends far {
   public void meth0() {
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120 && fec.method_1758() && !far.c.player.isSneaking()) {
         far.c.player.cameraPitch = 0.0F;
         if (far.c.player.onGround) {
            far.c.player.motionY = 0.3425D;
            EntityPlayerSP var10000 = far.c.player;
            var10000.motionX *= 1.5893D;
            var10000 = far.c.player;
            var10000.motionZ *= 1.5893D;
         } else {
            far.c.player.motionY = -0.19D;
         }
      }

   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }
}
