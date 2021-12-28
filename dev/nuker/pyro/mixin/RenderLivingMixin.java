/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderLiving
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderLiving;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderLiving.class})
public class RenderLivingMixin {
    @Inject(method={"renderLeash"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method11707(CallbackInfo var1) {
        if (!PyroStatic.Field6434.Method2715()) {
            var1.Method9034();
        }
    }
}

