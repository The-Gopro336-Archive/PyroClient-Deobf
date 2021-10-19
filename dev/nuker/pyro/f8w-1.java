/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f8w {
   // $FF: renamed from: c dev.nuker.pyro.f8w
   field_1944,
   // $FF: renamed from: 0 dev.nuker.pyro.f8w
   field_1945,
   // $FF: renamed from: 1 dev.nuker.pyro.f8w
   field_1946,
   // $FF: renamed from: 2 dev.nuker.pyro.f8w
   field_1947;

   // $FF: renamed from: c dev.nuker.pyro.f8w[]
   public static f8w[] field_1948 = new f8w[]{field_1944 = new f8w("UNCHANGED", 0), field_1945 = new f8w("ADDED", 1), field_1946 = new f8w("REMOVED", 2), field_1947 = new f8w("MODIFIED", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8w
   public static f8w method_3060(String var0) {
      return (f8w)Enum.valueOf(f8w.class, var0);
   }
}
