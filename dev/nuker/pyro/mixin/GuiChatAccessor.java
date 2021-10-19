/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.gui.GuiChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({GuiChat.class})
public interface GuiChatAccessor {
   @Accessor("sentHistoryCursor")
   int getHistoryCursor();

   @Accessor("sentHistoryCursor")
   void setHistoryCursor(int var1);

   @Accessor("historyBuffer")
   void setHistoryBuffer(String var1);
}
