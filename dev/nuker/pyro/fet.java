/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class fet extends fdZ {
   // $FF: renamed from: c (double, dev.nuker.pyro.fes) net.minecraft.entity.Entity
   public static Entity method_1743(double var0, fes var2) {
      return method_1744(var0, few.method_1716().field_1208.meth3(), few.method_1716().field_1208.meth4(), var2);
   }

   // $FF: renamed from: c (double, float, float, dev.nuker.pyro.fes) net.minecraft.entity.Entity
   public static Entity method_1744(double var0, float var2, float var3, fes var4) {
      EntityPlayerSP var5 = c.player;
      if (var5 != null && c.world != null) {
         double var6 = var0;
         Vec3d var8 = var5.getPositionEyes(1.0F);
         float var9 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
         float var10 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
         float var11 = -MathHelper.cos(-var3 * 0.017453292F);
         float var12 = MathHelper.sin(-var3 * 0.017453292F);
         Vec3d var13 = new Vec3d((double)(var10 * var11), (double)var12, (double)(var9 * var11));
         Vec3d var14 = var8.addVector(var13.x * var0, var13.y * var0, var13.z * var0);
         List var15 = c.world.getEntitiesInAABBexcluding(var5, var5.getEntityBoundingBox().expand(var13.x * var0, var13.y * var0, var13.z * var0).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::func_70067_L));
         Entity var16 = null;
         Iterator var17 = var15.iterator();

         while(true) {
            while(true) {
               Entity var18;
               do {
                  if (!var17.hasNext()) {
                     return var16;
                  }

                  var18 = (Entity)var17.next();
               } while(!var4.method_1(var18));

               float var19 = var18.getCollisionBorderSize();
               AxisAlignedBB var20 = var18.getEntityBoundingBox().expand((double)var19, (double)var19, (double)var19);
               RayTraceResult var21 = var20.calculateIntercept(var8, var14);
               if (var20.contains(var8)) {
                  if (var6 >= 0.0D) {
                     var16 = var18;
                     var6 = 0.0D;
                  }
               } else if (var21 != null) {
                  double var22 = var8.distanceTo(var21.hitVec);
                  if (var22 < var6 || var6 == 0.0D) {
                     if (var18 == var5.getRidingEntity() && !var5.canRiderInteract()) {
                        if (var6 == 0.0D) {
                           var16 = var18;
                        }
                     } else {
                        var16 = var18;
                        var6 = var22;
                     }
                  }
               }
            }
         }
      } else {
         return null;
      }
   }
}
