/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import io.netty.channel.Channel;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

// $FF: renamed from: dev.nuker.pyro.fg
public class class_54 extends NetworkManager {
   public class_54(EnumPacketDirection var1) {
      super(var1);
   }

   // $FF: renamed from: c () io.netty.channel.Channel
   public Channel method_4064() {
      return new class_58(this);
   }
}
