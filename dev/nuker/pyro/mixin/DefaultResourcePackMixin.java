/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroClientLoadingPlugin;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DefaultResourcePack.class})
public class DefaultResourcePackMixin {
   @Inject(
      method = {"resourceExists"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void pyroResourcesExist(ResourceLocation location, CallbackInfoReturnable cir) {
      if (location.getResourceDomain().equals("pyro")) {
         try {
            if (Launch.classLoader.getClassBytes("net.minecraft.world.World") != null) {
               cir.setReturnValue(Launch.classLoader.getResourceAsStream(location.getResourcePath()) != null);
            } else {
               cir.setReturnValue(PyroClientLoadingPlugin.resources.containsKey(location.getResourcePath()));
            }
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

   }

   @Inject(
      method = {"getResourceStream"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getPyroResource(ResourceLocation location, CallbackInfoReturnable cir) {
      if (location.getResourceDomain().equals("pyro")) {
         try {
            if (Launch.classLoader.getClassBytes("net.minecraft.world.World") != null) {
               cir.setReturnValue(Launch.classLoader.getResourceAsStream(location.getResourcePath()));
            } else {
               cir.setReturnValue(PyroClientLoadingPlugin.resources.containsKey(location.getResourcePath()) ? new ByteArrayInputStream((byte[])PyroClientLoadingPlugin.resources.get(location.getResourcePath())) : null);
            }
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

   }
}
