/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f52 extends f58 {
   // $FF: renamed from: 1 boolean
   public boolean field_1113 = false;
   // $FF: renamed from: 4 float
   public float field_1114 = 0.0F;
   // $FF: renamed from: 5 float
   public float field_1115 = 0.0F;

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
      super.c(var1, var2, var3);
      this.field_1113 = false;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         this.field_1113 = true;
         this.field_1114 = (float)var1;
         this.field_1115 = (float)(Double)((DoubleSetting)this.c).c();
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      DoubleSetting var1 = (DoubleSetting)this.c;
      return String.format("%s %.2f", var1.c(), (float)(Double)var1.c());
   }

   public f52(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
      DoubleSetting var4 = (DoubleSetting)var1;
      this.5().add(new f5d(this, var4.c(), var2, var3));
      this.5().add(new f51(this));
      String var5 = this.1();
      if (var5 != null) {
         var5 = var5 + "\nThis option can be right clicked inorder to change it's exact value!";
      } else {
         var5 = "This option can be right clicked inorder to change it's exact value!";
      }

      this.c(var5);
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      DoubleSetting var4 = (DoubleSetting)this.c;
      double var5 = var4.getValue();
      double var7 = var4.method_3328();
      float var9;
      if (this.field_1113) {
         var9 = (var1 - this.2()) / (this.c() - this.2() * 2.0F);
         if (var9 < 0.0F) {
            var9 = 0.0F;
         }

         if (var9 > 1.0F) {
            var9 = 1.0F;
         }

         double var10 = var5 + (double)var9 * (var7 - var5);
         var4.c(var10);
      }

      var9 = (float)(((Double)var4.c() - var4.getValue()) / (var4.method_3328() - var4.getValue()));
      PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, this.c() * var9 - this.2() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      if (!this.5().isEmpty()) {
         if (!this.9()) {
            PyroRenderUtil.meth1("...", this.c() - this.2() - this.1("...") - 1.0F, this.7(), f0H.field_2338.method_3494());
         } else {
            float var13 = this.1(".");
            float var11 = -5.0F;

            for(int var12 = 0; var12 < 3; ++var12) {
               PyroRenderUtil.meth1(".", -this.2() + this.c() - var13 - 1.0F, this.7() + var11, f0H.field_2338.method_3494());
               var11 += 3.0F;
            }
         }
      }

      return false;
   }
}
