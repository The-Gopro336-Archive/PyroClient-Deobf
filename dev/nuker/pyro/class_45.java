/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.crash.ICrashReportDetail;

// $FF: renamed from: dev.nuker.pyro.fr
public class class_45 implements ICrashReportDetail {
   // $FF: renamed from: c dev.nuker.pyro.fv
   public class_55 field_2649;

   public Object call() {
      return this.method_4008();
   }

   // $FF: renamed from: c () java.lang.String
   public String method_4008() {
      return class_55.method_4077(this.field_2649).size() + " total; " + class_55.method_4077(this.field_2649);
   }

   public class_45(class_55 var1) {
      this.field_2649 = var1;
      super();
   }
}
