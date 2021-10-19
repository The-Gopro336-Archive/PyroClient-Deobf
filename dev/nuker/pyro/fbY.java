/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbY {
   // $FF: renamed from: c dev.nuker.pyro.fbY
   field_1625,
   // $FF: renamed from: 0 dev.nuker.pyro.fbY
   field_1626,
   // $FF: renamed from: 1 dev.nuker.pyro.fbY
   field_1627;

   // $FF: renamed from: c dev.nuker.pyro.fbY[]
   public static fbY[] field_1628 = new fbY[]{field_1625 = new fbY("Clear", 0), field_1626 = new fbY("Rain", 1), field_1627 = new fbY("Thunder", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbY
   public static fbY method_2822(String var0) {
      return (fbY)Enum.valueOf(fbY.class, var0);
   }
}
