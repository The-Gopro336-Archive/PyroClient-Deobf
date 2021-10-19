/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;

public class fax extends far {
   // $FF: renamed from: c double
   public double field_1166 = 1();
   // $FF: renamed from: 0 double
   public double field_1167 = 0.0D;
   // $FF: renamed from: c int
   public int field_1168 = 1;
   // $FF: renamed from: c boolean
   public boolean field_1169 = false;

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      if (var1.c() == f41.field_2120 && !(Boolean)PyroStatic.field_2473.c.method_3034() && !var1.c()) {
         var1.0();
         if (fec.method_1756().moveForward == 0.0F && fec.method_1756().moveStrafing == 0.0F) {
            this.field_1166 = 1();
         }

         if (c(fec.method_1756().posY - (double)((int)fec.method_1756().posY), 3) == c(0.4D, 3)) {
            var1.method_3120(fec.method_1756().motionY = 0.31D);
         } else if (c(fec.method_1756().posY - (double)((int)fec.method_1756().posY), 3) == c(0.71D, 3)) {
            var1.method_3120(fec.method_1756().motionY = 0.04D);
         } else if (c(fec.method_1756().posY - (double)((int)fec.method_1756().posY), 3) == c(0.75D, 3)) {
            var1.method_3120(fec.method_1756().motionY = -0.2D);
         }

         List var2 = c.world.getCollisionBoxes(c.player, c.player.getEntityBoundingBox().offset(0.0D, -0.56D, 0.0D));
         if (var2.size() > 0 && c(fec.method_1756().posY - (double)((int)fec.method_1756().posY), 3) == c(0.55D, 3)) {
            var1.method_3120(fec.method_1756().motionY = -0.14D);
         }

         if (this.field_1168 == 1 && fec.method_1756().collidedVertically && (fec.method_1756().moveForward != 0.0F || fec.method_1756().moveStrafing != 0.0F)) {
            this.field_1166 = 2.0D * 1() - 0.01D;
         } else if (this.field_1168 == 2 && fec.method_1756().collidedVertically && (fec.method_1756().moveForward != 0.0F || fec.method_1756().moveStrafing != 0.0F)) {
            var1.method_3120(fec.method_1756().motionY = 0.4D);
            this.field_1169 = !this.field_1169;
            this.field_1166 *= this.field_1169 ? 1.685D : 1.395D;
         } else if (this.field_1168 == 3) {
            double var3 = 0.66D * (this.field_1167 - 1());
            this.field_1166 = this.field_1167 - var3;
         } else {
            var2 = c.world.getCollisionBoxes(c.player, c.player.getEntityBoundingBox().offset(0.0D, c.player.motionY, 0.0D));
            if ((var2.size() > 0 || fec.method_1756().collidedVertically) && this.field_1168 > 0) {
               if (1.35D * 1() - 0.01D > this.field_1166) {
                  this.field_1168 = 0;
               } else {
                  this.field_1168 = fec.method_1756().moveForward == 0.0F && fec.method_1756().moveStrafing == 0.0F ? 0 : 1;
               }
            }

            this.field_1166 = this.field_1167 - this.field_1167 / 159.0D;
         }

         if (this.field_1168 > 8) {
            this.field_1166 = 1();
         }

         this.field_1166 = Math.max(this.field_1166, 1());
         if (this.field_1168 > 0) {
            fec.method_1774(var1, this.field_1166);
         }

         if (fec.method_1756().moveForward != 0.0F || fec.method_1756().moveStrafing != 0.0F) {
            ++this.field_1168;
         }

      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = c.player.posX - c.player.prevPosX;
         double var4 = c.player.posZ - c.player.prevPosZ;
         this.field_1167 = Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   public void meth0() {
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }
}
