/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;

public class f4W extends f4T {
   // $FF: renamed from: c int
   public static int field_1132 = 115;
   // $FF: renamed from: 0 int
   public static int field_1133 = 15;
   // $FF: renamed from: 1 int
   public static int field_1134 = 12;
   // $FF: renamed from: c dev.nuker.pyro.f4Q
   public f4Q field_1135 = null;
   // $FF: renamed from: 2 boolean
   public boolean field_1136 = true;

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      super.method_1639(var1, var2, var3);
      this.c(this.c(), 2.0F, 0);
      PyroRenderUtil.meth0(0.0F, 0.0F, this.c(), this.meth1(), f0H.field_2338.method_3505());
      c(this.8(), 2.0F, 4.0F, -1);
      this.field_1136 = true;
      float var4 = this.meth1() + 3.0F;
      if (this.9()) {
         PyroRenderUtil.meth0(0.0F, this.meth1(), this.c(), this.meth4(), f0H.field_2338.method_3490());
         var4 = this.method_1671(2.0F, var1, var2, var3, this, var4);
      }

      if (this.field_1136 && this.field_1135 != null) {
         this.field_1135 = null;
      }

      this.1(var4 - 2.0F);
      if (this.field_1135 != null && this.field_1135.method_1633() != null) {
         if (!this.field_1135.method_1633().contains("\n")) {
            float var12 = this.1(this.field_1135.method_1633());
            PyroRenderUtil.meth0(var1 + 8.0F, var2 - 2.0F, var1 + var12 + 14.0F, var2 + this.6(), f0H.field_2338.method_3499());
            c(this.field_1135.method_1633(), var1 + 12.0F, var2, -1);
         } else {
            String[] var5 = this.field_1135.method_1633().split("\n");
            float var6 = 0.0F;
            String[] var7 = var5;
            int var8 = var5.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               String var10 = var7[var9];
               float var11 = this.1(var10);
               if (var6 < var11) {
                  var6 = var11;
               }
            }

            PyroRenderUtil.meth0(var1 + 8.0F, var2 - 2.0F, var1 + var6 + 14.0F, var2 + this.6() * (float)var5.length, f0H.field_2338.method_3499());

            for(int var13 = 0; var13 < var5.length; ++var13) {
               c(var5[var13], var1 + 12.0F, var2 + this.6() * (float)var13, -1);
            }
         }

         if (c.currentScreen instanceof f4P) {
            ((f4P)c.currentScreen).method_2959(this);
         }
      }

      return this.field_1135 != null;
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (this.field_1135 != null) {
         this.field_1135.method_1622((int)((float)var1 - this.2()), (int)((float)var2 - this.7()), var3);
      }

   }

   // $FF: renamed from: c (char, int, dev.nuker.pyro.f4Q) void
   public void method_1670(char var1, int var2, f4Q var3) {
      if (var3.method_1634()) {
         Iterator var4 = var3.method_1631().iterator();

         while(var4.hasNext()) {
            f4Q var5 = (f4Q)var4.next();
            var5.method_1632(var1, var2);
            this.method_1670(var1, var2, var5);
         }
      }

   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
      super.method_1640(var1, var2, var3);
      this.method_1672(var1, var2, var3, this);
   }

   // $FF: renamed from: c (char, int) void
   public void method_1632(char var1, int var2) {
      super.c(var1, var2);
      this.method_1670(var1, var2, this);
   }

   public f4W(String var1, float var2, float var3) {
      super(var1, var2, var3, 115.0F, 0.0F, 15.0F);
   }

   // $FF: renamed from: c (float, float, float, float, dev.nuker.pyro.f4Q, float) float
   public float method_1671(float var1, float var2, float var3, float var4, f4Q var5, float var6) {
      if (var5.method_1634()) {
         Iterator var7 = var5.method_1631().iterator();

         while(var7.hasNext()) {
            f4Q var8 = (f4Q)var7.next();
            if (this.4 > 0.0F && var6 >= this.4) {
               break;
            }

            var8.method_1643(var1);
            var8.method_1645(var6);
            if (var2 >= 0.0F && var2 <= this.c() && var3 >= var6 - 1.0F && var3 <= var6 + var8.meth4() - 3.0F && this.field_1136) {
               this.field_1136 = false;
               this.field_1135 = var8;
               PyroRenderUtil.meth0(1.0F, var6 - 2.0F, this.c(), var6 + var8.meth4() - 3.0F, f0H.field_2338.method_3499());
            }

            var8.method_1639(var2, var3, var4);
            var6 += var8.meth4();
            if (var8.method_1634()) {
               float var9 = var6;
               PyroRenderUtil.meth0(1.0F, var6 - 2.0F, var8.method_1635(), var6 + var8.method_1621() - 3.0F, f0H.field_2338.method_3490());
               var6 += this.method_1671(var1 + 2.0F, var2, var3, var4, var8, var6) - var6;
               var8.method_1637(var6 - var9);
            }
         }
      }

      return var6;
   }

   // $FF: renamed from: c (int, int, int, dev.nuker.pyro.f4Q) void
   public void method_1672(int var1, int var2, int var3, f4Q var4) {
      if (var4.method_1634()) {
         Iterator var5 = var4.method_1631().iterator();

         while(var5.hasNext()) {
            f4Q var6 = (f4Q)var5.next();
            var6.method_1640(var1, var2, var3);
            this.method_1672(var1, var2, var3, var6);
         }
      }

   }
}
