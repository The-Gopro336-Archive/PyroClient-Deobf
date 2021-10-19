/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f28 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f28
   public static f28 field_4 = new f28();

   // $FF: renamed from: c (boolean) boolean
   public boolean method_47(boolean var1) {
      return FriendManager.Companion.saveSummitFriends(var1, false);
   }

   public Object invoke(Object var1) {
      return this.method_47((Boolean)var1);
   }

   public f28() {
      super(1);
   }
}
