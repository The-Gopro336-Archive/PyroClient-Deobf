/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;

public class fav extends far {
   // $FF: renamed from: c double
   public double field_1147 = 1();
   // $FF: renamed from: 0 double
   public double field_1148;
   // $FF: renamed from: c int
   public int field_1149;
   // $FF: renamed from: 0 int
   public int field_1150 = 0;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = c.player.posX - c.player.prevPosX;
         double var4 = c.player.posZ - c.player.prevPosZ;
         this.field_1148 = Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      if (var1.c() == f41.field_2120 && !(Boolean)PyroStatic.field_2473.c.method_3034() && !var1.c()) {
         if (!fec.method_1758()) {
            this.field_1150 = 0;
            f0b.field_2415.method_3669("speedhax");
            f0b.field_2415.method_3669("speeedupp");
         } else if (!(c.player.fallDistance > 5.0F)) {
            ++this.field_1150;
            if ((Boolean)PyroStatic.field_2494.method_344().c()) {
               f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.088F);
               if (this.field_1150 >= 50) {
                  f0b.field_2415.method_3669("speedhax");
                  f0b.field_2415.method_3667("speeedupp", f07.field_2303, 1.2F);
                  if (this.field_1150 > 52) {
                     this.field_1150 = 0;
                  }
               } else {
                  f0b.field_2415.method_3669("speeedupp");
               }
            }

            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || !(PyroStatic.field_2470.method_396((Double)PyroStatic.field_2470.field_265.c()) > 0.0D)) {
               if (this.field_1149 == 1 && (fec.method_1756().moveForward != 0.0F || fec.method_1756().moveStrafing != 0.0F)) {
                  this.field_1147 = 1.35D * 1() - 0.01D;
               } else if (this.field_1149 == 2 && c.player.collidedVertically && (c.player.moveForward != 0.0F || c.player.moveStrafing != 0.0F)) {
                  var1.0();
                  var1.method_3120(c.player.motionY = 0.399399995803833D);
                  this.field_1147 *= 3.0D;
               } else if (this.field_1149 == 3) {
                  double var2 = 0.66D * (this.field_1148 - 1());
                  this.field_1147 = this.field_1148 - var2;
               } else {
                  List var4 = c.world.getCollisionBoxes(c.player, c.player.getEntityBoundingBox().offset(0.0D, c.player.motionY, 0.0D));
                  if ((var4.size() > 0 || fec.method_1756().collidedVertically) && this.field_1149 > 0) {
                     this.field_1149 = fec.method_1756().moveForward == 0.0F && fec.method_1756().moveStrafing == 0.0F ? 0 : 1;
                  }

                  this.field_1147 = this.field_1148 - this.field_1148 / 159.0D;
               }

               this.field_1147 = Math.max(this.field_1147, 1());
               this.field_1147 = Math.min(this.field_1147, 0.551D);
               var1.0();
               fec.method_1774(var1, this.field_1147);
               if (c.player.moveForward != 0.0F || c.player.moveStrafing != 0.0F) {
                  ++this.field_1149;
               }

            }
         }
      }
   }

   public void meth0() {
      this.field_1150 = 0;
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }
}
