/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Supplier;

public class f0T implements Supplier {
   // $FF: renamed from: c dev.nuker.pyro.f0F
   public f0F field_2406;

   // $FF: renamed from: c () int
   public int method_3661() {
      return ((Number)this.field_2406.method_3575().get()).intValue() - 1;
   }

   public Object get() {
      return this.method_3661();
   }

   public f0T(f0F var1) {
      this.field_2406 = var1;
      super();
   }
}
