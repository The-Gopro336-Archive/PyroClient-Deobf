/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderMinecart
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderMinecart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderMinecart.class})
public abstract class RenderMinecartMixin {
    @Inject(method={"renderCartContents"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8090(CallbackInfo call) {
        if (!PyroStatic.Field6434.Method2715()) {
            call.Method9034();
        }
    }
}

