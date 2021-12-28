/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import net.minecraft.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class f4r {
    @NotNull
    public Entity Field4231;

    public void Method5851(@NotNull Entity entity) {
        this.Field4231 = entity;
    }

    public f4r(@NotNull Entity entity) {
        this.Field4231 = entity;
    }

    @NotNull
    public Entity Method5852() {
        return this.Field4231;
    }
}

