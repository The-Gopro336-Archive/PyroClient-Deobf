/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityPig
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityLlama.class, EntityPig.class})
public class EntityLlamaMixin {
    @Inject(method={"canBeSteered"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method5674(CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue()) {
            callback.Method521(true);
        }
    }
}

