/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class f7N extends f3Y {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_1745;

   public f7N(@NotNull String var1) {
      this();
      this.field_1745 = var1;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_2977(@NotNull List var1) {
      Object var10001 = var1.get(0);
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      } else {
         this.field_1745 = (String)var10001;
      }
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_2976() {
      String var10000 = this.field_1745;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("donkeyEntityId");
      }

      return CollectionsKt.listOf(var10000);
   }

   public f7N() {
   }

   // $FF: renamed from: c () java.lang.String
   @NotNull
   public String method_2982() {
      String var10000 = this.field_1745;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("donkeyEntityId");
      }

      return var10000;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_2983(@NotNull String var1) {
      this.field_1745 = var1;
   }
}
