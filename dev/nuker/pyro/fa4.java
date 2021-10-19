/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fa4 {
   // $FF: renamed from: c dev.nuker.pyro.fa4
   field_1443,
   // $FF: renamed from: 0 dev.nuker.pyro.fa4
   field_1444,
   // $FF: renamed from: 1 dev.nuker.pyro.fa4
   field_1445;

   // $FF: renamed from: c dev.nuker.pyro.fa4[]
   public static fa4[] field_1446 = new fa4[]{field_1443 = new fa4("REACHED_GOAL", 0), field_1444 = new fa4("TIMEOUT", 1), field_1445 = new fa4("UNLOADED_CHUNKS", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fa4
   public static fa4 method_2612(String var0) {
      return (fa4)Enum.valueOf(fa4.class, var0);
   }
}
