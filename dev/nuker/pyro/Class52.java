/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.profiler.Profiler
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldSettings
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class30;
import dev.nuker.pyro.Class60;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;

public class Class52
extends Class60 {
    public BlockPos getSpawnPoint() {
        return new BlockPos(0, 64, 0);
    }

    public Class52(WorldSettings worldSettings, Class30 class30) {
        super(class30, worldSettings, 0, EnumDifficulty.HARD, new Profiler());
        this.provider.setWorld((World)this);
    }
}

