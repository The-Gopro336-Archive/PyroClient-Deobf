/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderDragon
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderDragon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderDragon.class})
public abstract class RenderDragonMixin {
    @Inject(method={"renderCrystalBeams"}, at={@Class0(value="HEAD")}, cancellable=true)
    private static void Method9692(double var0, double var2, double var4, float var6, double var7, double var9, double var11, int var13, double var14, double var16, double var18, CallbackInfo var20) {
        if (!PyroStatic.Field6434.Method2715()) {
            var20.Method9034();
        }
    }
}

