/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f4F;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiScreen.class})
public class GuiScreenMixin {
   @Inject(
      method = {"renderToolTip"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderToolTip(ItemStack stack, int x, int y, CallbackInfo info) {
      f4F event = new f4F(stack, x, y);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }
}
