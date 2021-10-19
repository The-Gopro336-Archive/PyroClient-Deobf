/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f2c extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f2c
   public static f2c field_19 = new f2c();

   public Object invoke(Object var1) {
      return this.method_62((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_62(boolean var1) {
      return FriendManager.Companion.loadSummitFriends(var1, false);
   }

   public f2c() {
      super(1);
   }
}
