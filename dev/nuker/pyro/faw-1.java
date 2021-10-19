/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;

public class faw extends far {
   // $FF: renamed from: c double
   public double field_1144 = 1();
   // $FF: renamed from: 0 double
   public double field_1145;
   // $FF: renamed from: c int
   public int field_1146;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = c.player.posX - c.player.prevPosX;
         double var4 = c.player.posZ - c.player.prevPosZ;
         this.field_1145 = Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      if (var1.c() == f41.field_2120 && !(Boolean)PyroStatic.field_2473.c.method_3034() && !var1.c()) {
         if (c.player.moveForward == 0.0F && c.player.moveStrafing == 0.0F) {
            this.field_1144 = 1();
         }

         if (this.field_1146 == 1 && c.player.collidedVertically && (c.player.moveForward != 0.0F || c.player.moveStrafing != 0.0F)) {
            this.field_1144 = 0.25D + 1() - 0.01D;
         } else if (this.field_1146 == 2 && c.player.collidedVertically && (c.player.moveForward != 0.0F || c.player.moveStrafing != 0.0F)) {
            var1.0();
            var1.method_3120(c.player.motionY = 0.4D);
            this.field_1144 *= 2.149D;
         } else if (this.field_1146 == 3) {
            double var2 = 0.66D * (this.field_1145 - 1());
            this.field_1144 = this.field_1145 - var2;
         } else {
            List var4 = c.world.getCollisionBoxes(c.player, c.player.getEntityBoundingBox().offset(0.0D, c.player.motionY, 0.0D));
            if ((var4.size() > 0 || c.player.collidedVertically) && this.field_1146 > 0) {
               if (1.35D * 1() - 0.01D > this.field_1144) {
                  this.field_1146 = 0;
               } else {
                  this.field_1146 = c.player.moveForward == 0.0F && c.player.moveStrafing == 0.0F ? 0 : 1;
               }
            }

            this.field_1144 = this.field_1145 - this.field_1145 / 159.0D;
         }

         this.field_1144 = Math.max(this.field_1144, 1());
         if (this.field_1146 > 0) {
            var1.0();
            fec.method_1774(var1, this.field_1144);
         }

         if (c.player.moveForward != 0.0F || c.player.moveStrafing != 0.0F) {
            ++this.field_1146;
         }

      }
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   public void meth0() {
   }
}
