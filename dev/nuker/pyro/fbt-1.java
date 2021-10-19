/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fbt {
   // $FF: renamed from: c dev.nuker.pyro.fbt
   field_957,
   // $FF: renamed from: 0 dev.nuker.pyro.fbt
   field_958,
   // $FF: renamed from: 1 dev.nuker.pyro.fbt
   field_959;

   // $FF: renamed from: c dev.nuker.pyro.fbt[]
   public static fbt[] field_960 = new fbt[]{field_957 = new fbt("Off", 0), field_958 = new fbt("Hide", 1), field_959 = new fbt("Remove", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fbt
   public static fbt method_1404(String var0) {
      return (fbt)Enum.valueOf(fbt.class, var0);
   }
}
