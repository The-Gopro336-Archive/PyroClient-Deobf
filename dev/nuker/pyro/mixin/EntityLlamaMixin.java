/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityLlama.class, EntityPig.class})
public class EntityLlamaMixin {
   @Inject(
      method = {"canBeSteered"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void canBeSteered(CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2520.c.method_3034()) {
         callback.setReturnValue(true);
      }

   }
}
