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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class fe5 extends Tessellator {
   // $FF: renamed from: c dev.nuker.pyro.fe5
   public static fe5 field_1245;

   public fe5() {
      super(2097152);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, int, int, int, int, int) void
   public void method_1900(@NotNull BlockPos var1, int var2, int var3, int var4, int var5, int var6) {
      this.method_1925(this.getBuffer(), (float)var1.getX(), (float)var1.getY(), (float)var1.getZ(), 1.0F, 1.0F, 1.0F, var2, var3, var4, var5, var6);
   }

   // $FF: renamed from: c (float, float, float, float, float, float, int, int) void
   public void method_1901(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8) {
      int var9 = var7 >>> 24 & 255;
      int var10 = var7 >>> 16 & 255;
      int var11 = var7 >>> 8 & 255;
      int var12 = var7 & 255;
      this.method_1925(this.getBuffer(), var1, var2, var3, var4, var5, var6, var10, var11, var12, var9, var8);
   }

   // $FF: renamed from: 0 (float, float, float, int, int) void
   public void method_1902(float var1, float var2, float var3, int var4, int var5) {
      int var6 = var4 >>> 24 & 255;
      int var7 = var4 >>> 16 & 255;
      int var8 = var4 >>> 8 & 255;
      int var9 = var4 & 255;
      this.method_1903(this.getBuffer(), var1, var2, var3, 1.0F, 1.0F, 1.0F, var7, var8, var9, var6, var5);
   }

   // $FF: renamed from: 0 (net.minecraft.client.renderer.BufferBuilder, float, float, float, float, float, float, int, int, int, int, int) void
   public void method_1903(@NotNull BufferBuilder var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9, int var10, int var11, int var12) {
      if ((var12 & 1) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 2) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 4) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 8) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 16) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 32) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, double, double, double, double, double, double, int, int) void
   public void method_1904(@NotNull BufferBuilder var1, double var2, double var4, double var6, double var8, double var10, double var12, int var14, int var15) {
      this.method_1914(var1, var2, var4, var6, var8, var10, var12, var14 >>> 16 & 255, var14 >>> 8 & 255, var14 & 255, var14 >>> 24 & 255, var15 >>> 16 & 255, var15 >>> 8 & 255, var15 & 255, var15 >>> 24 & 255);
   }

   // $FF: renamed from: c (float, float, float, int, int) void
   public void method_1905(float var1, float var2, float var3, int var4, int var5) {
      int var6 = var4 >>> 24 & 255;
      int var7 = var4 >>> 16 & 255;
      int var8 = var4 >>> 8 & 255;
      int var9 = var4 & 255;
      this.method_1925(this.getBuffer(), var1, var2, var3, 0.25F, 0.25F, 0.25F, var7, var8, var9, var6, var5);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, int, int) void
   public void method_1906(@NotNull BlockPos var1, int var2, int var3) {
      int var4 = var2 >>> 24 & 255;
      int var5 = var2 >>> 16 & 255;
      int var6 = var2 >>> 8 & 255;
      int var7 = var2 & 255;
      this.method_1911(var1, var5, var6, var7, var4, var3);
   }

   // $FF: renamed from: c () void
   public void method_1907() {
      GL11.glBlendFunc(770, 771);
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.glLineWidth(1.5F);
      GlStateManager.disableTexture2D();
      GlStateManager.depthMask(false);
      GlStateManager.enableBlend();
      GlStateManager.disableDepth();
      GlStateManager.disableLighting();
      GlStateManager.disableCull();
      GlStateManager.enableAlpha();
      GlStateManager.color(1.0F, 1.0F, 1.0F);
   }

   // $FF: renamed from: 2 () void
   public void method_1908() {
      GlStateManager.enableCull();
      GlStateManager.depthMask(true);
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.enableDepth();
   }

   // $FF: renamed from: 0 (float, float, float, float, float, float, int, int, int, int, int) void
   public void method_1909(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10, int var11) {
      this.method_1903(this.getBuffer(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: renamed from: c (float, float, float, float, float, float, int, int, int, int, int) void
   public void method_1910(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10, int var11) {
      this.method_1925(this.getBuffer(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, int, int, int, int, int) void
   public void method_1911(@NotNull BlockPos var1, int var2, int var3, int var4, int var5, int var6) {
      this.method_1903(this.getBuffer(), (float)var1.getX(), (float)var1.getY(), (float)var1.getZ(), 1.0F, 1.0F, 1.0F, var2, var3, var4, var5, var6);
   }

   // $FF: renamed from: 1 () void
   public void method_1912() {
      this.method_1919();
      this.method_1908();
   }

   // $FF: renamed from: 0 (float, float, float, float, float, float, int, int) void
   public void method_1913(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8) {
      int var9 = var7 >>> 24 & 255;
      int var10 = var7 >>> 16 & 255;
      int var11 = var7 >>> 8 & 255;
      int var12 = var7 & 255;
      this.method_1903(this.getBuffer(), var1, var2, var3, var4, var5, var6, var10, var11, var12, var9, var8);
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, double, double, double, double, double, double, int, int, int, int, int, int, int, int) void
   public void method_1914(@NotNull BufferBuilder var1, double var2, double var4, double var6, double var8, double var10, double var12, int var14, int var15, int var16, int var17, int var18, int var19, int var20, int var21) {
      var1.pos(var2, var4, var6).color(var14, var15, var16, var17).endVertex();
      var1.pos(var8, var10, var12).color(var18, var19, var20, var21).endVertex();
   }

   // $FF: renamed from: 0 (int) void
   public void method_1915(int var1) {
      this.method_1907();
      this.method_1922(var1);
   }

   static {
      fe5 var0 = new fe5();
      field_1245 = var0;
   }

   // $FF: renamed from: 1 (net.minecraft.client.renderer.BufferBuilder, float, float, float, float, float, float, int, int, int, int, int) void
   public void method_1916(@NotNull BufferBuilder var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9, int var10, int var11, int var12) {
      if ((var12 & 17) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 18) != 0) {
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 33) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 34) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 5) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 6) != 0) {
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 9) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 10) != 0) {
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 20) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 36) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 24) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 40) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

   }

   // $FF: renamed from: 0 (net.minecraft.util.math.BlockPos, int, int) void
   public void method_1917(@NotNull BlockPos var1, int var2, int var3) {
      int var4 = var2 >>> 24 & 255;
      int var5 = var2 >>> 16 & 255;
      int var6 = var2 >>> 8 & 255;
      int var7 = var2 & 255;
      this.method_1900(var1, var5, var6, var7, var4, var3);
   }

   // $FF: renamed from: 0 (net.minecraft.util.math.AxisAlignedBB, int, int) void
   public void method_1918(@NotNull AxisAlignedBB var1, int var2, int var3) {
      int var4 = var2 >>> 24 & 255;
      int var5 = var2 >>> 16 & 255;
      int var6 = var2 >>> 8 & 255;
      int var7 = var2 & 255;
      this.method_1903(this.getBuffer(), (float)var1.minX, (float)var1.minY, (float)var1.minZ, (float)(var1.maxX - var1.minX), (float)(var1.maxY - var1.minY), (float)(var1.maxZ - var1.minZ), var5, var6, var7, var4, var3);
   }

   // $FF: renamed from: 0 () void
   public void method_1919() {
      this.draw();
   }

   // $FF: renamed from: 1 (float, float, float, int, int) void
   public void method_1920(float var1, float var2, float var3, int var4, int var5) {
      int var6 = var4 >>> 24 & 255;
      int var7 = var4 >>> 16 & 255;
      int var8 = var4 >>> 8 & 255;
      int var9 = var4 & 255;
      this.method_1925(this.getBuffer(), var1, var2, var3, 1.0F, 1.0F, 1.0F, var7, var8, var9, var6, var5);
   }

   // $FF: renamed from: 3 () net.minecraft.client.renderer.BufferBuilder
   @NotNull
   public BufferBuilder method_1921() {
      return this.getBuffer();
   }

   // $FF: renamed from: c (int) void
   public void method_1922(int var1) {
      this.getBuffer().begin(var1, DefaultVertexFormats.POSITION_COLOR);
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, int, int) void
   public void method_1923(@NotNull AxisAlignedBB var1, int var2, int var3) {
      int var4 = var2 >>> 24 & 255;
      int var5 = var2 >>> 16 & 255;
      int var6 = var2 >>> 8 & 255;
      int var7 = var2 & 255;
      this.method_1925(this.getBuffer(), (float)var1.minX, (float)var1.minY, (float)var1.minZ, (float)(var1.maxX - var1.minX), (float)(var1.maxY - var1.minY), (float)(var1.maxZ - var1.minZ), var5, var6, var7, var4, var3);
   }

   // $FF: renamed from: c (float, float, float, float, int) void
   public void method_1924(float var1, float var2, float var3, float var4, int var5) {
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      float var9 = (float)(var5 >> 24 & 255) / 255.0F;
      Tessellator var10 = Tessellator.getInstance();
      BufferBuilder var11 = var10.getBuffer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      var11.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var11.pos((double)var1, (double)var4, 0.0D).color(var6, var7, var8, var9).endVertex();
      var11.pos((double)var3, (double)var4, 0.0D).color(var6, var7, var8, var9).endVertex();
      var11.pos((double)var3, (double)var2, 0.0D).color(var6, var7, var8, var9).endVertex();
      var11.pos((double)var1, (double)var2, 0.0D).color(var6, var7, var8, var9).endVertex();
      var10.draw();
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   // $FF: renamed from: c (net.minecraft.client.renderer.BufferBuilder, float, float, float, float, float, float, int, int, int, int, int) void
   public void method_1925(@NotNull BufferBuilder var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8, int var9, int var10, int var11, int var12) {
      if ((var12 & 1) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 2) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 4) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 8) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 16) != 0) {
         var1.pos((double)var2, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
      }

      if ((var12 & 32) != 0) {
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4).color(var8, var9, var10, var11).endVertex();
         var1.pos((double)var2 + (double)var5, (double)var3 + (double)var6, (double)var4 + (double)var7).color(var8, var9, var10, var11).endVertex();
      }

   }
}
