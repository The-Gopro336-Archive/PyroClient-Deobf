/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f56 extends f58 {
   // $FF: renamed from: 1 boolean
   public boolean field_1117 = false;

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         this.field_1117 = true;
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      IntegerSetting var4 = (IntegerSetting)this.c;
      int var5 = var4.method_3340();
      int var6 = var4.method_3342();
      float var7;
      if (this.field_1117) {
         var7 = (var1 + this.2()) / this.c();
         if (var7 < 0.0F) {
            var7 = 0.0F;
         }

         if (var7 > 1.0F) {
            var7 = 1.0F;
         }

         int var8 = (int)Math.max((float)var6, var7 * (float)var5);
         var4.c(var8);
      }

      var7 = (float)Math.max((Integer)var4.c() - var6, 0) / (float)(var5 - var6);
      var7 = Math.min(1.0F, var7);
      PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, -this.2() + this.c() * var7 - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      if (!this.5().isEmpty()) {
         if (!this.9()) {
            PyroRenderUtil.meth1("...", -this.2() + this.c() - this.1("...") - 1.0F, this.7(), f0H.field_2338.method_3494());
         } else {
            float var11 = this.1(".");
            float var9 = -5.0F;

            for(int var10 = 0; var10 < 3; ++var10) {
               PyroRenderUtil.meth1(".", -this.2() + this.c() - var11 - 1.0F, this.7() + var9, f0H.field_2338.method_3494());
               var9 += 3.0F;
            }
         }
      }

      return false;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      IntegerSetting var1 = (IntegerSetting)this.c;
      return var1.c() + " " + var1.c();
   }

   public f56(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
      IntegerSetting var4 = (IntegerSetting)var1;
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

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
      super.c(var1, var2, var3);
      this.field_1117 = false;
   }
}
