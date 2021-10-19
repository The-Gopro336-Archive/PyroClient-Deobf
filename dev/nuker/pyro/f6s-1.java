/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.jvm.internal.Ref;

public class f6s implements Predicate {
   // $FF: renamed from: c kotlin.jvm.internal.Ref$LongRef
   public Ref.LongRef field_1820;

   // $FF: renamed from: c (dev.nuker.pyro.fe3) boolean
   public boolean method_3008(fe3 var1) {
      return ((Number)var1.method_1960()).longValue() <= this.field_1820.element;
   }

   public boolean test(Object var1) {
      return this.method_3008((fe3)var1);
   }

   public f6s(Ref.LongRef var1) {
      this.field_1820 = var1;
      super();
   }
}
