/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class fbX extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_692;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_693;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_694;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_695;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_696;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_697;
   // $FF: renamed from: c boolean
   public boolean field_698;

   // $FF: renamed from: c (dev.nuker.pyro.f4d) void
   @f0g
   @LauncherEventHide
   public void method_1012(@NotNull f4d var1) {
      if ((Boolean)this.field_696.c()) {
         Iterator var3 = this.c.world.playerEntities.iterator();

         while(var3.hasNext()) {
            EntityPlayer var2 = (EntityPlayer)var3.next();
            if (Intrinsics.areEqual((Object)var2.getName(), (Object)var1.c())) {
               String var4 = var2.getName();
               Waypoint var5 = new Waypoint(var4 + " logout spot", var2.posX, var2.posY, var2.posZ, CollectionsKt.listOf(var2.dimension));
               WaypointManager.INSTANCE.saveWaypoint(var5);
               break;
            }
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_1013(@NotNull f4t var1) {
      if ((Boolean)this.field_697.c()) {
         if (this.c.currentScreen instanceof GuiGameOver && this.field_698) {
            this.field_698 = false;
            WaypointManager.INSTANCE.saveWaypoint(new Waypoint("death point", this.c.player.posX, this.c.player.posY, this.c.player.posZ, CollectionsKt.listOf(this.c.player.dimension)));
         } else if (this.c.currentScreen == null) {
            this.field_698 = true;
         }
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.Waypoint, double, double, double, float, double, double) void
   public void method_1014(Waypoint var1, double var2, double var4, double var6, float var8, double var9, double var11) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 3 () double
   public double method_1015() {
      return ((Number)this.field_695.c()).doubleValue() / (double)1000;
   }

   public fbX() {
      super("waypoints", "Waypoints", "Shows a marker for positions you set");
      this.field_692 = (f0o)this.register((f0w)(new f0o("mode", "Modes", (String)null, (Enum)fbV.field_1629)));
      this.field_693 = (DoubleSetting)this.register((f0w)(new DoubleSetting("width", "Width", (String)null, 1.8D, 0.1D, 5.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_694 = (BooleanSetting)this.register((f0w)(new BooleanSetting("lines", "Lines", (String)null, false)));
      this.field_695 = (DoubleSetting)this.register((f0w)(new DoubleSetting("scaling", "Scaling", (String)null, 3.0D, 1.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_696 = (BooleanSetting)this.register((f0w)(new BooleanSetting("logoutSpots", "LogoutSpots", (String)null, true)));
      this.field_697 = (BooleanSetting)this.register((f0w)(new BooleanSetting("deathPoints", "DeathPoints", (String)null, false)));
      this.field_698 = true;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1016() {
      return this.field_695;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4b) void
   @f0g
   @LauncherEventHide
   public void method_1017(@NotNull f4b var1) {
      if ((Boolean)this.field_696.c()) {
         Iterator var3 = WaypointManager.INSTANCE.getWaypoints().iterator();

         while(var3.hasNext()) {
            Waypoint var2 = (Waypoint)var3.next();
            if (Intrinsics.areEqual((Object)StringsKt.replace$default(var2.getName(), " logout spot", "", false, 4, (Object)null), (Object)var1.c())) {
               WaypointManager.INSTANCE.deleteWaypoint(var2);
               String var4 = var1.c();
               Pyro.INSTANCE.sendMessage("Deleting " + var4 + " logoutspot as they logged back in");
            }
         }
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_1018(boolean var1) {
      this.field_698 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.Waypoint, double, double, double, float, double, double) void
   public void method_1019(Waypoint var1, double var2, double var4, double var6, float var8, double var9, double var11) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1020() {
      return this.field_693;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_1021() {
      return this.field_692;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.DoubleSetting) void
   public void method_1022(@NotNull DoubleSetting var1) {
      this.field_695 = var1;
   }

   // $FF: renamed from: 7 () boolean
   public boolean method_1023() {
      return this.field_698;
   }

   // $FF: renamed from: c () java.util.List
   @NotNull
   public List method_1024() {
      ArrayList var1 = new ArrayList();
      Iterable var2 = (Iterable)WaypointManager.INSTANCE.getWaypoints();
      boolean var3 = false;
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         Waypoint var6 = (Waypoint)var5;
         boolean var7 = false;
         if (StringsKt.contains$default((CharSequence)var6.getName(), (CharSequence)"logout spot", false, 2, (Object)null) && (Boolean)this.field_696.c()) {
            var1.add(var6);
         } else if (StringsKt.contains$default((CharSequence)var6.getName(), (CharSequence)"death point", false, 2, (Object)null) && (Boolean)this.field_697.c()) {
            var1.add(var6);
         } else {
            var1.add(var6);
         }
      }

      return (List)var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.BooleanSetting) void
   public void method_1025(@NotNull BooleanSetting var1) {
      this.field_697 = var1;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1026() {
      return this.field_696;
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.BooleanSetting) void
   public void method_1027(@NotNull BooleanSetting var1) {
      this.field_694 = var1;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1028() {
      return this.field_697;
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      super.method_123(var1, var2);
      Entity var3 = this.c.getRenderViewEntity();
      if (var3 == null) {
         var3 = (Entity)this.c.player;
      }

      Iterable var4 = (Iterable)this.method_1024();
      boolean var5 = false;

      for(Iterator var6 = var4.iterator(); var6.hasNext(); GlStateManager.popMatrix()) {
         Object var7 = var6.next();
         Waypoint var8 = (Waypoint)var7;
         boolean var9 = false;
         double var10 = this.c.player.dimension == -1 ? var8.getX() / 8.0D : var8.getX();
         double var12 = this.c.player.dimension == -1 ? var8.getY() / 8.0D : var8.getY();
         double var14 = this.c.player.dimension == -1 ? var8.getZ() / 8.0D : var8.getZ();
         PyroRenderUtil.method_1441();
         GlStateManager.pushMatrix();
         RenderManager var10001 = this.c.getRenderManager();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
         }

         double var16 = var10 - ((RenderManagerAccessor)var10001).getRenderPosX();
         var10001 = this.c.getRenderManager();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
         }

         double var18 = var12 - ((RenderManagerAccessor)var10001).getRenderPosY();
         var10001 = this.c.getRenderManager();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
         }

         double var20 = var14 - ((RenderManagerAccessor)var10001).getRenderPosZ();
         AxisAlignedBB var22 = new AxisAlignedBB(var16 - 0.25D, var18, var20 - 0.25D, var16 + 0.25D, var18 + 2.0D, var20 + 0.25D);
         GlStateManager.color(1.0F, 0.0F, 0.0F, 0.7F);
         GL11.glLoadIdentity();
         GL11.glLineWidth((float)((Number)this.field_693.c()).doubleValue());
         EntityRenderer var10000 = this.c.entityRenderer;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
         }

         ((EntityRendererAccessor)var10000).invokeSetupCameraTransform(var2, 0);
         if ((Boolean)this.field_694.c()) {
            double var23 = 0.0D;
            Vec3d var27 = new Vec3d(var23, var23, 1.0D);
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            var27 = var27.rotatePitch((float)(-Math.toRadians((double)var3.rotationPitch)));
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            Vec3d var25 = var27.rotateYaw((float)(-Math.toRadians((double)var3.rotationYaw)));
            double var28 = var25.x;
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            GL11.glVertex3d(var28, (double)var3.getEyeHeight() + var25.y, var25.z);
            GL11.glVertex3d(var16, var18, var20);
            GL11.glEnd();
         }

         GL11.glTranslated(var16, var18, var20);
         GL11.glTranslated(-var16, -var18, -var20);
         PyroRenderUtil.meth1(var22);
         GlStateManager.popMatrix();
         PyroRenderUtil.meth2();
         GlStateManager.pushMatrix();
         Vec3d var26 = this.method_1030(var10, var12, var14);
         if (var26 != null) {
            if (this.c.player.getDistance(var10, var12, var14) > 150.0D) {
               double var10002 = var26.x;
               RenderManager var10003 = this.c.getRenderManager();
               if (var10003 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               var10002 -= ((RenderManagerAccessor)var10003).getRenderPosX();
               double var29 = var26.y;
               RenderManager var10004 = this.c.getRenderManager();
               if (var10004 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               var29 = var29 - ((RenderManagerAccessor)var10004).getRenderPosY() + 0.7D;
               double var30 = var26.z;
               RenderManager var10005 = this.c.getRenderManager();
               if (var10005 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
               }

               this.method_1019(var8, var10002, var29, var30 - ((RenderManagerAccessor)var10005).getRenderPosZ(), var2, var10, var14);
            } else {
               this.method_1014(var8, var16, var18 + 0.7D, var20, var2, var10, var14);
            }
         }
      }

   }

   // $FF: renamed from: 0 (dev.nuker.pyro.BooleanSetting) void
   public void method_1029(@NotNull BooleanSetting var1) {
      this.field_696 = var1;
   }

   // $FF: renamed from: c (double, double, double) net.minecraft.util.math.Vec3d
   public Vec3d method_1030(double var1, double var3, double var5) {
      Entity var13 = this.c.getRenderViewEntity();
      if (var13 == null) {
         var13 = (Entity)this.c.player;
      }

      Vec3d var10000 = new Vec3d;
      if (var13 == null) {
         Intrinsics.throwNpe();
      }

      var10000.<init>(var13.posX, var13.posY, var13.posZ);
      Vec3d var14 = var10000;
      double var15 = var13.getDistance(var1, var3, var5);
      double var7 = var14.x - 150.0D * (var14.x - var1) / var15;
      double var9 = var14.y - 150.0D * (var14.y - var3) / var15;
      double var11 = var14.z - 150.0D * (var14.z - var5) / var15;
      return new Vec3d(var7, var9, var11);
   }

   // $FF: renamed from: 0 (double, double, double) double
   public double method_1031(double var1, double var3, double var5) {
      return RangesKt.coerceAtLeast(var3, RangesKt.coerceAtMost(var5, var1));
   }

   // $FF: renamed from: 5 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1032() {
      return this.field_694;
   }

   // $FF: renamed from: c (dev.nuker.pyro.DoubleSetting) void
   public void method_1033(@NotNull DoubleSetting var1) {
      this.field_693 = var1;
   }
}
