/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbj {
   // $FF: renamed from: c dev.nuker.pyro.fbj
   field_1640,
   // $FF: renamed from: 0 dev.nuker.pyro.fbj
   field_1641,
   // $FF: renamed from: 1 dev.nuker.pyro.fbj
   field_1642,
   // $FF: renamed from: 2 dev.nuker.pyro.fbj
   field_1643,
   // $FF: renamed from: 3 dev.nuker.pyro.fbj
   field_1644;

   // $FF: renamed from: c dev.nuker.pyro.fbj[]
   public static fbj[] field_1645 = new fbj[]{field_1640 = new fbj("Glow", 0), field_1641 = new fbj("Outline", 1), field_1642 = new fbj("Filled", 2), field_1643 = new fbj("FilledOutline", 3), field_1644 = new fbj("Flat", 4)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbj
   public static fbj method_2831(String var0) {
      return (fbj)Enum.valueOf(fbj.class, var0);
   }
}
