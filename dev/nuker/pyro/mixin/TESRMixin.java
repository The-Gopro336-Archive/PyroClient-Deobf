/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({TileEntitySpecialRenderer.class})
public class TESRMixin {
   @Inject(
      method = {"isGlobalRenderer"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void espGlobalRender(TileEntity te, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2498.c.method_3034() && PyroStatic.field_2498.method_995(te) && (Boolean)PyroStatic.field_2498.method_979().c()) {
         cir.setReturnValue(true);
      }

   }
}
