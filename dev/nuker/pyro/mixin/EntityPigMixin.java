/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.passive.EntityPig
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.mixin.EntityAnimalMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPig.class})
public abstract class EntityPigMixin
extends EntityAnimalMixin {
    @Shadow
    private boolean Field7433;
    @Shadow
    private int Field7434;
    @Shadow
    private int Field7435;

    @Inject(method={"canBeSteered"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method12367(CallbackInfoReturnable callback) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue()) {
            callback.Method521(true);
        }
    }

    @Inject(method={"travel"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12368(float strafe, float vertical, float forward, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6456.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6456.Method274().Method7979()).booleanValue()) {
            Entity entity;
            info.Method9034();
            Entity entity2 = entity = this.Method12589().isEmpty() ? null : (Entity)this.Method12589().get(0);
            if (this.Method12588() && this.Method5721()) {
                this.Field7657 = this.Field7642 = entity.rotationYaw;
                this.Field7641 = entity.rotationPitch * 0.5f;
                this.Method12590(this.Field7642, this.Field7641);
                this.Field7520 = this.Field7642;
                this.Field7522 = this.Field7642;
                this.Field7656 = 1.0f;
                this.Field7524 = this.Method12450() * 0.1f;
                if (this.Field7433 && this.Field7434++ > this.Field7435) {
                    this.Field7433 = false;
                }
                if (this.Method5720()) {
                    float f = (float)this.Method12451(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225f;
                    if (this.Field7433) {
                        f += f * 1.15f * MathHelper.sin((float)((float)this.Field7434 / (float)this.Field7435 * (float)Math.PI));
                    }
                    this.Method5722(f);
                } else {
                    this.Field7646 = 0.0;
                    this.Field7647 = 0.0;
                    this.Field7648 = 0.0;
                }
                this.Field7525 = this.Field7526;
                double d1 = this.Field7643 - this.Field7662;
                double d0 = this.Field7645 - this.Field7664;
                float f1 = MathHelper.sqrt((double)(d1 * d1 + d0 * d0)) * 4.0f;
                if (f1 > 1.0f) {
                    f1 = 1.0f;
                }
                this.Field7526 += (f1 - this.Field7526) * 0.4f;
                this.Field7527 += this.Field7526;
            } else {
                this.Field7656 = 0.5f;
                this.Field7524 = 0.02f;
                super.Method12449(strafe, vertical, forward);
            }
        }
    }
}

