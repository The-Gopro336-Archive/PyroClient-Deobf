/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbV {
   // $FF: renamed from: c dev.nuker.pyro.fbV
   field_1629,
   // $FF: renamed from: 0 dev.nuker.pyro.fbV
   field_1630;

   // $FF: renamed from: c dev.nuker.pyro.fbV[]
   public static fbV[] field_1631 = new fbV[]{field_1629 = new fbV("Coords", 0), field_1630 = new fbV("Distance", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbV
   public static fbV method_2823(String var0) {
      return (fbV)Enum.valueOf(fbV.class, var0);
   }
}
