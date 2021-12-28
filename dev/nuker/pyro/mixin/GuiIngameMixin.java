/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngame.class})
public class GuiIngameMixin {
    @Inject(method={"renderVignette"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method4638(float lightLevel, ScaledResolution scaledRes, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6464.Field5236.Method5264()).booleanValue()) {
            PyroStatic.Field6464.Method2386(scaledRes);
            ci.Method9034();
        } else if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method284().Method7979()).booleanValue()) {
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            ci.Method9034();
        }
    }

    @Inject(method={"renderPotionEffects"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method4639(ScaledResolution res, CallbackInfo info) {
        info.Method9034();
    }
}

