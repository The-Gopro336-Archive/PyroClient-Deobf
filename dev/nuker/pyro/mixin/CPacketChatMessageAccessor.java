/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Debug(
   export = true,
   print = true
)
@Mixin({CPacketChatMessage.class})
public interface CPacketChatMessageAccessor {
   @Accessor("message")
   String getMessage();

   @Accessor("message")
   void setMessage(String var1);
}
