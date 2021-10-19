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

public class f7M extends f3Y {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_1743;

   public f7M(@NotNull String var1) {
      this();
      this.field_1743 = var1;
   }

   // $FF: renamed from: c (java.util.List) void
   public void method_2977(@NotNull List var1) {
      Object var10001 = var1.get(0);
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      } else {
         this.field_1743 = (String)var10001;
      }
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_2978(@NotNull String var1) {
      this.field_1743 = var1;
   }

   public f7M() {
   }

   // $FF: renamed from: c () java.lang.String
   @NotNull
   public String method_2979() {
      String var10000 = this.field_1743;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ourEntityId");
      }

      return var10000;
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_2976() {
      String var10000 = this.field_1743;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("ourEntityId");
      }

      return CollectionsKt.listOf(var10000);
   }
}
