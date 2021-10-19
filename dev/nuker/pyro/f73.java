/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.SPacketEntityVelocityAccessor;
import dev.nuker.pyro.mixin.SPacketExplosionAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class f73 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_565;
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_566;
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_567;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_568;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_569;
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_570;

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_849() {
      return this.field_568;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_850() {
      return this.field_570;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_851() {
      return this.field_566;
   }

   public f73() {
      super("velocity", "Velocity", "Allows you to modify the velocity you receive");
      this.field_565 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f72.field_1725)));
      this.field_566 = (IntegerSetting)this.register((f0w)(new IntegerSetting("horizontal", "Horizontal", "The horizontal velocity you will take", 0, 0, 100, 1)));
      this.field_567 = (IntegerSetting)this.register((f0w)(new IntegerSetting("vertical", "Vertical", "The vertical velocity you will take", 0, 0, 100, 1)));
      this.field_568 = (BooleanSetting)this.register((f0w)(new BooleanSetting("explosions", "Explosions", "Apply the velocity modifier on explosions", true)));
      this.field_569 = (BooleanSetting)this.register((f0w)(new BooleanSetting("bobbers", "Bobbers", "Apply the velocity modifier on fishing bobber velocity", true)));
      this.field_570 = (BooleanSetting)this.register((f0w)(new BooleanSetting("nopush", "NoPush", "Disables collision movement", true)));
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_852() {
      return this.field_567;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_853(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         if ((f72)this.field_565.c() != f72.field_1725) {
            this.5(((f72)this.field_565.c()).toString());
         } else {
            StringCompanionObject var2 = StringCompanionObject.INSTANCE;
            String var3 = "H:%s%% V:%s%%";
            Object[] var4 = new Object[]{this.field_566.c(), this.field_567.c()};
            boolean var5 = false;
            String var7 = String.format(var3, Arrays.copyOf(var4, var4.length));
            this.5(var7);
         }

         if ((f72)this.field_565.c() == f72.field_1726 && this.c.player.hurtTime != 0) {
            var1.0();
            var1.method_3135(true);
         }
      }

   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_854() {
      return this.field_565;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4x) void
   @f0g
   @LauncherEventHide
   public void method_855(@NotNull f4x var1) {
      if ((Boolean)this.field_570.c()) {
         var1.0();
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_856() {
      return this.field_569;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_857(@NotNull f4e var1) {
      if (this.c.world != null && this.c.player != null && var1.c() == f41.field_2120) {
         if ((f72)this.field_565.c() == f72.field_1725) {
            Packet var10000;
            if (var1.c() instanceof SPacketEntityStatus && (Boolean)this.field_569.c()) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityStatus");
               }

               SPacketEntityStatus var5 = (SPacketEntityStatus)var10000;
               if (var5.getOpCode() == 31) {
                  Entity var3 = var5.getEntity((World)this.c.world);
                  if (var3 != null && var3 instanceof EntityFishHook && ((EntityFishHook)var3).caughtEntity == this.c.player) {
                     var1.0();
                  }
               }
            } else if (var1.c() instanceof SPacketEntityVelocity) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketEntityVelocity");
               }

               SPacketEntityVelocity var6 = (SPacketEntityVelocity)var10000;
               if (var6 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.SPacketEntityVelocityAccessor");
               }

               SPacketEntityVelocityAccessor var2 = (SPacketEntityVelocityAccessor)var6;
               if (var2.getEntityID() == this.c.player.getEntityId()) {
                  if (((Number)this.field_566.c()).intValue() == 0 && ((Number)this.field_567.c()).intValue() == 0) {
                     var1.0();
                     return;
                  }

                  if (((Number)this.field_566.c()).intValue() != 100) {
                     var2.setMotionX(var2.getMotionX() / 100 * ((Number)this.field_566.c()).intValue());
                     var2.setMotionZ(var2.getMotionZ() / 100 * ((Number)this.field_566.c()).intValue());
                  }

                  if (((Number)this.field_567.c()).intValue() != 100) {
                     var2.setMotionY(var2.getMotionY() / 100 * ((Number)this.field_567.c()).intValue());
                  }
               }
            } else if (var1.c() instanceof SPacketExplosion && (Boolean)this.field_568.c()) {
               var10000 = var1.c();
               if (var10000 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.server.SPacketExplosion");
               }

               SPacketExplosion var7 = (SPacketExplosion)var10000;
               if (var7 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.SPacketExplosionAccessor");
               }

               SPacketExplosionAccessor var4 = (SPacketExplosionAccessor)var7;
               if (((Number)this.field_566.c()).intValue() == 0 && ((Number)this.field_567.c()).intValue() == 0) {
                  var1.0();
                  return;
               }

               if (((Number)this.field_566.c()).intValue() != 100) {
                  var4.setMotionX(var4.getMotionX() / (float)100 * ((Number)this.field_566.c()).floatValue());
                  var4.setMotionZ(var4.getMotionZ() / (float)100 * ((Number)this.field_566.c()).floatValue());
               }

               if (((Number)this.field_567.c()).intValue() != 100) {
                  var4.setMotionY(var4.getMotionY() / (float)100 * ((Number)this.field_567.c()).floatValue());
               }
            }
         }

      }
   }
}
