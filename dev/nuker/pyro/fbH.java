/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbH {
   // $FF: renamed from: c dev.nuker.pyro.fbH
   field_1608,
   // $FF: renamed from: 0 dev.nuker.pyro.fbH
   field_1609,
   // $FF: renamed from: 1 dev.nuker.pyro.fbH
   field_1610;

   // $FF: renamed from: c dev.nuker.pyro.fbH[]
   public static fbH[] field_1611 = new fbH[]{field_1608 = new fbH("Head", 0), field_1609 = new fbH("Body", 1), field_1610 = new fbH("Feet", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbH
   public static fbH method_2815(String var0) {
      return (fbH)Enum.valueOf(fbH.class, var0);
   }
}
