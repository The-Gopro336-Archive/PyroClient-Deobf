/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public enum f6p {
   // $FF: renamed from: c dev.nuker.pyro.f6p
   field_1780,
   // $FF: renamed from: 0 dev.nuker.pyro.f6p
   field_1781,
   // $FF: renamed from: 1 dev.nuker.pyro.f6p
   field_1782;

   // $FF: renamed from: c dev.nuker.pyro.f6p[]
   public static f6p[] field_1783 = new f6p[]{field_1780 = new f6p("Auto", 0), field_1781 = new f6p("None", 1), field_1782 = new f6p("Packet", 2)};

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f6p
   public static f6p method_3001(String var0) {
      return (f6p)Enum.valueOf(f6p.class, var0);
   }
}
