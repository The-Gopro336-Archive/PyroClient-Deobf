/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Items;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9A extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_339;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_340;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_341;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_342;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_343;
   // $FF: renamed from: c dev.nuker.pyro.far
   @Nullable
   public far field_344;
   // $FF: renamed from: c boolean
   public boolean field_345;
   // $FF: renamed from: 0 boolean
   public boolean field_346;
   // $FF: renamed from: c dev.nuker.pyro.f6n
   @Nullable
   public f6n field_347;
   // $FF: renamed from: 1 boolean
   public boolean field_348;

   // $FF: renamed from: c (dev.nuker.pyro.far) void
   public void method_483(@Nullable far var1) {
      this.field_344 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_484(@NotNull f4e var1) {
      if (this.c.player != null && this.c.player.capabilities != null && !this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying && var1.c() == f41.field_2120 && var1.c() instanceof SPacketPlayerPosLook) {
         Pyro.INSTANCE.sendMessage("Detected a rubberband, toggling LongJump!");
         this.c.method_3033(false);
         far var10000 = this.field_344;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.meth0();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_485(@NotNull f4u var1) {
      if (!var1.c() && var1.c() == f41.field_2120 && (Boolean)this.field_343.c() && this.field_347 != null) {
         f6n var10000;
         if (!this.field_348) {
            if (!this.method_491()) {
               return;
            }

            Ref.ObjectRef var2 = new Ref.ObjectRef();
            var2.element = (EnumFacing)null;
            Ref.BooleanRef var3 = new Ref.BooleanRef();
            var3.element = Intrinsics.areEqual((Object)this.c.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL);
            var10000 = this.field_347;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            f6n var10001;
            if (var10000.method_2995() != null) {
               var1.0();
               var10001 = this.field_347;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               feh var20 = var10001.method_2995();
               if (var20 == null) {
                  Intrinsics.throwNpe();
               }

               var1.method_3140(var20.method_2042().method_2076().meth4());
               var10001 = this.field_347;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var20 = var10001.method_2995();
               if (var20 == null) {
                  Intrinsics.throwNpe();
               }

               var1.method_3139(var20.method_2042().method_2076().meth3());
               var10001 = this.field_347;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var20 = var10001.method_2995();
               if (var20 == null) {
                  Intrinsics.throwNpe();
               }

               var2.element = var20.method_2039();
            } else {
               var10001 = this.field_347;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var2.element = few.method_1732((BlockPos)var10001, true);
               few var19 = few.method_1716();
               var10001 = this.field_347;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               float[] var4 = var19.method_1736((BlockPos)var10001, (EnumFacing)var2.element);
               var1.0();
               var1.method_3140(var4[1]);
               var1.method_3139(var4[0]);
            }

            float var13 = this.c.player.rotationPitch;
            float var5 = this.c.player.rotationYaw;
            float var6 = this.c.getRenderPartialTicks();
            this.c.player.rotationPitch = var1.method_3131();
            this.c.player.rotationYaw = var1.method_3134();
            RayTraceResult var7 = this.c.player.rayTrace((double)this.c.playerController.getBlockReachDistance(), var6);
            Ref.FloatRef var8 = new Ref.FloatRef();
            var8.element = 0.0F;
            Ref.FloatRef var9 = new Ref.FloatRef();
            var9.element = 0.0F;
            Ref.FloatRef var10 = new Ref.FloatRef();
            var10.element = 0.0F;
            if (var7 != null) {
               double var22 = var7.hitVec.x;
               f6n var10002 = this.field_347;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var8.element = (float)(var22 - (double)var10002.getX());
               var22 = var7.hitVec.y;
               var10002 = this.field_347;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var9.element = (float)(var22 - (double)var10002.getY());
               var22 = var7.hitVec.z;
               var10002 = this.field_347;
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               var10.element = (float)(var22 - (double)var10002.getZ());
            }

            this.c.player.rotationPitch = var13;
            this.c.player.rotationYaw = var5;
            var1.method_3133((Consumer)(new f9y(this, var2, var3, var8, var9, var10)));
         } else {
            var10000 = this.field_347;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            double var12 = (double)var10000.getX();
            var10000 = this.field_347;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            double var14 = (double)var10000.getY();
            var10000 = this.field_347;
            if (var10000 == null) {
               Intrinsics.throwNpe();
            }

            double var15 = (double)var10000.getZ();
            List var16 = this.c.world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(var12, var14, var15, var12 + 1.0D, var14 + 2.0D, var15 + 1.0D));
            Iterator var18 = var16.iterator();

            while(var18.hasNext()) {
               Entity var17 = (Entity)var18.next();
               if (var17 instanceof EntityEnderCrystal && fdN.method_1859(var17)) {
                  fex var11 = few.method_1716().method_1725(((EntityEnderCrystal)var17).getEntityBoundingBox(), false, false, false, true);
                  var1.0();
                  var1.method_3140(var11.method_2076().meth4());
                  var1.method_3139(var11.method_2076().meth3());
                  var1.method_3133((Consumer)(new f9z(this, var17)));
                  break;
               }
            }
         }
      }

      if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
         if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
            if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
               far var21 = this.field_344;
               if (var21 == null) {
                  Intrinsics.throwNpe();
               }

               var21.method_1684(var1);
            }

         }
      }
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_486() {
      return this.field_342;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f9A) net.minecraft.client.Minecraft
   public static Minecraft method_487(f9A var0) {
      return var0.c;
   }

   // $FF: renamed from: 3 () boolean
   public boolean method_488() {
      return this.field_345;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_489() {
      return this.field_341;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_490() {
      return this.field_340;
   }

   // $FF: renamed from: c () boolean
   public boolean method_491() {
      if (Intrinsics.areEqual((Object)this.c.player.getHeldItemMainhand().getItem(), (Object)Items.END_CRYSTAL) ^ true && Intrinsics.areEqual((Object)this.c.player.getHeldItemOffhand().getItem(), (Object)Items.END_CRYSTAL) ^ true) {
         int var1 = fdX.field_1227.method_1839(Items.END_CRYSTAL);
         if (var1 != -1) {
            this.c.player.inventory.currentItem = var1;
            this.c.playerController.updateController();
            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_492(@NotNull f4t var1) {
      this.5(((f9w)this.field_339.c()).toString());
      if ((Boolean)this.field_341.c()) {
         if (this.field_346 && this.field_345 && this.c.player.onGround) {
            this.c.method_3033(false);
            return;
         }

         if (this.field_346 && !this.field_345 && !this.c.player.onGround) {
            this.field_345 = true;
         } else if (this.c.player.onGround) {
            this.field_346 = true;
         }
      }

      if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
         if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
            if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
               far var10000 = this.field_344;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.method_1682();
            }

         }
      }
   }

   // $FF: renamed from: a () boolean
   public boolean method_493() {
      return this.field_346;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_494() {
      return this.field_339;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_495(@Nullable f4p var1) {
      if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
         if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
            if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
               far var10000 = this.field_344;
               if (var10000 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.method_1681(var1);
            }

         }
      }
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_496() {
      return this.field_343;
   }

   // $FF: renamed from: 2 () void
   public void method_497() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f9A, net.minecraft.client.Minecraft) void
   public static void method_498(f9A var0, Minecraft var1) {
      var0.c = var1;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.far
   @Nullable
   public far method_499() {
      return this.field_344;
   }

   public f9A() {
      super("longjump", "LongJump", "Allows you to jump farther");
      this.field_339 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f9w.field_2261)));
      this.field_340 = (DoubleSetting)this.register((f0w)(new DoubleSetting("speedInc", "SpeedInc", (String)null, 1.61D, 0.0D, 3.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_341 = (BooleanSetting)this.register((f0w)(new BooleanSetting("quitOnGround", "StopOnGround", "Disables LongJump when you land", false)));
      this.field_342 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useTimer", "UseTimer", (String)null, false)));
      this.field_343 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useCrystal", "UseCrystal", "Attempts to place and break a crystal so you can easily redirect velocity", false)));
      this.field_339.c((Consumer)(new f9v(this)));
   }

   // $FF: renamed from: c (boolean) void
   public void method_500(boolean var1) {
      this.field_346 = var1;
   }

   // $FF: renamed from: 5 () boolean
   public boolean method_501() {
      return this.field_348;
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_502(boolean var1) {
      this.field_345 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.f6n
   @Nullable
   public f6n method_503() {
      return this.field_347;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_345 = false;
      this.field_346 = false;
      this.method_497();
      f0b.field_2415.method_3669("longjump");
      this.field_347 = (f6n)null;
      this.field_348 = false;
      if (var1 && (Boolean)this.field_343.c()) {
         ArrayList var4 = PyroStatic.field_2480.method_195();
         float var5 = 30.0F;
         Iterator var7 = var4.iterator();

         while(var7.hasNext()) {
            f6n var6 = (f6n)var7.next();
            double var8 = this.c.player.getDistanceSq((BlockPos)var6);
            if (!(var8 > (double)10)) {
               float var10 = fdM.method_1881((BlockPos)var6, (EntityLivingBase)this.c.player);
               if (var10 < var5) {
                  var5 = var10;
                  this.field_347 = var6;
               }
            }
         }

         if (this.field_347 == null) {
            Pyro.INSTANCE.sendMessage("No suitable place to crystal at");
         }
      }

   }

   // $FF: renamed from: 1 (boolean) void
   public void method_504(boolean var1) {
      this.field_348 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f6n) void
   public void method_505(@Nullable f6n var1) {
      this.field_347 = var1;
   }
}
