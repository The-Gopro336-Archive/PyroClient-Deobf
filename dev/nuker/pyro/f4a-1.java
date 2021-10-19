/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.network.Packet;

public class f4a extends f42 {
   // $FF: renamed from: c net.minecraft.network.Packet
   public Packet field_2097;

   public f4a(Packet var1, f41 var2) {
      super(var2);
      this.field_2097 = var1;
   }

   // $FF: renamed from: c () net.minecraft.network.Packet
   public Packet method_3180() {
      return this.field_2097;
   }
}
