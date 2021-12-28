/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  com.google.common.base.Predicates
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EntitySelectors
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fes;
import dev.nuker.pyro.few;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class fet
extends fdZ {
    public static Entity Method823(double d, fes fes2) {
        return fet.Method824(d, few.Method835().Field511.Method6942(), few.Method835().Field511.Method6936(), fes2);
    }

    public static Entity Method824(double d, float f, float f2, fes fes2) {
        EntityPlayerSP entityPlayerSP = fet.Field313.player;
        if (entityPlayerSP != null) {
            if (fet.Field313.world != null) {
                double d2 = d;
                Vec3d vec3d = entityPlayerSP.getPositionEyes(1.0f);
                float f3 = MathHelper.cos((float)(-f * ((float)Math.PI / 180) - (float)Math.PI));
                float f4 = MathHelper.sin((float)(-f * ((float)Math.PI / 180) - (float)Math.PI));
                float f5 = -MathHelper.cos((float)(-f2 * ((float)Math.PI / 180)));
                float f6 = MathHelper.sin((float)(-f2 * ((float)Math.PI / 180)));
                Vec3d vec3d2 = new Vec3d((double)(f4 * f5), (double)f6, (double)(f3 * f5));
                Vec3d vec3d3 = vec3d.addVector(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2);
                List list = fet.Field313.world.getEntitiesInAABBexcluding((Entity)entityPlayerSP, entityPlayerSP.getEntityBoundingBox().expand(vec3d2.x * d2, vec3d2.y * d2, vec3d2.z * d2).expand(1.0, 1.0, 1.0), Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, Entity::func_70067_L));
                Entity entity = null;
                for (Entity entity2 : list) {
                    if (!fes2.Method884(entity2)) continue;
                    float f7 = entity2.getCollisionBorderSize();
                    AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().expand((double)f7, (double)f7, (double)f7);
                    RayTraceResult rayTraceResult = axisAlignedBB.calculateIntercept(vec3d, vec3d3);
                    if (axisAlignedBB.contains(vec3d)) {
                        if (!(d2 >= 0.0)) continue;
                        entity = entity2;
                        d2 = 0.0;
                        continue;
                    }
                    if (rayTraceResult == null) continue;
                    double d3 = vec3d.distanceTo(rayTraceResult.hitVec);
                    if (!(d3 < d2) && d2 != 0.0) continue;
                    if (entity2 == entityPlayerSP.getRidingEntity() && !entityPlayerSP.canRiderInteract()) {
                        if (d2 != 0.0) continue;
                        entity = entity2;
                        continue;
                    }
                    entity = entity2;
                    d2 = d3;
                }
                return entity;
            }
        }
        return null;
    }
}

