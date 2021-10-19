/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f7m {
   // $FF: renamed from: c dev.nuker.pyro.f7m
   field_1866,
   // $FF: renamed from: 0 dev.nuker.pyro.f7m
   field_1867,
   // $FF: renamed from: 1 dev.nuker.pyro.f7m
   field_1868,
   // $FF: renamed from: 2 dev.nuker.pyro.f7m
   field_1869;

   // $FF: renamed from: c dev.nuker.pyro.f7m[]
   public static f7m[] field_1870 = new f7m[]{field_1866 = new f7m("Down", 0), field_1867 = new f7m("Up", 1), field_1868 = new f7m("Preserve", 2), field_1869 = new f7m("Bounds", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f7m
   public static f7m method_3032(String var0) {
      return (f7m)Enum.valueOf(f7m.class, var0);
   }
}
