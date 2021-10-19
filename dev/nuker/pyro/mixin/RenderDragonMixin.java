/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderDragon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderDragon.class})
public abstract class RenderDragonMixin {
   @Inject(
      method = {"renderCrystalBeams"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void renderCrystalBeams(double var0, double var2, double var4, float var6, double var7, double var9, double var11, int var13, double var14, double var16, double var18, CallbackInfo var20) {
      if (!PyroStatic.field_2498.method_986()) {
         var20.cancel();
      }

   }
}
