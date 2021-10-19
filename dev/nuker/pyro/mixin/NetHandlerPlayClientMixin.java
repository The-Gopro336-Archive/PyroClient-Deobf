/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f3n;
import dev.nuker.pyro.f4j;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({NetHandlerPlayClient.class})
public class NetHandlerPlayClientMixin {
   @Shadow
   private Minecraft gameController;
   @Shadow
   private WorldClient clientWorldController;

   @Inject(
      method = {"sendPacket"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void processPacket(Packet packetIn, CallbackInfo ci) {
      if (packetIn instanceof CPacketChatMessage) {
         String message = ((CPacketChatMessageAccessor)packetIn).getMessage();
         if (!message.equals(f3n.field_2175.method_3248())) {
            f4j event = new f4j(message);
            Pyro.getEventManager().method_32(event);
            message = event.method_3112();
            if (message.length() > 256) {
               message = message.substring(0, 256);
            }

            if (!event.c()) {
               ((CPacketChatMessageAccessor)packetIn).setMessage(message);
            } else {
               ci.cancel();
            }
         } else {
            f3n.field_2175.method_3247((String)null);
         }
      }

   }
}
