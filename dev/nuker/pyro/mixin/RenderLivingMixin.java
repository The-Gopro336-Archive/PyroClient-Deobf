/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderLiving;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderLiving.class})
public class RenderLivingMixin {
   @Inject(
      method = {"renderLeash"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderLeash(CallbackInfo var1) {
      if (!PyroStatic.field_2498.method_986()) {
         var1.cancel();
      }

   }
}
