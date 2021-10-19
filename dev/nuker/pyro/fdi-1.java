/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fdi {
   // $FF: renamed from: c dev.nuker.pyro.fdi
   field_1315,
   // $FF: renamed from: 0 dev.nuker.pyro.fdi
   field_1316,
   // $FF: renamed from: 1 dev.nuker.pyro.fdi
   field_1317,
   // $FF: renamed from: 2 dev.nuker.pyro.fdi
   field_1318;

   // $FF: renamed from: c dev.nuker.pyro.fdi[]
   public static fdi[] field_1319 = new fdi[]{field_1315 = new fdi("Normal", 0), field_1316 = new fdi("NCP", 1), field_1317 = new fdi("Hypixel", 2), field_1318 = new fdi("Instant", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fdi
   public static fdi method_1989(String var0) {
      return (fdi)Enum.valueOf(fdi.class, var0);
   }
}
