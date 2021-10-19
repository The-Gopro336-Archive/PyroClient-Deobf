/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fdS {
   // $FF: renamed from: c dev.nuker.pyro.fdS
   field_1236,
   // $FF: renamed from: 0 dev.nuker.pyro.fdS
   field_1237,
   // $FF: renamed from: 1 dev.nuker.pyro.fdS
   field_1238,
   // $FF: renamed from: 2 dev.nuker.pyro.fdS
   field_1239;

   // $FF: renamed from: c dev.nuker.pyro.fdS[]
   public static fdS[] field_1240 = new fdS[]{field_1236 = new fdS("NONE", 0), field_1237 = new fdS("CLIENT", 1), field_1238 = new fdS("SERVER", 2), field_1239 = new fdS("SWAPBACK", 3)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fdS
   public static fdS method_1893(String var0) {
      return (fdS)Enum.valueOf(fdS.class, var0);
   }
}
