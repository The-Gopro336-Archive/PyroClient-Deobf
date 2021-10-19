/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fb2 {
   // $FF: renamed from: c dev.nuker.pyro.fb2
   field_1471,
   // $FF: renamed from: 0 dev.nuker.pyro.fb2
   field_1472;

   // $FF: renamed from: c dev.nuker.pyro.fb2[]
   public static fb2[] field_1473 = new fb2[]{field_1471 = new fb2("CAMERA", 0), field_1472 = new fb2("PACKET", 1)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fb2
   public static fb2 method_2652(String var0) {
      return (fb2)Enum.valueOf(fb2.class, var0);
   }
}
