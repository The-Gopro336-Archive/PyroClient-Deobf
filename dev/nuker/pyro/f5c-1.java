/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f5c extends f58 {
   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if ((Boolean)((BooleanSetting)this.c).c()) {
         PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      }

      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      if (!this.5().isEmpty()) {
         if (!this.9()) {
            PyroRenderUtil.meth1("...", -this.2() + this.c() - this.1("...") - 1.0F, this.7(), f0H.field_2338.method_3494());
         } else {
            float var4 = this.1(".");
            float var5 = -5.0F;

            for(int var6 = 0; var6 < 3; ++var6) {
               PyroRenderUtil.meth1(".", -this.2() + this.c() - var4 - 1.0F, this.7() + var5, f0H.field_2338.method_3494());
               var5 += 3.0F;
            }
         }
      }

      return false;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      return ((BooleanSetting)this.c).c();
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         BooleanSetting var4 = (BooleanSetting)this.c;
         var4.c(!(Boolean)var4.c());
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   public f5c(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
   }
}
