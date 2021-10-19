/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class f0U implements Supplier {
   // $FF: renamed from: c dev.nuker.pyro.f0F
   public f0F field_2407;

   public Object get() {
      return this.method_3662();
   }

   // $FF: renamed from: c () java.lang.Integer
   @NotNull
   public Integer method_3662() {
      return (Integer)this.field_2407.method_3575().get();
   }

   public f0U(f0F var1) {
      this.field_2407 = var1;
      super();
   }
}
