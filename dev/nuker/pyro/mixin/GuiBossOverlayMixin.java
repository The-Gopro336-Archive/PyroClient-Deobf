/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.gui.GuiBossOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiBossOverlay.class})
public class GuiBossOverlayMixin {
   @Inject(
      method = {"renderBossHealth"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void renderBossHealth(CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1330().c()) {
         info.cancel();
      }

   }
}
