/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f7l {
   // $FF: renamed from: c dev.nuker.pyro.f7l
   field_1862,
   // $FF: renamed from: 0 dev.nuker.pyro.f7l
   field_1863,
   // $FF: renamed from: 1 dev.nuker.pyro.f7l
   field_1864;

   // $FF: renamed from: c dev.nuker.pyro.f7l[]
   public static f7l[] field_1865 = new f7l[]{field_1862 = new f7l("Off", 0), field_1863 = new f7l("Semi", 1), field_1864 = new f7l("Full", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f7l
   public static f7l method_3031(String var0) {
      return (f7l)Enum.valueOf(f7l.class, var0);
   }
}
