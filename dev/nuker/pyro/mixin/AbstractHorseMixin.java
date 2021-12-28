/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.AbstractHorse
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.entity.passive.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AbstractHorse.class})
public abstract class AbstractHorseMixin {
    @Inject(method={"getHorseJumpStrength"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method294(CallbackInfoReturnable callbackInfoReturnable) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue()) {
            callbackInfoReturnable.Method521(PyroStatic.Field6456.Method238().Method7979());
        }
    }

    @Inject(method={"canBeSteered"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method295(CallbackInfoReturnable info) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue()) {
            info.Method9034();
            info.Method521(true);
        }
    }

    @Inject(method={"isHorseSaddled"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method296(CallbackInfoReturnable info) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue()) {
            info.Method9034();
            info.Method521(true);
        }
    }
}

