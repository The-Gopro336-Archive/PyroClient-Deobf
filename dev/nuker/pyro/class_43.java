/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.crash.ICrashReportDetail;

// $FF: renamed from: dev.nuker.pyro.ft
public class class_43 implements ICrashReportDetail {
   // $FF: renamed from: c dev.nuker.pyro.fv
   public class_55 field_2644;

   // $FF: renamed from: c () java.lang.String
   public String method_4001() {
      return class_55.method_4067(this.field_2644).player.getServerBrand();
   }

   public Object call() {
      return this.method_4001();
   }

   public class_43(class_55 var1) {
      this.field_2644 = var1;
      super();
   }
}
