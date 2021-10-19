/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
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
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({NettyCompressionDecoder.class})
public class PacketCompressionFixMixin {
   @Shadow
   @Final
   private Inflater inflater;
   @Shadow
   private int threshold;

   @Overwrite
   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List p_decode_3_) {
      if (p_decode_2_.readableBytes() != 0) {
         PacketBuffer packetbuffer = new PacketBuffer(p_decode_2_);
         int i = packetbuffer.readVarInt();
         if (i == 0) {
            p_decode_3_.add(packetbuffer.readBytes(packetbuffer.readableBytes()));
         } else {
            if ((Boolean)PyroStatic.field_2477.c.method_3034()) {
               if ((i < this.threshold || i > 2097152) && Minecraft.getMinecraft().ingameGUI != null) {
                  Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((new TextComponentString("")).appendSibling(Pyro.getPrefix()).appendSibling(new TextComponentString("Recieved a bad packet, ignoring")));
               }
            } else {
               if (i < this.threshold) {
                  throw new DecoderException("Badly compressed packet - size of " + i + " is below server threshold of " + this.threshold);
               }

               if (i > 2097152) {
                  throw new DecoderException("Badly compressed packet - size of " + i + " is larger than protocol maximum of " + 2097152);
               }
            }

            byte[] abyte = new byte[packetbuffer.readableBytes()];
            packetbuffer.readBytes(abyte);
            this.inflater.setInput(abyte);
            byte[] abyte1 = new byte[i];
            this.inflater.inflate(abyte1);
            p_decode_3_.add(Unpooled.wrappedBuffer(abyte1));
            this.inflater.reset();
         }
      }

   }
}
