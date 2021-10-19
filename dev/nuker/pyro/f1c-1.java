/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;

public class f1c implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f11
   public f11 field_1977;
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_1978;

   public f1c(f11 var1, f0o var2) {
      this.field_1977 = var1;
      this.field_1978 = var2;
      super();
   }

   public void accept(Object var1) {
      this.method_3065((Enum)var1);
   }

   // $FF: renamed from: c (java.lang.Enum) void
   public void method_3065(Enum var1) {
      this.field_1978.c(var1);
      f11.method_3633(this.field_1977, var1);
   }
}
