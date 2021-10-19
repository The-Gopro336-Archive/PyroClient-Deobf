/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f23 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f23
   public static f23 field_12 = new f23();

   // $FF: renamed from: c (boolean) boolean
   public boolean method_55(boolean var1) {
      return FriendManager.Companion.loadAresFriends(var1);
   }

   public Object invoke(Object var1) {
      return this.method_55((Boolean)var1);
   }

   public f23() {
      super(1);
   }
}
