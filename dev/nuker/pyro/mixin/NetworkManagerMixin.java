/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
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
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetworkManager.class})
public class NetworkManagerMixin {
    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method2998(Packet packet, CallbackInfo info) {
        f49 event = new f49(packet, f41.Pre);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@Class0(value="RETURN")})
    private void Method2999(Packet packet, CallbackInfo callbackInfo) {
        Pyro.Method8978().Method7918(new f49(packet, f41.Post));
    }

    @Inject(method={"channelRead0"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3000(ChannelHandlerContext context, Packet packet, CallbackInfo info) {
        f4e event = new f4e(packet, f41.Pre);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }

    @Inject(method={"channelRead0"}, at={@Class0(value="RETURN")})
    private void Method3001(ChannelHandlerContext context, Packet packet, CallbackInfo info) {
        f4e event = new f4e(packet, f41.Post);
        Pyro.Method8978().Method7918(event);
        if (event.Method7947()) {
            info.Method9034();
        }
    }
}

