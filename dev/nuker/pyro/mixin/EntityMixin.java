/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
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
import org.spongepowered.asm.mixin.injection.At$Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Entity.class})
public abstract class EntityMixin {
   @Shadow
   public float rotationPitch;
   @Shadow
   public float rotationYaw;
   @Shadow
   public double posX;
   @Shadow
   public double posY;
   @Shadow
   public double posZ;
   @Shadow
   public double motionX;
   @Shadow
   public double motionY;
   @Shadow
   public double motionZ;
   @Shadow
   public boolean onGround;
   @Shadow
   public boolean collidedHorizontally;
   @Shadow
   public boolean collidedVertically;
   @Shadow
   public boolean collided;
   @Shadow
   protected boolean inPortal;
   @Shadow
   protected Random rand;
   @Shadow
   public boolean isDead;
   @Shadow
   public float stepHeight;
   @Shadow
   public float prevRotationYaw;
   @Shadow
   public float prevRotationPitch;
   @Shadow
   public double lastTickPosX;
   @Shadow
   public double lastTickPosY;
   @Shadow
   public double lastTickPosZ;
   @Shadow
   public double prevPosX;
   @Shadow
   public double prevPosY;
   @Shadow
   public double prevPosZ;
   private float prevStepHeight = 0.0F;

   @Shadow
   public void move(MoverType type, double x, double y, double z) {
   }

   @Shadow
   public abstract boolean isSprinting();

   @Shadow
   public abstract boolean isSneaking();

   @Shadow
   public abstract AxisAlignedBB getEntityBoundingBox();

   @Shadow
   public abstract boolean isRiding();

   @Shadow
   public abstract Entity getRidingEntity();

   @Shadow
   protected abstract boolean getFlag(int var1);

   @Shadow
   public abstract boolean isBeingRidden();

   @Shadow
   public abstract List getPassengers();

   @Shadow
   public void setRotation(float yaw, float pitch) {
   }

   @Shadow
   public abstract void setSneaking(boolean var1);

   @Inject(
      method = {"turn"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void turnFreecam(float yaw, float pitch, CallbackInfo ci) {
      if (this == Minecraft.getMinecraft().player && (Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 && PyroStatic.field_2481.field_775 != null) {
         PyroStatic.field_2481.field_773 = (float)((double)PyroStatic.field_2481.field_773 + (double)yaw * 0.15D);
         PyroStatic.field_2481.field_772 = (float)((double)PyroStatic.field_2481.field_772 - (double)pitch * 0.15D);
         PyroStatic.field_2481.field_773 = MathHelper.wrapDegrees(PyroStatic.field_2481.field_773);
         PyroStatic.field_2481.field_772 = Math.min(90.0F, Math.max(PyroStatic.field_2481.field_772, -90.0F));
         PyroStatic.field_2481.field_775.rotationPitch = PyroStatic.field_2481.field_772;
         PyroStatic.field_2481.field_775.rotationYaw = PyroStatic.field_2481.field_773;
         PyroStatic.field_2481.field_775.rotationYawHead = PyroStatic.field_2481.field_773;
         PyroStatic.field_2481.field_775.prevRotationPitch = PyroStatic.field_2481.field_772;
         PyroStatic.field_2481.field_775.prevRotationYaw = PyroStatic.field_2481.field_773;
         PyroStatic.field_2481.field_775.prevRotationYawHead = PyroStatic.field_2481.field_773;
         ci.cancel();
      }

   }

   @Inject(
      method = {"isGlowing"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void enableEspGlow(CallbackInfoReturnable cir) {
      try {
         if ((Boolean)PyroStatic.field_2498.c.method_3034() && PyroStatic.field_2498.method_974().c() == faV.field_1491 && PyroStatic.field_2498.method_973((Entity)this) != null) {
            cir.setReturnValue(true);
         }
      } catch (Exception var3) {
      }

   }

   @Inject(
      method = {"move"},
      at = {@At(
   value = "FIELD",
   target = "net/minecraft/entity/Entity.onGround:Z",
   ordinal = 1
)}
   )
   private void stepBegin(MoverType type, double x, double y, double z, CallbackInfo info) {
      Entity self = (Entity)this;
      if (self instanceof EntityPlayerSP) {
         f4z event = new f4z(this.getEntityBoundingBox(), this.stepHeight, f41.field_2120);
         Pyro.getEventManager().method_32(event);
         this.prevStepHeight = this.stepHeight;
         this.stepHeight = event.method_3184();
      }

   }

   @Inject(
      method = {"move"},
      at = {@At(
   value = "INVOKE",
   target = "net/minecraft/entity/Entity.setEntityBoundingBox(Lnet/minecraft/util/math/AxisAlignedBB;)V",
   ordinal = 7,
   shift = At$Shift.AFTER
)}
   )
   private void stepEnd(MoverType var1, double x, double y, double z, CallbackInfo info) {
      Entity self = (Entity)this;
      if (self instanceof EntityPlayerSP) {
         f4z event = new f4z(this.getEntityBoundingBox(), this.stepHeight, f41.field_2121);
         Pyro.getEventManager().method_32(event);
      }

   }

   @Inject(
      method = {"move"},
      at = {@At("RETURN")}
   )
   private void resetStepHeight(MoverType type, double x, double y, double z, CallbackInfo info) {
      Entity self = (Entity)this;
      if (self instanceof EntityPlayerSP && this.prevStepHeight != 0.0F) {
         this.stepHeight = this.prevStepHeight;
         this.prevStepHeight = 0.0F;
      }

   }
}
