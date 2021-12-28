/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderGuardian
 *  net.minecraft.entity.monster.EntityGuardian
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderGuardian.class})
public abstract class RenderGuardianMixin {
    @Inject(method={"doRender"}, at={@Class0(value="INVOKE", target="net/minecraft/entity/monster/EntityGuardian.getAttackAnimationScale(F)F")}, cancellable=true)
    private void Method6431(EntityGuardian entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
        if (!PyroStatic.Field6434.Method2715()) {
            callbackInfo.Method9034();
        }
    }
}

