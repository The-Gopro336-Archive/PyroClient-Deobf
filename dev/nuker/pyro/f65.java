/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f65 {
   // $FF: renamed from: c dev.nuker.pyro.f65
   field_2194,
   // $FF: renamed from: 0 dev.nuker.pyro.f65
   field_2195,
   // $FF: renamed from: 1 dev.nuker.pyro.f65
   field_2196;

   // $FF: renamed from: c dev.nuker.pyro.f65[]
   public static f65[] field_2197 = new f65[]{field_2194 = new f65("NONE", 0), field_2195 = new f65("CLIENTSIDE", 1), field_2196 = new f65("SERVERSIDE", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f65
   public static f65 method_3271(String var0) {
      return (f65)Enum.valueOf(f65.class, var0);
   }
}
