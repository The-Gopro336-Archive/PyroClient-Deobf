/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f4H;
import dev.nuker.pyro.f4I;
import dev.nuker.pyro.fbY;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({World.class})
public class WorldMixin {
   @Inject(
      method = {"onEntityAdded"},
      at = {@At("HEAD")}
   )
   private void onEntityAdded(Entity entityIn, CallbackInfo info) {
      Pyro.getEventManager().method_32(new f4H(entityIn));
   }

   @Inject(
      method = {"onEntityRemoved"},
      at = {@At("RETURN")}
   )
   private void onEntityRemoved(Entity entityIn, CallbackInfo info) {
      Pyro.getEventManager().method_32(new f4I(entityIn));
   }

   @Inject(
      method = {"checkLightFor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void checkLightFor(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1335().c()) {
         callback.cancel();
         callback.setReturnValue(true);
      }

   }

   @Inject(
      method = {"getRainStrength"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void spoofWeatherRain(float delta, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2505.c.method_3034()) {
         cir.setReturnValue(PyroStatic.field_2505.method_1034().c() == fbY.field_1625 ? 0.0F : 1.0F);
      }

   }

   @Inject(
      method = {"getThunderStrength"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void spoofWeatherThunder(float delta, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2505.c.method_3034()) {
         cir.setReturnValue(PyroStatic.field_2505.method_1034().c() == fbY.field_1627 ? 1.0F : 0.0F);
      }

   }

   @Inject(
      method = {"getSkyColor"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void getSkyColor(Entity entityIn, float partialTicks, CallbackInfoReturnable callback) {
      if ((Boolean)PyroStatic.field_2585.c.method_3034()) {
         callback.setReturnValue(PyroStatic.field_2585.method_1079());
      }

   }
}
