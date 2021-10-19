/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 3,
   d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"},
   d2 = {"<anonymous>", "", "it", "", "invoke"}
)
final class FriendManager$Companion$loadAresFriends$1 extends Lambda implements Function1 {
   public static final FriendManager$Companion$loadAresFriends$1 INSTANCE = new FriendManager$Companion$loadAresFriends$1();

   public final void invoke(@NotNull String it) {
      Intrinsics.checkParameterIsNotNull(it, "it");
      FriendManager.Companion.addFriendIfNeed(it);
   }

   FriendManager$Companion$loadAresFriends$1() {
      super(1);
   }
}
