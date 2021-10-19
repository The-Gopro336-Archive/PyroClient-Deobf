/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.entity.RenderGuardian;
import net.minecraft.entity.monster.EntityGuardian;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderGuardian.class})
public abstract class RenderGuardianMixin {
   @Inject(
      method = {"doRender"},
      at = {@At(
   value = "INVOKE",
   target = "net/minecraft/entity/monster/EntityGuardian.getAttackAnimationScale(F)F"
)},
      cancellable = true
   )
   private void f$E(EntityGuardian entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo callbackInfo) {
      if (!PyroStatic.field_2498.method_986()) {
         callbackInfo.cancel();
      }

   }
}
