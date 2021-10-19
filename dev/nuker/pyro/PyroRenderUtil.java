/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.awt.Color;
import java.util.Objects;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class PyroRenderUtil extends fdZ {
   // $FF: renamed from: c net.minecraft.client.renderer.culling.ICamera
   public static ICamera field_983 = new Frustum();

   public static void meth3() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, int, boolean, int, float, boolean, boolean, int, boolean) void
   public static void method_1426(BlockPos var0, int var1, boolean var2, int var3, float var4, boolean var5, boolean var6, int var7, boolean var8) {
      if (var6) {
         method_1443(var0, new Color(var1 >> 16 & 255, var1 >> 8 & 255, var1 & 255, var7));
      }

      if (var5) {
         method_1433(var0, var2 ? var3 : var1, var4, var8);
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB) void
   public static void method_1427(AxisAlignedBB var0) {
      if (var0 != null) {
         GL11.glBegin(7);
         boolean var1 = true;
         boolean var2 = true;
         boolean var3 = true;
         boolean var4 = true;
         boolean var5 = true;
         boolean var6 = true;
         boolean var7 = true;
         boolean var8 = true;
         boolean var9 = true;
         boolean var10 = true;
         boolean var11 = true;
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
      }
   }

   // $FF: renamed from: c (float, float, float, float, float, int) void
   public static void method_1428(float var0, float var1, float var2, float var3, float var4, int var5) {
      meth0(var0, var1, var0 + var4, var3, var5);
      meth0(var0, var1, var2, var1 + var4, var5);
      meth0(var0, var3, var2, var3 + var4, var5);
      meth0(var2 - var4, var1, var2, var3, var5);
   }

   // $FF: renamed from: c (double, double, double, double, float) void
   public static void method_1429(double var0, double var2, double var4, double var6, float var8) {
      GL11.glDisable(3553);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GL11.glEnable(3553);
   }

   public static void meth0(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      float var9 = (float)(var5 >> 24 & 255) / 255.0F;
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      GL11.glLineWidth(var4);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      Tessellator var10 = Tessellator.getInstance();
      BufferBuilder var11 = var10.getBuffer();
      var11.begin(3, DefaultVertexFormats.POSITION_COLOR);
      var11.pos((double)var0, (double)var1, 0.0D).color(var6, var7, var8, var9).endVertex();
      var11.pos((double)var2, (double)var3, 0.0D).color(var6, var7, var8, var9).endVertex();
      var10.draw();
      GlStateManager.shadeModel(7424);
      GL11.glDisable(2848);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
      GlStateManager.popMatrix();
   }

   // $FF: renamed from: c (int) void
   public static void method_1430(int var0) {
      GL11.glColor4f((float)(var0 >> 16 & 255) / 255.0F, (float)(var0 >> 8 & 255) / 255.0F, (float)(var0 & 255) / 255.0F, (float)(var0 >> 24 & 255) / 255.0F);
   }

   public static void meth2() {
      GL11.glEnable(2896);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(3042);
      GL11.glEnable(3008);
      GL11.glDepthMask(true);
      GL11.glCullFace(1029);
      GL11.glPopMatrix();
      GL11.glPopAttrib();
   }

   public static void meth0(AxisAlignedBB var0) {
      if (var0 != null) {
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, float, java.awt.Color) void
   public static void method_1431(AxisAlignedBB var0, float var1, Color var2) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(var1);
      GL11.glColor4f((float)var2.getRed() / 255.0F, (float)var2.getGreen() / 255.0F, (float)var2.getBlue() / 255.0F, (float)var2.getAlpha() / 255.0F);
      meth1(var0);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, float) net.minecraft.util.math.Vec3d
   public static Vec3d method_1432(Entity var0, float var1) {
      return new Vec3d(var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * (double)var1, var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * (double)var1, var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * (double)var1);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, int, float, boolean) void
   public static void method_1433(BlockPos var0, int var1, float var2, boolean var3) {
      IBlockState var4 = feg.method_1791(var0);
      if ((var3 || var4.getMaterial() != Material.AIR) && c.world.getWorldBorder().contains(var0)) {
         Vec3d var5 = method_1432(c.player, c.getRenderPartialTicks());
         method_1437(var4.getSelectedBoundingBox(c.world, var0).grow(0.0020000000949949026D).offset(-var5.x, -var5.y, -var5.z), var1, var2);
      }

   }

   // $FF: renamed from: c (float, float, float, float, float, int, int) void
   public static void method_1434(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      meth0();
      method_1436(var0, var1, var2, var3, var5);
      method_1430(var6);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(var4);
      GL11.glBegin(3);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      meth3();
   }

   // $FF: renamed from: c (float, float, float, float) void
   public static void method_1435(float var0, float var1, float var2, float var3) {
      GL11.glBegin(7);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
   }

   // $FF: renamed from: c (float, float, float, float, int) void
   public static void method_1436(float var0, float var1, float var2, float var3, int var4) {
      meth0();
      method_1430(var4);
      method_1435(var0, var1, var2, var3);
      meth3();
   }

   public static float meth4() {
      return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.method_4135().getHeight() : (float)c.fontRenderer.FONT_HEIGHT;
   }

   public static void meth1(AxisAlignedBB var0) {
      if (var0 != null) {
         GL11.glBegin(3);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(3);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(1);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, int, float) void
   public static void method_1437(AxisAlignedBB var0, int var1, float var2) {
      float var3 = (float)(var1 >> 24 & 255) / 255.0F;
      float var4 = (float)(var1 >> 16 & 255) / 255.0F;
      float var5 = (float)(var1 >> 8 & 255) / 255.0F;
      float var6 = (float)(var1 & 255) / 255.0F;
      GlStateManager.pushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableDepth();
      GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
      GlStateManager.disableTexture2D();
      GlStateManager.depthMask(false);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glLineWidth(var2);
      Tessellator var7 = Tessellator.getInstance();
      BufferBuilder var8 = var7.getBuffer();
      var8.begin(3, DefaultVertexFormats.POSITION_COLOR);
      var8.pos(var0.minX, var0.minY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.minY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.minY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.minY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.maxZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.minZ).color(var4, var5, var6, var3).endVertex();
      var7.draw();
      GL11.glDisable(2848);
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static float meth0(String var0) {
      return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.method_4135().getStringWidth(var0) : (float)c.fontRenderer.getStringWidth(var0);
   }

   // $FF: renamed from: c (net.minecraft.util.math.AxisAlignedBB, java.awt.Color) void
   public static void method_1438(AxisAlignedBB var0, Color var1) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)var1.getRed() / 255.0F, (float)var1.getGreen() / 255.0F, (float)var1.getBlue() / 255.0F, (float)var1.getAlpha() / 255.0F);
      meth0(var0);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void meth1(String var0, float var1, float var2, int var3) {
      if ((Boolean)PyroStatic.field_2484.method_971().c()) {
         class_59.field_2713.method_4135().drawStringWithShadow(var0, var1, var2, var3);
      } else {
         c.fontRenderer.drawStringWithShadow(var0, var1, var2, var3);
      }

   }

   // $FF: renamed from: c (java.lang.String) float
   public static float method_1439(String var0) {
      if (var0 == null) {
         return 0.0F;
      } else {
         return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.method_4135().getStringWidth(var0) : (float)c.fontRenderer.getStringWidth(var0);
      }
   }

   // $FF: renamed from: c (float, float, float, net.minecraft.entity.Entity, float) void
   public static void method_1440(float var0, float var1, float var2, Entity var3, float var4) {
      method_1442(var0, var1, var2);
      int var5 = (int)var3.getDistance((double)var0, (double)var1, (double)var2);
      float var6 = (float)var5 / 2.0F / (2.0F + (2.0F - var4));
      if (var6 < 1.0F) {
         var6 = 1.0F;
      }

      GlStateManager.scale(var6, var6, var6);
   }

   // $FF: renamed from: c () void
   public static void method_1441() {
      GL11.glPushAttrib(1048575);
      GL11.glPushMatrix();
      GL11.glDisable(3008);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glEnable(2884);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4353);
      GL11.glDisable(2896);
   }

   public static void meth0(float var0, float var1, float var2, float var3, int var4) {
      float var5 = (float)(var4 >> 24 & 255) / 255.0F;
      float var6 = (float)(var4 >> 16 & 255) / 255.0F;
      float var7 = (float)(var4 >> 8 & 255) / 255.0F;
      float var8 = (float)(var4 & 255) / 255.0F;
      Tessellator var9 = Tessellator.getInstance();
      BufferBuilder var10 = var9.getBuffer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      var10.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var10.pos((double)var0, (double)var3, 0.0D).color(var6, var7, var8, var5).endVertex();
      var10.pos((double)var2, (double)var3, 0.0D).color(var6, var7, var8, var5).endVertex();
      var10.pos((double)var2, (double)var1, 0.0D).color(var6, var7, var8, var5).endVertex();
      var10.pos((double)var0, (double)var1, 0.0D).color(var6, var7, var8, var5).endVertex();
      var9.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static float meth1() {
      return (Boolean)PyroStatic.field_2484.method_971().c() ? (float)class_59.field_2713.method_4135().getHeight() : (float)(c.fontRenderer.FONT_HEIGHT + 2);
   }

   // $FF: renamed from: c (float, float, float) void
   public static void method_1442(float var0, float var1, float var2) {
      float var3 = 0.02666667F;
      RenderManagerAccessor var4 = (RenderManagerAccessor)c.getRenderManager();
      GlStateManager.translate((double)var0 - var4.getRenderPosX(), (double)var1 - var4.getRenderPosY(), (double)var2 - var4.getRenderPosZ());
      GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-c.getRenderViewEntity().rotationYaw, 0.0F, 1.0F, 0.0F);
      float var10001 = c.gameSettings.thirdPersonView == 2 ? -1.0F : 1.0F;
      GlStateManager.rotate(c.getRenderViewEntity().rotationPitch, var10001, 0.0F, 0.0F);
      GlStateManager.scale(-var3, -var3, var3);
   }

   // $FF: renamed from: c (net.minecraft.util.math.BlockPos, java.awt.Color) void
   public static void method_1443(BlockPos var0, Color var1) {
      AxisAlignedBB var2 = new AxisAlignedBB((double)var0.getX() - c.getRenderManager().viewerPosX, (double)var0.getY() - c.getRenderManager().viewerPosY, (double)var0.getZ() - c.getRenderManager().viewerPosZ, (double)(var0.getX() + 1) - c.getRenderManager().viewerPosX, (double)(var0.getY() + 1) - c.getRenderManager().viewerPosY, (double)(var0.getZ() + 1) - c.getRenderManager().viewerPosZ);
      field_983.setPosition(((Entity)Objects.requireNonNull(c.getRenderViewEntity())).posX, c.getRenderViewEntity().posY, c.getRenderViewEntity().posZ);
      if (field_983.isBoundingBoxInFrustum(new AxisAlignedBB(var2.minX + c.getRenderManager().viewerPosX, var2.minY + c.getRenderManager().viewerPosY, var2.minZ + c.getRenderManager().viewerPosZ, var2.maxX + c.getRenderManager().viewerPosX, var2.maxY + c.getRenderManager().viewerPosY, var2.maxZ + c.getRenderManager().viewerPosZ))) {
         GlStateManager.pushMatrix();
         GlStateManager.enableBlend();
         GlStateManager.disableDepth();
         GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
         GlStateManager.disableTexture2D();
         GlStateManager.depthMask(false);
         GL11.glEnable(2848);
         GL11.glHint(3154, 4354);
         RenderGlobal.renderFilledBox(var2, (float)var1.getRed() / 255.0F, (float)var1.getGreen() / 255.0F, (float)var1.getBlue() / 255.0F, (float)var1.getAlpha() / 255.0F);
         GL11.glDisable(2848);
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
         GlStateManager.popMatrix();
      }

   }

   // $FF: renamed from: c (java.lang.String, float, float, int) void
   public static void method_1444(String var0, float var1, float var2, int var3) {
      if ((Boolean)PyroStatic.field_2484.method_971().c()) {
         class_59.field_2713.method_4135().drawString(var0, var1, var2, var3);
      } else {
         c.fontRenderer.drawString(var0, (int)var1, (int)var2, var3);
      }

   }

   public static void meth0(String var0, float var1, float var2, int var3) {
      if ((Boolean)PyroStatic.field_2484.method_971().c()) {
         class_59.field_2713.method_4135().drawCenteredString(var0, var1, var2, var3);
      } else {
         c.fontRenderer.drawString(var0, (int)((float)((int)var1) - method_1439(var0) / 2.0F), (int)var2, var3);
      }

   }

   // $FF: renamed from: c (double, double, double, double, int) void
   public static void method_1445(double var0, double var2, double var4, double var6, int var8) {
      float var9 = (float)(var8 >> 24 & 255) / 255.0F;
      float var10 = (float)(var8 >> 16 & 255) / 255.0F;
      float var11 = (float)(var8 >> 8 & 255) / 255.0F;
      float var12 = (float)(var8 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(var10, var11, var12, var9);
      GL11.glBegin(7);
      GL11.glVertex2d(var0, var6);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var4, var2);
      GL11.glVertex2d(var0, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, double, double, double, int) void
   public static void method_1446(Entity var0, double var1, double var3, double var5, int var7) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var1, (float)var3 + var0.height + 0.5F, (float)var5);
      float var8 = 1.0F;
      float var9 = 0.0F;
      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
      float var10 = -c.getRenderManager().playerViewY;
      float var11 = 1.0F;
      float var12 = 0.0F;
      GL11.glRotatef(var10, 0.0F, 1.0F, 0.0F);
      GL11.glScalef(-0.017F, -0.017F, 0.017F);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      byte var13 = 0;
      if (var0.isSneaking()) {
         var13 = 4;
      }

      GL11.glDisable(3553);
      GL11.glPushMatrix();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glEnable(2848);
      GlStateManager.disableLighting();
      method_1445(0.0D, (double)(var13 + 19), 0.0D, (double)(var13 + 21), -16777216);
      method_1445(0.0D, (double)(var13 + 21), 0.0D, (double)(var13 + 46), -16777216);
      method_1445(0.0D, (double)(var13 + 21), 0.0D, (double)(var13 + 25), var7);
      method_1445(0.0D, (double)(var13 + 25), 0.0D, (double)(var13 + 48), var7);
      method_1445(0.0D, (double)(var13 + 19), 0.0D, (double)(var13 + 21), -16777216);
      method_1445(0.0D, (double)(var13 + 21), 0.0D, (double)(var13 + 46), -16777216);
      method_1445(0.0D, (double)(var13 + 21), 0.0D, (double)(var13 + 25), var7);
      method_1445(0.0D, (double)(var13 + 25), 0.0D, (double)(var13 + 48), var7);
      method_1445(0.0D, (double)(var13 + 140), 0.0D, (double)(var13 + 142), -16777216);
      method_1445(0.0D, (double)(var13 + 115), 0.0D, (double)(var13 + 140), -16777216);
      method_1445(0.0D, (double)(var13 + 136), 0.0D, (double)(var13 + 140), var7);
      method_1445(0.0D, (double)(var13 + 113), 0.0D, (double)(var13 + 140), var7);
      method_1445(0.0D, (double)(var13 + 140), 0.0D, (double)(var13 + 142), -16777216);
      method_1445(0.0D, (double)(var13 + 115), 0.0D, (double)(var13 + 140), -16777216);
      method_1445(0.0D, (double)(var13 + 136), 0.0D, (double)(var13 + 140), var7);
      method_1445(0.0D, (double)(var13 + 113), 0.0D, (double)(var13 + 140), var7);
      GlStateManager.enableLighting();
      GL11.glDisable(2848);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      float var14 = 1.0F;
      boolean var15 = true;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public static void meth0() {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }
}
