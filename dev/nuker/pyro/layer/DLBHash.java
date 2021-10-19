/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.layer;

import java.nio.ByteBuffer;

public class DLBHash {
   public static DLBHash INSTANCE;

   static {
      DLBHash var0 = new DLBHash();
      INSTANCE = var0;
   }

   public byte[] get() {
      return ByteBuffer.allocate(16).putInt(-1172281222).putInt(327996254).putInt(-361805921).putInt(-625156042).array();
   }
}
