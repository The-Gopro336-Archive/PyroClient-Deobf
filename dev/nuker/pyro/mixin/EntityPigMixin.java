/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityPig.class})
public abstract class EntityPigMixin extends EntityAnimalMixin {
   @Shadow
   private boolean boosting;
   @Shadow
   private int boostTime;
   @Shadow
   private int totalBoostTime;

   @Inject(
      method = {"canBeSteered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void overCanBeSteered(CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034()) {
         callback.setReturnValue(true);
      }

   }

   @Inject(
      method = {"travel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void travel(float strafe, float vertical, float forward, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034() && (Boolean)PyroStatic.field_2520.method_282().c()) {
         info.cancel();
         Entity entity = this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
         if (this.isBeingRidden() && this.canBeSteered()) {
            this.rotationYaw = entity.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.rotationYaw;
            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
            if (this.boosting && this.boostTime++ > this.totalBoostTime) {
               this.boosting = false;
            }

            if (this.canPassengerSteer()) {
               float f = (float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225F;
               if (this.boosting) {
                  f += f * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * 3.1415927F);
               }

               this.setAIMoveSpeed(f);
            } else {
               this.motionX = 0.0D;
               this.motionY = 0.0D;
               this.motionZ = 0.0D;
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double d1 = this.posX - this.prevPosX;
            double d0 = this.posZ - this.prevPosZ;
            float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
            if (f1 > 1.0F) {
               f1 = 1.0F;
            }

            this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
         } else {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.travel(strafe, vertical, forward);
         }
      }

   }
}
