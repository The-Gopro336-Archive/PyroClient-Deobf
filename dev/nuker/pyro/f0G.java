/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f0G {
   // $FF: renamed from: c dev.nuker.pyro.f0G
   field_2325,
   // $FF: renamed from: 0 dev.nuker.pyro.f0G
   field_2326,
   // $FF: renamed from: 1 dev.nuker.pyro.f0G
   field_2327;

   // $FF: renamed from: c dev.nuker.pyro.f0G[]
   public static f0G[] field_2328 = new f0G[]{field_2325 = new f0G("LEFT", 0), field_2326 = new f0G("RIGHT", 1), field_2327 = new f0G("CENTER", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f0G
   public static f0G method_3486(String var0) {
      return (f0G)Enum.valueOf(f0G.class, var0);
   }
}
