/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f7f {
   // $FF: renamed from: c dev.nuker.pyro.f7f
   field_1833,
   // $FF: renamed from: 0 dev.nuker.pyro.f7f
   field_1834;

   // $FF: renamed from: c dev.nuker.pyro.f7f[]
   public static f7f[] field_1835 = new f7f[]{field_1833 = new f7f("Tunnel", 0), field_1834 = new f7f("Nearby", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f7f
   public static f7f method_3013(String var0) {
      return (f7f)Enum.valueOf(f7f.class, var0);
   }
}
