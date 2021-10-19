/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class fau extends far {
   // $FF: renamed from: c double
   public double field_1151 = far.method_1680();
   // $FF: renamed from: 0 double
   public double field_1152;
   // $FF: renamed from: c int
   public int field_1153 = 4;

   // $FF: renamed from: c () int
   public int method_1685() {
      return this.field_1153;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !((Boolean)PyroStatic.field_2473.c.method_3034() ? false : var1.c())) {
         if (fec.method_1758() && !(far.c.player.fallDistance > 5.0F)) {
            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || !(PyroStatic.field_2470.method_396(((Number)PyroStatic.field_2470.field_265.c()).doubleValue()) > (double)0.0F)) {
               if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                  f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.033F);
               }

               if (this.field_1153 == 1 && (far.c.player.moveForward != 0.0F || far.c.player.moveStrafing != 0.0F)) {
                  this.field_1151 = 1.15D * far.method_1680() - 0.01D;
               } else {
                  double var2;
                  if (this.field_1153 == 2 && far.c.player.collidedVertically) {
                     var2 = 0.411111115D;
                     boolean var4 = false;
                     boolean var5 = false;
                     boolean var8 = false;
                     far.c.player.motionY = var2;
                     var1.method_3120(var2);
                     this.field_1151 *= 1.415D;
                  } else if (this.field_1153 == 3) {
                     var2 = 0.66D * (this.field_1152 - far.method_1680());
                     this.field_1151 = this.field_1152 - var2;
                  } else {
                     List var12 = far.c.world.getCollisionBoxes((Entity)far.c.player, far.c.player.getEntityBoundingBox().offset(0.0D, far.c.player.motionY, 0.0D));
                     if ((var12.size() > 0 || far.c.player.collidedVertically) && this.field_1153 > 0) {
                        this.field_1153 = 1;
                     }

                     this.field_1151 = this.field_1152 - this.field_1152 / 159.0D;
                  }
               }

               var1.0();
               this.field_1151 = Math.max(this.field_1151, far.method_1680());
               fec.method_1774(var1, this.field_1151);
               ++this.field_1153;
               int var10000 = this.field_1153;
            }
         } else {
            f0b.field_2415.method_3669("speedhax");
         }
      }
   }

   public void meth0() {
      this.field_1151 = far.method_1680();
      this.field_1153 = 4;
      this.field_1152 = 0.0D;
   }

   // $FF: renamed from: c (int) void
   public void method_1686(int var1) {
      this.field_1153 = var1;
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = far.c.player.posX - far.c.player.prevPosX;
         double var4 = far.c.player.posZ - far.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_1152 = var10;
      }
   }
}
