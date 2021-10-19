/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.ranges.RangesKt;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class faA extends far {
   // $FF: renamed from: c double
   public double field_1200 = far.method_1680();
   // $FF: renamed from: 0 double
   public double field_1201;
   // $FF: renamed from: 1 double
   public double field_1202 = 2.0D;
   // $FF: renamed from: c dev.nuker.pyro.fe8
   public fe8 field_1203 = new fe8();

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         if (this.field_1202 == 3.0D) {
            var1.0();
            if (feg.field_1216.method_1783(far.c.player.getPosition().up().up()).blocksMovement()) {
               var1.method_3138(var1.method_3130() + 0.2D);
            } else {
               var1.method_3138(var1.method_3130() + 0.4D);
            }
         }

         double var2 = far.c.player.posX - far.c.player.prevPosX;
         double var4 = far.c.player.posZ - far.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_1201 = var10;
      }
   }

   public void meth0() {
      this.field_1203.method_1979();
      this.field_1200 = far.method_1680();
      this.field_1202 = 2.0D;
      this.field_1201 = 0.0D;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120) {
         if (!var1.c()) {
            if (far.c.player.movementInput.jump) {
               this.field_1202 = 2.0D;
            } else {
               if (far.c.player.onGround || this.field_1202 == 3.0D) {
                  if (!far.c.player.collidedHorizontally && far.c.player.moveForward != 0.0F || far.c.player.moveStrafing != 0.0F) {
                     if (this.field_1202 == 2.0D) {
                        this.field_1200 *= 2.149D;
                        this.field_1202 = 3.0D;
                     } else if (this.field_1202 == 3.0D) {
                        this.field_1202 = 2.0D;
                        this.field_1200 = this.field_1201 - 0.66D * (this.field_1201 - far.method_1680());
                     } else {
                        List var2 = far.c.world.getCollisionBoxes((Entity)far.c.player, far.c.player.getEntityBoundingBox().offset(0.0D, far.c.player.motionY, 0.0D));
                        if (var2.size() > 0 || far.c.player.collidedVertically) {
                           this.field_1202 = 1.0D;
                        }
                     }
                  }

                  var1.0();
                  double var12 = RangesKt.coerceAtLeast(this.field_1200, far.method_1680());
                  boolean var4 = false;
                  boolean var5 = false;
                  boolean var8 = false;
                  this.field_1200 = var12;
                  fec.method_1774(var1, var12);
               }

            }
         }
      }
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }
}
