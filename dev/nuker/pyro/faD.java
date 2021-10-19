/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.ranges.RangesKt;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class faD extends far {
   // $FF: renamed from: c double
   public double field_1191 = far.method_1680();
   // $FF: renamed from: 0 double
   public double field_1192;
   // $FF: renamed from: c int
   public int field_1193;
   // $FF: renamed from: 0 int
   public int field_1194;

   // $FF: renamed from: c () int
   public int method_1696() {
      return this.field_1193;
   }

   public void meth0() {
      this.field_1191 = 0.2873D;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   public void method_1684(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = far.c.player.posX - far.c.player.prevPosX;
         double var4 = far.c.player.posZ - far.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_1192 = var10;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   public void method_1681(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !((Boolean)PyroStatic.field_2473.c.method_3034() ? false : var1.c())) {
         if (fec.method_1758() && !(far.c.player.fallDistance > 5.0F)) {
            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || !(PyroStatic.field_2470.method_396(((Number)PyroStatic.field_2470.field_265.c()).doubleValue()) > (double)0.0F)) {
               if ((Boolean)PyroStatic.field_2494.method_344().c()) {
                  f0b.field_2415.method_3667("speedhax", f07.field_2303, 1.088F);
               }

               if (this.field_1193 == 1) {
                  this.field_1191 = 1.35D * far.method_1680() - 0.01D;
               } else {
                  double var2;
                  if (this.field_1193 == 2 && far.c.player.collidedVertically) {
                     var1.0();
                     var2 = 0.399399995803833D;
                     boolean var4 = false;
                     boolean var5 = false;
                     boolean var8 = false;
                     far.c.player.motionY = var2;
                     var1.method_3120(var2);
                     this.field_1191 *= 2.149D;
                  } else if (this.field_1193 == 3) {
                     var2 = 0.66D * (this.field_1192 - far.method_1680());
                     this.field_1191 = this.field_1192 - var2;
                  } else {
                     List var12 = far.c.world.getCollisionBoxes((Entity)far.c.player, far.c.player.getEntityBoundingBox().offset(0.0D, far.c.player.motionY, 0.0D));
                     if ((var12.size() > 0 || far.c.player.collidedVertically) && this.field_1193 > 0) {
                        this.field_1193 = 1;
                     }

                     this.field_1191 = this.field_1192 - this.field_1192 / 159.0D;
                  }
               }

               this.field_1191 = RangesKt.coerceAtLeast(this.field_1191, far.method_1680());
               this.field_1191 = RangesKt.coerceAtMost(this.field_1191, this.field_1194 > 25 ? 0.449D : 0.433D);
               ++this.field_1194;
               int var10000 = this.field_1194;
               if (this.field_1194 > 50) {
                  this.field_1194 = 0;
               }

               var1.0();
               fec.method_1774(var1, this.field_1191);
               ++this.field_1193;
               var10000 = this.field_1193;
            }
         } else {
            f0b.field_2415.method_3669("speedhax");
         }
      }
   }

   // $FF: renamed from: c () void
   public void method_1682() {
   }

   // $FF: renamed from: c (int) void
   public void method_1697(int var1) {
      this.field_1193 = var1;
   }
}
