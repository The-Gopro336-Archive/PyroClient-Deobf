/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.feh;
import dev.nuker.pyro.fer;
import dev.nuker.pyro.few;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class fei
extends fdZ {
    public Rotation Field483 = null;
    public feh Field484 = null;

    public boolean Method800(BlockPos blockPos, boolean bl, boolean bl2) {
        if (!feg.Method700(blockPos)) {
            return false;
        }
        Vec3d vec3d = new Vec3d(fei.Field313.player.posX, fei.Field313.player.getEntityBoundingBox().minY + (double)fei.Field313.player.getEyeHeight(), fei.Field313.player.posZ);
        fer fer2 = null;
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!feg.Method691(blockPos2)) continue;
            Vec3d vec3d2 = new Vec3d(enumFacing.getDirectionVec());
            for (double d = 0.1; d < 0.9; d += 0.1) {
                for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                    for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                        Vec3d vec3d3 = new Vec3d((Vec3i)blockPos).addVector(d, d2, d3);
                        double d4 = vec3d.squareDistanceTo(vec3d3);
                        Vec3d vec3d4 = vec3d3.add(new Vec3d(vec3d2.x * 0.5, vec3d2.y * 0.5, vec3d2.z * 0.5));
                        if (bl) {
                            if (vec3d.squareDistanceTo(vec3d4) > 18.0 || d4 > vec3d.squareDistanceTo(vec3d3.add(vec3d2)) || fei.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, true, false) != null) continue;
                        }
                        double d5 = vec3d4.x - vec3d.x;
                        double d6 = vec3d4.y - vec3d.y;
                        double d7 = vec3d4.z - vec3d.z;
                        double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
                        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d7, d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d6, d8))))));
                        Vec3d vec3d5 = few.Method835().Method834(rotation);
                        Vec3d vec3d6 = vec3d.addVector(vec3d5.x * 4.0, vec3d5.y * 4.0, vec3d5.z * 4.0);
                        if (!bl2) {
                            RayTraceResult rayTraceResult = fei.Field313.world.rayTraceBlocks(vec3d, vec3d6, false, false, true);
                            if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                            if (!rayTraceResult.getBlockPos().equals((Object)blockPos2)) continue;
                        }
                        if (fer2 != null && !(few.Method835().Method853(rotation) < few.Method835().Method853(fer2.Method880()))) continue;
                        fer2 = new fer(new feh(blockPos2, enumFacing.getOpposite(), vec3d4), rotation);
                    }
                }
            }
        }
        if (fer2 == null) {
            return false;
        }
        this.Field483 = fer2.Method880();
        this.Field484 = fer2.Method881();
        return true;
    }

    public void Method801(BlockPos blockPos, boolean bl, boolean bl2) {
        if (!feg.Method700(blockPos) || this.Method800(blockPos, !bl2, bl2)) {
            return;
        }
        if (!bl) {
            return;
        }
        if (feg.Method691(blockPos)) {
            return;
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                BlockPos blockPos2 = blockPos.add(i, 0, j);
                boolean bl3 = !bl2;
                if (!this.Method800(blockPos2, bl3, bl2)) continue;
                return;
            }
        }
    }
}

