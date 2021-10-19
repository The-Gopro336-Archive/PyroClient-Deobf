/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.entity.EntityPlayerSP;
import org.jetbrains.annotations.NotNull;

public class faB extends far {
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1199 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         if (this.field_1199.method_1980(100.0D)) {
            if (!fec.method_1758()) {
               far.c.player.motionX = 0.0D;
               far.c.player.motionZ = 0.0D;
               f0b.field_2415.method_3669("speedhax");
            } else {
               if (!far.c.player.movementInput.jump && far.c.player.onGround) {
                  if (far.c.player.ticksExisted % 2 == 0) {
                     var1.0();
                     if (feg.field_1216.method_1783(far.c.player.getPosition().up().up()).blocksMovement()) {
                        var1.method_3138(var1.method_3130() + 0.2D);
                     } else {
                        var1.method_3138(var1.method_3130() + 0.424999997D);
                     }
                  }

                  if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                     f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.3F);
                  }

                  EntityPlayerSP var10000 = far.c.player;
                  var10000.motionX *= far.c.player.ticksExisted % 2 != 0 ? 2.0D : 0.705D;
                  var10000 = far.c.player;
                  var10000.motionZ *= far.c.player.ticksExisted % 2 != 0 ? 2.0D : 0.705D;
               }

            }
         }
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   public void meth0() {
      this.field_1199.method_1979();
   }
}
