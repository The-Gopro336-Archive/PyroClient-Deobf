/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

// $FF: renamed from: dev.nuker.pyro.f9
public class class_15 {
   // $FF: renamed from: c (java.lang.String) dev.nuker.pyro.fa
   @NotNull
   public class_34 method_3407(@NotNull String var1) {
      class_34 var2 = new class_34();
      Collection var3 = (Collection)StringsKt.split$default((CharSequence)var1, new String[]{"\n"}, false, 0, 6, (Object)null);
      boolean var4 = false;
      Object[] var10000 = var3.toArray(new String[0]);
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      } else {
         Object[] var7 = var10000;
         var2.method_3967((String[])var7);
         return var2;
      }
   }

   public class_15() {
   }

   public class_15(DefaultConstructorMarker var1) {
      this();
   }
}
