/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f2k extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f2k
   public static f2k field_17 = new f2k();

   public Object invoke(Object var1) {
      return this.method_60((Boolean)var1);
   }

   public f2k() {
      super(1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_60(boolean var1) {
      return FriendManager.Companion.saveFutureFriends(var1);
   }
}
