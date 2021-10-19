/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.NotNull;

public class f0L extends f0Y {
   // $FF: renamed from: c java.lang.String
   @NotNull
   public String field_2360;
   // $FF: renamed from: c dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2361;
   // $FF: renamed from: 0 dev.nuker.pyro.fw
   @NotNull
   public class_6 field_2362;

   // $FF: renamed from: c (int, int, int, int, float) void
   public void method_3593(int var1, int var2, int var3, int var4, float var5) {
      Tessellator var6 = Tessellator.getInstance();
      BufferBuilder var7 = var6.getBuffer();
      this.method_3607(var7);
      float var8 = 0.0F;
      int var9 = var1;

      for(int var10 = var1 + var3; var9 < var10; ++var9) {
         float var11 = (float)(var9 - var1) / (float)var3;
         float[] var12 = f00.field_2296.method_3689(var8, 1.0F, 1.0F, 1.0F);
         float[] var13 = f00.field_2296.method_3689(var11, 1.0F, 1.0F, 1.0F);
         var7.pos((double)var9, (double)var2 + (double)var4, 0.0D).color(var12[0], var12[1], var12[2], var12[3]).endVertex();
         var7.pos((double)var9 + (double)1, (double)var2 + (double)var4, 0.0D).color(var13[0], var13[1], var13[2], var13[3]).endVertex();
         var7.pos((double)var9 + (double)1, (double)(var2 + var4) - (double)((float)(var9 - var1 + 1) / (float)var3 * (float)var4), 0.0D).color(var13[0], var13[1], var13[2], var13[3]).endVertex();
         var7.pos((double)var9, (double)(var2 + var4) - (double)((float)(var9 - var1) / (float)var3 * (float)var4), 0.0D).color(var12[0], var12[1], var12[2], var12[3]).endVertex();
         var8 = var11;
      }

      float var14 = (float)var1 + var5 * (float)var3 - 0.5F;
      var7.pos((double)var14, (double)(var2 + var4) + (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14 + (double)1, (double)(var2 + var4) + (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14 + (double)1, (double)var2 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var7.pos((double)var14, (double)var2 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var6.draw();
      this.method_3600();
   }

   // $FF: renamed from: 1 () java.lang.String
   @NotNull
   public String method_3594() {
      return this.field_2360;
   }

   public f0L(@NotNull f0l var1) {
      super((f0w)var1);
      this.field_2360 = var1.c();
      this.field_2361 = var1.getValue();
      this.field_2362 = (class_6)var1.field_2222;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_26(@NotNull f0F var1, @NotNull f0H var2) {
      return (Boolean)this.field_2362.method_3034() ? (int)((float)10 + (float)(var1.method_3581() - f0H.field_2335 * 2) * 0.41666666F) + f0H.field_2335 * 2 : var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2;
   }

   // $FF: renamed from: c (java.lang.String) void
   public void method_3595(@NotNull String var1) {
      this.field_2360 = var1;
   }

   // $FF: renamed from: c (int, int, int, int, float, float, float, float, int) void
   public void method_3596(int var1, int var2, int var3, int var4, float var5, float var6, float var7, float var8, int var9) {
      Tessellator var10 = Tessellator.getInstance();
      BufferBuilder var11 = var10.getBuffer();
      this.method_3607(var11);
      this.method_3598(var11, (float)var1, (float)var2, var3, var4, var3 / (var4 / 2), 2);
      float var12 = var9 == 0 ? var5 : (var9 == 1 ? var6 : (var9 == 2 ? var7 : var8));
      float var13 = 0.0F;
      int var14 = var1;

      for(int var15 = var1 + var3; var14 < var15; ++var14) {
         float var16 = (float)(var14 - var1) / (float)var3;
         float[] var17 = new float[]{var9 == 0 ? var13 : var5, var9 == 1 ? var13 : var6, var9 == 2 ? var13 : var7, var9 == 3 ? var13 : var8};
         float[] var18 = new float[]{var9 == 0 ? var16 : var5, var9 == 1 ? var16 : var6, var9 == 2 ? var16 : var7, var9 == 3 ? var16 : var8};
         var11.pos((double)var14, (double)var2 + (double)var4, 0.0D).color(var17[0], var17[1], var17[2], var17[3]).endVertex();
         var11.pos((double)var14 + (double)1, (double)var2 + (double)var4, 0.0D).color(var18[0], var18[1], var18[2], var18[3]).endVertex();
         var11.pos((double)var14 + (double)1, (double)var2, 0.0D).color(var18[0], var18[1], var18[2], var18[3]).endVertex();
         var11.pos((double)var14, (double)var2, 0.0D).color(var17[0], var17[1], var17[2], var17[3]).endVertex();
         var13 = var16;
      }

      this.method_3601(var11, var1, var2, var3, var4, var12, new float[]{var5, var6, var7, var8});
      var10.draw();
      this.method_3600();
   }

   // $FF: renamed from: c (int, int, int, int, float, float, float) void
   public void method_3597(int var1, int var2, int var3, int var4, float var5, float var6, float var7) {
      Tessellator var8 = Tessellator.getInstance();
      BufferBuilder var9 = var8.getBuffer();
      this.method_3607(var9);
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
            var9.pos((double)var11, (double)var15 + (double)1, 0.0D).color(var21[0], var21[1], var21[2], 1.0F).endVertex();
            var9.pos((double)var11 + (double)1, (double)var15 + (double)1, 0.0D).color(var19[0], var19[1], var19[2], 1.0F).endVertex();
            var9.pos((double)var11 + (double)1, (double)var15, 0.0D).color(var18[0], var18[1], var18[2], 1.0F).endVertex();
            var9.pos((double)var11, (double)var15, 0.0D).color(var20[0], var20[1], var20[2], 1.0F).endVertex();
            var14 = var17;
         }

         var10 = var13;
      }

      float var22 = (float)var1 + var6 * (float)var3 - 0.5F;
      float var23 = (float)var2 + (1.0F - var7) * (float)var4 - 0.5F;
      int var24 = (double)var7 > 0.5D && (double)var6 < 0.5D ? 0 : 255;
      var9.pos((double)var22 - (double)1, (double)var23 + (double)2, 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)var22 + (double)2, (double)var23 + (double)2, 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)var22 + (double)2, (double)var23 - (double)1, 0.0D).color(var24, var24, var24, 255).endVertex();
      var9.pos((double)var22 - (double)1, (double)var23 - (double)1, 0.0D).color(var24, var24, var24, 255).endVertex();
      float[] var25 = f00.field_2296.method_3689(var5, var6, var7, 1.0F);
      var9.pos((double)var22, (double)var23 + (double)1, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22 + (double)1, (double)var23 + (double)1, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22 + (double)1, (double)var23, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var9.pos((double)var22, (double)var23, 0.0D).color(var25[0], var25[1], var25[2], 1.0F).endVertex();
      var8.draw();
      this.method_3600();
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, float, float, int, int, int, int) void
   public void method_3598(BufferBuilder var1, float var2, float var3, int var4, int var5, int var6, int var7) {
      float[] var8 = new float[]{240.0F, 240.0F, 240.0F};
      float[] var9 = new float[]{130.0F, 130.0F, 130.0F};
      int var10 = var4 / var6;
      int var11 = var5 / var7;
      int var12 = 0;

      for(int var13 = var6; var12 < var13; ++var12) {
         int var14 = 0;

         for(int var15 = var7; var14 < var15; ++var14) {
            float[] var16 = (var12 + (var14 % 2 == 0 ? 1 : 0)) % 2 == 0 ? var8 : var9;
            float var17 = (float)(var12 * var10) + var2;
            float var18 = (float)(var14 * var11) + var3;
            float var19 = Math.max((float)var12 + (float)var10, (float)var4 + var2);
            float var20 = Math.max((float)var14 + (float)var11, (float)var5 + var3);
            var1.pos((double)var17, (double)var20, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var19, (double)var20, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var19, (double)var18, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
            var1.pos((double)var17, (double)var18, 0.0D).color(var16[0], var16[1], var16[2], 1.0F).endVertex();
         }
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H, dev.nuker.pyro.f17) void
   public void method_24(@NotNull f0F var1, @NotNull f0H var2, @NotNull f17 var3) {
      byte var4 = 8;
      int var5 = f0H.field_2335 * 2 + 10;
      int var6 = var4 + f0H.field_2335;
      int var7 = (int)((float)(var1.method_3581() - f0H.field_2335 * 2) * 0.41666666F);
      int var8 = var7 + f0H.field_2335 * 2 + var1.method_3582().FONT_HEIGHT + 3;
      int var9 = var1.method_3581() - f0H.field_2335 * 3 - var7 - var1.method_3582().FONT_HEIGHT;
      int var10 = var9 - var4;
      if (var3.method_3645() == 0) {
         double var11 = var3 instanceof f15 ? ((f15)var3).method_3656() : var3.method_3647();
         double var13 = var3 instanceof f15 ? ((f15)var3).method_3650() : var3.method_3646();
         float var15;
         if (var11 >= (double)f0H.field_2335 && var11 <= (double)var7 && var13 >= (double)var5 && var13 <= (double)(var5 + var7)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)f0H.field_2335) / (double)var7), 0.0F, 1.0F);
            float var16 = MathHelper.clamp(1.0F - (float)((var3.method_3646() - (double)var5) / (double)var7), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth42(var15);
            ((f00)this.field_2361.method_3034()).meth72(var16);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var7 + f0H.field_2335 + 3) && var11 <= (double)(var7 + f0H.field_2335 + 3 + var4) && var13 >= (double)var5 && var13 <= (double)(var5 + var7)) {
            var15 = MathHelper.clamp((float)((var3.method_3646() - (double)var5) / (double)var7), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth6(var15);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var8 + var4) && var11 <= (double)(var8 + var4 + var10) && var13 >= (double)var5 && var13 <= (double)(var5 + var4)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)var8 - (double)var4) / (double)var10), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth5(var15);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var8 + var4) && var11 <= (double)(var8 + var4 + var10) && var13 >= (double)(var5 + var6) && var13 <= (double)(var5 + var4 + var6)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)var8 - (double)var4) / (double)var10), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth3(var15);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var8 + var4) && var11 <= (double)(var8 + var4 + var10) && var13 >= (double)(var5 + var6 * 2) && var13 <= (double)(var5 + var4 + var6 * 2)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)var8 - (double)var4) / (double)var10), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth1(var15);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var8 + var4) && var11 <= (double)(var8 + var4 + var10) && var13 >= (double)(var5 + var6 * 3) && var13 <= (double)(var5 + var4 + var6 * 3)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)var8 - (double)var4) / (double)var10), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth0(var15);
            this.field_2361.method_3035();
         } else if (var11 >= (double)(var8 + var1.method_3582().getStringWidth("Rainbow") + f0H.field_2335) && var13 >= (double)(var5 + var6 * 4 - 2) && var11 <= (double)(var8 + var1.method_3582().getStringWidth("Rainbow") + f0H.field_2335 + var9 - var1.method_3582().getStringWidth("Rainbow")) && var13 <= (double)(var5 + var6 * 4 + var4 + 1)) {
            var15 = MathHelper.clamp((float)((var3.method_3647() - (double)var8 - (double)var1.method_3582().getStringWidth("Rainbow") - (double)f0H.field_2335) / (double)(var9 - var1.method_3582().getStringWidth("Rainbow") - f0H.field_2335 * 2)), 0.0F, 1.0F);
            ((f00)this.field_2361.method_3034()).meth2(var15);
            this.field_2361.method_3035();
         } else if (var3 instanceof f14 && var13 <= (double)(var1.method_3582().FONT_HEIGHT + f0H.field_2335 * 2)) {
            this.field_2362.method_3033(!(Boolean)this.field_2362.method_3034());
            var1.method_3579();
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f0F, dev.nuker.pyro.f0H) int
   public int method_29(@NotNull f0F var1, @NotNull f0H var2) {
      return var1.method_3582().getStringWidth(this.field_2360) + f0H.field_2335 * 2 + 2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fw) void
   public void method_3599(@NotNull class_6 var1) {
      this.field_2362 = var1;
   }

   // $FF: renamed from: 2 () void
   public void method_3600() {
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.shadeModel(7424);
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, int, int, int, int, float, float[]) void
   public void method_3601(BufferBuilder var1, int var2, int var3, int var4, int var5, float var6, float[] var7) {
      float var8 = (float)var2 + var6 * (float)var4 - 0.5F;
      var1.pos((double)var8 - (double)1, (double)(var3 + var5) + (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var8 + (double)2, (double)(var3 + var5) + (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var8 + (double)2, (double)var3 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var8 - (double)1, (double)var3 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      this.method_3598(var1, var8, (float)var3, 1, var5, 1, 2);
      var1.pos((double)var8, (double)var3 + (double)var5, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8 + (double)1, (double)var3 + (double)var5, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8 + (double)1, (double)var3, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var8, (double)var3, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fw) void
   public void method_3602(@NotNull class_6 var1) {
      this.field_2361 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0F, double, double, dev.nuker.pyro.f0H) void
   public void method_28(@NotNull f0F var1, double var2, double var4, @NotNull f0H var6) {
      super.method_28(var1, var2, var4, var6);
      f0J.method_3555(f0J.field_2340, var1.method_3582(), this.field_2360, 0, 0, var1.method_3581() - 4, f0H.field_2335 * 2 + var1.method_3582().FONT_HEIGHT, f0H.field_2336, f0H.field_2335, var6.method_3494(), false, 512, (Object)null);
      int var7 = var1.method_3581() - f0H.field_2335;
      byte var8 = 8;
      Tessellator var9 = Tessellator.getInstance();
      BufferBuilder var10 = var9.getBuffer();
      this.method_3607(var10);
      this.method_3598(var10, (float)var7 - (float)var8, (float)f0H.field_2335, var8, var8, 2, 2);
      var9.draw();
      this.method_3600();
      Gui.drawRect(var7 - var8, f0H.field_2335, var1.method_3581() - f0H.field_2335, f0H.field_2335 + var8, ((f00)this.field_2361.method_3034()).meth1());
      if ((Boolean)this.field_2362.method_3034()) {
         int var11 = f0H.field_2335 * 2 + var8;
         int var12 = var8 + f0H.field_2335;
         float[] var13 = ((f00)this.field_2361.method_3034()).meth6();
         int var14 = (int)((float)(var1.method_3581() - f0H.field_2335 * 2) * 0.41666666F);
         int var15 = var14 + f0H.field_2335 * 2 + var1.method_3582().FONT_HEIGHT + 3;
         int var16 = var1.method_3581() - f0H.field_2335 * 3 - var14 - var1.method_3582().FONT_HEIGHT - 3;
         this.method_3597(f0H.field_2335, var11, var14, var14, var13[0], var13[1], var13[2]);
         this.method_3605(f0H.field_2335 + var14 + 3, var11, var8, var14, var13[0]);
         float[] var17 = f00.field_2296.method_3689(var13[0], var13[1], var13[2], var13[3]);
         int var18 = var16 - var8;
         f0J.field_2340.method_3553(var1.method_3582(), "R", var15, var11 + 1, var6.method_3494());
         this.method_3596(var15 + var8, var11, var18, var8, var17[0], var17[1], var17[2], var17[3], 0);
         f0J.field_2340.method_3553(var1.method_3582(), "G", var15, var11 + 1 + var12, var6.method_3494());
         this.method_3596(var15 + var8, var11 + var12, var18, var8, var17[0], var17[1], var17[2], var17[3], 1);
         f0J.field_2340.method_3553(var1.method_3582(), "B", var15, var11 + 1 + var12 * 2, var6.method_3494());
         this.method_3596(var15 + var8, var11 + var12 * 2, var18, var8, var17[0], var17[1], var17[2], var17[3], 2);
         f0J.field_2340.method_3553(var1.method_3582(), "A", var15, var11 + 1 + var12 * 3, var6.method_3494());
         this.method_3596(var15 + var8, var11 + var12 * 3, var18, var8, var17[0], var17[1], var17[2], var17[3], 3);
         f0J.field_2340.method_3553(var1.method_3582(), "Rainbow", var15, var11 + var12 * 4, ((f00)this.field_2361.method_3034()).meth4() ? var6.method_3488() : var6.method_3494());
         this.method_3593(var15 + var1.method_3582().getStringWidth("Rainbow") + f0H.field_2335, var11 + var12 * 4, var16 - var1.method_3582().getStringWidth("Rainbow") - f0H.field_2335, var8, ((f00)this.field_2361.method_3034()).method_3449());
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3603() {
      return this.field_2361;
   }

   // $FF: renamed from: 0 (net.minecraft.client.renderer.BufferBuilder, int, int, int, int, float, float[]) void
   public void method_3604(BufferBuilder var1, int var2, int var3, int var4, int var5, float var6, float[] var7) {
      float var8 = (float)var3 + var6 * (float)var5 - 0.5F;
      var1.pos((double)var2 - (double)1, (double)var8 + (double)2, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var2 + var4) + (double)1, (double)var8 + (double)2, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)(var2 + var4) + (double)1, (double)var8 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var2 - (double)1, (double)var8 - (double)1, 0.0D).color(255, 255, 255, 255).endVertex();
      var1.pos((double)var2, (double)var8 + (double)1, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var2 + (double)var4, (double)var8 + (double)1, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var2 + (double)var4, (double)var8, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
      var1.pos((double)var2, (double)var8, 0.0D).color(var7[0], var7[1], var7[2], var7[3]).endVertex();
   }

   // $FF: renamed from: 0 (int, int, int, int, float) void
   public void method_3605(int var1, int var2, int var3, int var4, float var5) {
      Tessellator var6 = Tessellator.getInstance();
      BufferBuilder var7 = var6.getBuffer();
      this.method_3607(var7);
      float var8 = 0.0F;
      int var9 = var2;

      for(int var10 = var2 + var4; var9 < var10; ++var9) {
         float var11 = (float)(var9 - var2) / (float)var4;
         float[] var12 = f00.field_2296.method_3689(var8, 1.0F, 1.0F, 1.0F);
         float[] var13 = f00.field_2296.method_3689(var11, 1.0F, 1.0F, 1.0F);
         var7.pos((double)var1, (double)var9 + (double)1, 0.0D).color(var13[0], var13[1], var13[2], 1.0F).endVertex();
         var7.pos((double)var1 + (double)var3, (double)var9 + (double)1, 0.0D).color(var13[0], var13[1], var13[2], 1.0F).endVertex();
         var7.pos((double)var1 + (double)var3, (double)var9, 0.0D).color(var12[0], var12[1], var12[2], 1.0F).endVertex();
         var7.pos((double)var1, (double)var9, 0.0D).color(var12[0], var12[1], var12[2], 1.0F).endVertex();
         var8 = var11;
      }

      this.method_3604(var7, var1, var2, var3, var4, var5, f00.field_2296.method_3689(var5, 1.0F, 1.0F, 1.0F));
      var6.draw();
      this.method_3600();
   }

   // $FF: renamed from: c () dev.nuker.pyro.fw
   @NotNull
   public class_6 method_3606() {
      return this.field_2362;
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder) void
   public void method_3607(BufferBuilder var1) {
      GlStateManager.shadeModel(7425);
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      var1.begin(7, DefaultVertexFormats.POSITION_COLOR);
   }
}
