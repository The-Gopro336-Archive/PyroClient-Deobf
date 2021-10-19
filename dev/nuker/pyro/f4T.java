/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f4T extends f4Q {
   // $FF: renamed from: 1 boolean
   public boolean field_1127;
   // $FF: renamed from: 4 float
   public float field_1128;
   // $FF: renamed from: 5 float
   public float field_1129;
   // $FF: renamed from: 6 float
   public float field_1130;
   // $FF: renamed from: 7 float
   public float field_1131;

   public float meth1() {
      return this.field_1129;
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if (this.field_1127) {
         this.2(var1 + this.2() - this.field_1130);
         this.3(var2 + this.7() - this.field_1131);
      }

      if (this.field_1128 > 0.0F) {
         this.field_1128 -= 10.0F;
         if (this.field_1128 <= 0.0F) {
            this.field_1128 = 0.0F;
            this.c(!this.9());
         }
      }

      return super.method_1639(var1, var2, var3);
   }

   // $FF: renamed from: 4 (float) void
   public void method_1669(float var1) {
      this.field_1129 = var1;
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
      super.method_1640(var1, var2, var3);
      this.field_1127 = false;
   }

   public f4T(String var1, float var2, float var3, float var4, float var5, float var6) {
      super(var1, var2, var3, var4, var5);
      this.field_1129 = var6;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      double var4 = f0H.field_2338.method_3492();
      float var6 = (float)((double)((float)var1 - this.2()) / var4);
      float var7 = (float)((double)((float)var2 - this.7()) / var4);
      if (var6 >= 0.0F && var6 <= this.c() && var7 >= 0.0F && (double)var7 < (double)this.field_1129 * var4) {
         if (var3 == 0) {
            this.field_1127 = true;
            this.field_1130 = var6;
            this.field_1131 = var7;
         } else if (var3 == 1) {
            this.field_1128 = this.meth4();
         }
      }

   }
}
