/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class faz extends far {
   // $FF: renamed from: c double
   public double field_1157 = far.method_1680();
   // $FF: renamed from: 0 double
   public double field_1158;
   // $FF: renamed from: c int
   public int field_1159 = 4;
   // $FF: renamed from: 0 int
   public int field_1160;
   // $FF: renamed from: c boolean
   public boolean field_1161;

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !((Boolean)PyroStatic.field_2473.c.method_3034() ? true : var1.c())) {
         if (fec.method_1758() && !(far.c.player.fallDistance > 5.0F)) {
            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || !(PyroStatic.field_2470.method_396(((Number)PyroStatic.field_2470.field_265.c()).doubleValue()) > (double)0.0F)) {
               if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                  f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.088F);
               }

               double var2;
               if (far.c.player.collidedHorizontally) {
                  int var10001;
                  if (far.c.player.onGround) {
                     var2 = PyroStatic.field_2470.method_396(1.0D);
                     if (var2 == 1.0D) {
                        var10001 = this.field_1160++;
                     }
                  }

                  if (this.field_1160 > 0) {
                     switch(this.field_1160) {
                     case 1:
                        var1.0();
                        var1.method_3120(0.41999998688698D);
                        var10001 = this.field_1160++;
                        return;
                     case 2:
                        var1.0();
                        var1.method_3120(0.33319999363422D);
                        var10001 = this.field_1160++;
                        return;
                     case 3:
                        float var13 = (float)fec.method_1749();
                        var1.method_3120(0.24813599859094704D);
                        var1.method_3125((double)(-MathHelper.sin(var13)) * 0.2D);
                        var1.method_3127((double)MathHelper.cos(var13) * 0.2D);
                        this.field_1160 = 0;
                        far.c.player.motionY = 0.0D;
                        var1.0();
                        return;
                     default:
                        return;
                     }
                  }
               }

               this.field_1160 = 0;
               if (this.field_1159 == 1 && (far.c.player.moveForward != 0.0F || far.c.player.moveStrafing != 0.0F)) {
                  this.field_1157 = 1.35D * far.method_1680() - 0.01D;
               } else if (this.field_1159 == 2 && far.c.player.collidedVertically) {
                  var2 = 0.4D;
                  boolean var4 = false;
                  boolean var5 = false;
                  boolean var8 = false;
                  far.c.player.motionY = var2;
                  var1.method_3120(var2);
                  this.field_1161 = !this.field_1161;
                  this.field_1157 *= this.field_1161 ? 1.6835D : 1.395D;
               } else if (this.field_1159 == 3) {
                  var2 = 0.66D * (this.field_1158 - far.method_1680());
                  this.field_1157 = this.field_1158 - var2;
               } else {
                  List var12 = far.c.world.getCollisionBoxes((Entity)far.c.player, far.c.player.getEntityBoundingBox().offset(0.0D, far.c.player.motionY, 0.0D));
                  if ((var12.size() > 0 || far.c.player.collidedVertically) && this.field_1159 > 0) {
                     this.field_1159 = 1;
                  }

                  this.field_1157 = this.field_1158 - this.field_1158 / 159.0D;
               }

               var1.0();
               this.field_1157 = Math.max(this.field_1157, far.method_1680());
               fec.method_1774(var1, this.field_1157);
               ++this.field_1159;
               int var10000 = this.field_1159;
            }
         } else {
            f0b.field_2415.method_3669("speedhax");
         }
      }
   }

   // $FF: renamed from: 0 () int
   public int method_1690() {
      return this.field_1159;
   }

   // $FF: renamed from: 0 (int) void
   public void method_1691(int var1) {
      this.field_1159 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = far.c.player.posX - far.c.player.prevPosX;
         double var4 = far.c.player.posZ - far.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_1158 = var10;
      }
   }

   // $FF: renamed from: c () int
   public int method_1692() {
      return this.field_1160;
   }

   public void meth0() {
      this.field_1157 = far.method_1680();
      this.field_1159 = 4;
      this.field_1158 = 0.0D;
      this.field_1160 = 0;
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   // $FF: renamed from: c (int) void
   public void method_1693(int var1) {
      this.field_1160 = var1;
   }
}
