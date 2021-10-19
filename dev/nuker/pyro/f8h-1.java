/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public enum f8h {
   // $FF: renamed from: c dev.nuker.pyro.f8h
   field_1890,
   // $FF: renamed from: 0 dev.nuker.pyro.f8h
   field_1891,
   // $FF: renamed from: 1 dev.nuker.pyro.f8h
   field_1892;

   // $FF: renamed from: c dev.nuker.pyro.f8h[]
   public static f8h[] field_1893 = new f8h[]{field_1890 = new f8h("Smart", 0, new Regex(".*-?[0-9]+( +|(,| *[xyz] *[:=]? *) *)-?[0-9]+.*")), field_1891 = new f8h("Strict", 1, new Regex(".*-?[0-9].+-?[0-9].*")), field_1892 = new f8h("Basic", 2, new Regex(".*-?[0-9] -?[0-9].*"))};
   // $FF: renamed from: c kotlin.text.Regex
   @NotNull
   public Regex field_1894;

   // $FF: renamed from: c () kotlin.text.Regex
   @NotNull
   public Regex method_3044() {
      return this.field_1894;
   }

   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.f8h
   public static f8h method_3045(String var0) {
      return (f8h)Enum.valueOf(f8h.class, var0);
   }

   public f8h(Regex var3) {
      this.field_1894 = var3;
   }
}
