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
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.init.Blocks
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.IBlockAccess
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fee;
import dev.nuker.pyro.fef;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
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
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class feg
extends fdZ {
    @NotNull
    public static List<Block> Field453;
    public static feg Field454;

    @NotNull
    public String Method688(int n) {
        return Block.getBlockById((int)n).getLocalizedName();
    }

    @JvmStatic
    public static boolean Method689(@NotNull BlockPos blockPos) {
        double d = fdZ.Field313.player.posX - ((double)blockPos.getX() + 0.5);
        double d2 = fdZ.Field313.player.posY - ((double)blockPos.getY() + 0.5) + 1.5;
        double d3 = fdZ.Field313.player.posZ - ((double)blockPos.getZ() + 0.5);
        double d4 = d * d + d2 * d2 + d3 * d3;
        return d4 <= 36.0;
    }

    @JvmStatic
    @NotNull
    public static Block Method690(@Nullable BlockPos blockPos) {
        return fdZ.Field313.world.getBlockState(blockPos).getBlock();
    }

    @JvmStatic
    public static boolean Method691(@Nullable BlockPos blockPos) {
        return feg.Method690(blockPos).canCollideCheck(feg.Method701(blockPos), false);
    }

    public boolean Method657(@Nullable BlockPos blockPos) {
        AxisAlignedBB axisAlignedBB = feg.Method701(blockPos).getCollisionBoundingBox((IBlockAccess)fdZ.Field313.world, blockPos);
        return axisAlignedBB != null && axisAlignedBB.maxX - axisAlignedBB.minX == 1.0 && axisAlignedBB.maxY - axisAlignedBB.minY == 1.0 && axisAlignedBB.maxZ - axisAlignedBB.minZ == 1.0;
    }

    @NotNull
    public List Method692() {
        return Field453;
    }

    @NotNull
    public Material Method693(@Nullable BlockPos blockPos) {
        return feg.Method701(blockPos).getMaterial();
    }

    @NotNull
    public Map Method694(int n) {
        Map map = new HashMap();
        int n2 = n;
        int n3 = -n + 1;
        if (n2 >= n3) {
            while (true) {
                int n4;
                int n5;
                if ((n5 = n) >= (n4 = -n + 1)) {
                    while (true) {
                        int n6;
                        int n7;
                        if ((n7 = n) >= (n6 = -n + 1)) {
                            while (true) {
                                BlockPos blockPos = new BlockPos((int)fdZ.Field313.player.posX + n2, (int)fdZ.Field313.player.posY + n5, (int)fdZ.Field313.player.posZ + n7);
                                Block block = feg.Method690(blockPos);
                                map.put(blockPos, block);
                                if (n7 == n6) break;
                                --n7;
                            }
                        }
                        if (n5 == n4) break;
                        --n5;
                    }
                }
                if (n2 == n3) break;
                --n2;
            }
        }
        return map;
    }

    static {
        feg feg2;
        Field454 = feg2 = new feg();
        Field453 = CollectionsKt.Method1014(new Block[]{Blocks.AIR, (Block)Blocks.LAVA, (Block)Blocks.WATER, (Block)Blocks.FLOWING_LAVA, (Block)Blocks.FLOWING_WATER});
    }

    @JvmStatic
    public static boolean Method695(@NotNull AxisAlignedBB axisAlignedBB, @NotNull fef fef2) {
        int n = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().maxX) + 1;
        for (int i = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().minX); i < n; ++i) {
            int n2 = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().maxZ) + 1;
            for (int j = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().minZ); j < n2; ++j) {
                Block block = feg.Method690(new BlockPos((double)i, axisAlignedBB.minY, (double)j));
                if (block == null || fef2.Method680(block)) continue;
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean Method696(@NotNull BlockPos blockPos) {
        Block block = feg.Method690(blockPos);
        boolean bl = false;
        Iterator iterator2 = fdZ.Field313.world.loadedTileEntityList.iterator();
        while (iterator2.hasNext()) {
            TileEntity tileEntity = (TileEntity)iterator2.next();
            if (!Intrinsics.Method6572((Object)tileEntity.getPos(), (Object)blockPos)) continue;
            return false;
        }
        if (bl) return false;
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

    @Nullable
    public fee Method697(@NotNull BlockPos blockPos) {
        BlockPos blockPos2 = blockPos;
        WorldClient worldClient = fdZ.Field313.world;
        BlockPos blockPos3 = blockPos2;
        int n = -1;
        int n2 = 0;
        if (!Field453.contains((Object)worldClient.getBlockState(blockPos3.add(n2, n, n2)).getBlock())) {
            BlockPos blockPos4 = blockPos2;
            int n3 = -1;
            int n4 = 0;
            return new fee(blockPos4.add(n4, n3, n4), EnumFacing.UP);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new fee(blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new fee(blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new fee(blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(0, 0, 1)).getBlock())) {
            return new fee(blockPos2.add(0, 0, 1), EnumFacing.NORTH);
        }
        BlockPos blockPos5 = blockPos2.add(-1, 0, 0);
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos5.add(-1, 0, 0)).getBlock())) {
            return new fee(blockPos5.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos5.add(1, 0, 0)).getBlock())) {
            return new fee(blockPos5.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos5.add(0, 0, -1)).getBlock())) {
            return new fee(blockPos5.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos5.add(0, 0, 1)).getBlock())) {
            return new fee(blockPos5.add(0, 0, 1), EnumFacing.NORTH);
        }
        BlockPos blockPos6 = blockPos2.add(1, 0, 0);
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos6.add(-1, 0, 0)).getBlock())) {
            return new fee(blockPos6.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos6.add(1, 0, 0)).getBlock())) {
            return new fee(blockPos6.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos6.add(0, 0, -1)).getBlock())) {
            return new fee(blockPos6.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos6.add(0, 0, 1)).getBlock())) {
            return new fee(blockPos6.add(0, 0, 1), EnumFacing.NORTH);
        }
        BlockPos blockPos7 = blockPos2.add(0, 0, -1);
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos7.add(-1, 0, 0)).getBlock())) {
            return new fee(blockPos7.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos7.add(1, 0, 0)).getBlock())) {
            return new fee(blockPos7.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos7.add(0, 0, -1)).getBlock())) {
            return new fee(blockPos7.add(0, 0, -1), EnumFacing.SOUTH);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos7.add(0, 0, 1)).getBlock())) {
            return new fee(blockPos7.add(0, 0, 1), EnumFacing.NORTH);
        }
        blockPos2 = blockPos2.add(0, 0, 1);
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(-1, 0, 0)).getBlock())) {
            return new fee(blockPos2.add(-1, 0, 0), EnumFacing.EAST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(1, 0, 0)).getBlock())) {
            return new fee(blockPos2.add(1, 0, 0), EnumFacing.WEST);
        }
        if (!Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(0, 0, -1)).getBlock())) {
            return new fee(blockPos2.add(0, 0, -1), EnumFacing.SOUTH);
        }
        return !Field453.contains((Object)fdZ.Field313.world.getBlockState(blockPos2.add(0, 0, 1)).getBlock()) ? new fee(blockPos2.add(0, 0, 1), EnumFacing.NORTH) : null;
    }

    public double Method698(@NotNull BlockPos blockPos) {
        return fdZ.Field313.player.getDistance((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5);
    }

    public boolean Method699(@NotNull AxisAlignedBB axisAlignedBB, @NotNull fef fef2) {
        int n = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().maxX) + 1;
        for (int i = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().minX); i < n; ++i) {
            int n2 = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().maxZ) + 1;
            for (int j = MathHelper.floor((double)fdZ.Field313.player.getEntityBoundingBox().minZ); j < n2; ++j) {
                AxisAlignedBB axisAlignedBB2;
                BlockPos blockPos = new BlockPos((double)i, axisAlignedBB.minY, (double)j);
                Block block = feg.Method690(blockPos);
                if (block == null) continue;
                if (!fef2.Method680(block) || (axisAlignedBB2 = feg.Method701(blockPos).getCollisionBoundingBox((IBlockAccess)fdZ.Field313.world, blockPos)) == null) continue;
                if (!fdZ.Field313.player.getEntityBoundingBox().intersects(axisAlignedBB2)) continue;
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static boolean Method700(@Nullable BlockPos blockPos) {
        return Field454.Method693(blockPos).isReplaceable();
    }

    @JvmStatic
    @NotNull
    public static IBlockState Method701(@Nullable BlockPos blockPos) {
        return fdZ.Field313.world.getBlockState(blockPos);
    }
}

