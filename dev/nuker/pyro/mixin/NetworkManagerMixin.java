/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f49;
import dev.nuker.pyro.f4e;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({NetworkManager.class})
public class NetworkManagerMixin {
   @Inject(
      method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void sendPacketPre(Packet packet, CallbackInfo info) {
      f49 event = new f49(packet, f41.field_2120);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
      at = {@At("RETURN")}
   )
   private void sendPacketPost(Packet packet, CallbackInfo callbackInfo) {
      Pyro.getEventManager().method_32(new f49(packet, f41.field_2121));
   }

   @Inject(
      method = {"channelRead0"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void channelReadPre(ChannelHandlerContext context, Packet packet, CallbackInfo info) {
      f4e event = new f4e(packet, f41.field_2120);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"channelRead0"},
      at = {@At("RETURN")}
   )
   private void channelReadPost(ChannelHandlerContext context, Packet packet, CallbackInfo info) {
      f4e event = new f4e(packet, f41.field_2121);
      Pyro.getEventManager().method_32(event);
      if (event.c()) {
         info.cancel();
      }

   }
}
