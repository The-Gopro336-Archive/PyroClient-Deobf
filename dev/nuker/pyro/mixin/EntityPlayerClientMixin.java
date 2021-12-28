/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AbstractClientPlayer.class})
public class EntityPlayerClientMixin {
    @Inject(method={"isSpectator"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12323(CallbackInfoReturnable cir) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA && ((Entity)this).getEntityId() == -6969) {
            cir.Method521(true);
        }
    }
}

