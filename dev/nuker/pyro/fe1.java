/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 */
package dev.nuker.pyro;

import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fe0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class fe1
extends fdZ {
    public static fe0 Method450(IBlockState iBlockState) {
        if (iBlockState.getBlock() == Blocks.CLAY) {
            return fe0.f$b;
        }
        if (iBlockState.getBlock() == Blocks.GOLD_BLOCK) {
            return fe0.f$j;
        }
        if (iBlockState.getBlock() == Blocks.WOOL) {
            return fe0.f$i;
        }
        if (iBlockState.getBlock() == Blocks.PACKED_ICE) {
            return fe0.f$M;
        }
        if (iBlockState.getBlock() == Blocks.BONE_BLOCK) {
            return fe0.f$g;
        }
        if (iBlockState.getMaterial() == Material.ROCK) {
            return fe0.f$C;
        }
        if (iBlockState.getMaterial() == Material.SAND) {
            return fe0.f$e;
        }
        if (iBlockState.getMaterial() == Material.GLASS) {
            return fe0.f$I;
        }
        return iBlockState.getMaterial() == Material.WOOD ? fe0.f$K : fe0.f$a;
    }

    public static double Method451(BlockPos blockPos) {
        double d = Math.abs(fe1.Field313.player.posX - (double)blockPos.getX() - 0.5);
        double d2 = Math.abs(fe1.Field313.player.posY + (double)fe1.Field313.player.getEyeHeight() - (double)blockPos.getY() - 0.5);
        double d3 = Math.abs(fe1.Field313.player.posZ - (double)blockPos.getZ() - 0.5);
        return d * d + d2 * d2 + d3 * d3;
    }

    public static LinkedHashMap Method452() {
        BlockPos blockPos = fe1.Field313.player.getPosition();
        LinkedHashMap<fe0, BlockPos[]> linkedHashMap = new LinkedHashMap<fe0, BlockPos[]>();
        HashMap hashMap = new HashMap();
        Arrays.asList(fe0.Method448()).forEach(arg_0 -> fe1.Method453(linkedHashMap, hashMap, arg_0));
        int n = 6;
        int n2 = -6;
        int n3 = -6;
        while (n3 < n) {
            int n4;
            n3 = n4 = -n;
            while (n3 < n) {
                int n5 = -1;
                n3 = -1;
                while (n3 < 5) {
                    BlockPos blockPos2;
                    BlockPos blockPos3 = blockPos.add(n2, n5, n4);
                    if (fe1.Method451(blockPos2) < 27.040000000000003) {
                        fe0 fe02;
                        int n6;
                        if (fe1.Field313.world.getBlockState(blockPos3).getBlock() == Blocks.NOTEBLOCK && (n6 = ((AtomicInteger)hashMap.get((Object)(fe02 = fe1.Method450(fe1.Field313.world.getBlockState(blockPos3.down()))))).getAndIncrement()) < 25) {
                            BlockPos[] arrblockPos = (BlockPos[])linkedHashMap.get((Object)fe02);
                            arrblockPos[n6] = blockPos3;
                            linkedHashMap.put(fe02, arrblockPos);
                        }
                    }
                    n3 = ++n5;
                }
                n3 = ++n4;
            }
            n3 = ++n2;
        }
        return linkedHashMap;
    }

    public static void Method453(LinkedHashMap linkedHashMap, HashMap hashMap, fe0 fe02) {
        BlockPos[] arrblockPos = new BlockPos[25];
        boolean bl = true;
        linkedHashMap.put(fe02, arrblockPos);
        hashMap.put(fe02, new AtomicInteger());
    }
}

