/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f59 extends f58 {
   // $FF: renamed from: c java.lang.Object[]
   public Object[] field_1110;
   // $FF: renamed from: c dev.nuker.pyro.f4Z
   public f4Z field_1111;
   // $FF: renamed from: c dev.nuker.pyro.f0z
   public f0z field_1112;

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 1.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      PyroRenderUtil.meth1("...", -this.2() + this.c() - this.1("...") - 1.0F, this.7(), f0H.field_2338.method_3494());
      return true;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      f0o var1 = (f0o)this.c;
      return var1.c() + " " + var1.c();
   }

   public f59(f0z var1, f0o var2, float var3, float var4, f4Z var5) {
      super(var2, var3, var4);
      this.field_1112 = var1;
      if (var2.c().getClass().getEnumConstants() != null) {
         this.field_1110 = var2.c().getClass().getEnumConstants();
      }

      this.field_1111 = var5;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         f0o var4 = (f0o)this.c;
         int var5 = -1;

         for(int var6 = 0; var6 < this.field_1110.length - 1; ++var6) {
            if (this.field_1110[var6] == var4.c()) {
               var5 = var6;
               break;
            }
         }

         if (var5 >= this.field_1110.length - 1) {
            var5 = -1;
         }

         ++var5;
         var4.c(this.field_1110[var5]);
         this.field_1111.method_1646();
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.field_1112.method_3332().method_3033(!this.9());
         this.c(!this.9());
      }

   }
}
