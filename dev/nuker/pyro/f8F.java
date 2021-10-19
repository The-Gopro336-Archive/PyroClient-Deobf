/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f8F extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_389 = (DoubleSetting)this.register((f0w)(new DoubleSetting("speed", "Speed", (String)null, 1.15D, 1.0D, 2.149D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_390 = (DoubleSetting)this.register((f0w)(new DoubleSetting("yMotion", "YMotion", (String)null, 0.4D, 0.01D, 0.415D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_391 = (BooleanSetting)this.register((f0w)(new BooleanSetting("autoJump", "AutoJump", (String)null, false)));
   // $FF: renamed from: 1 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_392 = (DoubleSetting)this.register((f0w)(new DoubleSetting("timer", "Timer", (String)null, 1.088D, 1.0D, 2.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c double
   public double field_393;
   // $FF: renamed from: 1 int
   public int field_394 = 4;
   // $FF: renamed from: 0 double
   public double field_395 = far.method_1680();

   // $FF: renamed from: c () double
   public double method_586() {
      return this.field_395;
   }

   // $FF: renamed from: 0 () double
   public double method_587() {
      return this.field_393;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(-1)
   @LauncherEventHide
   public void method_588(@NotNull f4p var1) {
      if (!var1.c() && var1.c() == f41.field_2120) {
         boolean var2 = this.c.player.movementInput.jump;
         if (!var2) {
            var2 = (Boolean)this.field_391.c();
         }

         if (var2 && fec.method_1758()) {
            if (this.field_394 == 1) {
               f0b.field_2415.method_3667("airstrafe", f07.field_2303, (float)((Number)this.field_392.c()).doubleValue());
               this.field_395 = 1.35D * far.method_1680() - 0.01D;
            } else if (this.field_394 == 2 && this.c.player.collidedVertically) {
               var1.0();
               Object var12 = this.field_390.c();
               boolean var4 = false;
               boolean var5 = false;
               double var6 = ((Number)var12).doubleValue();
               boolean var8 = false;
               this.c.player.motionY = var6;
               var1.method_3120(((Number)var12).doubleValue());
               this.field_395 *= ((Number)this.field_389.c()).doubleValue();
            } else if (this.field_394 == 3) {
               double var11 = 0.66D * (this.field_393 - far.method_1680());
               this.field_395 = this.field_393 - var11;
            } else {
               List var3 = this.c.world.getCollisionBoxes((Entity)this.c.player, this.c.player.getEntityBoundingBox().offset(0.0D, this.c.player.motionY, 0.0D));
               if ((var3.size() > 0 || this.c.player.collidedVertically) && this.field_394 > 0) {
                  this.field_394 = 1;
               }

               this.field_395 = this.field_393 - this.field_393 / 159.0D;
            }

            this.field_395 = RangesKt.coerceAtLeast(this.field_395, far.method_1680());
            var1.0();
            fec.method_1774(var1, this.field_395);
            ++this.field_394;
            int var10000 = this.field_394;
         } else {
            f0b.field_2415.method_3669("airstrafe");
            this.field_394 = 0;
         }
      }

   }

   // $FF: renamed from: 5 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_589() {
      return this.field_392;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_590() {
      return this.field_391;
   }

   // $FF: renamed from: 0 (double) void
   public void method_591(double var1) {
      this.field_393 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_592() {
      return this.field_390;
   }

   public f8F() {
      super("airstrafe", "AirStrafe", "Allows you to strafe while in air, speed will override this, useful while using OnGround speed or manually jumping");
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_593() {
      return this.field_389;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_594(@NotNull f4e var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof SPacketPlayerPosLook) {
         this.field_394 = 4;
         this.field_395 = far.method_1680();
         this.field_393 = 0.0D;
      }

   }

   // $FF: renamed from: 3 (int) void
   public void method_595(int var1) {
      this.field_394 = var1;
   }

   // $FF: renamed from: c (double) void
   public void method_596(double var1) {
      this.field_395 = var1;
   }

   // $FF: renamed from: 4 () int
   public int method_597() {
      return this.field_394;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.field_394 = 4;
      f0b.field_2415.method_3669("airstrafe");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_598(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         double var2 = this.c.player.posX - this.c.player.prevPosX;
         double var4 = this.c.player.posZ - this.c.player.prevPosZ;
         double var6 = var2 * var2 + var4 * var4;
         boolean var8 = false;
         double var10 = Math.sqrt(var6);
         this.field_393 = var10;
      }
   }
}
