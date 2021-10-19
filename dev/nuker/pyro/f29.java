/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f29 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f29
   public static f29 field_9 = new f29();

   // $FF: renamed from: c (boolean) boolean
   public boolean method_52(boolean var1) {
      return FriendManager.Companion.saveSummitFriends(var1, true);
   }

   public Object invoke(Object var1) {
      return this.method_52((Boolean)var1);
   }

   public f29() {
      super(1);
   }
}
