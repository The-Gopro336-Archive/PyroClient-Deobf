/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.renderer.tileentity.TileEntitySignRenderer;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({TileEntitySignRenderer.class})
public class TileEntitySignRendererMixin {
   @Redirect(
      method = {"render"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/util/text/ITextComponent;getFormattedText()Ljava/lang/String;"
)
   )
   private String getSignText(ITextComponent iTextComponent) {
      return (Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1326().c() ? "" : iTextComponent.getFormattedText();
   }
}
