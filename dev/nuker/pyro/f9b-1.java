/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f9b {
   // $FF: renamed from: c dev.nuker.pyro.f9b
   field_1966,
   // $FF: renamed from: 0 dev.nuker.pyro.f9b
   field_1967,
   // $FF: renamed from: 1 dev.nuker.pyro.f9b
   field_1968,
   // $FF: renamed from: 2 dev.nuker.pyro.f9b
   field_1969;

   // $FF: renamed from: c dev.nuker.pyro.f9b[]
   public static f9b[] field_1970 = new f9b[]{field_1966 = new f9b("Ignore", 0), field_1967 = new f9b("Frequency", 1), field_1968 = new f9b("Distance", 2), field_1969 = new f9b("Both", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f9b
   public static f9b method_3064(String var0) {
      return (f9b)Enum.valueOf(f9b.class, var0);
   }
}
