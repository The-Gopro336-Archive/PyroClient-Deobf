/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f5i {
   // $FF: renamed from: c java.util.List
   public List field_1703 = new CopyOnWriteArrayList();

   // $FF: renamed from: c (java.lang.String, java.lang.String, int) void
   public void method_2955(String var1, String var2, int var3) {
      this.field_1703.add(new f5h(this, var1, var2, var3));
   }

   // $FF: renamed from: c () dev.nuker.pyro.f5i
   public static f5i method_2956() {
      return Pyro.getNotificationManager();
   }
}
