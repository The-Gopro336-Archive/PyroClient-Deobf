/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f48;
import dev.nuker.pyro.f4m;
import dev.nuker.pyro.f4n;
import dev.nuker.pyro.f4s;
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
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityLivingBase.class})
public abstract class EntityLivingBaseMixin extends EntityMixin {
   @Shadow
   public int deathTime;
   @Shadow
   public float renderYawOffset;
   @Shadow
   public float prevRenderYawOffset;
   @Shadow
   public float rotationYawHead;
   @Shadow
   public float prevRotationYawHead;
   @Shadow
   public float jumpMovementFactor;
   @Shadow
   public float prevLimbSwingAmount;
   @Shadow
   public float limbSwingAmount;
   @Shadow
   public float limbSwing;
   private boolean changeMovResult = false;
   private float lastPitch = 0.0F;
   private float lastYaw = 0.0F;

   @Shadow
   public void travel(float strafe, float vertical, float forward) {
   }

   @Shadow
   public abstract float getAIMoveSpeed();

   @Shadow
   public abstract IAttributeInstance getEntityAttribute(IAttribute var1);

   @Inject(
      method = {"travel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onTravel(float strafe, float vertical, float forward, CallbackInfo ci) {
      if (this == Minecraft.getMinecraft().player) {
         f4s travelEvent = new f4s();
         Pyro.getEventManager().method_32(travelEvent);
         if (travelEvent.c()) {
            Minecraft.getMinecraft().player.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            ci.cancel();
         }

         EntityPlayer player = (EntityPlayer)this;
         this.lastPitch = player.rotationPitch;
         this.lastYaw = player.rotationYaw;
         if (Pyro.getRotationManager().method_3462() != -1337.0F) {
            player.rotationPitch = Pyro.getRotationManager().method_3462();
         }

         if (Pyro.getRotationManager().method_3459() != -1337.0F) {
            player.rotationYaw = Pyro.getRotationManager().method_3459();
         }
      }

   }

   @Inject(
      method = {"travel"},
      at = {@At("RETURN")}
   )
   private void revertRotations(float strafe, float vertical, float forward, CallbackInfo ci) {
      if (this == Minecraft.getMinecraft().player) {
         EntityPlayer player = (EntityPlayer)this;
         if (Pyro.getRotationManager().method_3462() != -1337.0F) {
            player.rotationPitch = this.lastPitch;
         }

         if (Pyro.getRotationManager().method_3459() != -1337.0F) {
            player.rotationYaw = this.lastYaw;
         }
      }

   }

   @Redirect(
      method = {"travel"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/util/math/MathHelper;cos(F)F",
   ordinal = 0
)
   )
   private float newCos(float value) {
      return (float)Math.cos(this == Minecraft.getMinecraft().player && Pyro.getRotationManager().method_3462() != -1337.0F ? (double)(Pyro.getRotationManager().method_3462() * 0.017453292F) : (double)value);
   }

   @Inject(
      method = {"isElytraFlying"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void modifyCheckFlight(CallbackInfoReturnable cir) {
      if (this.changeMovResult) {
         this.changeMovResult = false;
         cir.setReturnValue(false);
      } else {
         if (this == Minecraft.getMinecraft().player) {
            f4m event = new f4m(this.getFlag(7));
            Pyro.getEventManager().method_32(event);
            if (event.c()) {
               cir.setReturnValue(event.method_3145());
            }
         }

      }
   }

   @Inject(
      method = {"isPotionActive"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isPotionActive(Potion potionIn, CallbackInfoReturnable cir) {
      if (potionIn == MobEffects.BLINDNESS && (Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1324().c()) {
         cir.setReturnValue(false);
      }

   }

   @Inject(
      method = {"onDeathUpdate"},
      at = {@At("HEAD")}
   )
   private void setDead(CallbackInfo info) {
      if (this.deathTime == 19 && !this.isDead && (Entity)this instanceof EntityPlayer) {
         Pyro.getEventManager().method_32(new f48((Entity)this));
      }

   }

   @Inject(
      method = {"onItemUseFinish"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void onItemUseFinish(CallbackInfo info) {
      f4n event = new f4n();
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }
}
