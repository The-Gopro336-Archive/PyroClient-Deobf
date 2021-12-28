/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import net.minecraft.block.Block;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;

public class fbz {
    @NotNull
    public Vec3d Field172;
    @NotNull
    public Block Field173;

    public void Method261(@NotNull Vec3d vec3d) {
        this.Field172 = vec3d;
    }

    @NotNull
    public Block Method262() {
        return this.Field173;
    }

    public fbz(@NotNull Vec3d vec3d, @NotNull Block block) {
        this.Field172 = vec3d;
        this.Field173 = block;
    }

    @NotNull
    public Vec3d Method263() {
        return this.Field172;
    }

    public void Method264(@NotNull Block block) {
        this.Field173 = block;
    }
}

