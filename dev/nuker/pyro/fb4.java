/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityFlagAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.function.Consumer;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fb4 extends Module {
   // $FF: renamed from: c net.minecraft.entity.Entity
   @Nullable
   public Entity field_765;
   // $FF: renamed from: c boolean
   public boolean field_766;
   // $FF: renamed from: c double
   public double field_767;
   // $FF: renamed from: 0 double
   public double field_768;
   // $FF: renamed from: 1 double
   public double field_769;
   // $FF: renamed from: c float
   public float field_770;
   // $FF: renamed from: 0 float
   public float field_771;
   // $FF: renamed from: 1 float
   @JvmField
   public float field_772;
   // $FF: renamed from: 2 float
   @JvmField
   public float field_773;
   // $FF: renamed from: c net.minecraft.util.MovementInputFromOptions
   @NotNull
   public MovementInputFromOptions field_774;
   // $FF: renamed from: c net.minecraft.client.entity.EntityOtherPlayerMP
   @JvmField
   @Nullable
   public EntityOtherPlayerMP field_775;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_776;
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @JvmField
   @NotNull
   public f0z field_777;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_778;
   // $FF: renamed from: 0 boolean
   public boolean field_779;
   // $FF: renamed from: 3 float
   public float field_780;
   // $FF: renamed from: 4 float
   public float field_781;
   // $FF: renamed from: 5 float
   public float field_782;
   // $FF: renamed from: 1 boolean
   public boolean field_783;

   // $FF: renamed from: 1 (double) void
   public void method_1130(double var1) {
      this.field_768 = var1;
   }

   // $FF: renamed from: 2 () boolean
   public boolean method_1131() {
      return this.field_783;
   }

   // $FF: renamed from: c (net.minecraft.util.MovementInputFromOptions) void
   public void method_1132(@NotNull MovementInputFromOptions var1) {
      this.field_774 = var1;
   }

   // $FF: renamed from: g () void
   public void method_1133() {
      EntityOtherPlayerMP var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      EntityOtherPlayerMP var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.lastTickPosX = var10001.posX;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.prevPosX = var10001.lastTickPosX;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.lastTickPosY = var10001.posY;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.prevPosY = var10001.lastTickPosY;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.lastTickPosZ = var10001.posZ;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10001 = this.field_775;
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      var10000.prevPosZ = var10001.lastTickPosZ;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_1134(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketUseEntity) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketUseEntity");
         }

         if (Intrinsics.areEqual((Object)((CPacketUseEntity)var10000).getEntityFromWorld((World)this.c.world), (Object)this.c.player)) {
            var1.0();
         }
      }

      if (var1.c() == f41.field_2120 && (Boolean)PyroStatic.field_2481.c.method_3034() && (fb2)PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472) {
         Packet var2 = var1.c();
         if ((Boolean)PyroStatic.field_2481.field_776.c() && (var2 instanceof CPacketPlayer || var2 instanceof CPacketInput)) {
            var1.0();
         }

         if ((Boolean)PyroStatic.field_2481.field_776.c() && (var2 instanceof CPacketUseEntity || var2 instanceof CPacketVehicleMove)) {
            var1.0();
         }
      }

   }

   // $FF: renamed from: 5 () float
   public float method_1135() {
      return this.field_770;
   }

   // $FF: renamed from: b () double
   public double method_1136() {
      return this.field_767;
   }

   public fb4() {
      super("freecam", "Freecam", "Free your eyes from your body");
      this.field_774 = new MovementInputFromOptions(this.c.gameSettings);
      this.field_776 = new BooleanSetting("packet_cancel", "Riding Packet Cancel", "Cancel riding packets", false);
      Enum var10005 = (Enum)fb2.field_1471;
      List[] var10006 = new List[2];
      byte var12 = 0;
      List[] var11 = var10006;
      List[] var10 = var10006;
      Enum var9 = var10005;
      String var8 = "Camera mode moves the camera, Packet mode desynchronizes position";
      String var7 = "Mode";
      String var6 = "mode";
      boolean var1 = false;
      List var13 = CollectionsKt.emptyList();
      var11[var12] = var13;
      var10[1] = CollectionsKt.listOf(this.field_776);
      this.field_777 = (f0z)this.register((f0w)(new f0z(var6, var7, var8, var9, var10)));
      this.field_778 = (DoubleSetting)this.register((f0w)(new DoubleSetting("speed", "Speed", (String)null, 20.0D, 0.0D, 50.0D, 25.0D)));
      this.field_777.method_3334().c((Consumer)(new fb1(this)));
   }

   // $FF: renamed from: 0 (float, float, float) float
   public float method_1137(float var1, float var2, float var3) {
      float var4 = var1;
      float var5 = var3;
      if (var2 != 0.0F) {
         if (var2 < (float)0) {
            var5 = var3 * -1.0F;
         }

         if (var2 < (float)0 != var1 < (float)0) {
            var4 = 0.0F;
         }

         var4 = MathHelper.clamp(var4 + var5, -1.0F, 1.0F);
      } else {
         var4 = var1 * 0.5F;
      }

      return var4;
   }

   // $FF: renamed from: 4 () float
   public float method_1138() {
      return this.field_782;
   }

   // $FF: renamed from: d () float
   public float method_1139() {
      return this.field_771;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1140(@NotNull f43 var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 2 (boolean) void
   public void method_1141(boolean var1) {
      if (var1) {
         this.field_767 = this.c.player.posX;
         this.field_768 = this.c.player.posY;
         this.field_769 = this.c.player.posZ;
         if (this.c.player.getRidingEntity() != null) {
            this.field_765 = this.c.player.getRidingEntity();
            this.c.player.dismountRidingEntity();
         }

         this.field_770 = this.c.player.rotationPitch;
         this.field_771 = this.c.player.rotationYaw;
         this.field_766 = this.c.player.isElytraFlying();
         this.field_775 = fe4.field_1243.method_1897((EntityPlayer)this.c.player, -6969, false);
         this.field_779 = false;
      } else {
         this.c.player.setPositionAndRotation(this.field_767, this.field_768, this.field_769, this.field_771, this.field_770);
         this.field_769 = 0.0D;
         this.field_768 = this.field_769;
         this.field_767 = this.field_768;
         this.field_771 = 0.0F;
         this.field_770 = this.field_771;
         EntityPlayerSP var10000 = this.c.player;
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityFlagAccessor");
         }

         ((EntityFlagAccessor)var10000).set(7, this.field_766);
         this.c.player.motionZ = 0.0D;
         this.c.player.motionY = this.c.player.motionZ;
         this.c.player.motionX = this.c.player.motionY;
         EntityOtherPlayerMP var10001;
         if (this.field_765 != null) {
            EntityOtherPlayerMP var2 = this.field_775;
            if (var2 == null) {
               Intrinsics.throwNpe();
            }

            if (var2.getRidingEntity() != null) {
               var10000 = this.c.player;
               var10001 = this.field_775;
               if (var10001 == null) {
                  Intrinsics.throwNpe();
               }

               var10000.startRiding(var10001.getRidingEntity(), true);
               this.field_765 = (Entity)null;
            }
         }

         fe4 var3 = fe4.field_1243;
         var10001 = this.field_775;
         if (var10001 == null) {
            Intrinsics.throwNpe();
         }

         var3.method_1896(var10001);
      }

      this.c.player.capabilities.isFlying = var1;
      this.c.player.capabilities.setFlySpeed(var1 ? (float)(((Number)this.field_778.c()).doubleValue() / (double)100.0F) : 0.05F);
      this.c.player.noClip = var1 || this.c.player.isSpectator();
   }

   // $FF: renamed from: e () double
   public double method_1142() {
      return this.field_768;
   }

   // $FF: renamed from: c (double) void
   public void method_1143(double var1) {
      this.field_769 = var1;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: 0 (boolean) void
   public void method_1144(boolean var1) {
      this.field_766 = var1;
   }

   // $FF: renamed from: 3 () float
   public float method_1145() {
      return this.field_780;
   }

   // $FF: renamed from: c (float, float, float) void
   public void method_1146(float var1, float var2, float var3) {
      EntityOtherPlayerMP var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      double var4 = Math.sin((double)var10000.rotationYaw * 3.141592653589793D / 180.0D);
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      double var6 = Math.cos((double)var10000.rotationYaw * 3.141592653589793D / 180.0D);
      double var8 = this.method_1152();
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.motionX = ((double)var3 * var6 - (double)var1 * var4) * var8;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.motionY = (double)var2 * var8;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.motionZ = ((double)var1 * var6 + (double)var3 * var4) * var8;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.noClip = true;
      var10000 = this.field_775;
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      MoverType var10001 = MoverType.SELF;
      EntityOtherPlayerMP var10002 = this.field_775;
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      double var10 = var10002.motionX;
      EntityOtherPlayerMP var10003 = this.field_775;
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      double var11 = var10003.motionY;
      EntityOtherPlayerMP var10004 = this.field_775;
      if (var10004 == null) {
         Intrinsics.throwNpe();
      }

      var10000.move(var10001, var10, var11, var10004.motionZ);
   }

   // $FF: renamed from: c () net.minecraft.util.MovementInputFromOptions
   @NotNull
   public MovementInputFromOptions method_1147() {
      return this.field_774;
   }

   // $FF: renamed from: 1 (boolean) void
   public void method_1148(boolean var1) {
      if (var1) {
         this.field_772 = this.c.player.rotationPitch;
         this.field_773 = this.c.player.rotationYaw;
         this.field_775 = fe4.field_1243.method_1899((EntityPlayer)this.c.player, -6969, false);
         EntityOtherPlayerMP var10000 = this.field_775;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.posX = this.c.player.posX;
         var10000 = this.field_775;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.posY = this.c.player.posY;
         var10000 = this.field_775;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.posZ = this.c.player.posZ;
         this.c.setRenderViewEntity((Entity)this.field_775);
      } else {
         this.c.setRenderViewEntity((Entity)this.c.player);
         if (this.field_775 != null) {
            fe4 var2 = fe4.field_1243;
            EntityOtherPlayerMP var10001 = this.field_775;
            if (var10001 == null) {
               Intrinsics.throwNpe();
            }

            var2.method_1896(var10001);
         }

         this.field_775 = (EntityOtherPlayerMP)null;
      }

   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) void
   public void method_1149(@Nullable Entity var1) {
      this.field_765 = var1;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1150(float var1) {
      this.field_781 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1151() {
      return this.field_776;
   }

   // $FF: renamed from: 8 () double
   public double method_1152() {
      return ((Number)this.field_778.c()).doubleValue() / (double)9;
   }

   // $FF: renamed from: 3 (float) void
   public void method_1153(float var1) {
      this.field_782 = var1;
   }

   // $FF: renamed from: 1 (float) void
   public void method_1154(float var1) {
      this.field_770 = var1;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1155() {
      return this.field_778;
   }

   // $FF: renamed from: 2 (float) void
   public void method_1156(float var1) {
      this.field_780 = var1;
   }

   // $FF: renamed from: a () double
   public double method_1157() {
      return this.field_769;
   }

   // $FF: renamed from: c (boolean, boolean) void
   public void method_1158(boolean var1, boolean var2) {
      EntityOtherPlayerMP var3 = this.field_775;
      if (var3 != null) {
         Minecraft var4 = Minecraft.getMinecraft();
         float var5 = 0.0F;
         float var6 = 0.0F;
         float var7 = 0.0F;
         GameSettings var8 = var4.gameSettings;
         if (var8.keyBindForward.isKeyDown()) {
            ++var5;
         }

         if (var8.keyBindBack.isKeyDown()) {
            var5 += -1.0F;
         }

         if (var8.keyBindLeft.isKeyDown()) {
            ++var7;
         }

         if (var8.keyBindRight.isKeyDown()) {
            var7 += -1.0F;
         }

         if (var8.keyBindJump.isKeyDown()) {
            ++var6;
         }

         if (var8.keyBindSneak.isKeyDown()) {
            var6 += -1.0F;
         }

         if (var8.keyBindSprint.isKeyDown()) {
            this.field_783 = true;
         } else if (var5 == 0.0F) {
            this.field_783 = false;
         }

         float var9 = 0.15F;
         float var10 = var7 * var7 + var5 * var5;
         var10 = var5 != 0.0F && var7 != 0.0F ? (float)Math.sqrt((double)var10 * 0.6D) : 1.0F;
         this.field_780 = this.method_1137(this.field_780, var5, var9) / var10;
         this.field_782 = this.method_1137(this.field_782, var6, var9);
         this.field_781 = this.method_1137(this.field_781, var7, var9) / var10;
         var5 = this.field_783 ? this.field_780 * (float)2 : this.field_780;
         this.method_1146(var5, this.field_782, this.field_781);
      }

   }

   // $FF: renamed from: 0 () boolean
   public boolean method_1159() {
      return this.field_766;
   }

   // $FF: renamed from: 6 () boolean
   public boolean method_1160() {
      return this.field_779;
   }

   // $FF: renamed from: c (float) void
   public void method_1161(float var1) {
      this.field_771 = var1;
   }

   // $FF: renamed from: c (boolean) void
   public void method_1162(boolean var1) {
      this.field_779 = var1;
   }

   // $FF: renamed from: 3 (boolean) void
   public void method_1163(boolean var1) {
      this.field_783 = var1;
   }

   // $FF: renamed from: f () float
   public float method_1164() {
      return this.field_781;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4x) void
   @f0g
   @LauncherEventHide
   public void method_1165(@NotNull f4x var1) {
      var1.0();
   }

   // $FF: renamed from: 0 (double) void
   public void method_1166(double var1) {
      this.field_767 = var1;
   }

   // $FF: renamed from: 7 () net.minecraft.entity.Entity
   @Nullable
   public Entity method_1167() {
      return this.field_765;
   }
}
