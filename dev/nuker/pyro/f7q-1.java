/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketKeepAlive;

public class f7q implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f7r
   public f7r field_1850;

   public void accept(Object var1) {
      this.method_3021((CPacketKeepAlive)var1);
   }

   public f7q(f7r var1) {
      this.field_1850 = var1;
      super();
   }

   // $FF: renamed from: c (net.minecraft.network.play.client.CPacketKeepAlive) void
   public void method_3021(CPacketKeepAlive var1) {
      f7r.method_522(this.field_1850).player.connection.sendPacket((Packet)var1);
   }
}
