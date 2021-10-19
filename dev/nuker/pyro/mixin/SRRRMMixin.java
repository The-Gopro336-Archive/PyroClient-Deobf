/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import java.util.Map;
import net.minecraft.client.resources.FallbackResourceManager;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({SimpleReloadableResourceManager.class})
public class SRRRMMixin {
   @Shadow
   @Final
   private Map domainResourceManagers;

   @Inject(
      method = {"getResource"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void setPyroMCNamespace(ResourceLocation location, CallbackInfoReturnable cir) {
      if (location.getResourceDomain().equals("pyro")) {
         cir.setReturnValue(((FallbackResourceManager)this.domainResourceManagers.get("minecraft")).getResource(location));
      }

   }
}
