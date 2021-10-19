/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f50 extends f58 {
   public f50(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
      this.c.add(new f5a((f0l)var1, var2));
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      return ((f0l)this.c).c();
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth0(-this.2() + this.c() - 8.0F, this.7() + 1.0F, -this.2() + this.c() - 3.0F, this.7() + this.meth4() - 6.0F, ((f00)((f0l)this.c).c()).meth1());
      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), f0H.field_2338.method_3494());
      return true;
   }
}
