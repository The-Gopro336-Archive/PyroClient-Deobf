/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"},
   d2 = {"<anonymous>", "", "it", "", "invoke"}
)
final class FriendManager$Companion$saveImpactFriends$1 extends Lambda implements Function1 {
   // $FF: synthetic field
   final boolean $overwrite;
   // $FF: synthetic field
   final List $friends;

   public final void invoke(@NotNull String it) {
      Intrinsics.checkParameterIsNotNull(it, "it");
      if (!this.$overwrite || FriendManager.Companion.hasFriend(StringsKt.substringBeforeLast$default(it, ":", (String)null, 2, (Object)null))) {
         this.$friends.add(StringsKt.substringBeforeLast$default(it, ":", (String)null, 2, (Object)null));
      }

   }

   FriendManager$Companion$saveImpactFriends$1(boolean var1, List var2) {
      super(1);
      this.$overwrite = var1;
      this.$friends = var2;
   }
}
