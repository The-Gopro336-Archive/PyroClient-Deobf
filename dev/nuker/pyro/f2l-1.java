/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f2l extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f2l
   public static f2l field_16 = new f2l();

   public Object invoke(Object var1) {
      return this.method_59((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_59(boolean var1) {
      return FriendManager.Companion.loadImpactFriends(var1);
   }

   public f2l() {
      super(1);
   }
}
