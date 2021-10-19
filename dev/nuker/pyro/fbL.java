/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class fbL {
   // $FF: renamed from: c net.minecraft.client.entity.EntityPlayerSP
   public EntityPlayerSP field_1588;
   // $FF: renamed from: c net.minecraft.util.math.Vec3d
   public Vec3d field_1589;
   // $FF: renamed from: 0 net.minecraft.util.math.Vec3d
   public Vec3d field_1590;
   // $FF: renamed from: c float
   public float field_1591;
   // $FF: renamed from: 0 float
   public float field_1592;
   // $FF: renamed from: c net.minecraft.util.math.AxisAlignedBB
   public AxisAlignedBB field_1593;
   // $FF: renamed from: c boolean
   public boolean field_1594;
   // $FF: renamed from: c net.minecraft.util.math.RayTraceResult
   public RayTraceResult field_1595;
   // $FF: renamed from: c dev.nuker.pyro.fbM
   public fbM field_1596;
   // $FF: renamed from: c dev.nuker.pyro.fbN
   public fbN field_1597;

   // $FF: renamed from: c () boolean
   public boolean method_2800() {
      return this.field_1594;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.RayTraceResult) void
   public void method_2801(Vec3d var1, RayTraceResult var2) {
      Entity var3 = null;
      RayTraceResult var4 = null;
      double var5 = 0.0D;
      List var7 = Minecraft.getMinecraft().world.getEntitiesWithinAABBExcludingEntity(this.field_1588, this.field_1593.expand(this.field_1590.x, this.field_1590.y, this.field_1590.z).grow(1.0D, 1.0D, 1.0D));
      Iterator var8 = var7.iterator();

      while(true) {
         Entity var9;
         RayTraceResult var12;
         double var13;
         do {
            do {
               do {
                  if (!var8.hasNext()) {
                     if (var3 != null) {
                        this.field_1595 = new RayTraceResult(var3, var4.hitVec);
                     } else {
                        this.field_1595 = var2;
                     }

                     return;
                  }

                  var9 = (Entity)var8.next();
               } while(!var9.canBeCollidedWith());

               float var10 = var9.getCollisionBorderSize();
               AxisAlignedBB var11 = var9.getEntityBoundingBox().expand((double)var10, (double)var10, (double)var10);
               var12 = var11.calculateIntercept(this.field_1589, var1);
            } while(var12 == null);

            var13 = this.field_1589.distanceTo(var12.hitVec);
         } while(!(var13 < var5) && var5 != 0.0D);

         var3 = var9;
         var4 = var12;
         var5 = var13;
      }
   }

   // $FF: renamed from: 4 () float
   public float method_2802() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (double, double, double, float, float) void
   public void method_2803(double var1, double var3, double var5, float var7, float var8) {
      this.field_1589 = new Vec3d(var1, var3, var5);
      this.field_1591 = var7;
      this.field_1592 = var8;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_2804(Vec3d var1, float var2) {
      this.field_1590 = fdY.method_1820(var1, (float)var1.lengthVector());
      this.field_1590 = fdY.method_1821(this.field_1590, var2);
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fbL) net.minecraft.util.math.RayTraceResult
   public static RayTraceResult method_2805(fbL var0) {
      return var0.field_1595;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d) void
   public void method_2806(Vec3d var1) {
      this.field_1589 = new Vec3d(var1.x, var1.y, var1.z);
      double var2 = (this.field_1596 == fbM.field_1616 ? 0.5D : 0.25D) / 2.0D;
      this.field_1593 = new AxisAlignedBB(var1.x - var2, var1.y - var2, var1.z - var2, var1.x + var2, var1.y + var2, var1.z + var2);
   }

   // $FF: renamed from: 1 () void
   public void method_2807() {
      Vec3d var1 = this.field_1589.add(this.field_1590);
      RayTraceResult var2 = this.field_1588.getEntityWorld().rayTraceBlocks(this.field_1589, var1, this.field_1596 == fbM.field_1619, !this.method_2810(), false);
      if (var2 != null) {
         var1 = var2.hitVec;
      }

      this.method_2801(var1, var2);
      if (this.field_1595 != null) {
         this.field_1594 = true;
         this.method_2806(this.field_1595.hitVec);
      } else if (this.field_1589.y <= 0.0D) {
         this.field_1594 = true;
      } else {
         this.field_1589 = this.field_1589.add(this.field_1590);
         float var3 = 0.99F;
         if (this.field_1588.getEntityWorld().isMaterialInBB(this.field_1593, Material.WATER)) {
            var3 = this.field_1596 == fbM.field_1616 ? 0.6F : 0.8F;
         }

         if (this.field_1596 == fbM.field_1619) {
            var3 = 0.92F;
         }

         this.field_1590 = fdY.method_1821(this.field_1590, var3);
         this.field_1590 = this.field_1590.subtract(0.0D, (double)this.method_2811(), 0.0D);
         this.method_2806(this.field_1589);
      }
   }

   // $FF: renamed from: 0 () net.minecraft.util.math.RayTraceResult
   public RayTraceResult method_2808() {
      return this.field_1595;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fbL) net.minecraft.util.math.Vec3d
   public static Vec3d method_2809(fbL var0) {
      return var0.field_1589;
   }

   public fbL(fbN var1, EntityPlayerSP var2, fbM var3) {
      this.field_1597 = var1;
      super();
      this.field_1588 = var2;
      this.field_1596 = var3;
      this.method_2803(this.field_1588.posX, this.field_1588.posY + (double)this.field_1588.getEyeHeight(), this.field_1588.posZ, this.field_1588.rotationYaw, this.field_1588.rotationPitch);
      Vec3d var4 = new Vec3d((double)(MathHelper.cos(this.field_1591 / 180.0F * 3.1415927F) * 0.16F), 0.1D, (double)(MathHelper.sin(this.field_1591 / 180.0F * 3.1415927F) * 0.16F));
      this.field_1589 = this.field_1589.subtract(var4);
      this.method_2806(this.field_1589);
      this.field_1590 = new Vec3d((double)(-MathHelper.sin(this.field_1591 / 180.0F * 3.1415927F) * MathHelper.cos(this.field_1592 / 180.0F * 3.1415927F)), (double)(-MathHelper.sin(this.field_1592 / 180.0F * 3.1415927F)), (double)(MathHelper.cos(this.field_1591 / 180.0F * 3.1415927F) * MathHelper.cos(this.field_1592 / 180.0F * 3.1415927F)));
      this.method_2804(this.field_1590, this.method_2802());
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_2810() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 2 () float
   public float method_2811() {
      return this.field_1596.method_2819();
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fbL) boolean
   public static boolean method_2812(fbL var0) {
      return var0.field_1594;
   }
}
