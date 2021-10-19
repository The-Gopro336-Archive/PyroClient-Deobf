/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fen {
   // $FF: renamed from: c dev.nuker.pyro.fen
   field_1352,
   // $FF: renamed from: 0 dev.nuker.pyro.fen
   field_1353,
   // $FF: renamed from: 1 dev.nuker.pyro.fen
   field_1354;

   // $FF: renamed from: c dev.nuker.pyro.fen[]
   public static fen[] field_1355 = new fen[]{field_1352 = new fen("NONE", 0), field_1353 = new fen("BOX", 1), field_1354 = new fen("WIREFRAME", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fen
   public static fen method_2018(String var0) {
      return (fen)Enum.valueOf(fen.class, var0);
   }
}
