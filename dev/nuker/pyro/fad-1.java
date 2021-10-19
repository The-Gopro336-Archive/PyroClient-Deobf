/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fad {
   // $FF: renamed from: c dev.nuker.pyro.fad
   field_1598,
   // $FF: renamed from: 0 dev.nuker.pyro.fad
   field_1599,
   // $FF: renamed from: 1 dev.nuker.pyro.fad
   field_1600;

   // $FF: renamed from: c dev.nuker.pyro.fad[]
   public static fad[] field_1601 = new fad[]{field_1598 = new fad("Packet", 0), field_1599 = new fad("Spin", 1), field_1600 = new fad("Off", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fad
   public static fad method_2813(String var0) {
      return (fad)Enum.valueOf(fad.class, var0);
   }
}
