/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketVehicleMoveAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.network.play.server.SPacketMoveVehicle;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9e extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_177 = (DoubleSetting)this.register((f0w)(new DoubleSetting("speed", "Speed", (String)null, 1.0D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_178 = (DoubleSetting)this.register((f0w)(new DoubleSetting("upSpeed", "UpSpeed", (String)null, 1.0D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_179 = (DoubleSetting)this.register((f0w)(new DoubleSetting("downSpeed", "DownSpeed", (String)null, 1.0D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_180 = (BooleanSetting)this.register((f0w)(new BooleanSetting("ncp", "NCP", (String)null, true)));
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_181 = (BooleanSetting)this.register((f0w)(new BooleanSetting("antiKick", "AntiKick", (String)null, true)));
   // $FF: renamed from: 2 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_182 = (DoubleSetting)this.register((f0w)(new DoubleSetting("scale", "RenderScale", "Make the first person boat render smaller", 0.4D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_183;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_184;
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_185;
   // $FF: renamed from: 1 int
   public int field_186;
   // $FF: renamed from: c boolean
   public boolean field_187;
   // $FF: renamed from: 2 int
   public int field_188;
   // $FF: renamed from: c double
   public double field_189;
   // $FF: renamed from: 3 int
   public int field_190;
   // $FF: renamed from: c long
   public long field_191;
   // $FF: renamed from: c float
   public float field_192;

   // $FF: renamed from: 8 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_260() {
      return this.field_182;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_261(@NotNull f4e var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_262(@NotNull f4t var1) {
      if (this.field_191 + (long)1000 < System.currentTimeMillis()) {
         this.field_191 = System.currentTimeMillis();
         this.field_190 -= ((Number)this.field_184.c()).intValue();
         if (this.field_190 < 0) {
            this.field_190 = 0;
         }
      }

      if (this.c.player.isRiding() && this.field_188 > 0 && (Boolean)this.field_180.c() && this.c.player.ticksExisted % 2 == 0) {
         NetHandlerPlayClient var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         CPacketUseEntity var10001 = new CPacketUseEntity;
         Entity var10003 = this.c.player.getRidingEntity();
         if (var10003 == null) {
            Intrinsics.throwNpe();
         }

         var10001.<init>(var10003, EnumHand.OFF_HAND);
         var10000.sendPacket((Packet)var10001);
         var10000 = this.c.getConnection();
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         int var2;
         this.field_188 = (var2 = this.field_188) + 1;
         var10000.sendPacket((Packet)(new CPacketConfirmTeleport(var2)));
      }

   }

   public f9e() {
      super("boatfly", "BoatFly", "Allows you to fly with boats");
      this.field_183 = (f0o)this.register((f0w)(new f0o("rubberMode", "RubberMode", "Figure out which rubberband packets to accept", (Enum)f9b.field_1969)));
      this.field_184 = (IntegerSetting)this.register((f0w)(new IntegerSetting("frequency", "Frequency", "Amount of rubberband packets sent in one second to actually rubberband", 15, 1, 20, 0, 64, (DefaultConstructorMarker)null)));
      this.field_185 = (IntegerSetting)this.register((f0w)(new IntegerSetting("distance", "Distance", "Minimum distance to count a rubberband packet as valid", 35, 1, 100, 0, 64, (DefaultConstructorMarker)null)));
      this.field_189 = -1.0D;
   }

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_263() {
      return this.field_183;
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_264() {
      return this.field_180;
   }

   // $FF: renamed from: 7 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_265() {
      return this.field_185;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_188 = 0;
      this.field_189 = -1.0D;
      this.field_192 = this.c.player.rotationYaw;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_266() {
      return this.field_177;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_267(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         Packet var2 = var1.c();
         Packet var10000;
         Entity var4;
         if (var2 instanceof CPacketVehicleMove) {
            var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketVehicleMove");
            }

            CPacketVehicleMove var3 = (CPacketVehicleMove)var10000;
            if ((Boolean)this.field_181.c() && this.field_187) {
               var4 = this.c.player.getRidingEntity();
               if (var4 == null) {
                  Intrinsics.throwNpe();
               }

               if (!var4.onGround) {
                  WorldClient var5 = this.c.world;
                  Entity var10002 = this.c.player.getRidingEntity();
                  if (var10002 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var5.getCollisionBoxes((Entity)null, var10002.getEntityBoundingBox().grow(0.0625D).expand(0.0D, -0.05D, 0.0D)).isEmpty()) {
                     this.field_187 = false;
                     var10000 = var1.c();
                     if (var10000 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.CPacketVehicleMoveAccessor");
                     }

                     ((CPacketVehicleMoveAccessor)var10000).setY(var3.getY() - 0.05D);
                  }
               }
            }
         } else if (var2 instanceof CPacketSteerBoat) {
            var1.0();
         } else if (var2 instanceof CPacketInput) {
            if (this.c.player.isRiding()) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketInput");
               }

               if (((CPacketInput)var10000).isSneaking()) {
                  var4 = this.c.player.getRidingEntity();
                  if (var4 == null) {
                     Intrinsics.throwNpe();
                  }

                  if (var4.onGround) {
                     return;
                  }
               }

               var1.0();
            }
         } else if (var2 instanceof CPacketPlayer) {
            if (this.c.player.isRiding()) {
               var1.0();
            }
         } else if (var2 instanceof CPacketEntityAction && this.c.player.isRiding()) {
            var10000 = var1.c();
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketEntityAction");
            }

            if (((CPacketEntityAction)var10000).getAction() != Action.OPEN_INVENTORY) {
               var1.0();
            }
         }
      }

   }

   // $FF: renamed from: c (float) void
   public void method_268(float var1) {
      this.field_192 = var1;
   }

   // $FF: renamed from: 9 () float
   public float method_269() {
      return this.field_192;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_270() {
      return this.field_181;
   }

   // $FF: renamed from: 3 () void
   public void method_271() {
      if (this.c.player.isRiding()) {
         Entity var1 = this.c.player.getRidingEntity();
         if (var1 != null) {
            int var10001 = this.field_186++;
            this.field_187 = !this.c.player.movementInput.sneak && this.c.player.ticksExisted % 2 == 0 && !var1.collidedHorizontally && this.c.world.getCollisionBoxes((Entity)null, var1.getEntityBoundingBox().grow(0.0625D).expand(0.0D, -0.05D, 0.0D)).isEmpty();
            if (this.field_186 > 2) {
               this.field_186 = 0;
            }

            var1.motionY = 0.0D;
            double[] var2 = fec.method_1754(((Number)this.field_177.c()).doubleValue());
            double[] var3 = (Boolean)PyroStatic.field_2467.c.method_3034() ? PyroStatic.field_2467.method_1216(((Number)this.field_177.c()).doubleValue()) : null;
            if (var3 != null) {
               ;
            }

            if ((Boolean)PyroStatic.field_2467.c.method_3034()) {
               double[] var4 = PyroStatic.field_2467.method_1216(((Number)this.field_177.c()).doubleValue());
               if (var4 != null) {
                  var1.motionX = var4[0];
                  var1.motionZ = var4[1];
                  var1.motionY = var4[2];
               } else {
                  var1.motionX = 0.0D;
                  var1.motionY = 0.0D;
                  var1.motionZ = 0.0D;
               }
            } else {
               if (this.c.player.movementInput.jump) {
                  var1.motionY = ((Number)this.field_178.c()).doubleValue();
               } else if (this.c.player.movementInput.sneak) {
                  var1.motionY = -((Number)this.field_179.c()).doubleValue();
               }

               fec.method_1753(((Number)this.field_177.c()).doubleValue());
            }
         }
      } else {
         this.field_189 = -1.0D;
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_272() {
      return this.field_178;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_273() {
      return this.field_179;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_274() {
      return this.field_184;
   }
}
