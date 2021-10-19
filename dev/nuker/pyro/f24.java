/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f24 extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f24
   public static f24 field_11 = new f24();

   public Object invoke(Object var1) {
      return this.method_54((Boolean)var1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_54(boolean var1) {
      return FriendManager.Companion.saveAresFriends(var1);
   }

   public f24() {
      super(1);
   }
}
