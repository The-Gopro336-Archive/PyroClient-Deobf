/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f1Z extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f1Z
   public static f1Z field_8 = new f1Z();

   public f1Z() {
      super(1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_51(boolean var1) {
      return FriendManager.Companion.saveImpactFriends(var1);
   }

   public Object invoke(Object var1) {
      return this.method_51((Boolean)var1);
   }
}
