/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f3n;
import dev.nuker.pyro.f4j;
import dev.nuker.pyro.mixin.CPacketChatMessageAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetHandlerPlayClient.class})
public class NetHandlerPlayClientMixin {
    @Shadow
    private Minecraft Field2728;
    @Shadow
    private WorldClient Field2729;

    @Inject(method={"sendPacket"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method4548(Packet packetIn, CallbackInfo ci) {
        if (packetIn instanceof CPacketChatMessage) {
            String message = ((CPacketChatMessageAccessor)packetIn).Method1802();
            if (!message.equals(f3n.Field4075.Method5728())) {
                f4j event = new f4j(message);
                Pyro.Method8978().Method7918(event);
                message = event.Method5798();
                if (message.length() > 256) {
                    message = message.substring(0, 256);
                }
                if (!event.Method7947()) {
                    ((CPacketChatMessageAccessor)packetIn).Method1803(message);
                } else {
                    ci.Method9034();
                }
            } else {
                f3n.Field4075.Method5727(null);
            }
        }
    }
}

