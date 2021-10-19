/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({GuiPlayerTabOverlay.class})
public interface GuiPlayerTabOverlayAccessor {
   @Accessor("footer")
   ITextComponent getFooter();

   @Accessor("header")
   ITextComponent getHeader();

   @Accessor("lastTimeOpened")
   long getLastTimeOpened();
}
