/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f21 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f21
   public static f21 field_14 = new f21();

   public f21() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_57((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_57(boolean var1) {
      return FriendManager.Companion.loadSummitFriends(var1, true);
   }
}
