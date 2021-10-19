/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.util.math.BlockPos;

public class f31 implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f31
   public static f31 field_2017 = new f31();

   public int run(CommandContext var1) {
      PyroStatic.field_2613.c.method_3033(true);
      NetHandlerPlayClient var10000 = fdZ.field_976.getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketTabComplete("/", (BlockPos)null, false)));
      Pyro.INSTANCE.sendMessage("Discovering plugins...");
      return 0;
   }
}
