/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.Iterator;
import java.util.List;

public class f4Z extends f4Q {
   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   // $FF: renamed from: c () void
   public void method_1646() {
   }

   // $FF: renamed from: 1 () int
   public int method_1647() {
      return 1;
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      if (this.method_1648()) {
         PyroRenderUtil.meth0(this.2(), this.7() - 2.0F, -this.2() + this.c(), this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
      }

      c(this.8(), this.2() + 1.0F, this.7() + 2.0F, f0H.field_2338.method_3494());
      if (!this.5().isEmpty() && this.5().size() > this.method_1647()) {
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

      return super.method_1639(var1, var2, var3);
   }

   public f4Z(String var1, String var2) {
      super(var1, 0.0F, 0.0F, 115.0F, 15.0F);
      this.c(var2);
   }

   // $FF: renamed from: 0 () boolean
   public boolean method_1648() {
      return false;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4Q, dev.nuker.pyro.f0w) dev.nuker.pyro.f4Q
   public f4Q method_1649(f4Q var1, f0w var2) {
      Object var3 = null;
      if (var2 instanceof BooleanSetting) {
         var1.method_1631().add(var3 = new f5c(var2, 115.0F, 12.0F));
      } else if (var2 instanceof f0l) {
         var1.method_1631().add(var3 = new f50(var2, 115.0F, 12.0F));
      } else if (var2 instanceof DoubleSetting) {
         var1.method_1631().add(var3 = new f52(var2, 115.0F, 12.0F));
      } else if (var2 instanceof f0o) {
         var1.method_1631().add(var3 = new f55(var2, 115.0F, 12.0F));
      } else if (var2 instanceof IntegerSetting) {
         var1.method_1631().add(var3 = new f56(var2, 115.0F, 12.0F));
      } else if (var2 instanceof BindSetting) {
         var1.method_1631().add(var3 = new f57(var2, 115.0F, 12.0F));
      } else {
         int var5;
         if (var2 instanceof f0z) {
            f0z var4 = (f0z)var2;
            var1.method_1631().add(var3 = new f59(var4, var4.method_3334(), 115.0F, 12.0F, this));
            var5 = 0;
            Object[] var6 = var4.method_3334().c().getClass().getEnumConstants();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               Object var9 = var6[var8];
               if (var9 == var4.method_3334().c()) {
                  break;
               }

               ++var5;
            }

            List[] var11 = (List[])((List[])var4.c());
            Iterator var12 = var11[var5].iterator();

            while(var12.hasNext()) {
               f0w var13 = (f0w)var12.next();
               this.method_1649((f4Q)var3, var13);
            }

            if ((Boolean)var4.method_3332().method_3034()) {
               ((f4Q)var3).method_1642(true);
            }
         } else if (var2 instanceof f0t) {
            f0t var10 = (f0t)var2;
            var3 = this.method_1649(var1, (f0w)((List)var10.c()).get(0));
            if (((List)var10.c()).size() > 1) {
               for(var5 = 1; var5 < ((List)var10.c()).size(); ++var5) {
                  this.method_1649((f4Q)var3, (f0w)((List)var10.c()).get(var5));
               }
            }

            if ((Boolean)var10.method_3322().method_3034()) {
               ((f4Q)var3).method_1642(true);
            }
         } else if (var2 instanceof f0n) {
            var1.method_1631().add(var3 = new f53(var2, 115.0F, 12.0F));
         }
      }

      return (f4Q)var3;
   }
}
