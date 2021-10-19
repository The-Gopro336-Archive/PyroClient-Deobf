/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f22 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f22
   public static f22 field_13 = new f22();

   public Object invoke(Object var1) {
      return this.method_56((Boolean)var1);
   }

   public f22() {
      super(1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_56(boolean var1) {
      return FriendManager.Companion.saveSummitFriends(var1, true);
   }
}
