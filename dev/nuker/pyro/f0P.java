/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

public class f0P implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f0R
   public f0R field_2383;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   public IntegerSetting field_2384;

   public void accept(Object var1) {
      this.method_3623((Double)var1);
   }

   // $FF: renamed from: c (java.lang.Double) void
   public void method_3623(Double var1) {
      this.field_2384.c((int)var1);
      if (!this.field_2383.method_3620()) {
         class_7 var10000 = this.field_2383.c();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.method_3033((double)((int)var1));
      }

      this.field_2383.method_3619(false);
   }

   public f0P(f0R var1, IntegerSetting var2) {
      this.field_2383 = var1;
      this.field_2384 = var2;
      super();
   }
}
