/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.crash.ICrashReportDetail;

// $FF: renamed from: dev.nuker.pyro.fs
public class class_42 implements ICrashReportDetail {
   // $FF: renamed from: c dev.nuker.pyro.fv
   public class_55 field_2643;

   public Object call() {
      return this.method_4000();
   }

   public class_42(class_55 var1) {
      this.field_2643 = var1;
      super();
   }

   // $FF: renamed from: c () java.lang.String
   public String method_4000() {
      return class_55.method_4069(this.field_2643).size() + " total; " + class_55.method_4069(this.field_2643);
   }
}
