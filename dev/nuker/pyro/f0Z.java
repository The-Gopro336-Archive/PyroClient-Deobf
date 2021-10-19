/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

public class f0Z implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f11
   public f11 field_2405;

   public f0Z(f11 var1) {
      this.field_2405 = var1;
      super();
   }

   public void accept(@Nullable Object var1) {
      f13 var10000 = this.field_2405.0();
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.api.ui.control.EnumControl<T>");
      } else {
         class_6 var2 = ((f0O)var10000).field_2376;
         if (var1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type T");
         } else {
            var2.method_3033((Enum)var1);
         }
      }
   }
}
