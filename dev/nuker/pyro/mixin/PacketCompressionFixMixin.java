/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.DecoderException
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.NettyCompressionDecoder
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import java.util.List;
import java.util.zip.Inflater;
import net.minecraft.client.Minecraft;
import net.minecraft.network.NettyCompressionDecoder;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value={NettyCompressionDecoder.class})
public class PacketCompressionFixMixin {
    @Shadow
    @Final
    private Inflater Field4311;
    @Shadow
    private int Field4312;

    @Overwrite
    protected void Method5971(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List p_decode_3_) {
        if (p_decode_2_.readableBytes() != 0) {
            PacketBuffer packetbuffer = new PacketBuffer(p_decode_2_);
            int i = packetbuffer.readVarInt();
            if (i == 0) {
                p_decode_3_.add(packetbuffer.readBytes(packetbuffer.readableBytes()));
            } else {
                if (((Boolean)PyroStatic.Field6413.Field5236.Method5264()).booleanValue()) {
                    if ((i < this.Field4312 || i > 0x200000) && Minecraft.getMinecraft().ingameGUI != null) {
                        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("").appendSibling(Pyro.Method8977()).appendSibling((ITextComponent)new TextComponentString("Recieved a bad packet, ignoring")));
                    }
                } else {
                    if (i < this.Field4312) {
                        throw new DecoderException("Badly compressed packet - size of " + i + " is below server threshold of " + this.Field4312);
                    }
                    if (i > 0x200000) {
                        throw new DecoderException("Badly compressed packet - size of " + i + " is larger than protocol maximum of " + 0x200000);
                    }
                }
                byte[] abyte = new byte[packetbuffer.readableBytes()];
                packetbuffer.readBytes(abyte);
                this.Field4311.setInput(abyte);
                byte[] abyte1 = new byte[i];
                this.Field4311.inflate(abyte1);
                p_decode_3_.add(Unpooled.wrappedBuffer((byte[])abyte1));
                this.Field4311.reset();
            }
        }
    }
}

