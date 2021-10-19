/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public class f2a extends Lambda implements Function1 {
   // $FF: renamed from: c dev.nuker.pyro.f2a
   public static f2a field_20 = new f2a();

   public f2a() {
      super(1);
   }

   // $FF: renamed from: c (boolean) boolean
   public boolean method_63(boolean var1) {
      return FriendManager.Companion.saveAresFriends(var1);
   }

   public Object invoke(Object var1) {
      return this.method_63((Boolean)var1);
   }
}
