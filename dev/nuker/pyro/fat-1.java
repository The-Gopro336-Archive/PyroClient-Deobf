/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class fat extends far {
   // $FF: renamed from: c double
   public double field_1154 = far.method_1680();
   // $FF: renamed from: 0 double
   public double field_1155;
   // $FF: renamed from: c int
   public int field_1156 = 4;

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = far.c.player.posX - far.c.player.prevPosX;
         double var4 = far.c.player.posZ - far.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_1155 = var10;
      }
   }

   // $FF: renamed from: c () int
   public int method_1687() {
      return this.field_1156;
   }

   // $FF: renamed from: c (int) void
   public void method_1688(int var1) {
      this.field_1156 = var1;
   }

   // $FF: renamed from: c (double) double
   public double method_1689(double var1) {
      BigDecimal var3 = new BigDecimal(var1);
      var3 = var3.setScale(3, RoundingMode.HALF_UP);
      return var3.doubleValue();
   }

   public void meth0() {
      this.field_1154 = far.method_1680();
      this.field_1156 = 4;
      this.field_1155 = 0.0D;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !((Boolean)PyroStatic.field_2473.c.method_3034() ? false : var1.c())) {
         if (fec.method_1758() && !(far.c.player.fallDistance > 5.0F)) {
            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || !(PyroStatic.field_2470.method_396(((Number)PyroStatic.field_2470.field_265.c()).doubleValue()) > (double)0.0F)) {
               if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                  f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.088F);
               }

               if (this.method_1689(far.c.player.posY - (double)((int)far.c.player.posY)) == this.method_1689(0.138D)) {
                  EntityPlayerSP var10000 = far.c.player;
                  var10000.motionY -= 0.13D;
                  var1.method_3120(var1.method_3119() - 0.13D);
                  var10000 = far.c.player;
                  var10000.posY -= 0.13D;
               }

               if (this.field_1156 == 1 && (far.c.player.moveForward != 0.0F || far.c.player.moveStrafing != 0.0F)) {
                  this.field_1154 = 1.35D * far.method_1680() - 0.01D;
               } else {
                  double var2;
                  if (this.field_1156 == 2 && far.c.player.collidedVertically) {
                     var2 = 0.4D;
                     boolean var4 = false;
                     boolean var5 = false;
                     boolean var8 = false;
                     far.c.player.motionY = var2;
                     var1.method_3120(var2);
                     this.field_1154 *= 2.149D;
                  } else if (this.field_1156 == 3) {
                     var2 = 0.66D * (this.field_1155 - far.method_1680());
                     this.field_1154 = this.field_1155 - var2;
                  } else {
                     List var12 = far.c.world.getCollisionBoxes((Entity)far.c.player, far.c.player.getEntityBoundingBox().offset(0.0D, far.c.player.motionY, 0.0D));
                     if ((var12.size() > 0 || far.c.player.collidedVertically) && this.field_1156 > 0) {
                        this.field_1156 = 1;
                     }

                     this.field_1154 = this.field_1155 - this.field_1155 / 159.0D;
                  }
               }

               var1.0();
               this.field_1154 = Math.max(this.field_1154, far.method_1680());
               fec.method_1774(var1, this.field_1154);
               ++this.field_1156;
               int var13 = this.field_1156;
            }
         } else {
            f0b.field_2415.method_3669("speedhax");
         }
      }
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }
}
