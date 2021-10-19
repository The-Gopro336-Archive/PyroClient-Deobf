/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbM {
   // $FF: renamed from: c dev.nuker.pyro.fbM
   field_1615(0.0F, 0.0F),
   // $FF: renamed from: 0 dev.nuker.pyro.fbM
   field_1616(1.5F, 0.05F),
   // $FF: renamed from: 1 dev.nuker.pyro.fbM
   field_1617(0.5F, 0.05F),
   // $FF: renamed from: 2 dev.nuker.pyro.fbM
   field_1618(0.7F, 0.07F),
   // $FF: renamed from: 3 dev.nuker.pyro.fbM
   field_1619(1.5F, 0.04F),
   // $FF: renamed from: 4 dev.nuker.pyro.fbM
   field_1620(1.5F, 0.03F);

   // $FF: renamed from: c float
   public float field_1621;
   // $FF: renamed from: 0 float
   public float field_1622;
   // $FF: renamed from: c dev.nuker.pyro.fbM[]
   public static fbM[] field_1623 = new fbM[]{field_1615, field_1616, field_1617, field_1618, field_1619, field_1620};

   public fbM(float var3, float var4) {
      this.field_1621 = var3;
      this.field_1622 = var4;
   }

   // $FF: renamed from: c () float
   public float method_2819() {
      return this.field_1622;
   }

   // $FF: renamed from: 0 () float
   public float method_2820() {
      return this.field_1621;
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbM
   public static fbM method_2821(String var0) {
      return (fbM)Enum.valueOf(fbM.class, var0);
   }
}
