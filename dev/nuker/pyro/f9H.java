/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f9H extends Module {
   public f9H() {
      super("safewalk", "SafeWalk", "Allows you to walk on side of blocks, as you were sneaking");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_460(f4p var1) {
      if (this.c.player.onGround) {
         if (var1.c() == f41.field_2120 && !var1.c()) {
            double var2 = var1.method_3128();
            double var4 = var1.method_3119();
            double var6 = var1.method_3123();
            double var8 = (double)this.c.player.stepHeight;
            double var16 = 0.05D;

            while(var2 != 0.0D && this.c.world.getCollisionBoxes(this.c.player, this.c.player.getEntityBoundingBox().offset(var2, -var8, 0.0D)).isEmpty()) {
               if (var2 < 0.05D && var2 >= -0.05D) {
                  var2 = 0.0D;
               } else if (var2 > 0.0D) {
                  var2 -= 0.05D;
               } else {
                  var2 += 0.05D;
               }
            }

            while(var6 != 0.0D && this.c.world.getCollisionBoxes(this.c.player, this.c.player.getEntityBoundingBox().offset(0.0D, -var8, var6)).isEmpty()) {
               if (var6 < 0.05D && var6 >= -0.05D) {
                  var6 = 0.0D;
               } else if (var6 > 0.0D) {
                  var6 -= 0.05D;
               } else {
                  var6 += 0.05D;
               }
            }

            while(var2 != 0.0D && var6 != 0.0D && this.c.world.getCollisionBoxes(this.c.player, this.c.player.getEntityBoundingBox().offset(var2, -var8, var6)).isEmpty()) {
               if (var2 < 0.05D && var2 >= -0.05D) {
                  var2 = 0.0D;
               } else if (var2 > 0.0D) {
                  var2 -= 0.05D;
               } else {
                  var2 += 0.05D;
               }

               if (var6 < 0.05D && var6 >= -0.05D) {
                  var6 = 0.0D;
               } else if (var6 > 0.0D) {
                  var6 -= 0.05D;
               } else {
                  var6 += 0.05D;
               }
            }

            var1.0();
            var1.method_3125(var2);
            var1.method_3120(var4);
            var1.method_3127(var6);
         }
      }
   }
}
