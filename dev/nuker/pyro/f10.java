/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Supplier;

public class f10 implements Supplier {
   // $FF: renamed from: c dev.nuker.pyro.f0F
   public f0F field_2382;

   // $FF: renamed from: c () int
   public int method_3622() {
      return ((Number)this.field_2382.method_3575().get()).intValue() - 1;
   }

   public f10(f0F var1) {
      this.field_2382 = var1;
      super();
   }

   public Object get() {
      return this.method_3622();
   }
}
