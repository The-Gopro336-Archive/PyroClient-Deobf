/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f51 extends f4Q {
   // $FF: renamed from: c dev.nuker.pyro.f58
   public f58 field_1104;

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth1(this.8(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      return false;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (var3 == 0) {
         this.field_1104.method_1654().method_3314(this.field_1104.method_1654().method_3304());
      }

   }

   public f51(f58 var1) {
      super("Defaults", 0.0F, 0.0F, 115.0F, PyroRenderUtil.meth1() + 2.0F);
      this.field_1104 = var1;
   }
}
