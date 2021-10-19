/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.class_5;
import dev.nuker.pyro.f4E;
import net.minecraft.client.gui.GuiSubtitleOverlay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiSubtitleOverlay.class})
public abstract class GuiSubtitleOverlayMixin {
   @Inject(
      method = {"renderSubtitles"},
      at = {@At("HEAD")}
   )
   private void renderSubtitles(CallbackInfo callbackInfo) {
      Pyro.eventManager.method_32(new f4E());
      class_5.field_1004.meth3();
   }
}
