/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockBed
 *  net.minecraft.block.BlockButton
 *  net.minecraft.block.BlockCake
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.block.BlockFenceGate
 *  net.minecraft.block.BlockNote
 *  net.minecraft.block.BlockRedstoneDiode
 *  net.minecraft.block.BlockTrapDoor
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f43;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.fet;
import dev.nuker.pyro.fex;
import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class few
extends fdZ {
    public Random Field508 = new Random();
    public int Field509;
    public Rotation Field510;
    public Rotation Field511 = new Rotation(0.0f, 0.0f);
    public boolean Field512 = false;
    public double Field513 = this.Field508.nextDouble();
    public double Field514 = this.Field508.nextDouble();
    public double Field515 = this.Field508.nextDouble();

    public static float Method827(float f, float f2) {
        float f3 = Math.abs(f - f2) % 360.0f;
        if (f3 > 180.0f) {
            f3 = 360.0f - f3;
        }
        return f3;
    }

    public fex Method828(BlockPos blockPos) {
        if (blockPos == null) {
            return null;
        }
        fex fex2 = null;
        double d = 0.1;
        double d2 = 0.1;
        double d3 = 0.1;
        for (d = 0.1; d < 0.9; d += 0.1) {
            for (d2 = 0.1; d2 < 0.9; d2 += 0.1) {
                for (d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                    Vec3d vec3d = new Vec3d(few.Field313.player.posX, few.Field313.player.getEntityBoundingBox().minY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ);
                    Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).addVector(d, d2, d3);
                    double d4 = vec3d.distanceTo(vec3d2);
                    double d5 = vec3d2.x - vec3d.x;
                    double d6 = vec3d2.y - vec3d.y;
                    double d7 = vec3d2.z - vec3d.z;
                    double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
                    Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d7, (double)d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d6, (double)d8))))));
                    Vec3d vec3d3 = this.Method834(rotation);
                    Vec3d vec3d4 = vec3d.addVector(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
                    RayTraceResult rayTraceResult = few.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, false, true);
                    if (rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK) continue;
                    fex fex3 = new fex(vec3d2, rotation, rayTraceResult.sideHit);
                    if (fex2 != null && !(this.Method853(fex3.Method891()) < this.Method853(fex2.Method891()))) continue;
                    fex2 = fex3;
                }
            }
        }
        return fex2;
    }

    public void Method829(Rotation rotation, int n) {
        if (Double.isNaN(rotation.Method6942()) || Double.isNaN(rotation.Method6936()) || rotation.Method6936() > 90.0f || rotation.Method6936() < -90.0f) {
            return;
        }
        rotation.Method6943(few.Field313.gameSettings.mouseSensitivity);
        this.Field510 = rotation;
        this.Field509 = n;
    }

    public void Method830(Rotation rotation) {
        this.Method829(rotation, 0);
    }

    public static float Method831(float f, float f2, float f3) {
        float f4 = 0.006f;
        float f5 = f3 * f3 * f3 * f3 - 0.006f * (0.006f * (f * f) + 2.0f * f2 * (f3 * f3));
        return (float)Math.toDegrees(Math.atan(((double)(f3 * f3) - Math.sqrt(f5)) / (double)(0.006f * f)));
    }

    public Rotation Method832(Rotation rotation, Rotation rotation2, float f) {
        float f2 = this.Method845(rotation2.Method6942(), rotation.Method6942());
        float f3 = this.Method845(rotation2.Method6936(), rotation.Method6936());
        return new Rotation(rotation.Method6942() + (f2 > f ? f : Math.max(f2, -f)), rotation.Method6936() + (f3 > f ? f : Math.max(f3, -f)));
    }

    public double Method833(Rotation rotation, Rotation rotation2) {
        return Math.hypot(this.Method845(rotation.Method6942(), rotation2.Method6942()), rotation.Method6936() - rotation2.Method6936());
    }

    public Vec3d Method834(Rotation rotation) {
        float f = MathHelper.cos((float)(-rotation.Method6942() * ((float)Math.PI / 180) - (float)Math.PI));
        float f2 = MathHelper.sin((float)(-rotation.Method6942() * ((float)Math.PI / 180) - (float)Math.PI));
        float f3 = -MathHelper.cos((float)(-rotation.Method6936() * ((float)Math.PI / 180)));
        float f4 = MathHelper.sin((float)(-rotation.Method6936() * ((float)Math.PI / 180)));
        return new Vec3d((double)(f2 * f3), (double)f4, (double)(f * f3));
    }

    public static float Method336(float f) {
        f %= 360.0f;
        if (f >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static few Method835() {
        return Pyro.Method8980();
    }

    public fex Method836(BlockPos blockPos, EnumFacing enumFacing) {
        AxisAlignedBB axisAlignedBB = few.Field313.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)few.Field313.world, blockPos);
        double d = (double)blockPos.getX() + (axisAlignedBB.minX + axisAlignedBB.maxX) / 2.0;
        double d2 = (double)blockPos.getY() + (axisAlignedBB.minY + axisAlignedBB.maxY) / 2.0;
        double d3 = (double)blockPos.getZ() + (axisAlignedBB.minZ + axisAlignedBB.maxZ) / 2.0;
        double d4 = 0.0;
        double d5 = 0.0;
        double d6 = 0.0;
        if (enumFacing != null) {
            d4 = (double)enumFacing.getDirectionVec().getX() * ((axisAlignedBB.minX + axisAlignedBB.maxX) / 2.0);
            d5 = (double)enumFacing.getDirectionVec().getY() * ((axisAlignedBB.minY + axisAlignedBB.maxY) / 2.0);
            d6 = (double)enumFacing.getDirectionVec().getZ() * ((axisAlignedBB.minZ + axisAlignedBB.maxZ) / 2.0);
            d += d4;
            d2 += d5;
            d3 += d6;
        }
        float[] arrf = this.Method664(d, d2, d3);
        return new fex(new Vec3d(d4, d5, d6), new Rotation(arrf[0], arrf[1]), enumFacing);
    }

    @f0g
    @LauncherEventHide
    public void Method837(f49 f492) {
        CPacketPlayerAccessor cPacketPlayerAccessor;
        if (f492.Method5619() != f41.Pre) {
            return;
        }
        Packet packet = f492.Method5784();
        if (packet instanceof CPacketPlayer && (cPacketPlayerAccessor = (CPacketPlayerAccessor)((CPacketPlayer)packet)).Method8723()) {
            this.Field511 = new Rotation(cPacketPlayerAccessor.Method8725(), cPacketPlayerAccessor.Method8726());
        }
    }

    public static float[] Method838(List list) {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        for (Entity entity : list) {
            d += entity.posX;
            d2 += entity.getEntityBoundingBox().maxY - 2.0;
            d3 += entity.posZ;
        }
        return new float[]{few.Method846(d /= (double)list.size(), d3 /= (double)list.size(), d2 /= (double)list.size())[0], few.Method846(d, d3, d2)[1]};
    }

    public boolean Method839(Vec3d vec3d) {
        Vec3d vec3d2 = new Vec3d(few.Field313.player.posX, few.Field313.player.getEntityBoundingBox().minY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ);
        return few.Field313.world.rayTraceBlocks(vec3d2, vec3d) == null;
    }

    public float[] Method664(double d, double d2, double d3) {
        double d4 = d - few.Field313.player.posX;
        double d5 = d4;
        double d6 = d5 * d5;
        double d7 = d3 -= few.Field313.player.posZ;
        double d8 = MathHelper.sqrt((double)(d6 + d7 * d7));
        float f = (float)(Math.atan2(d3, d4) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float)(-(Math.atan2(d2 -= few.Field313.player.posY + (double)few.Field313.player.getEyeHeight(), d8) * 180.0 / Math.PI));
        float f3 = f - few.Field313.player.rotationYaw;
        if (f3 < -180.0f || f3 > 180.0f) {
            float f4 = Math.round(Math.abs(f3 / 360.0f));
            f3 = f3 < 0.0f ? (f3 += 360.0f * f4) : (f3 -= 360.0f * f4);
        }
        return new float[]{few.Field313.player.rotationYaw + f3, f2};
    }

    @f0g
    @LauncherEventHide
    public void Method840(f43 f432) {
        if (this.Field510 != null) {
            --this.Field509;
            if (this.Field509 <= 0) {
                this.Method461();
            }
        }
        if (this.Field508.nextGaussian() > 0.8) {
            this.Field513 = Math.random();
        }
        if (this.Field508.nextGaussian() > 0.8) {
            this.Field514 = Math.random();
        }
        if (this.Field508.nextGaussian() > 0.8) {
            this.Field515 = Math.random();
        }
    }

    public static boolean Method841(Entity entity, Entity entity2) {
        return entity2 == entity;
    }

    public static float[] Method842(EntityLivingBase entityLivingBase) {
        double d = entityLivingBase.posX;
        double d2 = entityLivingBase.posZ;
        double d3 = entityLivingBase.posY + (double)(entityLivingBase.getEyeHeight() / 2.0f) - 0.5;
        return few.Method846(d, d2, d3);
    }

    public fex Method843(AxisAlignedBB axisAlignedBB, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl) {
            Vec3d vec3d = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (this.Field513 * 0.3 + 1.0), axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (this.Field514 * 0.3 + 1.0), axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (this.Field515 * 0.3 + 1.0));
            return new fex(vec3d, this.Method855(vec3d, bl3));
        }
        Vec3d vec3d = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * this.Field513 * 0.8, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * this.Field514 * 0.8, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * this.Field515 * 0.8);
        Rotation rotation = this.Method855(vec3d, bl3);
        fex fex2 = null;
        for (double d = 0.15; d < 0.85; d += 0.1) {
            for (double d2 = 0.15; d2 < 1.0; d2 += 0.1) {
                for (double d3 = 0.15; d3 < 0.85; d3 += 0.1) {
                    Vec3d vec3d2 = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * d, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * d2, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * d3);
                    Rotation rotation2 = this.Method855(vec3d2, bl3);
                    if (!bl4) {
                        if (!this.Method839(vec3d2)) continue;
                    }
                    fex fex3 = new fex(vec3d2, rotation2);
                    if (fex2 != null && !(bl2 ? this.Method833(fex3.Method891(), rotation) < this.Method833(fex2.Method891(), rotation) : this.Method853(fex3.Method891()) < this.Method853(fex2.Method891()))) continue;
                    fex2 = fex3;
                }
            }
        }
        return fex2;
    }

    public fex Method844(BlockPos blockPos, double d, double d2, double d3) {
        if (blockPos == null) {
            return null;
        }
        fex fex2 = null;
        Vec3d vec3d = new Vec3d(few.Field313.player.posX, few.Field313.player.getEntityBoundingBox().minY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ);
        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).addVector(d, d2, d3);
        double d4 = vec3d.distanceTo(vec3d2);
        double d5 = vec3d2.x - vec3d.x;
        double d6 = vec3d2.y - vec3d.y;
        double d7 = vec3d2.z - vec3d.z;
        double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d7, (double)d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d6, (double)d8))))));
        Vec3d vec3d3 = this.Method834(rotation);
        Vec3d vec3d4 = vec3d.addVector(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
        RayTraceResult rayTraceResult = few.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, false, true);
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
            fex fex3 = new fex(vec3d2, rotation);
            if (fex2 == null || this.Method853(fex3.Method891()) < this.Method853(fex2.Method891())) {
                fex2 = fex3;
            }
        }
        return fex2;
    }

    public float Method845(float f, float f2) {
        return ((f - f2) % 360.0f + 540.0f) % 360.0f - 180.0f;
    }

    public void Method462() {
        Pyro.Method8978().Method7915(this);
    }

    public static float[] Method846(double d, double d2, double d3) {
        double d4 = d - few.Field313.player.posX;
        double d5 = d2 - few.Field313.player.posZ;
        double d6 = d3 - few.Field313.player.posY - 0.6;
        double d7 = MathHelper.sqrt((double)(d4 * d4 + d5 * d5));
        float f = (float)(MathHelper.atan2((double)d5, (double)d4) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float)(-(MathHelper.atan2((double)d6, (double)d7) * 180.0 / Math.PI));
        return new float[]{f, f2};
    }

    public fex Method847(BlockPos blockPos) {
        if (blockPos == null) {
            return null;
        }
        fex fex2 = null;
        double d = 0.5;
        double d2 = 0.9;
        double d3 = 0.5;
        Vec3d vec3d = new Vec3d(few.Field313.player.posX, few.Field313.player.getEntityBoundingBox().minY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ);
        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).addVector(d, d2, d3);
        double d4 = vec3d.distanceTo(vec3d2);
        double d5 = vec3d2.x - vec3d.x;
        double d6 = vec3d2.y - vec3d.y;
        double d7 = vec3d2.z - vec3d.z;
        double d8 = MathHelper.sqrt((double)(d5 * d5 + d7 * d7));
        Rotation rotation = new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d7, (double)d5)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d6, (double)d8))))));
        Vec3d vec3d3 = this.Method834(rotation);
        Vec3d vec3d4 = vec3d.addVector(vec3d3.x * d4, vec3d3.y * d4, vec3d3.z * d4);
        RayTraceResult rayTraceResult = few.Field313.world.rayTraceBlocks(vec3d, vec3d4, false, false, true);
        if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
            fex fex3 = new fex(vec3d2, rotation, rayTraceResult.sideHit);
            if (fex2 == null || this.Method853(fex3.Method891()) < this.Method853(fex2.Method891())) {
                fex2 = fex3;
            }
        }
        return fex2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean Method657(BlockPos blockPos) {
        TileEntity tileEntity;
        Block block;
        block1: {
            block = feg.Method690(blockPos);
            for (TileEntity tileEntity2 : few.Field313.world.loadedTileEntityList) {
                if (!tileEntity2.getPos().equals((Object)blockPos)) continue;
                tileEntity = tileEntity2;
                break block1;
            }
            tileEntity = null;
        }
        if (tileEntity != null) return false;
        if (block instanceof BlockBed) return false;
        if (block instanceof BlockNote) return false;
        if (block instanceof BlockDoor) return false;
        if (block instanceof BlockTrapDoor) return false;
        if (block instanceof BlockFenceGate) return false;
        if (block instanceof BlockButton) return false;
        if (block instanceof BlockAnvil) return false;
        if (block instanceof BlockWorkbench) return false;
        if (block instanceof BlockCake) return false;
        if (block instanceof BlockRedstoneDiode) return false;
        return true;
    }

    public static EnumFacing Method848(BlockPos blockPos, boolean bl) {
        EnumFacing[] arrenumFacing = EnumFacing.values();
        int n = arrenumFacing.length;
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            EnumFacing enumFacing = arrenumFacing[n2];
            RayTraceResult rayTraceResult = few.Field313.world.rayTraceBlocks(new Vec3d(few.Field313.player.posX, few.Field313.player.posY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ), new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing.getDirectionVec().getX() * 1.0 / 2.0, (double)blockPos.getY() + 0.5 + (double)enumFacing.getDirectionVec().getY() * 1.0 / 2.0, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 1.0 / 2.0), false, true, false);
            if (rayTraceResult != null) {
                if (rayTraceResult.typeOfHit.equals((Object)RayTraceResult.Type.BLOCK)) {
                    if (rayTraceResult.getBlockPos().equals((Object)blockPos)) {
                        return enumFacing;
                    }
                }
            }
            n3 = ++n2;
        }
        if (bl) {
            if ((double)blockPos.getY() > few.Field313.player.posY + (double)few.Field313.player.getEyeHeight()) {
                return EnumFacing.DOWN;
            }
            return EnumFacing.UP;
        }
        return null;
    }

    public double Method728(Entity entity) {
        Rotation rotation = this.Method855(this.Method854(entity.getEntityBoundingBox()), true);
        return this.Method833(rotation, new Rotation(few.Field313.player.rotationYaw, few.Field313.player.rotationPitch));
    }

    public RayTraceResult Method849(float f, float f2) {
        float f3 = few.Field313.player.rotationYaw;
        float f4 = few.Field313.player.rotationPitch;
        few.Field313.player.rotationYaw = f;
        few.Field313.player.rotationPitch = f2;
        RayTraceResult rayTraceResult = few.Field313.player.rayTrace((double)few.Field313.playerController.getBlockReachDistance(), Field313.getRenderPartialTicks());
        few.Field313.player.rotationYaw = f3;
        few.Field313.player.rotationPitch = f4;
        return rayTraceResult;
    }

    public static boolean Method696(BlockPos blockPos) {
        return few.Method848(blockPos, false) != null;
    }

    public float[] Method850(BlockPos blockPos, EnumFacing enumFacing) {
        AxisAlignedBB axisAlignedBB = few.Field313.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)few.Field313.world, blockPos);
        double d = (double)blockPos.getX() + (axisAlignedBB.minX + axisAlignedBB.maxX) / 2.0;
        double d2 = (double)blockPos.getY() + (axisAlignedBB.minY + axisAlignedBB.maxY) / 2.0;
        double d3 = (double)blockPos.getZ() + (axisAlignedBB.minZ + axisAlignedBB.maxZ) / 2.0;
        if (enumFacing != null) {
            d += (double)enumFacing.getDirectionVec().getX() * ((axisAlignedBB.minX + axisAlignedBB.maxX) / 2.0);
            d2 += (double)enumFacing.getDirectionVec().getY() * ((axisAlignedBB.minY + axisAlignedBB.maxY) / 2.0);
            d3 += (double)enumFacing.getDirectionVec().getZ() * ((axisAlignedBB.minZ + axisAlignedBB.maxZ) / 2.0);
        }
        return this.Method664(d, d2, d3);
    }

    public void Method461() {
        this.Field509 = 0;
        this.Field510 = null;
    }

    public void Method851(Entity entity, boolean bl, boolean bl2, float f) {
        EntityPlayerSP entityPlayerSP = few.Field313.player;
        double d = entity.posX + (bl2 ? (entity.posX - entity.prevPosX) * (double)f : 0.0) - (entityPlayerSP.posX + (bl2 ? entityPlayerSP.posX - entityPlayerSP.prevPosX : 0.0));
        double d2 = entity.getEntityBoundingBox().minY + (bl2 ? (entity.getEntityBoundingBox().minY - entity.prevPosY) * (double)f : 0.0) + (double)entity.getEyeHeight() - 0.15 - (entityPlayerSP.getEntityBoundingBox().minY + (bl2 ? entityPlayerSP.posY - entityPlayerSP.prevPosY : 0.0)) - (double)entityPlayerSP.getEyeHeight();
        double d3 = entity.posZ + (bl2 ? (entity.posZ - entity.prevPosZ) * (double)f : 0.0) - (entityPlayerSP.posZ + (bl2 ? entityPlayerSP.posZ - entityPlayerSP.prevPosZ : 0.0));
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f2 = (float)entityPlayerSP.getItemInUseMaxCount() / 20.0f;
        f2 = (f2 * f2 + f2 * 2.0f) / 3.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        Rotation rotation = new Rotation((float)(MathHelper.atan2((double)d3, (double)d) * 180.0 / Math.PI) - 90.0f, (float)(-Math.toDegrees(Math.atan(((double)(f2 * f2) - Math.sqrt((double)(f2 * f2 * f2 * f2) - (double)0.006f * ((double)0.006f * (d4 * d4) + 2.0 * d2 * (double)(f2 * f2)))) / ((double)0.006f * d4)))));
        if (bl) {
            this.Method830(rotation);
        } else {
            this.Method832(new Rotation(entityPlayerSP.rotationYaw, entityPlayerSP.rotationPitch), rotation, 10 + new Random().nextInt(6)).Method6941((EntityPlayer)few.Field313.player);
        }
    }

    public boolean Method852(Entity entity, double d) {
        return fet.Method823(d, arg_0 -> few.Method841(entity, arg_0)) != null;
    }

    public double Method853(Rotation rotation) {
        return this.Field511 == null ? 0.0 : this.Method833(rotation, this.Field511);
    }

    public Vec3d Method854(AxisAlignedBB axisAlignedBB) {
        return new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * 0.5, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * 0.5, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * 0.5);
    }

    public Rotation Method855(Vec3d vec3d, boolean bl) {
        Vec3d vec3d2 = new Vec3d(few.Field313.player.posX, few.Field313.player.getEntityBoundingBox().minY + (double)few.Field313.player.getEyeHeight(), few.Field313.player.posZ);
        if (bl) {
            vec3d2.addVector(few.Field313.player.motionX, few.Field313.player.motionY, few.Field313.player.motionZ);
        }
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        return new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d3, (double)d)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d2, (double)Math.sqrt(d * d + d3 * d3)))))));
    }
}

