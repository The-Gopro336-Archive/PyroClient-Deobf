/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f72 {
   // $FF: renamed from: c dev.nuker.pyro.f72
   field_1725,
   // $FF: renamed from: 0 dev.nuker.pyro.f72
   field_1726;

   // $FF: renamed from: c dev.nuker.pyro.f72[]
   public static f72[] field_1727 = new f72[]{field_1725 = new f72("Normal", 0), field_1726 = new f72("AAC", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f72
   public static f72 method_2970(String var0) {
      return (f72)Enum.valueOf(f72.class, var0);
   }
}
