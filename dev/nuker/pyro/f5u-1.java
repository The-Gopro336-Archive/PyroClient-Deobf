/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class f5u extends f5k {
   // $FF: renamed from: c int
   public static int field_1022 = 5;
   // $FF: renamed from: 0 int
   public static int field_1023 = 25;
   // $FF: renamed from: 4 float
   public float field_1024;
   // $FF: renamed from: 5 float
   public float field_1025;
   // $FF: renamed from: c dev.nuker.pyro.f5t
   public f5t field_1026;
   // $FF: renamed from: 4 boolean
   public boolean field_1027;
   // $FF: renamed from: 5 boolean
   public boolean field_1028;
   // $FF: renamed from: 6 boolean
   public boolean field_1029;
   // $FF: renamed from: c net.minecraft.client.gui.ScaledResolution
   public ScaledResolution field_1030 = null;

   // $FF: renamed from: c (double, double, double, double) void
   public void method_1520(double var1, double var3, double var5, double var7) {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      PyroRenderUtil.method_1429(var1, var3, var5, var7, 4.0F);
      GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
      PyroRenderUtil.method_1429(var1, var3, var5, var7, 2.0F);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, int, int) void
   public void method_1505(ScaledResolution var1, int var2, int var3) {
      this.field_1030 = var1;
      if (this.field_1027) {
         this.field_1028 = true;
         this.method_1524(var2, var3);
         float var4 = (float)var2 - this.field_1024;
         float var5 = (float)var3 - this.field_1025;
         this.3(Math.min(Math.max(0.0F, var4), (float)var1.getScaledWidth() - this.meth1()));
         this.2(Math.min(Math.max(0.0F, var5), (float)var1.getScaledHeight() - this.d()));
         if (this.field_1026 != null) {
            GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
            double var6 = (double)(var4 + (this.field_1026.field_1717 == -1 ? 2.0F : (this.field_1026.field_1717 == 0 ? this.meth1() / 2.0F : this.meth1() - 2.0F)));
            double var8 = (double)(var5 + (this.field_1026.field_1718 == -1 ? 2.0F : (this.field_1026.field_1718 == 0 ? this.d() / 2.0F : this.d() - 2.0F)));
            switch(this.field_1026.field_1717) {
            case -1:
               this.method_1520(0.0D, var8, (double)var4, var8);
               break;
            case 1:
               this.method_1520((double)var1.getScaledWidth(), var8, (double)(var4 + this.meth1()), var8);
            }

            switch(this.field_1026.field_1718) {
            case -1:
               this.method_1520(var6, 0.0D, var6, (double)var5);
               break;
            case 1:
               this.method_1520(var6, (double)var1.getScaledHeight(), var6, (double)(var5 + this.d()));
            }
         }
      } else if (this.field_1028) {
         this.field_1028 = false;
         class_5.field_1004.method_1493();
      }

      if ((Boolean)PyroStatic.field_2484.method_970().c() && (this.c.method_1535() || c.currentScreen instanceof f5j)) {
         PyroRenderUtil.meth0(this.7(), this.8(), this.7() + this.meth1(), this.8() + this.d(), this.e() ? 1963986960 : 1979645952);
      }

      if (this.method_1523(var2, var3) && this.c.method_1536()) {
         PyroRenderUtil.meth0(this.7(), this.8(), this.7() + this.meth1(), this.8() + this.d(), 1345864260);
      }

      GlStateManager.pushMatrix();
      GlStateManager.translate(this.7(), this.8(), 0.0F);
      this.c.method_1528(this.field_1026, this.7() + this.meth1() / 2.0F > (float)this.field_1030.getScaledWidth() / 2.0F ? (this.8() + this.d() / 2.0F > (float)this.field_1030.getScaledHeight() / 2.0F ? 1 : 0) : (this.8() + this.d() / 2.0F > (float)this.field_1030.getScaledHeight() / 2.0F ? 2 : 3), var1, (float)var2 - this.7(), (float)var3 - this.8());
      GlStateManager.popMatrix();
      if (this.method_1523(var2, var3)) {
         if (!this.c.method_1536()) {
            PyroRenderUtil.meth0(this.7(), this.8(), this.7() + this.meth1(), this.8() + this.d(), 1345864260);
         }

         this.field_1029 = true;
      } else {
         this.field_1029 = false;
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_1500(boolean var1) {
      super.method_1500(var1);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution) void
   public void method_1499(ScaledResolution var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_1521(boolean var1) {
      this.field_1027 = var1;
      if (var1) {
         class_5.field_1004.method_1481(this);
      }

   }

   // $FF: renamed from: c () void
   public void method_1522() {
   }

   // $FF: renamed from: 0 (int, int) boolean
   public boolean method_1523(int var1, int var2) {
      return (float)var1 >= this.7() && (float)var1 < this.7() + this.meth1() && (float)var2 >= this.8() && (float)var2 < this.8() + this.d();
   }

   public f5u(String var1, String var2, f5q var3, boolean var4) {
      super(var1, var2, var3, f5l.field_1682, !var4);
   }

   // $FF: renamed from: c (int, int) void
   public void method_1524(int var1, int var2) {
      if (this.field_1030 != null) {
         boolean var3 = false;
         if (!var3) {
            f5t var4 = f5t.method_2962((float)var1 - this.field_1024, (float)var2 - this.field_1025, this.meth1(), this.d(), this.field_1030.getScaledWidth(), this.field_1030.getScaledHeight(), 5);
            if (var4 != null) {
               this.field_1026 = var4;
            } else if (this.field_1026 != null) {
               f5t var5 = f5t.method_2962((float)var1 - this.field_1024, (float)var2 - this.field_1025, this.meth1(), this.d(), this.field_1030.getScaledWidth(), this.field_1030.getScaledHeight(), 25);
               if (var5 == null) {
                  this.field_1026 = null;
               } else {
                  this.field_1026 = var5;
               }
            }
         }
      }

   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1512(int var1, int var2, int var3) {
      if ((float)var1 >= this.7() && (float)var1 <= this.7() + this.meth1() && (float)var2 >= this.8() && (float)var2 <= this.8() + this.d() && !this.c.method_1530(var1, var2, var3)) {
         if (var3 == 0) {
            if (this.field_1029) {
               this.field_1027 = true;
               this.field_1024 = (float)var1 - this.7();
               this.field_1025 = (float)var2 - this.8();
            } else {
               this.field_1027 = false;
            }
         } else if (var3 == 1) {
            this.method_1500(!this.e());
         }
      }

   }

   public f5u(String var1, String var2, f5q var3) {
      super(var1, var2, var3, f5l.field_1682);
   }
}
