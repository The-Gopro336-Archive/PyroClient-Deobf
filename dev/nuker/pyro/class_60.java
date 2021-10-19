/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.crash.ICrashReportDetail;

// $FF: renamed from: dev.nuker.pyro.fu
public class class_60 implements ICrashReportDetail {
   // $FF: renamed from: c dev.nuker.pyro.fv
   public class_55 field_2720;

   // $FF: renamed from: c () java.lang.String
   public String method_4140() {
      return class_55.method_4067(this.field_2720).getIntegratedServer() == null ? "Non-integrated multiplayer server" : "Integrated singleplayer server";
   }

   public class_60(class_55 var1) {
      this.field_2720 = var1;
      super();
   }

   public Object call() {
      return this.method_4140();
   }
}
