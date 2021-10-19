/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbG {
   // $FF: renamed from: c dev.nuker.pyro.fbG
   field_1603,
   // $FF: renamed from: 0 dev.nuker.pyro.fbG
   field_1604,
   // $FF: renamed from: 1 dev.nuker.pyro.fbG
   field_1605,
   // $FF: renamed from: 2 dev.nuker.pyro.fbG
   field_1606;

   // $FF: renamed from: c dev.nuker.pyro.fbG[]
   public static fbG[] field_1607 = new fbG[]{field_1603 = new fbG("Off", 0), field_1604 = new fbG("Outline", 1), field_1605 = new fbG("Fill", 2), field_1606 = new fbG("Stem", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbG
   public static fbG method_2814(String var0) {
      return (fbG)Enum.valueOf(fbG.class, var0);
   }
}
