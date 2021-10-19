/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiIngame.class})
public class GuiIngameMixin {
   @Inject(
      method = {"renderVignette"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void dontRenderVignette(float lightLevel, ScaledResolution scaledRes, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2528.c.method_3034()) {
         PyroStatic.field_2528.method_1169(scaledRes);
         ci.cancel();
      } else if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1336().c()) {
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         ci.cancel();
      }

   }

   @Inject(
      method = {"renderPotionEffects"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderPotionEffects(ScaledResolution res, CallbackInfo info) {
      info.cancel();
   }
}
