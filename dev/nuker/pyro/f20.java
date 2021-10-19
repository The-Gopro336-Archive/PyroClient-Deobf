/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f20 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f20
   public static f20 field_10 = new f20();

   public f20() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_53((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_53(boolean var1) {
      return FriendManager.Companion.saveSummitFriends(var1, false);
   }
}
