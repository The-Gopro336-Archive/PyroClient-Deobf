/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.faV;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Render.class})
public class RenderMixin {
    @Inject(method={"getTeamColor"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method9581(Entity entityIn, CallbackInfoReturnable cir) {
        f00 color;
        if (((Boolean)PyroStatic.Field6434.Field5236.Method5264()).booleanValue() && PyroStatic.Field6434.Method2544().Method7979() == faV.Glow && (color = PyroStatic.Field6434.Method2709(entityIn)) != null) {
            cir.Method521(color.Method7515());
        }
    }

    @Inject(method={"doRenderShadowAndFire"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method9582(CallbackInfo callbackInfo) {
        if (!PyroStatic.Field6434.Method2715()) {
            callbackInfo.Method9034();
        }
    }

    @Inject(method={"renderLivingLabel"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method9583(CallbackInfo callbackInfo) {
        if (!PyroStatic.Field6434.Method2715()) {
            callbackInfo.Method9034();
        }
    }
}

