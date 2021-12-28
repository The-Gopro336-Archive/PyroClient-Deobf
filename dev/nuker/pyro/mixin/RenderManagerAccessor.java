/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderManager.class})
public interface RenderManagerAccessor {
    @Accessor(value="renderPosX")
    public double Method2421();

    @Accessor(value="renderPosY")
    public double Method2422();

    @Accessor(value="renderPosZ")
    public double Method2423();
}

