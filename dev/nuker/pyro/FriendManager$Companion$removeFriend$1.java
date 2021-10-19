/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"},
   d2 = {"<anonymous>", "", "it", "Ldev/nuker/pyro/Friend;", "test"}
)
final class FriendManager$Companion$removeFriend$1 implements Predicate {
   // $FF: synthetic field
   final String $name;

   public final boolean test(@NotNull class_17 it) {
      Intrinsics.checkParameterIsNotNull(it, "it");
      return StringsKt.equals(it.method_3416(), this.$name, true);
   }

   FriendManager$Companion$removeFriend$1(String var1) {
      this.$name = var1;
   }
}
