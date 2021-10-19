/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f9P {
   // $FF: renamed from: c dev.nuker.pyro.f9P
   field_1906,
   // $FF: renamed from: 0 dev.nuker.pyro.f9P
   field_1907,
   // $FF: renamed from: 1 dev.nuker.pyro.f9P
   field_1908;

   // $FF: renamed from: c dev.nuker.pyro.f9P[]
   public static f9P[] field_1909 = new f9P[]{field_1906 = new f9P("NCP", 0), field_1907 = new f9P("AAC", 1), field_1908 = new f9P("Vanilla", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f9P
   public static f9P method_3051(String var0) {
      return (f9P)Enum.valueOf(f9P.class, var0);
   }
}
