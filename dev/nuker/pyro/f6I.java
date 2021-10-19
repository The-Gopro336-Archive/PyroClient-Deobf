/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f6I extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_600;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   public IntegerSetting field_601;
   // $FF: renamed from: c boolean[]
   public boolean[] field_602;

   // $FF: renamed from: c (int) java.lang.String
   public String method_900(int var1) {
      switch(var1) {
      case 0:
         return "Helmet is";
      case 1:
         return "Chestplate is";
      case 2:
         return "Leggings are";
      case 3:
         return "Boots are";
      default:
         return null;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_901(f4t var1) {
      // $FF: Couldn't be decompiled
   }

   public f6I() {
      super("durabilityalert", "DurabilityAlert", "Notifies you if your armor is low.");
      this.field_600 = new f0o("display", "Display", (String)null, f6H.field_1670);
      this.field_601 = new IntegerSetting("durability", "Durability", (String)null, 40, 0, 100);
      this.field_602 = new boolean[]{false, false, false, false};
      this.register(this.field_600);
      this.register(this.field_601);
   }
}
