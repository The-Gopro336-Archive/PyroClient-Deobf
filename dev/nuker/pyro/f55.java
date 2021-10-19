/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Iterator;

public class f55 extends f58 {
   // $FF: renamed from: c java.lang.Object[]
   public Object[] field_1118;
   // $FF: renamed from: c java.util.ArrayList
   public ArrayList field_1119 = new ArrayList();

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      PyroRenderUtil.meth0(this.2() + 3.0F, this.7() - 1.0F, -this.2() + this.c() - 2.0F, this.7() + this.meth4() - 3.0F, f0H.field_2338.method_3505());
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

      return true;
   }

   // $FF: renamed from: c () void
   public void method_1655() {
      this.5().clear();
      f0o var1 = (f0o)this.c;
      if (var1.c().getClass().getEnumConstants() != null) {
         this.field_1118 = var1.c().getClass().getEnumConstants();
         Object[] var2 = this.field_1118;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Object var5 = var2[var4];
            f54 var6;
            this.c.add(var6 = new f54(this, this, var5, this.c(), this.meth4()));
            this.field_1119.add(var6);
            if (var1.c() == var5) {
               var6.method_1659(true);
            }
         }
      }

   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.0(var1, var2, var3);
      if (var3 == 0) {
         f0o var4 = (f0o)this.c;
         int var5 = -1;

         for(int var6 = 0; var6 < this.field_1118.length - 1; ++var6) {
            if (this.field_1118[var6] == var4.c()) {
               var5 = var6;
               break;
            }
         }

         if (var5 >= this.field_1118.length - 1) {
            var5 = -1;
         }

         ++var5;
         var4.c(this.field_1118[var5]);
         this.method_1655();
      } else if (var3 == 1 && !this.5().isEmpty()) {
         this.c(!this.9());
      }

   }

   // $FF: renamed from: 8 () java.lang.String
   public String method_1630() {
      f0o var1 = (f0o)this.c;
      return var1.c() + " " + var1.c();
   }

   public f55(f0w var1, float var2, float var3) {
      super(var1, var2, var3);
      this.method_1655();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f54) void
   public void method_1656(f54 var1) {
      this.c.method_3314(var1.method_1658());
      Iterator var2 = this.field_1119.iterator();

      while(var2.hasNext()) {
         f54 var3 = (f54)var2.next();
         var3.method_1659(false);
      }

      var1.method_1659(true);
   }
}
