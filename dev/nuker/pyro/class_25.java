/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

// $FF: renamed from: dev.nuker.pyro.fN
public class class_25 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_2283;

   public class_25(Module var1) {
      this.field_2283 = var1;
      super();
   }

   // $FF: renamed from: c (java.lang.Boolean) void
   public void method_3421(@NotNull Boolean var1) {
      this.field_2283.field_89.method_3033(var1);
      class_37.field_2633.method_3978(this.field_2283);
   }

   public void accept(Object var1) {
      this.method_3421((Boolean)var1);
   }
}
