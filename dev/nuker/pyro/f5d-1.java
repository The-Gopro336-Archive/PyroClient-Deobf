/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f5d extends f4Q {
   // $FF: renamed from: c dev.nuker.pyro.f58
   public f58 field_1142;
   // $FF: renamed from: 1 java.lang.String
   public String field_1143;

   // $FF: renamed from: c () dev.nuker.pyro.f58
   public f58 method_1679() {
      return this.field_1142;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (var3 == 0) {
         c.displayGuiScreen(new f5b(this.field_1143, c.currentScreen, this));
      }

   }

   public f5d(f58 var1, String var2, float var3, float var4) {
      super("Change value", 0.0F, 0.0F, var3, var4);
      this.field_1143 = var2;
      this.field_1142 = var1;
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth1(this.8(), this.2() + 4.0F, this.7(), f0H.field_2338.method_3494());
      return super.method_1639(var1, var2, var3);
   }
}
