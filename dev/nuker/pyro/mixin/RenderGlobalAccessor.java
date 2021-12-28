/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.shader.ShaderGroup
 */
package dev.nuker.pyro.mixin;

import java.util.Map;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RenderGlobal.class})
public interface RenderGlobalAccessor {
    @Accessor(value="entityOutlineShader")
    public ShaderGroup Method12598();

    @Accessor(value="damagedBlocks")
    public Map Method12599();
}

