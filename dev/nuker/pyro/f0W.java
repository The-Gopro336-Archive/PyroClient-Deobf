/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public class f0W implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f0Y
   public f0Y field_2394;

   public f0W(f0Y var1) {
      this.field_2394 = var1;
      super();
   }

   public void accept(@Nullable Object var1) {
      f0w var10000 = this.field_2394.method_3588();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      if (var1 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
      } else {
         var10000.method_3314(var1);
      }
   }
}
