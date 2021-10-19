/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f5r extends f5k {
   // $FF: renamed from: c dev.nuker.pyro.Module
   public Module field_1021;

   // $FF: renamed from: e () boolean
   public boolean method_1509() {
      return this.field_1021 == null || !(Boolean)this.field_1021.method_131().method_3034();
   }

   public f5r(Module var1) {
      super(var1.method_127(), "General", new f5G(var1.method_127(), var1.method_122(), var1.method_139(), class_5.field_1004.field_1000), f5l.field_1681);
      this.field_1021 = var1;
      this.3 = (Boolean)var1.method_131().method_3034();
   }

   // $FF: renamed from: c (boolean) void
   public void method_1500(boolean var1) {
      if (this.field_1021 != null) {
         this.field_1021.method_131().method_3033(!var1);
      }

   }
}
