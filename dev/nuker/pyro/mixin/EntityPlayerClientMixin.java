/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({AbstractClientPlayer.class})
public class EntityPlayerClientMixin {
   @Inject(
      method = {"isSpectator"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void markFreecamSpectator(CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 && ((Entity)this).getEntityId() == -6969) {
         cir.setReturnValue(true);
      }

   }
}
