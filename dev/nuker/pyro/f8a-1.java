/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f8a {
   // $FF: renamed from: c dev.nuker.pyro.f8a
   field_1882,
   // $FF: renamed from: 0 dev.nuker.pyro.f8a
   field_1883;

   // $FF: renamed from: c dev.nuker.pyro.f8a[]
   public static f8a[] field_1884 = new f8a[]{field_1882 = new f8a("Random", 0), field_1883 = new f8a("Ordered", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8a
   public static f8a method_3041(String var0) {
      return (f8a)Enum.valueOf(f8a.class, var0);
   }
}
