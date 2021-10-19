/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;

public class f5a extends f4Q {
   // $FF: renamed from: c dev.nuker.pyro.f0l
   public f0l field_1124;
   // $FF: renamed from: c dev.nuker.pyro.f00
   public f00 field_1125;
   // $FF: renamed from: c int
   public int field_1126 = 0;

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, int, int, int, int, float, float[]) void
   public void method_1660(BufferBuilder var1, int var2, int var3, int var4, int var5, float var6, float[] var7) {
      float var8 = (float)var2 + var6 * (float)var4 - 0.5F;
      var1.pos((double)var8 - 1.0D, (double)(var3 + var5) + 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var8 + 2.0F), (double)(var3 + var5) + 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var8 + 2.0F), (double)var3 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var8 - 1.0D, (double)var3 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      this.method_1667(var1, var8, (float)var3, 1, var5, 1, 2);
      var1.pos((double)var8, (double)(var3 + var5), 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8 + 1.0D, (double)(var3 + var5), 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8 + 1.0D, (double)var3, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8, (double)var3, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder) void
   public void method_1661(BufferBuilder var1) {
      GlStateManager.shadeModel(7425);
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      var1.begin(7, DefaultVertexFormats.POSITION_COLOR);
   }

   // $FF: renamed from: c (int, int, int, int, float, float, float, float, int) void
   public void method_1662(int var1, int var2, int var3, int var4, float var5, float var6, float var7, float var8, int var9) {
      Tessellator var10 = Tessellator.getInstance();
      BufferBuilder var11 = var10.getBuffer();
      this.method_1661(var11);
      this.method_1667(var11, (float)var1, (float)var2, var3, var4, var3 / var4 / 2, 2);
      float var12 = var9 == 0 ? var5 : (var9 == 1 ? var6 : (var9 == 2 ? var7 : var8));
      float var13 = 0.0F;
      int var14 = var1;

      for(int var15 = var1 + var3; var14 < var15; ++var14) {
         float var16 = (float)(var14 - var1) / (float)var3;
         float[] var17 = new float[]{var9 == 0 ? var13 : var5, var9 == 1 ? var13 : var6, var9 == 2 ? var13 : var7, var9 == 3 ? var13 : var8};
         float[] var18 = new float[]{var9 == 0 ? var16 : var5, var9 == 1 ? var16 : var6, var9 == 2 ? var16 : var7, var9 == 3 ? var16 : var8};
         var11.pos((double)var14, (double)(var2 + var4), 0.0D).color(var17[0], var17[1], var17[2], var17[3]).endVertex();
         var11.pos((double)var14 + 1.0D, (double)(var2 + var4), 0.0D).color(var18[0], var18[1], var18[2], var18[3]).endVertex();
         var11.pos((double)var14 + 1.0D, (double)var2, 0.0D).color(var18[0], var18[1], var18[2], var18[3]).endVertex();
         var11.pos((double)var14, (double)var2, 0.0D).color(var17[0], var17[1], var17[2], var17[3]).endVertex();
         var13 = var16;
      }

      this.method_1660(var11, var1, var2, var3, var4, var12, new float[]{var5, var6, var7, var8});
      var10.draw();
      this.method_1668();
   }

   // $FF: renamed from: c (int, int, int) void
   public void method_1640(int var1, int var2, int var3) {
      super.method_1640(var1, var2, var3);
      this.field_1126 = 0;
      this.field_1124.c(this.field_1125.meth0());
   }

   // $FF: renamed from: c (float, float, float) boolean
   public boolean method_1639(float var1, float var2, float var3) {
      byte var4 = 8;
      byte var5 = 1;
      int var6 = (int)((float)(var5 * 2 + var4) + this.7()) - 10;
      int var7 = var4 + var5;
      float[] var8 = this.field_1125.meth6();
      int var9 = (int)((this.c() - (float)(var5 * 2)) * 0.41666666F);
      int var10 = (int)((float)(var9 + var5 * 2) + PyroRenderUtil.meth4() + 3.0F);
      int var11 = (int)(this.c() - (float)(var5 * 3) - (float)var9 - PyroRenderUtil.meth4() - 3.0F);
      this.method_1665(var5, var6, var9, var9, var8[0], var8[1], var8[2]);
      this.method_1663(var5 + var9 + 3, var6, var4, var9, var8[0]);
      float[] var12 = f00.field_2296.method_3689(var8[0], var8[1], var8[2], var8[3]);
      int var13 = var11 - var4;
      PyroRenderUtil.meth1("R", (float)var10, (float)(var6 + 1), -1);
      this.method_1662(var10 + var4, var6, var13, var4, var12[0], var12[1], var12[2], var12[3], 0);
      PyroRenderUtil.meth1("G", (float)var10, (float)(var6 + 1 + var7), -1);
      this.method_1662(var10 + var4, var6 + var7, var13, var4, var12[0], var12[1], var12[2], var12[3], 1);
      PyroRenderUtil.meth1("B", (float)var10, (float)(var6 + 1 + var7 * 2), -1);
      this.method_1662(var10 + var4, var6 + var7 * 2, var13, var4, var12[0], var12[1], var12[2], var12[3], 2);
      PyroRenderUtil.meth1("A", (float)var10, (float)(var6 + 1 + var7 * 3), -1);
      this.method_1662(var10 + var4, var6 + var7 * 3, var13, var4, var12[0], var12[1], var12[2], var12[3], 3);
      PyroRenderUtil.meth1("R", (float)var10, (float)(var6 + var7 * 4), -1);
      this.method_1664(var10 + var4, var6 + var7 * 4, var13, var4, this.field_1125.method_3449());
      var6 = (int)((float)var6 - this.7());
      switch(this.field_1126) {
      case 1:
         float var14 = MathHelper.clamp((var1 - (float)var5) / (float)var9, 0.0F, 1.0F);
         float var15 = MathHelper.clamp(1.0F - (var2 - this.7() - (float)var6) / (float)var9, 0.0F, 1.0F);
         this.field_1125.meth42(var14);
         this.field_1125.meth72(var15);
         break;
      case 2:
         float var16 = MathHelper.clamp((var2 - this.7() - (float)var6) / (float)var9, 0.0F, 1.0F);
         this.field_1125.meth6(var16);
         break;
      case 3:
         float var17 = MathHelper.clamp((var1 - (float)var10 - (float)var4) / (float)var13, 0.0F, 1.0F);
         this.field_1125.meth5(var17);
         break;
      case 4:
         float var18 = MathHelper.clamp((var1 - (float)var10 - (float)var4) / (float)var13, 0.0F, 1.0F);
         this.field_1125.meth3(var18);
         break;
      case 5:
         float var19 = MathHelper.clamp((var1 - (float)var10 - (float)var4) / (float)var13, 0.0F, 1.0F);
         this.field_1125.meth1(var19);
         break;
      case 6:
         float var20 = MathHelper.clamp((var1 - (float)var10 - (float)var4) / (float)var13, 0.0F, 1.0F);
         this.field_1125.meth0(var20);
         break;
      case 7:
         float var21 = MathHelper.clamp((var1 - (float)var10 - (float)var4) / (float)var13, 0.0F, 1.0F);
         this.field_1125.meth2(var21);
      }

      return false;
   }

   public f5a(f0l var1, float var2) {
      super(var1.3(), 0.0F, 0.0F, var2, 48.0F);
      this.field_1124 = var1;
      this.field_1125 = (f00)var1.c();
   }

   // $FF: renamed from: c (int, int, int, int, float) void
   public void method_1663(int var1, int var2, int var3, int var4, float var5) {
      Tessellator var6 = Tessellator.getInstance();
      BufferBuilder var7 = var6.getBuffer();
      this.method_1661(var7);
      float var8 = 0.0F;
      int var9 = var2;

      for(int var10 = var2 + var4; var9 < var10; ++var9) {
         float var11 = (float)(var9 - var2) / (float)var4;
         float[] var12 = f00.field_2296.method_3689(var8, 1.0F, 1.0F, 1.0F);
         float[] var13 = f00.field_2296.method_3689(var11, 1.0F, 1.0F, 1.0F);
         var7.pos((double)var1, (double)var9 + 1.0D, 0.0D).color(var13[0], var13[1], var13[2], 1.0F).endVertex();
         var7.pos((double)(var1 + var3), (double)var9 + 1.0D, 0.0D).color(var13[0], var13[1], var13[2], 1.0F).endVertex();
         var7.pos((double)(var1 + var3), (double)var9, 0.0D).color(var12[0], var12[1], var12[2], 1.0F).endVertex();
         var7.pos((double)var1, (double)var9, 0.0D).color(var12[0], var12[1], var12[2], 1.0F).endVertex();
         var8 = var11;
      }

      this.method_1666(var7, var1, var2, var3, var4, var5, f00.field_2296.method_3689(var5, 1.0F, 1.0F, 1.0F));
      var6.draw();
      this.method_1668();
   }

   // $FF: renamed from: 0 (int, int, int) void
   public void method_1622(int var1, int var2, int var3) {
      super.method_1622(var1, var2, var3);
      byte var4 = 8;
      byte var5 = 1;
      int var6 = (int)((float)(var5 * 2 + var4) + this.7()) - 10;
      int var7 = var4 + var5;
      int var8 = (int)((this.c() - (float)(var5 * 2)) * 0.41666666F);
      int var9 = (int)((float)(var8 + var5 * 2) + PyroRenderUtil.meth4() + 3.0F);
      int var10 = (int)(this.c() - (float)(var5 * 3) - (float)var8 - PyroRenderUtil.meth4() - 3.0F);
      int var11 = var10 - var4;
      if (var1 >= var5 && var1 <= var5 + var8) {
         this.field_1126 = 1;
      } else if (var1 >= var5 + var8 + 3 && var1 <= var5 + var8 + 3 + var4) {
         this.field_1126 = 2;
      } else if (var1 >= var9 + var4 && var1 <= var9 + var4 + var11 && var2 >= var6 && var2 <= var6 + var4) {
         this.field_1126 = 3;
      } else if (var1 >= var9 + var4 && var1 <= var9 + var4 + var11 && var2 >= var6 + var7 && var2 <= var6 + var4 + var7) {
         this.field_1126 = 4;
      } else if (var1 >= var9 + var4 && var1 <= var9 + var4 + var11 && var2 >= var6 + var7 * 2 && var2 <= var6 + var4 + var7 * 2) {
         this.field_1126 = 5;
      } else if (var1 >= var9 + var4 && var1 <= var9 + var4 + var11 && var2 >= var6 + var7 * 3 && var2 <= var6 + var4 + var7 * 3) {
         this.field_1126 = 6;
      } else if (var1 >= var9 + var4 && var1 <= var9 + var4 + var11 && var2 >= var6 + var7 * 4 && var2 <= var6 + var4 + var7 * 4) {
         this.field_1126 = 7;
      }

   }

   // $FF: renamed from: 0 (int, int, int, int, float) void
   public void method_1664(int var1, int var2, int var3, int var4, float var5) {
      Tessellator var6 = Tessellator.getInstance();
      BufferBuilder var7 = var6.getBuffer();
      this.method_1661(var7);
      float var8 = 0.0F;
      int var9 = var1;

      for(int var10 = var1 + var3; var9 < var10; ++var9) {
         float var11 = (float)(var9 - var1) / (float)var3;
         float[] var12 = f00.field_2296.method_3689(var8, 1.0F, 1.0F, 1.0F);
         float[] var13 = f00.field_2296.method_3689(var11, 1.0F, 1.0F, 1.0F);
         var7.pos((double)var9, (double)(var2 + var4), 0.0D).color(var12[0], var12[1], var12[2], var12[3]).endVertex();
         var7.pos((double)var9 + 1.0D, (double)(var2 + var4), 0.0D).color(var13[0], var13[1], var13[2], var13[3]).endVertex();
         var7.pos((double)var9 + 1.0D, (double)((float)(var2 + var4) - (float)(var9 - var1 + 1) / (float)var3 * (float)var4), 0.0D).color(var13[0], var13[1], var13[2], var13[3]).endVertex();
         var7.pos((double)var9, (double)((float)(var2 + var4) - (float)(var9 - var1) / (float)var3 * (float)var4), 0.0D).color(var12[0], var12[1], var12[2], var12[3]).endVertex();
         var8 = var11;
      }

      float var14 = (float)var1 + var5 * (float)var3 - 0.5F;
      var7.pos((double)var14, (double)(var2 + var4) + 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14 + 1.0D, (double)(var2 + var4) + 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14 + 1.0D, (double)var2 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14, (double)var2 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var6.draw();
      this.method_1668();
   }

   // $FF: renamed from: c (int, int, int, int, float, float, float) void
   public void method_1665(int var1, int var2, int var3, int var4, float var5, float var6, float var7) {
      Tessellator var8 = Tessellator.getInstance();
      BufferBuilder var9 = var8.getBuffer();
      this.method_1661(var9);
      float var10 = 0.0F;
      int var11 = var1;

      for(int var12 = var1 + var3; var11 < var12; ++var11) {
         float var13 = (float)(var11 - var1) / (float)var3;
         float var14 = 1.0F;
         int var15 = var2;

         for(int var16 = var2 + var4; var15 < var16; ++var15) {
            float var17 = 1.0F - (float)(var15 - var2) / (float)var4;
            float[] var18 = f00.field_2296.method_3689(var5, var10, var14, 1.0F);
            float[] var19 = f00.field_2296.method_3689(var5, var10, var17, 1.0F);
            float[] var20 = f00.field_2296.method_3689(var5, var13, var14, 1.0F);
            float[] var21 = f00.field_2296.method_3689(var5, var13, var17, 1.0F);
            var9.pos((double)var11, (double)var15 + 1.0D, 0.0D).color(var19[0], var19[1], var19[2], 1.0F).endVertex();
            var9.pos((double)var11 + 1.0D, (double)var15 + 1.0D, 0.0D).color(var21[0], var21[1], var21[2], 1.0F).endVertex();
            var9.pos((double)var11 + 1.0D, (double)var15, 0.0D).color(var20[0], var20[1], var20[2], 1.0F).endVertex();
            var9.pos((double)var11, (double)var15, 0.0D).color(var18[0], var18[1], var18[2], 1.0F).endVertex();
            var14 = var17;
         }

         var10 = var13;
      }

      float var22 = (float)var1 + var6 * (float)var3 - 0.5F;
      float var23 = (float)var2 + (1.0F - var7) * (float)var4 - 0.5F;
      int var24 = (double)var7 > 0.5D && (double)var6 < 0.5D ? 0 : 255;
      var9.pos((double)var22 - 1.0D, (double)(var23 + 2.0F), 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)(var22 + 2.0F), (double)(var23 + 2.0F), 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)(var22 + 2.0F), (double)var23 - 1.0D, 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)var22 - 1.0D, (double)var23 - 1.0D, 0.0D).color(var24, var24, var24, 255).endVertex();
      float[] var25 = f00.field_2296.method_3689(var5, var6, var7, 1.0F);
      var9.pos((double)var22, (double)var23 + 1.0D, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22 + 1.0D, (double)var23 + 1.0D, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22 + 1.0D, (double)var23, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22, (double)var23, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var8.draw();
      this.method_1668();
   }

   // $FF: renamed from: 0 (net.minecraft.client.renderer.BufferBuilder, int, int, int, int, float, float[]) void
   public void method_1666(BufferBuilder var1, int var2, int var3, int var4, int var5, float var6, float[] var7) {
      float var8 = (float)var3 + var6 * (float)var5 - 0.5F;
      var1.pos((double)var2 - 1.0D, (double)(var8 + 2.0F), 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var2 + var4) + 1.0D, (double)(var8 + 2.0F), 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var2 + var4) + 1.0D, (double)var8 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var2 - 1.0D, (double)var8 - 1.0D, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var2, (double)var8 + 1.0D, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)(var2 + var4), (double)var8 + 1.0D, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)(var2 + var4), (double)var8, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var2, (double)var8, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, float, float, int, int, int, int) void
   public void method_1667(BufferBuilder var1, float var2, float var3, int var4, int var5, int var6, int var7) {
      float[] var8 = new float[]{240.0F, 240.0F, 240.0F};
      float[] var9 = new float[]{130.0F, 130.0F, 130.0F};
      int var10 = var4 / var6;
      int var11 = var5 / var7;
      byte var12 = 0;

      for(int var13 = var6; var12 < var13; ++var12) {
         byte var14 = 0;

         for(int var15 = var7; var14 < var15; ++var14) {
            float[] var16 = (var12 + (var14 % 2 == 0 ? 1 : 0)) % 2 == 0 ? var8 : var9;
            float var17 = (float)(var12 * var10) + var2;
            float var18 = (float)(var14 * var11) + var3;
            float var19 = Math.max((float)(var12 + var10), (float)var4 + var2);
            float var20 = Math.max((float)(var14 + var11), (float)var5 + var3);
            var1.pos((double)var17, (double)var20, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var19, (double)var20, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var19, (double)var18, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var17, (double)var18, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
         }
      }

   }

   // $FF: renamed from: c () void
   public void method_1668() {
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.shadeModel(7424);
   }
}
