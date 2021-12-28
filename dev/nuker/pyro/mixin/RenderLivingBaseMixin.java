/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$Profile
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f4D;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={RenderLivingBase.class})
public abstract class RenderLivingBaseMixin
extends Render {
    @Shadow
    protected ModelBase Field2384;

    @Shadow
    protected abstract boolean Method3916(EntityLivingBase var1);

    protected RenderLivingBaseMixin(RenderManager renderManager) {
        super(renderManager);
    }

    @Inject(method={"isVisible"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3917(EntityLivingBase entity, CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.PACKET && entity == Minecraft.getMinecraft().player) {
            cir.Method521(PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.PACKET);
        }
    }

    @Inject(method={"renderModel"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3918(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, CallbackInfo ci) {
        f4D event = new f4D((RenderLivingBase)this, entitylivingbaseIn, this.Field2384, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            boolean flag1;
            ci.Method9034();
            boolean flag = this.Method3916(entitylivingbaseIn);
            boolean bl = flag1 = !flag && !entitylivingbaseIn.isInvisibleToPlayer((EntityPlayer)Minecraft.getMinecraft().player);
            if (flag || flag1) {
                if (!this.bindEntityTexture((Entity)entitylivingbaseIn)) {
                    return;
                }
                if (flag1) {
                    GlStateManager.enableBlendProfile((GlStateManager.Profile)GlStateManager.Profile.TRANSPARENT_MODEL);
                }
                if (flag1) {
                    GlStateManager.disableBlendProfile((GlStateManager.Profile)GlStateManager.Profile.TRANSPARENT_MODEL);
                }
            }
            return;
        }
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.PACKET && entitylivingbaseIn == Minecraft.getMinecraft().player) {
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)0.25f);
            GlStateManager.depthMask((boolean)false);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.alphaFunc((int)516, (float)0.003921569f);
        }
    }

    @Inject(method={"renderModel"}, at={@Class0(value="RETURN")})
    private void Method3919(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.PACKET && entitylivingbaseIn == Minecraft.getMinecraft().player) {
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc((int)516, (float)0.1f);
            GlStateManager.depthMask((boolean)true);
        }
    }

    @Inject(method={"getColorMultiplier"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3920(EntityLivingBase entitylivingbaseIn, float lightBrightness, float partialTickTime, CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6416.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6416.Method8838().Method7979()).booleanValue() && entitylivingbaseIn == PyroStatic.Field6416.Method8887()) {
            cir.Method521(((f00)PyroStatic.Field6416.Method8845().Method7979()).Method7515());
        }
    }

    @Inject(method={"renderLayers"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3921(CallbackInfo var1) {
        if (!PyroStatic.Field6434.Method2715()) {
            var1.Method9034();
        }
    }

    @Inject(method={"renderName"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3922(EntityLivingBase entity, double x, double y, double z, CallbackInfo info) {
        if (entity instanceof EntityPlayer && ((Boolean)PyroStatic.Field6433.Field5236.Method5264()).booleanValue()) {
            info.Method9034();
        }
        if (!PyroStatic.Field6434.Method2715()) {
            info.Method9034();
        }
    }
}

