/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.entity.EntityLivingBase
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityRenderer.class})
public interface EntityRendererAccessor {
    @Invoker(value="orientCamera")
    public void Method4464(float var1);

    @Invoker(value="applyBobbing")
    public void Method4465(float var1);

    @Accessor(value="lightmapColors")
    public int[] Method4466();

    @Accessor(value="lightmapTexture")
    public DynamicTexture Method4467();

    @Accessor(value="torchFlickerX")
    public float Method4468();

    @Accessor(value="bossColorModifier")
    public float Method4469();

    @Accessor(value="bossColorModifierPrev")
    public float Method4470();

    @Invoker(value="getNightVisionBrightness")
    public float Method4471(EntityLivingBase var1, float var2);

    @Invoker(value="setupCameraTransform")
    public void Method4472(float var1, int var2);
}

