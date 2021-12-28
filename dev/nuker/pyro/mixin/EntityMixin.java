/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4z;
import dev.nuker.pyro.faV;
import dev.nuker.pyro.fb2;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Entity.class})
public abstract class EntityMixin {
    @Shadow
    public float Field7641;
    @Shadow
    public float Field7642;
    @Shadow
    public double Field7643;
    @Shadow
    public double Field7644;
    @Shadow
    public double Field7645;
    @Shadow
    public double Field7646;
    @Shadow
    public double Field7647;
    @Shadow
    public double Field7648;
    @Shadow
    public boolean Field7649;
    @Shadow
    public boolean Field7650;
    @Shadow
    public boolean Field7651;
    @Shadow
    public boolean Field7652;
    @Shadow
    protected boolean Field7653;
    @Shadow
    protected Random Field7654;
    @Shadow
    public boolean Field7655;
    @Shadow
    public float Field7656;
    @Shadow
    public float Field7657;
    @Shadow
    public float Field7658;
    @Shadow
    public double Field7659;
    @Shadow
    public double Field7660;
    @Shadow
    public double Field7661;
    @Shadow
    public double Field7662;
    @Shadow
    public double Field7663;
    @Shadow
    public double Field7664;
    private float Field7665 = 0.0f;

    @Shadow
    public void Method12582(MoverType type, double x, double y, double z) {
    }

    @Shadow
    public abstract boolean Method12583();

    @Shadow
    public abstract boolean Method1122();

    @Shadow
    public abstract AxisAlignedBB Method12584();

    @Shadow
    public abstract boolean Method12585();

    @Shadow
    public abstract Entity Method12586();

    @Shadow
    protected abstract boolean Method12587(int var1);

    @Shadow
    public abstract boolean Method12588();

    @Shadow
    public abstract List Method12589();

    @Shadow
    public void Method12590(float yaw, float pitch) {
    }

    @Shadow
    public abstract void Method12591(boolean var1);

    @Inject(method={"turn"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12592(float yaw, float pitch, CallbackInfo ci) {
        if (this == Minecraft.getMinecraft().player && ((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA && PyroStatic.Field6417.Field1712 != null) {
            PyroStatic.Field6417.Field1710 = (float)((double)PyroStatic.Field6417.Field1710 + (double)yaw * 0.15);
            PyroStatic.Field6417.Field1709 = (float)((double)PyroStatic.Field6417.Field1709 - (double)pitch * 0.15);
            PyroStatic.Field6417.Field1710 = MathHelper.wrapDegrees((float)PyroStatic.Field6417.Field1710);
            PyroStatic.Field6417.Field1712.rotationPitch = PyroStatic.Field6417.Field1709 = Math.min(90.0f, Math.max(PyroStatic.Field6417.Field1709, -90.0f));
            PyroStatic.Field6417.Field1712.rotationYaw = PyroStatic.Field6417.Field1710;
            PyroStatic.Field6417.Field1712.rotationYawHead = PyroStatic.Field6417.Field1710;
            PyroStatic.Field6417.Field1712.prevRotationPitch = PyroStatic.Field6417.Field1709;
            PyroStatic.Field6417.Field1712.prevRotationYaw = PyroStatic.Field6417.Field1710;
            PyroStatic.Field6417.Field1712.prevRotationYawHead = PyroStatic.Field6417.Field1710;
            ci.Method9034();
        }
    }

    @Inject(method={"isGlowing"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method12593(CallbackInfoReturnable cir) {
        try {
            if (((Boolean)PyroStatic.Field6434.Field5236.Method5264()).booleanValue() && PyroStatic.Field6434.Method2544().Method7979() == faV.Glow && PyroStatic.Field6434.Method2709((Entity)this) != null) {
                cir.Method521(true);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"move"}, at={@Class0(value="FIELD", target="net/minecraft/entity/Entity.onGround:Z", ordinal=1)})
    private void Method12594(MoverType type, double x, double y, double z, CallbackInfo info) {
        Entity self = (Entity)this;
        if (self instanceof EntityPlayerSP) {
            f4z event = new f4z(this.Method12584(), this.Field7656, f41.Pre);
            Pyro.Method8978().Method7918(event);
            this.Field7665 = this.Field7656;
            this.Field7656 = event.Method5646();
        }
    }

    @Inject(method={"move"}, at={@Class0(value="INVOKE", target="net/minecraft/entity/Entity.setEntityBoundingBox(Lnet/minecraft/util/math/AxisAlignedBB;)V", ordinal=7, shift=At.Shift.AFTER)})
    private void Method12595(MoverType var1, double x, double y, double z, CallbackInfo info) {
        Entity self = (Entity)this;
        if (self instanceof EntityPlayerSP) {
            f4z event = new f4z(this.Method12584(), this.Field7656, f41.Post);
            Pyro.Method8978().Method7918(event);
        }
    }

    @Inject(method={"move"}, at={@Class0(value="RETURN")})
    private void Method12596(MoverType type, double x, double y, double z, CallbackInfo info) {
        Entity self = (Entity)this;
        if (self instanceof EntityPlayerSP && this.Field7665 != 0.0f) {
            this.Field7656 = this.Field7665;
            this.Field7665 = 0.0f;
        }
    }
}

