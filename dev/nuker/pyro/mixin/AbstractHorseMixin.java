/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.entity.passive.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({AbstractHorse.class})
public abstract class AbstractHorseMixin {
   @Inject(
      method = {"getHorseJumpStrength"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getHorseJumpStrength(CallbackInfoReturnable callbackInfoReturnable) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034()) {
         callbackInfoReturnable.setReturnValue(PyroStatic.field_2520.method_281().c());
      }

   }

   @Inject(
      method = {"canBeSteered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void canBeSteered(CallbackInfoReturnable info) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034()) {
         info.cancel();
         info.setReturnValue(true);
      }

   }

   @Inject(
      method = {"isHorseSaddled"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isHorseSaddled(CallbackInfoReturnable info) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034()) {
         info.cancel();
         info.setReturnValue(true);
      }

   }
}
