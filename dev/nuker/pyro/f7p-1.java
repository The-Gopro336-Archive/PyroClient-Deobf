/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.SPacketPlayerPosLookAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import io.netty.util.internal.ConcurrentSet;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f7p extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_374;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_375;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_376;
   // $FF: renamed from: 1 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_377;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_378;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_379;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_380;
   // $FF: renamed from: 1 int
   public int field_381;
   // $FF: renamed from: c io.netty.util.internal.ConcurrentSet
   @NotNull
   public ConcurrentSet field_382;
   // $FF: renamed from: c java.util.Random
   @NotNull
   public Random field_383;
   // $FF: renamed from: c java.util.concurrent.ConcurrentHashMap
   @NotNull
   public ConcurrentHashMap field_384;
   // $FF: renamed from: 2 int
   public int field_385;
   // $FF: renamed from: 3 int
   public int field_386;
   // $FF: renamed from: 4 int
   public int field_387;
   // $FF: renamed from: c boolean
   public boolean field_388;

   // $FF: renamed from: 2 () java.util.Random
   @NotNull
   public Random method_552() {
      return this.field_383;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(3)
   @LauncherEventHide
   public void method_553(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         if (((Number)this.field_378.c()).doubleValue() != 1.0D) {
            f0b.field_2415.method_3667("packetfly", f07.field_2303, (float)((Number)this.field_378.c()).doubleValue());
         }

         this.5(((f7k)this.field_374.c()).toString());
         this.c.player.setVelocity(0.0D, 0.0D, 0.0D);
         if ((f7k)this.field_374.c() != f7k.field_1858 && this.field_381 == 0) {
            if (this.method_577(4)) {
               this.method_556(0.0D, 0.0D, 0.0D, false);
            }

         } else {
            boolean var2 = this.method_584();
            double var3 = 0.0D;
            var3 = !this.c.player.movementInput.jump || !var2 && fec.method_1758() ? (this.c.player.movementInput.sneak ? -0.062D : (!var2 ? (this.method_577(4) ? ((Boolean)this.field_379.c() ? -0.04D : 0.0D) : 0.0D) : 0.0D)) : ((Boolean)this.field_379.c() && !var2 ? (this.method_577((f7k)this.field_374.c() == f7k.field_1858 ? 10 : 20) ? -0.032D : 0.062D) : 0.062D);
            if ((f7l)this.field_376.c() == f7l.field_1864 && var2 && fec.method_1758() && var3 != 0.0D) {
               var3 /= 1.5D;
            }

            double[] var5 = fec.method_1754((f7l)this.field_376.c() == f7l.field_1864 && var2 ? 0.034444444444444444D : 0.26D);
            int var6 = 1;
            if ((f7k)this.field_374.c() == f7k.field_1857 || (f7k)this.field_374.c() == f7k.field_1859 && this.c.player.ticksExisted % 20 == 0) {
               var6 = ((Number)this.field_375.c()).intValue();
            }

            int var7 = 1;
            int var8 = var6;
            if (var7 <= var6) {
               while(true) {
                  if ((f7k)this.field_374.c() == f7k.field_1860) {
                     if (this.c.player.ticksExisted % 2 == 0) {
                        if (this.field_388 && var3 >= (double)0) {
                           this.field_388 = false;
                           var3 = -0.032D;
                        }

                        this.c.player.motionX = var5[0] * (double)var7;
                        this.c.player.motionZ = var5[1] * (double)var7;
                        this.c.player.motionY = var3 * (double)var7;
                        this.method_556(this.c.player.motionX, this.c.player.motionY, this.c.player.motionZ, !(Boolean)this.field_380.c());
                     } else if (var3 < (double)0) {
                        this.field_388 = true;
                     }
                  } else {
                     this.c.player.motionX = var5[0] * (double)var7;
                     this.c.player.motionZ = var5[1] * (double)var7;
                     this.c.player.motionY = var3 * (double)var7;
                     this.method_556(this.c.player.motionX, this.c.player.motionY, this.c.player.motionZ, (f7k)this.field_374.c() != f7k.field_1858);
                  }

                  if (var7 == var8) {
                     break;
                  }

                  ++var7;
               }
            }

         }
      }
   }

   // $FF: renamed from: 3 (int) void
   public void method_554(int var1) {
      this.field_387 = var1;
   }

   // $FF: renamed from: 4 (int) void
   public void method_555(int var1) {
      this.field_385 = var1;
   }

   // $FF: renamed from: c (double, double, double, boolean) void
   public void method_556(double var1, double var3, double var5, boolean var7) {
      Vec3d var8 = new Vec3d(var1, var3, var5);
      Vec3d var9 = this.c.player.getPositionVector().add(var8);
      Vec3d var10 = this.method_561(var8, var9);
      this.method_573((CPacketPlayer)(new Position(var9.x, var9.y, var9.z, this.c.player.onGround)));
      this.method_573((CPacketPlayer)(new Position(var10.x, var10.y, var10.z, this.c.player.onGround)));
      if (var7) {
         NetHandlerPlayClient var10000 = this.c.player.connection;
         ++this.field_381;
         var10000.sendPacket((Packet)(new CPacketConfirmTeleport(this.field_381)));
         ((Map)this.field_384).put(this.field_381, new f7j(this, var9.x, var9.y, var9.z, System.currentTimeMillis()));
      }

   }

   // $FF: renamed from: b () int
   public int method_557() {
      if (this.c.isSingleplayer()) {
         return 2000;
      } else {
         int var1 = this.field_383.nextInt(29000000);
         return this.field_383.nextBoolean() ? var1 : -var1;
      }
   }

   // $FF: renamed from: 6 () void
   public void method_558() {
      this.field_385 = 0;
      this.field_381 = 0;
      this.field_382.clear();
      this.field_384.clear();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4J) void
   @f0g
   @LauncherEventHide
   public void method_559(@Nullable f4J var1) {
      this.method_558();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4x) void
   @f0g
   @LauncherEventHide
   public void method_560(@NotNull f4x var1) {
      var1.0();
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_381 = -1;
      this.field_386 = 0;
      this.field_387 = 0;
      f0b.field_2415.method_3669("packetfly");
      if (var1 && this.c.player != null) {
         this.method_558();
      }

   }

   // $FF: renamed from: c (net.minecraft.util.math.Vec3d, net.minecraft.util.math.Vec3d) net.minecraft.util.math.Vec3d
   @NotNull
   public Vec3d method_561(@NotNull Vec3d var1, @NotNull Vec3d var2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (boolean) void
   public void method_562(boolean var1) {
      this.field_388 = var1;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_563() {
      return this.field_380;
   }

   // $FF: renamed from: h () java.util.concurrent.ConcurrentHashMap
   @NotNull
   public ConcurrentHashMap method_564() {
      return this.field_384;
   }

   public f7p() {
      super("packetfly", "PacketFly", "Allows you to fly on NCP by spoofing packets");
      this.field_374 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f7k.field_1856)));
      this.field_375 = (IntegerSetting)this.register((f0w)(new IntegerSetting("factor", "Factor", (String)null, 1, 1, 10, 0, 64, (DefaultConstructorMarker)null)));
      this.field_376 = (f0o)this.register((f0w)(new f0o("phase", "Phase", (String)null, (Enum)f7l.field_1864)));
      this.field_377 = (f0o)this.register((f0w)(new f0o("type", "Type", (String)null, (Enum)f7m.field_1868)));
      this.field_378 = (DoubleSetting)this.register((f0w)(new DoubleSetting("timer", "Timer", (String)null, 1.0D, 0.1D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
      this.field_379 = (BooleanSetting)this.register((f0w)(new BooleanSetting("antiKick", "AntiKick", (String)null, true)));
      this.field_380 = (BooleanSetting)this.register((f0w)(new BooleanSetting("limitJitter", "LimitJitter", "Limits packetfly jitter, useful on strict NCP configs", false)));
      this.field_381 = -1;
      this.field_382 = new ConcurrentSet();
      this.field_383 = new Random();
      this.field_384 = new ConcurrentHashMap();
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_565() {
      return this.field_374;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_566() {
      return this.field_379;
   }

   // $FF: renamed from: f () int
   public int method_567() {
      return this.field_387;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_568(@Nullable f43 var1) {
      this.field_384.entrySet().removeIf((Predicate)f7o.field_1849);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(3)
   @LauncherEventHide
   public void method_569(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !var1.c()) {
         if ((f7k)this.field_374.c() != f7k.field_1858 && this.field_381 == 0) {
            return;
         }

         var1.0();
         var1.method_3125(this.c.player.motionX);
         var1.method_3120(this.c.player.motionY);
         var1.method_3127(this.c.player.motionZ);
         if ((f7l)this.field_376.c() != f7l.field_1862 && ((f7l)this.field_376.c() == f7l.field_1863 || this.method_584())) {
            this.c.player.noClip = true;
         }
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_570() {
      return this.field_377;
   }

   // $FF: renamed from: g () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_571() {
      return this.field_376;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_572(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120) {
         if (var1.c() instanceof CPacketPlayer) {
            ConcurrentSet var10000 = this.field_382;
            Packet var10001 = var1.c();
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayer");
            }

            if (var10000.contains((CPacketPlayer)var10001)) {
               var10000 = this.field_382;
               var10001 = var1.c();
               if (var10001 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayer");
               }

               var10000.remove((CPacketPlayer)var10001);
               return;
            }

            var1.0();
         }

      }
   }

   // $FF: renamed from: c (net.minecraft.network.play.client.CPacketPlayer) void
   public void method_573(@NotNull CPacketPlayer var1) {
      this.field_382.add(var1);
      this.c.player.connection.sendPacket((Packet)var1);
   }

   // $FF: renamed from: 8 () int
   public int method_574() {
      return this.field_386;
   }

   // $FF: renamed from: 6 (int) void
   public void method_575(int var1) {
      this.field_381 = var1;
   }

   // $FF: renamed from: 9 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_576() {
      return this.field_375;
   }

   // $FF: renamed from: c (int) boolean
   public boolean method_577(int var1) {
      int var10001 = this.field_385++;
      if (this.field_385 >= var1) {
         this.field_385 = 0;
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g(2)
   @LauncherEventHide
   public void method_578(@NotNull f4e var1) {
      if (this.c.player != null && var1.c() instanceof SPacketPlayerPosLook && var1.c() == f41.field_2120) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketPlayerPosLook");
         }

         SPacketPlayerPosLook var2 = (SPacketPlayerPosLook)var10000;
         f7j var3 = (f7j)this.field_384.remove(var2.getTeleportId());
         if (this.c.player.isEntityAlive() && this.c.world.isBlockLoaded(new BlockPos(this.c.player.posX, this.c.player.posY, this.c.player.posZ), false) && !(this.c.currentScreen instanceof GuiDownloadTerrain) && (f7k)this.field_374.c() != f7k.field_1858 && var3 != null && var3.method_3024() == var2.getX() && var3.method_3027() == var2.getY() && var3.method_3028() == var2.getZ()) {
            var1.c(true);
            return;
         }

         if (var2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.SPacketPlayerPosLookAccessor");
         }

         ((SPacketPlayerPosLookAccessor)var2).setYaw(this.c.player.rotationYaw);
         ((SPacketPlayerPosLookAccessor)var2).setPitch(this.c.player.rotationPitch);
         this.field_381 = var2.getTeleportId();
      }

   }

   // $FF: renamed from: a () int
   public int method_579() {
      return this.field_381;
   }

   // $FF: renamed from: 5 (int) void
   public void method_580(int var1) {
      this.field_386 = var1;
   }

   // $FF: renamed from: 5 () boolean
   public boolean method_581() {
      return this.field_388;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_582() {
      return this.field_378;
   }

   // $FF: renamed from: d () int
   public int method_583() {
      return this.field_385;
   }

   // $FF: renamed from: e () boolean
   public boolean method_584() {
      AxisAlignedBB var1 = this.c.player.getEntityBoundingBox();
      Collection var2 = (Collection)this.c.world.getCollisionBoxes((Entity)this.c.player, var1.expand(-0.0625D, -0.0625D, -0.0625D));
      boolean var3 = false;
      return !var2.isEmpty();
   }

   // $FF: renamed from: 7 () io.netty.util.internal.ConcurrentSet
   @NotNull
   public ConcurrentSet method_585() {
      return this.field_382;
   }
}
