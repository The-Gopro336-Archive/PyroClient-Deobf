/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.util.EnumHand;

public class f7S extends Module {
   // $FF: renamed from: c float
   public float field_459 = 0.0F;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(-30)
   @LauncherEventHide
   public void method_680(f4u var1) {
      if (!var1.c()) {
         var1.0();
         var1.method_3139(this.field_459 += 20.0F);
         var1.method_3140((float)(Math.random() * 90.0D));
         if (this.field_459 > 360.0F) {
            this.field_459 = 0.0F;
         }

         if (this.c.player.ticksExisted % 2 == 0) {
            this.c.player.swingArm(EnumHand.MAIN_HAND);
         } else {
            this.c.player.swingArm(EnumHand.OFF_HAND);
         }

      }
   }

   public f7S() {
      super("antiaim", "AntiAim", "Spinbot");
   }
}
