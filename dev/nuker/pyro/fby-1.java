/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fby extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_904 = new BooleanSetting("self", "Self", (String)null, true);
   // $FF: renamed from: c dev.nuker.pyro.f0t
   public f0t field_905;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_906;
   // $FF: renamed from: 0 dev.nuker.pyro.f0t
   public f0t field_907;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_908;
   // $FF: renamed from: 1 dev.nuker.pyro.f0t
   public f0t field_909;
   // $FF: renamed from: c dev.nuker.pyro.fbx
   public static fbx field_910 = new fbx((DefaultConstructorMarker)null);

   public fby() {
      super("rangeVisualizer", "RangeVisualizer", "Shows a circle where you and enemies can place");
      f0w var10004 = (f0w)this.field_904;
      f0w[] var10005 = fbx.method_1415(field_910, f00.field_2296.method_3687(255, 255, 255, 255));
      this.field_905 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      this.field_906 = new BooleanSetting("players", "Players", (String)null, true);
      var10004 = (f0w)this.field_906;
      var10005 = fbx.method_1415(field_910, f00.field_2296.method_3687(255, 0, 0, 255));
      this.field_907 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      this.field_908 = new BooleanSetting("friends", "Friends", (String)null, true);
      var10004 = (f0w)this.field_908;
      var10005 = fbx.method_1415(field_910, f00.field_2296.method_3687(5, 255, 240, 255));
      this.field_909 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer, dev.nuker.pyro.f00) void
   public void method_1337(@NotNull EntityPlayer var1, @NotNull f00 var2) {
      GlStateManager.blendFunc(770, 771);
      GlStateManager.glLineWidth(2.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.depthMask(false);
      GlStateManager.disableDepth();
      GlStateManager.color(var2.meth7(), var2.method_3446(), var2.meth22(), var2.meth9());
      GlStateManager.disableLighting();
      Entity var10001 = this.c.getRenderViewEntity();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      if (Intrinsics.areEqual((Object)var1, (Object)var10001)) {
         GlStateManager.loadIdentity();
         EntityRenderer var10000 = this.c.entityRenderer;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
         }

         ((EntityRendererAccessor)var10000).orientCam(this.c.getRenderPartialTicks());
      }

      Vec3d var3 = this.method_1339((Entity)var1);
      float var4 = 5.0F;
      byte var5 = 100;
      double var6 = 6.283185307179586D;
      GlStateManager.glBegin(2);

      for(int var8 = 0; var8 <= var5; ++var8) {
         float var19 = (float)var3.x;
         double var9 = (double)var8 * var6 / (double)var5;
         float var12 = var19;
         boolean var11 = false;
         double var14 = Math.cos(var9);
         var19 = var12 + var4 * (float)var14;
         float var20 = (float)var3.y;
         float var10002 = (float)var3.z;
         var9 = (double)var8 * var6 / (double)var5;
         float var18 = var10002;
         float var13 = var20;
         var12 = var19;
         var11 = false;
         double var16 = Math.sin(var9);
         GlStateManager.glVertex3f(var12, var13, var18 + var4 * (float)var16);
      }

      GlStateManager.glEnd();
      GlStateManager.enableTexture2D();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableLighting();
   }

   // $FF: renamed from: c (double, double) double
   public double method_1338(double var1, double var3) {
      return var3 + (var1 - var3) * (double)this.c.getRenderPartialTicks();
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1339(@NotNull Entity var1) {
      double var10000 = this.method_1338(var1.posX, var1.lastTickPosX);
      RenderManager var10001 = this.c.getRenderManager();
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
      } else {
         double var2 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosX();
         var10000 = this.method_1338(var1.posY, var1.lastTickPosY);
         var10001 = this.c.getRenderManager();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
         } else {
            double var4 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosY();
            var10000 = this.method_1338(var1.posZ, var1.lastTickPosZ);
            var10001 = this.c.getRenderManager();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            } else {
               double var6 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosZ();
               return new Vec3d(var2, var4, var6);
            }
         }
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1, float var2) {
      WorldClient var10000 = this.c.world;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      Iterator var4 = var10000.playerEntities.iterator();

      while(true) {
         while(true) {
            f0w var10002;
            EntityPlayer var3;
            do {
               do {
                  if (!var4.hasNext()) {
                     if ((Boolean)this.field_904.c()) {
                        EntityPlayer var10001 = (EntityPlayer)this.c.player;
                        var10002 = this.1("self.color");
                        if (var10002 == null) {
                           Intrinsics.throwNpe();
                        }

                        this.method_1337(var10001, (f00)((f0l)var10002).c());
                     }

                     return;
                  }

                  var3 = (EntityPlayer)var4.next();
               } while(!(Intrinsics.areEqual((Object)var3, (Object)this.c.player) ^ true));
            } while(var3.getEntityId() == -6969);

            if ((Boolean)this.field_908.c() && FriendManager.Companion.isFriend(var3)) {
               var10002 = this.1("friends.color");
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               this.method_1337(var3, (f00)((f0l)var10002).c());
            } else if ((Boolean)this.field_906.c()) {
               var10002 = this.1("players.color");
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               this.method_1337(var3, (f00)((f0l)var10002).c());
            }
         }
      }
   }
}
