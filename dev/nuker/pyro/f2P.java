/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f2P implements Predicate {
   // $FF: renamed from: c java.lang.String
   public String field_2016;

   public boolean test(Object var1) {
      return this.method_3096((Module)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.Module) boolean
   public boolean method_3096(@NotNull Module var1) {
      return Intrinsics.areEqual((Object)var1.method_141(), (Object)this.field_2016);
   }

   public f2P(String var1) {
      this.field_2016 = var1;
      super();
   }
}
