/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityWolf
 */
package dev.nuker.pyro.mixin;

import net.minecraft.entity.passive.EntityWolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EntityWolf.class})
public interface EntityWolfAccessor {
    @Accessor(value="isWet")
    public boolean Method12348();

    @Accessor(value="isWet")
    public void Method12349(boolean var1);
}

