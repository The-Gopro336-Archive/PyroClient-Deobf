/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f4p;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.NotNull;

public class f68
extends Module {
    @NotNull
    public BooleanSetting Field4193 = (BooleanSetting)this.Method7264(new BooleanSetting("doubleHoles", "Doubles", "Allow anchoring in double holes", true));
    @NotNull
    public BooleanSetting Field4194 = (BooleanSetting)this.Method7264(new BooleanSetting("disable_complete", "Disable On Complete", "Disables anchor aftor sucessfully anchoring once", false));
    @NotNull
    public BooleanSetting Field4195 = (BooleanSetting)this.Method7264(new BooleanSetting("pitch_mode", "Pitch Mode", "Only enable when looking below X pitch", true));
    @NotNull
    public IntegerSetting Field4196 = (IntegerSetting)this.Method7264(new IntegerSetting("pitch", "Pitch", "Pitch for pitch mode", 70, -90, 90, 0, 64, null));
    public boolean Field4197;

    @NotNull
    public BooleanSetting Method282() {
        return this.Field4193;
    }

    @NotNull
    public BooleanSetting Method215() {
        return this.Field4194;
    }

    public boolean Method2622() {
        return this.Field4197;
    }

    public f68() {
        super("anchor", "Anchor", "Pulls you to the bottom of a hole you go over");
    }

    @NotNull
    public BooleanSetting Method284() {
        return this.Field4195;
    }

    @f0g(value=1)
    @LauncherEventHide
    public void Method559(@NotNull f4p f4p2) {
        block19: {
            block20: {
                block16: {
                    block15: {
                        this.Field4197 = false;
                        if (!((Boolean)this.Field4195.Method7979()).booleanValue()) break block15;
                        if (!(this.Field5233.player.rotationPitch >= ((Number)this.Field4196.Method7979()).floatValue())) break block16;
                    }
                    BlockPos blockPos = new BlockPos(this.Field5233.player.getPositionVector());
                    if (PyroStatic.Field6408.Method4844((Entity)this.Field5233.player)) break block16;
                    int n = 5;
                    for (int i = 0; i <= n; ++i) {
                        block18: {
                            Vec3d vec3d;
                            block17: {
                                if (this.Field5233.world.isAirBlock(blockPos.down(i + 1))) continue;
                                int n2 = PyroStatic.Field6453.Method2745(blockPos.down(i), (Boolean)this.Field4193.Method7979());
                                if (n2 == 0) break;
                                vec3d = new Vec3d((Vec3i)blockPos);
                                if (n2 > 2) {
                                    EnumFacing enumFacing = EnumFacing.VALUES[n2 - 3];
                                    boolean bl = true;
                                    int n3 = 0;
                                    int n4 = i;
                                    if (n3 <= n4) {
                                        while (true) {
                                            if (!this.Field5233.world.isAirBlock(blockPos.offset(enumFacing).down(i - n3))) {
                                                bl = false;
                                            }
                                            if (n3 == n4) break;
                                            ++n3;
                                        }
                                    }
                                    if (bl) {
                                        vec3d = vec3d.addVector((double)enumFacing.getFrontOffsetX() / 2.0, (double)enumFacing.getFrontOffsetY() / 2.0, (double)enumFacing.getFrontOffsetZ() / 2.0);
                                    }
                                }
                                this.Field5233.player.motionX = 0.0;
                                this.Field5233.player.motionZ = 0.0;
                                this.Field5233.player.movementInput.moveForward = 0.0f;
                                this.Field5233.player.movementInput.moveStrafe = 0.0f;
                                if (this.Field5233.player.motionY > -0.1) {
                                    this.Field5233.player.motionY = -0.1;
                                }
                                if (this.Field5233.player.getEntityBoundingBox().minX <= vec3d.x) break block17;
                                if (this.Field5233.player.getEntityBoundingBox().minZ <= vec3d.z) break block17;
                                if (this.Field5233.player.getEntityBoundingBox().maxX >= vec3d.x + 1.0) break block17;
                                EntityPlayerSP entityPlayerSP = this.Field5233.player;
                                if (!(entityPlayerSP.getEntityBoundingBox().maxZ >= vec3d.z + 1.0)) break block18;
                            }
                            double d = vec3d.x + 0.5 - this.Field5233.player.posX;
                            double d2 = vec3d.z + 0.5 - this.Field5233.player.posZ;
                            f4p2.Method5837(d / (double)2);
                            f4p2.Method5820(d2 / (double)2);
                        }
                        this.Field4197 = true;
                        f4p2.Method7948();
                        break;
                    }
                }
                if (!this.Field5233.player.onGround) break block19;
                if (!PyroStatic.Field6408.Method4844((Entity)this.Field5233.player)) break block19;
                if (!((Boolean)this.Field4195.Method7979()).booleanValue()) break block20;
                if (!(this.Field5233.player.rotationPitch >= ((Number)this.Field4196.Method7979()).floatValue())) break block19;
            }
            this.Field4197 = true;
        }
    }

    @NotNull
    public IntegerSetting Method2387() {
        return this.Field4196;
    }

    public void Method557(boolean bl) {
        this.Field4197 = bl;
    }

    @f0g(value=1)
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        this.Field4197 = false;
        if (this.Field5233.player.onGround) {
            if (PyroStatic.Field6408.Method4844((Entity)this.Field5233.player)) {
                if (!((Boolean)this.Field4195.Method7979()).booleanValue() || this.Field5233.player.rotationPitch >= ((Number)this.Field4196.Method7979()).floatValue()) {
                    this.Field4197 = true;
                }
                if (((Boolean)this.Field4194.Method7979()).booleanValue()) {
                    this.Field5236.Method5266(false);
                }
            }
        }
    }
}

