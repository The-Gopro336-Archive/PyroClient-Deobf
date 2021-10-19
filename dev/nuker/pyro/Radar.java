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
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Radar extends Module {
   public BooleanSetting players = new BooleanSetting("players", "Players", (String)null, true);
   public BooleanSetting friends = new BooleanSetting("friends", "Friends", (String)null, true);
   public BooleanSetting bosses = new BooleanSetting("bosses", "Bosses", (String)null, true);
   public BooleanSetting hostiles = new BooleanSetting("hostiles", "Hostiles", (String)null, true);
   public BooleanSetting passives = new BooleanSetting("passives", "Passives", (String)null, true);
   public BooleanSetting items = new BooleanSetting("items", "Items", (String)null, false);
   public BooleanSetting other = new BooleanSetting("other", "Other", (String)null, false);
   // $FF: renamed from: c dev.nuker.pyro.f0t
   public f0t field_826;
   public f0t var0;
   public f0t var1;
   public f0t var2;
   public f0t var3;
   public f0t var4;
   public f0t var5;
   public DoubleSetting scale;
   public DoubleSetting distance;
   public DoubleSetting changeradius;
   public BooleanSetting hideFrustrum;
   public IntegerSetting tilt;
   public BooleanSetting unlockTilt;
   // $FF: renamed from: c dev.nuker.pyro.fbv
   public static fbv field_827 = new fbv((DefaultConstructorMarker)null);

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, float) void
   public void method_123(@Nullable Vec3d var1x, float var2x) {
      if (this.c.player != null) {
         ICamera var10000 = PyroRenderUtil.field_983;
         Entity var10001 = this.c.getRenderViewEntity();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         double var6 = var10001.posX;
         Entity var10002 = this.c.getRenderViewEntity();
         if (var10002 == null) {
            Intrinsics.throwNpe();
         }

         double var7 = var10002.posY;
         Entity var10003 = this.c.getRenderViewEntity();
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         var10000.setPosition(var6, var7, var10003.posZ);
         GlStateManager.pushMatrix();
         WorldClient var5x = this.c.world;
         if (var5x == null) {
            Intrinsics.throwNpe();
         }

         Iterator var4x = var5x.loadedEntityList.iterator();

         while(true) {
            while(true) {
               while(true) {
                  Entity var3x;
                  do {
                     do {
                        if (!var4x.hasNext()) {
                           GlStateManager.popMatrix();
                           return;
                        }

                        var3x = (Entity)var4x.next();
                     } while(var3x == this.c.getRenderViewEntity());
                  } while((Boolean)this.hideFrustrum.c() && PyroRenderUtil.field_983.isBoundingBoxInFrustum(var3x.getEntityBoundingBox()));

                  if (var3x instanceof EntityPlayer) {
                     if ((Boolean)this.friends.c() && FriendManager.Companion.isFriend((EntityPlayer)var3x)) {
                        this.method_1223(var3x, var1x, this.var0);
                     } else if ((Boolean)this.players.c()) {
                        this.method_1223(var3x, var1x, this.field_826);
                     }
                  } else if (!(var3x instanceof EntityDragon) && !(var3x instanceof EntityWither)) {
                     if (field_827.method_1413(var3x)) {
                        if ((Boolean)this.passives.c()) {
                           this.method_1223(var3x, var1x, this.var3);
                        }
                     } else if (var3x.isCreatureType(EnumCreatureType.MONSTER, false)) {
                        if ((Boolean)this.hostiles.c()) {
                           this.method_1223(var3x, var1x, this.var2);
                        }
                     } else if (var3x instanceof EntityItem) {
                        if ((Boolean)this.items.c()) {
                           this.method_1223(var3x, var1x, this.var4);
                        }
                     } else if ((Boolean)this.other.c()) {
                        this.method_1223(var3x, var1x, this.var5);
                     }
                  } else if ((Boolean)this.bosses.c()) {
                     this.method_1223(var3x, var1x, this.var1);
                  }
               }
            }
         }
      }
   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d) dev.nuker.pyro.Rotation
   @NotNull
   public Rotation method_1220(@NotNull Vec3d var1x, @NotNull Vec3d var2x) {
      double var3x = var2x.x - var1x.x;
      double var5x = var2x.y - var1x.y;
      double var7 = var2x.z - var1x.z;
      double var9 = (double)MathHelper.sqrt(var3x * var3x + var7 * var7);
      return new Rotation(MathHelper.wrapDegrees((float)Math.toDegrees(MathHelper.atan2(var7, var3x)) - 90.0F), MathHelper.wrapDegrees((float)(-Math.toDegrees(MathHelper.atan2(var5x, var9)))));
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_1221(@NotNull Entity var1x) {
      double var10000 = this.method_1224(var1x.posX, var1x.lastTickPosX);
      RenderManager var10001 = this.c.getRenderManager();
      if (var10001 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
      } else {
         double var2x = var10000 - ((RenderManagerAccessor)var10001).getRenderPosX();
         var10000 = this.method_1224(var1x.posY, var1x.lastTickPosY);
         var10001 = this.c.getRenderManager();
         if (var10001 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
         } else {
            double var4x = var10000 - ((RenderManagerAccessor)var10001).getRenderPosY();
            var10000 = this.method_1224(var1x.posZ, var1x.lastTickPosZ);
            var10001 = this.c.getRenderManager();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            } else {
               double var6 = var10000 - ((RenderManagerAccessor)var10001).getRenderPosZ();
               return new Vec3d(var2x, var4x, var6);
            }
         }
      }
   }

   // $FF: renamed from: c (float, float, float, float) void
   public void method_1222(float var1x, float var2x, float var3x, float var4x) {
      GlStateManager.glBegin(6);
      GlStateManager.glVertex3f(var1x, var2x, var3x);
      GlStateManager.glVertex3f(var1x + 0.1F * var4x, var2x, var3x - 0.2F * var4x);
      GlStateManager.glVertex3f(var1x, var2x, var3x - 0.12F * var4x);
      GlStateManager.glVertex3f(var1x - 0.1F * var4x, var2x, var3x - 0.2F * var4x);
      GlStateManager.glEnd();
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity, net.minecraft.util.math.Vec3d, dev.nuker.pyro.f0t) void
   public void method_1223(Entity var1x, Vec3d var2x, f0t var3x) {
      if (this.c.entityRenderer != null) {
         f0w var10000 = this.1(var3x.3() + ".far_color");
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         f00 var4x = (f00)((f0l)var10000).c();
         var10000 = this.1(var3x.3() + ".flat_color");
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         f00 var15;
         if ((Boolean)((BooleanSetting)var10000).c()) {
            var15 = var4x;
         } else {
            var10000 = this.1(var3x.3() + ".near_color");
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            var15 = (f00)((f0l)var10000).c();
         }

         f00 var5x = var15;
         Rotation var8 = this.method_1220(Vec3d.ZERO, this.method_1221(var1x));
         float var6 = var8.meth2();
         float var7 = var8.getPitch();
         float var16 = (float)180 - var6;
         Entity var10001 = this.c.getRenderViewEntity();
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var6 = var16 + var10001.rotationYaw;
         Vec3d var14 = (new Vec3d(0.0D, 0.0D, 1.0D)).rotateYaw((float)Math.toRadians((double)var6)).rotatePitch((float)Math.toRadians(180.0D));
         GlStateManager.blendFunc(770, 771);
         GlStateManager.disableTexture2D();
         GlStateManager.depthMask(false);
         GlStateManager.disableDepth();
         float var9 = (float)((double)var1x.getDistance(this.c.getRenderViewEntity()) / ((Number)this.changeradius.c()).doubleValue());
         GlStateManager.color(var4x.meth7() * var9 + var5x.meth7() * (1.0F - var9), var4x.method_3446() * var9 + var5x.method_3446() * (1.0F - var9), var4x.meth22() * var9 + var5x.meth22() * (1.0F - var9), var4x.meth9() * var9 + var5x.meth9() * (1.0F - var9));
         GlStateManager.disableLighting();
         GlStateManager.loadIdentity();
         EntityRenderer var17 = this.c.entityRenderer;
         if (var17 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
         } else {
            ((EntityRendererAccessor)var17).orientCam(this.c.getRenderPartialTicks());
            float var10 = (float)((Number)this.scale.c()).doubleValue() * 0.2F;
            float var11 = (float)((Number)this.distance.c()).doubleValue() * 0.2F;
            var10001 = this.c.getRenderViewEntity();
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            GlStateManager.translate(0.0F, var10001.getEyeHeight(), 0.0F);
            Entity var18 = this.c.getRenderViewEntity();
            if (var18 == null) {
               Intrinsics.throwNpe();
            }

            GlStateManager.rotate(-var18.rotationYaw, 0.0F, 1.0F, 0.0F);
            var18 = this.c.getRenderViewEntity();
            if (var18 == null) {
               Intrinsics.throwNpe();
            }

            GlStateManager.rotate(var18.rotationPitch, 1.0F, 0.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, 1.0F);
            float var12 = (float)((Number)this.tilt.c()).intValue();
            if ((Boolean)this.unlockTilt.c()) {
               var16 = (float)90;
               var10001 = this.c.getRenderViewEntity();
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               if (var16 - var10001.rotationPitch < var12) {
                  var16 = (float)90;
                  var10001 = this.c.getRenderViewEntity();
                  if (var10001 == null) {
                     Intrinsics.throwNpe();
                  }

                  var12 = var16 - var10001.rotationPitch;
               }
            }

            GlStateManager.rotate(var12, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(var6, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, var11);
            var10000 = this.1(var3x.3() + ".scale");
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            float var13 = (float)((Number)((DoubleSetting)var10000).c()).doubleValue() * var10 * 2.0F;
            this.method_1222((float)var14.x, (float)var14.y, (float)var14.z, var13);
            GlStateManager.enableTexture2D();
            GlStateManager.depthMask(true);
            GlStateManager.enableDepth();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableLighting();
         }
      }
   }

   // $FF: renamed from: c (double, double) double
   public double method_1224(double var1x, double var3x) {
      return var3x + (var1x - var3x) * (double)this.c.getRenderPartialTicks();
   }

   public Radar() {
      super("radar", "Radar", "See nearby entities");
      f0w var10004 = (f0w)this.players;
      f0w[] var10005 = fbv.method_1414(field_827, new f00(0.43F, 1.0F, 1.0F, 1.0F), new f00(0.8F, 1.0F, 1.0F, 1.0F), 0.75D);
      this.field_826 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.friends;
      var10005 = fbv.method_1414(field_827, new f00(0.51F, 1.0F, 1.0F, 1.0F), new f00(0.62F, 1.0F, 1.0F, 1.0F), 0.75D);
      this.var0 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.bosses;
      var10005 = fbv.method_1414(field_827, new f00(0.0F, 1.0F, 0.56F, 0.56F), new f00(0, 1, 1, 1), 0.75D);
      this.var1 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.hostiles;
      var10005 = fbv.method_1414(field_827, new f00(0.16F, 1.0F, 1.0F, 0.17F), new f00(0.08F, 1.0F, 1.0F, 0.88F), 0.5D);
      this.var2 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.passives;
      var10005 = fbv.method_1414(field_827, new f00(0.33F, 0.55F, 1.0F, 0.1F), new f00(0.33F, 0.6F, 1.0F, 0.44F), 0.5D);
      this.var3 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.items;
      var10005 = fbv.method_1414(field_827, new f00(0.5F, 1.0F, 1.0F, 0.3F), new f00(0.5F, 1.0F, 1.0F, 1.0F), 0.3D);
      this.var4 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      var10004 = (f0w)this.other;
      var10005 = fbv.method_1414(field_827, new f00(0.6F, 1.0F, 1.0F, 0.17F), new f00(0.6F, 1.0F, 1.0F, 1.0F), 0.5D);
      this.var5 = (f0t)this.register((f0w)(new f0t(var10004, (f0w[])Arrays.copyOf(var10005, var10005.length))));
      this.scale = (DoubleSetting)this.register((f0w)(new DoubleSetting("scale", "Scale", (String)null, 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.distance = (DoubleSetting)this.register((f0w)(new DoubleSetting("distance", "Distance", (String)null, 1.0D, 0.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.changeradius = (DoubleSetting)this.register((f0w)(new DoubleSetting("change_radius", "Color Change Radius", (String)null, 75.0D, 0.0D, 1000.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.hideFrustrum = (BooleanSetting)this.register((f0w)(new BooleanSetting("hide_frustrum", "Hide In Frustrum", "Hide entities you can see", false)));
      this.tilt = (IntegerSetting)this.register((f0w)(new IntegerSetting("tilt", "Tilt", (String)null, 50, -90, 90, 0, 64, (DefaultConstructorMarker)null)));
      this.unlockTilt = (BooleanSetting)this.register((f0w)(new BooleanSetting("unlockTilt", "Unlock Tilt", "Unlock tilt when you look down", false)));
   }
}
