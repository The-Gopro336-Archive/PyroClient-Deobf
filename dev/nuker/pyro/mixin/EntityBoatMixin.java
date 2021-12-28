/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityBoat
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.mixin.EntityMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityBoat.class})
public abstract class EntityBoatMixin
extends EntityMixin {
    private boolean Method7481() {
        return (Boolean)PyroStatic.Field6518.Field5236.Method5264();
    }

    @Shadow
    public abstract double Method7482();

    @Inject(method={"updateMotion"}, at={@Class0(value="RETURN")})
    private void Method7483(CallbackInfo info) {
        if (fdZ.Field313.player != null && fdZ.Field313.player.isRiding() && (EntityBoat)this == fdZ.Field313.player.getRidingEntity() && this.Method7481()) {
            PyroStatic.Field6518.Method5384();
        }
    }

    @Inject(method={"applyOrientationToEntity"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method7484(Entity passenger, CallbackInfo info) {
        if (fdZ.Field313.player != null && fdZ.Field313.player.isRiding() && fdZ.Field313.player == passenger && this.Method7481()) {
            info.Method9034();
        }
    }

    @Inject(method={"controlBoat"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method7485(CallbackInfo info) {
        if (fdZ.Field313.player != null && fdZ.Field313.player.isRiding() && (EntityBoat)this == fdZ.Field313.player.getRidingEntity() && this.Method7481()) {
            info.Method9034();
        }
    }

    @Inject(method={"updatePassenger"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method7486(Entity passenger, CallbackInfo info) {
        if (fdZ.Field313.player != null && fdZ.Field313.player.isRiding() && fdZ.Field313.player == passenger && this.Method7481()) {
            info.Method9034();
            float f = 0.0f;
            float f1 = (float)((this.Field7655 ? (double)0.01f : this.Method7482()) + passenger.getYOffset());
            Vec3d vec3d = new Vec3d((double)f, 0.0, 0.0).rotateYaw(-this.Field7642 * ((float)Math.PI / 180) - 1.5707964f);
            passenger.setPosition(this.Field7643 + vec3d.x, this.Field7644 + (double)f1, this.Field7645 + vec3d.z);
        }
    }
}

