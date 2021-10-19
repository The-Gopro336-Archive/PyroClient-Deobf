/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class fd0 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_912;
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_913;
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_914;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_915;

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      if ((fdc)this.field_914.c() == fdc.field_1296) {
         if (var1 == null) {
            Intrinsics.throwNpe();
         }

         this.method_1345("S", 0.0D, var1);
         this.method_1345("N", 180.0D, var1);
         this.method_1345("E", -90.0D, var1);
         this.method_1345("W", 90.0D, var1);
         this.method_1345("SE", -45.0D, var1);
         this.method_1345("NE", -135.0D, var1);
         this.method_1345("SW", 45.0D, var1);
         this.method_1345("NW", 135.0D, var1);
      } else if ((fdc)this.field_914.c() == fdc.field_1297) {
         if (var1 == null) {
            Intrinsics.throwNpe();
         }

         this.method_1342("S", 0.0D, var1);
         this.method_1342("N", 180.0D, var1);
         this.method_1342("E", -90.0D, var1);
         this.method_1342("W", 90.0D, var1);
         this.method_1342("SE", -45.0D, var1);
         this.method_1342("NE", -135.0D, var1);
         this.method_1342("SW", 45.0D, var1);
         this.method_1342("NW", 135.0D, var1);
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1341() {
      return this.field_915;
   }

   // $FF: renamed from: c (java.lang.String, double, net.minecraft.util.math.Vec3d) void
   public void method_1342(@NotNull String var1, double var2, @NotNull Vec3d var4) {
      f00 var5 = (f00)this.field_912.c();
      Vec3d var6 = (new Vec3d(0.0D, -1.0D, ((Number)this.field_915.c()).doubleValue())).rotateYaw(-((float)Math.toRadians(var2)));
      Vec3d var7 = (new Vec3d(0.0D, 1.0D, ((Number)this.field_915.c()).doubleValue())).rotateYaw(-((float)Math.toRadians(var2)));
      Vec3d var8 = (new Vec3d(0.0D, -0.0D, ((Number)this.field_915.c()).doubleValue())).rotateYaw(-((float)Math.toRadians(var2)));
      GlStateManager.blendFunc(770, 771);
      GlStateManager.glLineWidth(2.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.depthMask(false);
      GlStateManager.disableDepth();
      GlStateManager.color(var5.meth7(), var5.method_3446(), var5.meth22(), var5.meth9());
      GlStateManager.disableLighting();
      GlStateManager.loadIdentity();
      EntityRenderer var10000 = this.c.entityRenderer;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
      } else {
         ((EntityRendererAccessor)var10000).orientCam(this.c.getRenderPartialTicks());
         GlStateManager.glBegin(1);
         boolean var10 = false;
         boolean var11 = false;
         fd0 var12 = (fd0)this;
         boolean var13 = false;
         double var15 = var6.x;
         double var10001 = var6.y;
         Entity var10002 = var12.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         GL11.glVertex3d(var15, var10001 + (double)var10002.getEyeHeight(), var6.z);
         var15 = var7.x;
         var10001 = var7.y;
         var10002 = var12.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         GL11.glVertex3d(var15, var10001 + (double)var10002.getEyeHeight(), var7.z);
         var15 = var8.x;
         var10001 = var8.y;
         var10002 = var12.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         GL11.glVertex3d(var15, var10001 + (double)var10002.getEyeHeight(), var8.z);
         GlStateManager.glEnd();
         GlStateManager.enableTexture2D();
         float var16 = (float)var4.x + (float)var8.x;
         float var17 = (float)var4.y + (float)var8.y;
         var10002 = this.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         PyroRenderUtil.method_1440(var16, var17 + var10002.getEyeHeight(), (float)var4.z + (float)var8.z, this.c.getRenderViewEntity(), 0.1F);
         GlStateManager.disableDepth();
         GlStateManager.translate(-((double)PyroRenderUtil.method_1439(var1) / 2.0D), 0.0D, 0.0D);
         PyroRenderUtil.meth1(var1, 0.0F, 0.0F, ((f00)this.field_913.c()).meth1());
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableLighting();
      }
   }

   public fd0() {
      super("compass", "Compass", "Shows cardinal directions in the world");
      this.field_912 = (f0l)this.register((f0w)(new f0l("lineColor", "Line Color", (String)null, f00.field_2296.method_3687(255, 0, 0, 255))));
      this.field_913 = (f0l)this.register((f0w)(new f0l("textColor", "Text Color", (String)null, f00.field_2296.method_3687(255, 255, 255, 255))));
      this.field_914 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)fdc.field_1296)));
      this.field_915 = (DoubleSetting)this.register((f0w)(new DoubleSetting("distance", "Distance", "Length of yaw lines", 1.0D, 0.4D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1343() {
      return this.field_914;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1344() {
      return this.field_912;
   }

   // $FF: renamed from: 0 (java.lang.String, double, net.minecraft.util.math.Vec3d) void
   public void method_1345(@NotNull String var1, double var2, @NotNull Vec3d var4) {
      f00 var5 = (f00)this.field_912.c();
      Vec3d var10000 = new Vec3d(0.0D, 0.0D, 0.0D);
      Entity var10001 = this.c.getRenderViewEntity();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      Vec3d var6 = var10000.rotateYaw((float)Math.toRadians((double)var10001.rotationYaw));
      var10000 = new Vec3d(0.0D, -0.8D, 0.0D);
      var10001 = this.c.getRenderViewEntity();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      Vec3d var7 = var10000.rotateYaw((float)Math.toRadians((double)var10001.rotationYaw));
      Vec3d var8 = (new Vec3d(0.0D, -0.8D, ((Number)this.field_915.c()).doubleValue())).rotateYaw(-((float)Math.toRadians(var2)));
      GlStateManager.blendFunc(770, 771);
      GlStateManager.glLineWidth(2.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.depthMask(false);
      GlStateManager.disableDepth();
      GlStateManager.color(var5.meth7(), var5.method_3446(), var5.meth22(), var5.meth9());
      GlStateManager.disableLighting();
      GlStateManager.loadIdentity();
      EntityRenderer var15 = this.c.entityRenderer;
      if (var15 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
      } else {
         ((EntityRendererAccessor)var15).orientCam(this.c.getRenderPartialTicks());
         GlStateManager.glBegin(1);
         boolean var10 = false;
         boolean var11 = false;
         fd0 var12 = (fd0)this;
         boolean var13 = false;
         double var16 = var7.x;
         double var17 = var7.y;
         Entity var10002 = var12.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         GL11.glVertex3d(var16, var17 + (double)var10002.getEyeHeight(), var7.z);
         var16 = var8.x;
         var17 = var8.y;
         var10002 = var12.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         GL11.glVertex3d(var16, var17 + (double)var10002.getEyeHeight(), var8.z);
         GlStateManager.glEnd();
         GlStateManager.enableTexture2D();
         float var18 = (float)var6.x + (float)var4.x + (float)var8.x;
         float var19 = (float)var6.y + (float)var4.y + (float)var8.y;
         var10002 = this.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         PyroRenderUtil.method_1440(var18, var19 + var10002.getEyeHeight(), (float)var6.z + (float)var4.z + (float)var8.z, this.c.getRenderViewEntity(), 0.1F);
         GlStateManager.disableDepth();
         GlStateManager.translate(-((double)PyroRenderUtil.method_1439(var1) / 2.0D), 0.0D, 0.0D);
         PyroRenderUtil.meth1(var1, 0.0F, 0.0F, ((f00)this.field_913.c()).meth1());
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableLighting();
      }
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1346() {
      return this.field_913;
   }
}
