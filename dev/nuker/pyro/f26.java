/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f26 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f26
   public static f26 field_6 = new f26();

   // $FF: renamed from: c (boolean) boolean
   public boolean method_49(boolean var1) {
      return FriendManager.Companion.saveFutureFriends(var1);
   }

   public f26() {
      super(1);
   }

   public Object invoke(Object var1) {
      return this.method_49((Boolean)var1);
   }
}
