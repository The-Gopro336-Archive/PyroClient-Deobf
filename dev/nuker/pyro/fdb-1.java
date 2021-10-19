/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum fdb {
   // $FF: renamed from: c dev.nuker.pyro.fdb
   field_1302,
   // $FF: renamed from: 0 dev.nuker.pyro.fdb
   field_1303,
   // $FF: renamed from: 1 dev.nuker.pyro.fdb
   field_1304,
   // $FF: renamed from: 2 dev.nuker.pyro.fdb
   field_1305,
   // $FF: renamed from: 3 dev.nuker.pyro.fdb
   field_1306;

   // $FF: renamed from: c dev.nuker.pyro.fdb[]
   public static fdb[] field_1307 = new fdb[]{field_1302 = new fdb("Creative", 0), field_1303 = new fdb("Survival", 1), field_1304 = new fdb("Selective", 2), field_1305 = new fdb("Farm", 3), field_1306 = new fdb("Lawnmower", 4)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fdb
   public static fdb method_1985(String var0) {
      return (fdb)Enum.valueOf(fdb.class, var0);
   }
}
