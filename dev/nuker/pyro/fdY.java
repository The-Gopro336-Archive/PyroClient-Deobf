/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class fdY
extends fdZ {
    public static double Method510(double d, double d2, float f) {
        return d2 + (d - d2) * (double)Field313.getRenderPartialTicks();
    }

    public static Vec3d Method511(Vec3d vec3d, Vec3d vec3d2) {
        return new Vec3d(vec3d.x * vec3d2.x, vec3d.y * vec3d2.y, vec3d.z * vec3d2.z);
    }

    public static Vec3d Method364(Entity entity, float f) {
        return new Vec3d(fdY.Method510(entity.posX, entity.lastTickPosX, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2421(), fdY.Method510(entity.posY, entity.lastTickPosY, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2422(), fdY.Method510(entity.posZ, entity.lastTickPosZ, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2423());
    }

    public static Vec3d Method512(Vec3d vec3d, float f) {
        return new Vec3d(fdY.Method510(vec3d.x, vec3d.x, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2421(), fdY.Method510(vec3d.y, vec3d.y, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2422(), fdY.Method510(vec3d.z, vec3d.z, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2423());
    }

    public static Vec3d Method513(Vec3d vec3d, Vec3d vec3d2) {
        return new Vec3d(vec3d.x / vec3d2.x, vec3d.y / vec3d2.y, vec3d.z / vec3d2.z);
    }

    public static Vec3d Method514(Vec3d vec3d, float f) {
        return new Vec3d(fdY.Method510(vec3d.x, vec3d.x, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2421(), fdY.Method510(vec3d.y, vec3d.y - 0.021, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2422(), fdY.Method510(vec3d.z, vec3d.z, f) - ((RenderManagerAccessor)Field313.getRenderManager()).Method2423());
    }

    public static Vec3d Method515(Vec3d vec3d, float f) {
        return new Vec3d(vec3d.x / (double)f, vec3d.y / (double)f, vec3d.z / (double)f);
    }

    public static Vec3d Method516(Vec3d vec3d, float f) {
        return new Vec3d(vec3d.x * (double)f, vec3d.y * (double)f, vec3d.z * (double)f);
    }
}

