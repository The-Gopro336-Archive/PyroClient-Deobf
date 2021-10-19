/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f8B {
   // $FF: renamed from: c dev.nuker.pyro.f8B
   field_1826,
   // $FF: renamed from: 0 dev.nuker.pyro.f8B
   field_1827,
   // $FF: renamed from: 1 dev.nuker.pyro.f8B
   field_1828;

   // $FF: renamed from: c dev.nuker.pyro.f8B[]
   public static f8B[] field_1829 = new f8B[]{field_1826 = new f8B("File", 0), field_1827 = new f8B("Ban", 1), field_1828 = new f8B("Random", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8B
   public static f8B method_3011(String var0) {
      return (f8B)Enum.valueOf(f8B.class, var0);
   }
}
