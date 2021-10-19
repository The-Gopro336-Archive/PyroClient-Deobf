/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fdZ;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityBoat.class})
public abstract class EntityBoatMixin extends EntityMixin {
   private boolean boatflyEnabled() {
      return (Boolean)PyroStatic.field_2582.c.method_3034();
   }

   @Shadow
   public abstract double getMountedYOffset();

   @Inject(
      method = {"updateMotion"},
      at = {@At("RETURN")}
   )
   private void updateMotion(CallbackInfo info) {
      if (fdZ.field_976.player != null && fdZ.field_976.player.isRiding() && (EntityBoat)this == fdZ.field_976.player.getRidingEntity() && this.boatflyEnabled()) {
         PyroStatic.field_2582.method_271();
      }

   }

   @Inject(
      method = {"applyOrientationToEntity"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void applyOrientationToEntity(Entity passenger, CallbackInfo info) {
      if (fdZ.field_976.player != null && fdZ.field_976.player.isRiding() && fdZ.field_976.player == passenger && this.boatflyEnabled()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"controlBoat"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void controlBoat(CallbackInfo info) {
      if (fdZ.field_976.player != null && fdZ.field_976.player.isRiding() && (EntityBoat)this == fdZ.field_976.player.getRidingEntity() && this.boatflyEnabled()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"updatePassenger"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void updatePassenger(Entity passenger, CallbackInfo info) {
      if (fdZ.field_976.player != null && fdZ.field_976.player.isRiding() && fdZ.field_976.player == passenger && this.boatflyEnabled()) {
         info.cancel();
         float f = 0.0F;
         float f1 = (float)((this.isDead ? 0.009999999776482582D : this.getMountedYOffset()) + passenger.getYOffset());
         Vec3d vec3d = (new Vec3d((double)f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * 0.017453292F - 1.5707964F);
         passenger.setPosition(this.posX + vec3d.x, this.posY + (double)f1, this.posZ + vec3d.z);
      }

   }
}
