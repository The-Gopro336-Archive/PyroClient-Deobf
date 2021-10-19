/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f9U {
   // $FF: renamed from: c dev.nuker.pyro.f9U
   field_1956,
   // $FF: renamed from: 0 dev.nuker.pyro.f9U
   field_1957,
   // $FF: renamed from: 1 dev.nuker.pyro.f9U
   field_1958;

   // $FF: renamed from: c dev.nuker.pyro.f9U[]
   public static f9U[] field_1959 = new f9U[]{field_1956 = new f9U("Legit", 0), field_1957 = new f9U("Rage", 1), field_1958 = new f9U("Instant", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f9U
   public static f9U method_3062(String var0) {
      return (f9U)Enum.valueOf(f9U.class, var0);
   }
}
