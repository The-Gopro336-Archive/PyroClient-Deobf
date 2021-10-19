/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum mode {
   packet,
   // $FF: renamed from: 0 dev.nuker.pyro.mode
   field_1409,
   // $FF: renamed from: 1 dev.nuker.pyro.mode
   field_1410,
   // $FF: renamed from: 2 dev.nuker.pyro.mode
   field_1411;

   // $FF: renamed from: c dev.nuker.pyro.mode[]
   public static mode[] field_1412 = new mode[]{packet = new mode("Packet", 0), field_1409 = new mode("Jump", 1), field_1410 = new mode("Mini", 2), field_1411 = new mode("OldNCP", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.mode
   public static mode method_2600(String var0) {
      return (mode)Enum.valueOf(mode.class, var0);
   }
}
