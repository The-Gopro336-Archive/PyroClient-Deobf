/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public class f4c {
   // $FF: renamed from: c java.util.List
   @NotNull
   public List field_2184;

   // $FF: renamed from: c (java.util.List) void
   public void method_3252(@NotNull List var1) {
      this.field_2184 = var1;
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_3253() {
      return this.field_2184;
   }

   // $FF: renamed from: c (int) dev.nuker.pyro.f3Y
   @NotNull
   public f3Y method_3254(int var1) {
      return (f3Y)((Class)this.field_2184.get(var1)).newInstance();
   }

   public f4c(@NotNull List var1) {
      this.field_2184 = var1;
   }
}
