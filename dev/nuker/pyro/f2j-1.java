/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f2j extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f2j
   public static f2j field_18 = new f2j();

   public f2j() {
      super(1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_61(boolean var1) {
      return FriendManager.Companion.loadFutureFriends(var1);
   }

   public Object invoke(Object var1) {
      return this.method_61((Boolean)var1);
   }
}
