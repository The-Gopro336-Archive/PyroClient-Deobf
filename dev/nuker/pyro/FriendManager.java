/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"},
   d2 = {"Ldev/nuker/pyro/FriendManager;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "friends", "", "Ldev/nuker/pyro/Friend;", "getFriends", "()Ljava/util/List;", "setFriends", "(Ljava/util/List;)V", "Companion", "pyroclient"}
)
public final class FriendManager {
   private boolean enabled = true;
   @NotNull
   private List friends = (List)(new ArrayList());
   @NotNull
   private static FriendManager INSTANCE = new FriendManager();
   public static final FriendManager$Companion Companion = new FriendManager$Companion((DefaultConstructorMarker)null);

   public final boolean getEnabled() {
      return this.enabled;
   }

   public final void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   @NotNull
   public final List getFriends() {
      return this.friends;
   }

   public final void setFriends(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.friends = var1;
   }

   // $FF: synthetic method
   public static final FriendManager access$getINSTANCE$cp() {
      return INSTANCE;
   }

   // $FF: synthetic method
   public static final void access$setINSTANCE$cp(FriendManager var0) {
      INSTANCE = var0;
   }

   @JvmStatic
   public static final void loadFriends() {
      Companion.loadFriends();
   }
}
