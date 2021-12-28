/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.MoverType
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.ai.attributes.IAttributeInstance
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.Potion
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f48;
import dev.nuker.pyro.f4m;
import dev.nuker.pyro.f4n;
import dev.nuker.pyro.f4s;
import dev.nuker.pyro.mixin.EntityMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityLivingBase.class})
public abstract class EntityLivingBaseMixin
extends EntityMixin {
    @Shadow
    public int Field7519;
    @Shadow
    public float Field7520;
    @Shadow
    public float Field7521;
    @Shadow
    public float Field7522;
    @Shadow
    public float Field7523;
    @Shadow
    public float Field7524;
    @Shadow
    public float Field7525;
    @Shadow
    public float Field7526;
    @Shadow
    public float Field7527;
    private boolean Field7528 = false;
    private float Field7529 = 0.0f;
    private float Field7530 = 0.0f;

    @Shadow
    public void Method12449(float strafe, float vertical, float forward) {
    }

    @Shadow
    public abstract float Method12450();

    @Shadow
    public abstract IAttributeInstance Method12451(IAttribute var1);

    @Inject(method={"travel"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12452(float strafe, float vertical, float forward, CallbackInfo ci) {
        if (this == Minecraft.getMinecraft().player) {
            f4s travelEvent = new f4s();
            Pyro.Method8978().Method7918(travelEvent);
            if (travelEvent.Method7947()) {
                Minecraft.getMinecraft().player.move(MoverType.SELF, this.Field7646, this.Field7647, this.Field7648);
                ci.Method9034();
            }
            EntityPlayer player = (EntityPlayer)this;
            this.Field7529 = player.rotationPitch;
            this.Field7530 = player.rotationYaw;
            if (Pyro.Method8979().Method7544() != -1337.0f) {
                player.rotationPitch = Pyro.Method8979().Method7544();
            }
            if (Pyro.Method8979().Method7541() != -1337.0f) {
                player.rotationYaw = Pyro.Method8979().Method7541();
            }
        }
    }

    @Inject(method={"travel"}, at={@Class0(value="RETURN")})
    private void Method12453(float strafe, float vertical, float forward, CallbackInfo ci) {
        if (this == Minecraft.getMinecraft().player) {
            EntityPlayer player = (EntityPlayer)this;
            if (Pyro.Method8979().Method7544() != -1337.0f) {
                player.rotationPitch = this.Field7529;
            }
            if (Pyro.Method8979().Method7541() != -1337.0f) {
                player.rotationYaw = this.Field7530;
            }
        }
    }

    @Redirect(method={"travel"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/util/math/MathHelper;cos(F)F", ordinal=0))
    private float Method12454(float value) {
        return (float)Math.cos(this == Minecraft.getMinecraft().player && Pyro.Method8979().Method7544() != -1337.0f ? (double)(Pyro.Method8979().Method7544() * ((float)Math.PI / 180)) : (double)value);
    }

    @Inject(method={"isElytraFlying"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12455(CallbackInfoReturnable cir) {
        if (this.Field7528) {
            this.Field7528 = false;
            cir.Method521(false);
            return;
        }
        if (this == Minecraft.getMinecraft().player) {
            f4m event = new f4m(this.Method12587(7));
            Pyro.Method8978().Method7918(event);
            if (event.Method7947()) {
                cir.Method521(event.Method5594());
            }
        }
    }

    @Inject(method={"isPotionActive"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12456(Potion potionIn, CallbackInfoReturnable cir) {
        if (potionIn == MobEffects.BLINDNESS && ((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method273().Method7979()).booleanValue()) {
            cir.Method521(false);
        }
    }

    @Inject(method={"onDeathUpdate"}, at={@Class0(value="HEAD")})
    private void Method12457(CallbackInfo info) {
        if (this.Field7519 == 19 && !this.Field7655 && (Entity)this instanceof EntityPlayer) {
            Pyro.Method8978().Method7918(new f48((Entity)this));
        }
    }

    @Inject(method={"onItemUseFinish"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method12458(CallbackInfo info) {
        f4n event = new f4n();
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }
}

