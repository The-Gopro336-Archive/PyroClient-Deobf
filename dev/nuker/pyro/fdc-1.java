/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fdc {
   // $FF: renamed from: c dev.nuker.pyro.fdc
   field_1296,
   // $FF: renamed from: 0 dev.nuker.pyro.fdc
   field_1297;

   // $FF: renamed from: c dev.nuker.pyro.fdc[]
   public static fdc[] field_1298 = new fdc[]{field_1296 = new fdc("BELOW", 0), field_1297 = new fdc("INLINE", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fdc
   public static fdc method_1981(String var0) {
      return (fdc)Enum.valueOf(fdc.class, var0);
   }
}
