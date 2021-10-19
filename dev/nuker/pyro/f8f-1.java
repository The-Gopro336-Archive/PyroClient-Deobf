/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f8f {
   // $FF: renamed from: c dev.nuker.pyro.f8f
   field_1898,
   // $FF: renamed from: 0 dev.nuker.pyro.f8f
   field_1899,
   // $FF: renamed from: 1 dev.nuker.pyro.f8f
   field_1900;

   // $FF: renamed from: c dev.nuker.pyro.f8f[]
   public static f8f[] field_1901 = new f8f[]{field_1898 = new f8f("Store", 0), field_1899 = new f8f("Steal", 1), field_1900 = new f8f("Drop", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8f
   public static f8f method_3049(String var0) {
      return (f8f)Enum.valueOf(f8f.class, var0);
   }
}
