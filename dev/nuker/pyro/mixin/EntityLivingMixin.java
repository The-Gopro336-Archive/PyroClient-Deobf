/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.entity.EntityLiving;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({EntityLiving.class})
public abstract class EntityLivingMixin extends EntityLivingBaseMixin {
   @Shadow
   public abstract boolean canPassengerSteer();

   @Shadow
   public abstract boolean canBeSteered();

   @Shadow
   public void setAIMoveSpeed(float speedIn) {
   }
}
