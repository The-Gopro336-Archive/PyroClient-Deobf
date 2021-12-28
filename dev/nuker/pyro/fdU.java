/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAnvil
 *  net.minecraft.block.BlockBeacon
 *  net.minecraft.block.BlockBrewingStand
 *  net.minecraft.block.BlockButton
 *  net.minecraft.block.BlockChest
 *  net.minecraft.block.BlockCommandBlock
 *  net.minecraft.block.BlockDaylightDetector
 *  net.minecraft.block.BlockDispenser
 *  net.minecraft.block.BlockDoor
 *  net.minecraft.block.BlockDragonEgg
 *  net.minecraft.block.BlockEnchantmentTable
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockFenceGate
 *  net.minecraft.block.BlockFurnace
 *  net.minecraft.block.BlockHopper
 *  net.minecraft.block.BlockJukebox
 *  net.minecraft.block.BlockLever
 *  net.minecraft.block.BlockNote
 *  net.minecraft.block.BlockShulkerBox
 *  net.minecraft.block.BlockTrapDoor
 *  net.minecraft.block.BlockWorkbench
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumFacing$Axis
 *  net.minecraft.util.EnumFacing$AxisDirection
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.Tuple
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdR;
import dev.nuker.pyro.fdS;
import dev.nuker.pyro.fdT;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockBeacon;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockNote;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fdU {
    public Minecraft Field253;
    @NotNull
    public static fdU Field254;
    public static fdR Field255;

    @NotNull
    public Vec3d Method419() {
        return new Vec3d(this.Field253.player.posX, this.Field253.player.posY + (double)this.Field253.player.getEyeHeight(), this.Field253.player.posZ);
    }

    public static fdU Method420() {
        return Field254;
    }

    @NotNull
    public Vec2f Method421(@NotNull Vec3d vec3d, @NotNull Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.y - vec3d.y;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new Vec2f(this.Field253.player.rotationYaw + MathHelper.wrapDegrees((float)(f - this.Field253.player.rotationYaw)), this.Field253.player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - this.Field253.player.rotationPitch)));
    }

    @NotNull
    public Vec2f Method422(@NotNull Vec3d vec3d) {
        Vec3d vec3d2 = this.Method419();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new Vec2f(this.Field253.player.rotationYaw + MathHelper.wrapDegrees((float)(f - this.Field253.player.rotationYaw)), this.Field253.player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - this.Field253.player.rotationPitch)));
    }

    public fdU(@NotNull Minecraft minecraft) {
        this.Field253 = minecraft;
    }

    @NotNull
    public IBlockState Method423(@Nullable BlockPos blockPos) {
        return this.Field253.world.getBlockState(blockPos);
    }

    @Nullable
    public EnumFacing Method424(@Nullable BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.VALUES) {
            if (this.Field253.world.rayTraceBlocks(new Vec3d(this.Field253.player.posX, this.Field253.player.posY + (double)this.Field253.player.getEyeHeight(), this.Field253.player.posZ), this.Method431(blockPos, (World)this.Field253.world, enumFacing), false, true, false) != null) continue;
            return enumFacing;
        }
        return null;
    }

    @Nullable
    public Tuple Method425(@NotNull BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            EnumFacing enumFacing2 = enumFacing.getOpposite();
            if (!this.Method440(blockPos2)) continue;
            return new Tuple((Object)blockPos2, (Object)enumFacing2);
        }
        return null;
    }

    public void Method426(@NotNull Vec3d vec3d, boolean bl) {
        this.Method434(this.Method422(vec3d), bl);
    }

    @NotNull
    public Block Method427(@Nullable BlockPos blockPos) {
        return this.Method423(blockPos).getBlock();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method428(@Nullable Block block) {
        if (block instanceof BlockChest) return true;
        if (block instanceof BlockEnderChest) return true;
        if (block instanceof BlockAnvil) return true;
        if (block instanceof BlockDoor) return true;
        if (block instanceof BlockTrapDoor) return true;
        if (block instanceof BlockDispenser) return true;
        if (block instanceof BlockEnchantmentTable) return true;
        if (block instanceof BlockHopper) return true;
        if (block instanceof BlockBrewingStand) return true;
        if (block instanceof BlockWorkbench) return true;
        if (block instanceof BlockFurnace) return true;
        if (block instanceof BlockShulkerBox) return true;
        if (block instanceof BlockBeacon) return true;
        if (block instanceof BlockDragonEgg) return true;
        if (block instanceof BlockCommandBlock) return true;
        if (block instanceof BlockDaylightDetector) return true;
        if (block instanceof BlockNote) return true;
        if (block instanceof BlockJukebox) return true;
        if (block instanceof BlockLever) return true;
        if (block instanceof BlockButton) return true;
        if (!(block instanceof BlockFenceGate)) return false;
        return true;
    }

    public void Method429(@NotNull Vec3d vec3d, @Nullable EnumFacing enumFacing, boolean bl) {
        this.Method434(this.Method438(vec3d, enumFacing), bl);
    }

    public void Method430(@NotNull Vec3d vec3d, boolean bl) {
        this.Method432(this.Method422(vec3d), bl);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @NotNull
    public Vec3d Method431(@Nullable BlockPos blockPos, @NotNull World world, @NotNull EnumFacing enumFacing) {
        Vec3d vec3d;
        IBlockState iBlockState = world.getBlockState(blockPos);
        AxisAlignedBB axisAlignedBB = iBlockState.getBoundingBox((IBlockAccess)world, blockPos);
        Vec3d vec3d2 = null;
        double d = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) / 2.0;
        double d2 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) / 2.0;
        double d3 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) / 2.0;
        EnumFacing.Axis axis = enumFacing.getAxis();
        if (axis == null) throw (Throwable)new IllegalStateException("Unexpected valueAbstract: " + (Object)enumFacing.getAxis());
        switch (fdT.Field251[axis.ordinal()]) {
            case 1: {
                vec3d = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double)(enumFacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 1 : 0), d2, d3);
                break;
            }
            case 2: {
                vec3d = new Vec3d(d, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double)(enumFacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 1 : 0), d3);
                break;
            }
            case 3: {
                vec3d = new Vec3d(d, d2, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double)(enumFacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 1 : 0));
                break;
            }
            default: {
                throw (Throwable)new IllegalStateException("Unexpected valueAbstract: " + (Object)enumFacing.getAxis());
            }
        }
        vec3d2 = vec3d;
        return new Vec3d((Vec3i)blockPos).add(vec3d2);
    }

    public void Method432(@NotNull Vec2f vec2f, boolean bl) {
        this.Field253.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(vec2f.x, vec2f.y, this.Field253.player.onGround));
        if (bl) {
            this.Field253.player.rotationPitch = vec2f.y;
            this.Field253.player.rotationYaw = vec2f.x;
        }
    }

    @NotNull
    public Vec2f Method433(@NotNull Vec3d vec3d) {
        double d = vec3d.x;
        double d2 = vec3d.y;
        double d3 = vec3d.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new Vec2f(MathHelper.wrapDegrees((float)f), MathHelper.wrapDegrees((float)f2));
    }

    public void Method434(@NotNull Vec2f vec2f, boolean bl) {
        this.Field253.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(vec2f.x, vec2f.y, this.Field253.player.onGround));
    }

    public static void Method435(fdU fdU2) {
        Field254 = fdU2;
    }

    @NotNull
    public Vec2f Method436(@NotNull EnumFacing enumFacing) {
        return new Vec2f(enumFacing.getHorizontalAngle(), (float)(enumFacing.getFrontOffsetY() * 90));
    }

    public boolean Method437(@NotNull BlockPos blockPos, @NotNull fdS fdS2, boolean bl) {
        Tuple tuple = this.Method425(blockPos);
        if (tuple != null) {
            Vec3d vec3d = this.Method431((BlockPos)tuple.getFirst(), (World)this.Field253.world, (EnumFacing)tuple.getSecond());
            Vec2f vec2f = this.Method441();
            if (fdS2 != fdS.NONE) {
                this.Method426(vec3d, fdS2 == fdS.CLIENT);
            }
            boolean bl2 = false;
            Block block = this.Field253.world.getBlockState((BlockPos)tuple.getFirst()).getBlock();
            if (this.Method428(block)) {
                bl2 = true;
            }
            if (bl2) {
                this.Field253.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field253.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            if (bl) {
                float f = (float)(vec3d.x - (double)((BlockPos)tuple.getFirst()).getX());
                float f2 = (float)(vec3d.y - (double)((BlockPos)tuple.getFirst()).getY());
                float f3 = (float)(vec3d.z - (double)((BlockPos)tuple.getFirst()).getZ());
                this.Field253.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock((BlockPos)tuple.getFirst(), (EnumFacing)tuple.getSecond(), EnumHand.MAIN_HAND, f, f2, f3));
            } else {
                this.Field253.playerController.processRightClickBlock(this.Field253.player, this.Field253.world, (BlockPos)tuple.getFirst(), (EnumFacing)tuple.getSecond(), vec3d, EnumHand.MAIN_HAND);
            }
            this.Field253.player.swingArm(EnumHand.MAIN_HAND);
            if (bl2) {
                this.Field253.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)this.Field253.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (fdS2 == fdS.SWAPBACK) {
                this.Method434(vec2f, false);
            }
            return true;
        }
        return false;
    }

    @NotNull
    public Vec2f Method438(@NotNull Vec3d vec3d, @Nullable EnumFacing enumFacing) {
        Vec3d vec3d2 = this.Method419();
        double d = vec3d.x - vec3d2.x;
        double d2 = vec3d.y - vec3d2.y;
        double d3 = vec3d.z - vec3d2.z;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        return new Vec2f(this.Field253.player.rotationYaw + MathHelper.wrapDegrees((float)(f - this.Field253.player.rotationYaw)), this.Field253.player.rotationPitch + MathHelper.wrapDegrees((float)(f2 - this.Field253.player.rotationPitch)));
    }

    public void Method439(@Nullable BlockPos blockPos, @Nullable EnumFacing enumFacing, @Nullable Vec3d vec3d, @Nullable EnumHand enumHand) {
        this.Field253.playerController.processRightClickBlock(this.Field253.player, this.Field253.world, blockPos, enumFacing, vec3d, enumHand);
        this.Field253.player.swingArm(enumHand);
    }

    static {
        Field255 = new fdR(null);
        Field254 = new fdU(Minecraft.getMinecraft());
    }

    public boolean Method440(@Nullable BlockPos blockPos) {
        return this.Method427(blockPos).canCollideCheck(this.Method423(blockPos), false);
    }

    @NotNull
    public Vec2f Method441() {
        return new Vec2f(this.Field253.player.rotationYaw, this.Field253.player.rotationPitch);
    }
}

