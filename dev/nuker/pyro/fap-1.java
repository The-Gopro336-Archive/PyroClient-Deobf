/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class fap extends far {
   // $FF: renamed from: c double
   public double field_1181;
   // $FF: renamed from: 0 double
   public double field_1182;
   // $FF: renamed from: c int
   public int field_1183 = 0;

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   public void meth0() {
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(f4p var1) {
      if (!var1.c() && var1.c() == f41.field_2120) {
         if (fec.method_1756().collidedHorizontally || fec.method_1756().moveForward == 0.0F && fec.method_1756().moveStrafing == 0.0F) {
            this.field_1183 = 0;
            this.field_1181 = 0.0D;
            this.field_1182 = 0.0D;
            var1.0();
            var1.method_3125(0.0D);
            var1.method_3127(0.0D);
            if (fec.method_1756().collidedHorizontally) {
               var1.method_3120(fec.method_1756().motionY = 0.415D);
            }

            f0b.field_2415.method_3669("longjump");
         } else {
            if ((Boolean)PyroStatic.field_2519.method_486().c()) {
               f0b.field_2415.method_3667("longjump", f07.field_2303, 2.5F);
            }

            if (this.field_1183 == 1 && fec.method_1756().collidedVertically) {
               this.field_1181 = 1.0D + far.method_1680() - 0.05D;
            } else if (this.field_1183 == 2 && fec.method_1756().collidedVertically) {
               var1.method_3120(fec.method_1756().motionY = 0.415D);
               this.field_1181 *= (Double)PyroStatic.field_2519.method_490().c();
            } else if (this.field_1183 == 3) {
               double var2 = 0.66D * (this.field_1182 - far.method_1680());
               this.field_1181 = this.field_1182 - var2;
            } else {
               this.field_1181 = this.field_1182 - this.field_1182 / 159.0D;
               if (fec.method_1756().collidedVertically && this.field_1183 > 3) {
                  this.field_1183 = 1;
               }
            }

            var1.0();
            fec.method_1774(var1, this.field_1181 = Math.max(this.field_1181, 1()));
            ++this.field_1183;
         }
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = c.player.posX - c.player.prevPosX;
         double var4 = c.player.posZ - c.player.prevPosZ;
         this.field_1182 = Math.sqrt(var2 * var2 + var4 * var4);
         var1.0();
         var1.method_3135(true);
      }
   }
}
