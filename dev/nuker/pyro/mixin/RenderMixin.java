/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.faV;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Render.class})
public class RenderMixin {
   @Inject(
      method = {"getTeamColor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getEspColor(Entity entityIn, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2498.c.method_3034() && PyroStatic.field_2498.method_974().c() == faV.field_1491) {
         f00 color = PyroStatic.field_2498.method_973(entityIn);
         if (color != null) {
            cir.setReturnValue(color.meth1());
         }
      }

   }

   @Inject(
      method = {"doRenderShadowAndFire"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void doRenderShadowAndFire(CallbackInfo callbackInfo) {
      if (!PyroStatic.field_2498.method_986()) {
         callbackInfo.cancel();
      }

   }

   @Inject(
      method = {"renderLivingLabel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderLivingLabel(CallbackInfo callbackInfo) {
      if (!PyroStatic.field_2498.method_986()) {
         callbackInfo.cancel();
      }

   }
}
