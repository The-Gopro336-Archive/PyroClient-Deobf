/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderMinecart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderMinecart.class})
public abstract class RenderMinecartMixin {
   @Inject(
      method = {"renderCartContents"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderCartContents(CallbackInfo call) {
      if (!PyroStatic.field_2498.method_986()) {
         call.cancel();
      }

   }
}
