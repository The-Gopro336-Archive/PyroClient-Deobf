/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f8v {
   // $FF: renamed from: c dev.nuker.pyro.f8v
   field_1960,
   // $FF: renamed from: 0 dev.nuker.pyro.f8v
   field_1961,
   // $FF: renamed from: 1 dev.nuker.pyro.f8v
   field_1962,
   // $FF: renamed from: 2 dev.nuker.pyro.f8v
   field_1963;

   // $FF: renamed from: c dev.nuker.pyro.f8v[]
   public static f8v[] field_1964 = new f8v[]{field_1960 = new f8v("MODIFIED", 0), field_1961 = new f8v("TRACES", 1), field_1962 = new f8v("NONMC", 2), field_1963 = new f8v("MODSCAN", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8v
   public static f8v method_3063(String var0) {
      return (f8v)Enum.valueOf(f8v.class, var0);
   }
}
