/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fe5;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class faP
extends Module {
    public f0l Field1681 = new f0l("color", "EnemyColor", null, new f00(0.0f, 1.0f, 0.5f, 0.3f));
    public f0l Field1682 = new f0l("selfColor", "SelfColor", null, new f00(0.125f, 1.0f, 0.5f, 0.3f));
    public ConcurrentHashMap<Integer, ArrayList<BlockPos>> Field1683 = new ConcurrentHashMap();
    public List<BlockPos> Field1684 = new CopyOnWriteArrayList<BlockPos>();
    public static BlockPos[] Field1685 = new BlockPos[]{new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};

    public void Method2379(Map.Entry entry) {
        for (BlockPos blockPos : (ArrayList)entry.getValue()) {
            fe5.Field252.Method408(7);
            fe5.Field252.Method410(blockPos, ((f00)this.Field1681.Method7979()).Method7515(), 63);
            fe5.Field252.Method405();
        }
    }

    public boolean Method2380(Map.Entry entry) {
        return this.Field5233.world.getEntityByID(((Integer)entry.getKey()).intValue()) == null;
    }

    public ArrayList Method2381(EntityPlayer entityPlayer) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        for (int i = 0; i < 4; ++i) {
            BlockPos blockPos = fdN.Method359((Entity)entityPlayer, Field1685[i]);
            if (feg.Method690(blockPos) != Blocks.OBSIDIAN) continue;
            boolean bl = false;
            IBlockState iBlockState = feg.Method701(blockPos);
            switch (i) {
                case 0: {
                    bl = PyroStatic.Field6416.Method8865(blockPos.north(1).down(), iBlockState, true);
                    break;
                }
                case 1: {
                    bl = PyroStatic.Field6416.Method8865(blockPos.east(1).down(), iBlockState, true);
                    break;
                }
                case 2: {
                    bl = PyroStatic.Field6416.Method8865(blockPos.south(1).down(), iBlockState, true);
                    break;
                }
                case 3: {
                    bl = PyroStatic.Field6416.Method8865(blockPos.west(1).down(), iBlockState, true);
                }
            }
            if (!bl) continue;
            arrayList.add(blockPos);
        }
        return arrayList;
    }

    public void Method2382(EntityPlayer entityPlayer) {
        if (!FriendManager.Field2145.Method8960(entityPlayer) && !(entityPlayer instanceof EntityPlayerSP)) {
            ArrayList arrayList = this.Method2381(entityPlayer);
            this.Field1683.put(entityPlayer.getEntityId(), arrayList);
        }
    }

    @f0g
    @LauncherEventHide
    public void Method183(f4t f4t2) {
        this.Field1683.entrySet().removeIf(this::Method2380);
        this.Field5233.world.playerEntities.forEach(this::Method2382);
        this.Field1684 = this.Method2381((EntityPlayer)this.Field5233.player);
    }

    public faP() {
        super("cityesp", "CityESP", "Highlights blocks of enemies that you can city", true);
        this.Method7264(this.Field1681);
        this.Method7264(this.Field1682);
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        this.Field1683.entrySet().forEach(this::Method2379);
        if (!this.Field1684.isEmpty()) {
            this.Field1684.forEach(this::Method209);
        }
    }

    public void Method209(BlockPos blockPos) {
        fe5.Field252.Method408(7);
        fe5.Field252.Method410(blockPos, ((f00)this.Field1682.Method7979()).Method7515(), 63);
        fe5.Field252.Method405();
    }
}

