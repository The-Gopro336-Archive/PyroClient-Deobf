/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import java.util.function.Consumer;

public class f0v implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f0w
   public f0w field_2455;

   public void accept(Object var1) {
      Iterator var3 = f0w.method_3312(this.field_2455).iterator();

      while(var3.hasNext()) {
         Consumer var2 = (Consumer)var3.next();
         var2.accept(this.field_2455);
      }

   }

   public f0v(f0w var1) {
      this.field_2455 = var1;
      super();
   }
}
