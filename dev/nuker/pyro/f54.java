/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f54 extends f58 {
   // $FF: renamed from: c dev.nuker.pyro.f55
   public f55 field_1120;
   // $FF: renamed from: c java.lang.Object
   public Object field_1121;
   // $FF: renamed from: 1 boolean
   public boolean field_1122;
   // $FF: renamed from: 0 dev.nuker.pyro.f55
   public f55 field_1123;

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if (this.field_1122) {
         PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 2.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      }

      PyroRenderUtil.meth1(this.method_1630(), this.2() + 5.0F, this.7(), -1);
      return false;
   }

   // $FF: renamed from: c () boolean
   public boolean method_1657() {
      return this.field_1122;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         this.field_1120.method_1656(this);
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   public f54(f55 var1, f55 var2, Object var3, float var4, float var5) {
      this.field_1123 = var1;
      super(var2.c(), var4, var5);
      this.field_1120 = var2;
      this.field_1121 = var3;
   }

   // $FF: renamed from: 0 () java.lang.Object
   public Object method_1658() {
      return this.field_1121;
   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      return String.valueOf(this.field_1121);
   }

   // $FF: renamed from: 1 (boolean) void
   public void method_1659(boolean var1) {
      this.field_1122 = var1;
   }
}
