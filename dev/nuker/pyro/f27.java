/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f27 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f27
   public static f27 field_5 = new f27();

   public Object invoke(Object var1) {
      return this.method_48((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_48(boolean var1) {
      return FriendManager.Companion.saveImpactFriends(var1);
   }

   public f27() {
      super(1);
   }
}
