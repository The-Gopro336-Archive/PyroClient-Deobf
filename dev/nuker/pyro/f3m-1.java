/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import org.jetbrains.annotations.Nullable;

public class f3m implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3m
   public static f3m field_2153 = new f3m();

   public int run(@Nullable CommandContext var1) {
      f3n.field_2175.method_3247(StringArgumentType.getString(var1, "message"));
      NetHandlerPlayClient var10000 = Minecraft.getMinecraft().getConnection();
      if (var10000 != null) {
         var10000.sendPacket((Packet)(new CPacketChatMessage(f3n.field_2175.method_3248())));
      }

      return 0;
   }
}
