/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.List;
import java.util.function.Consumer;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9T extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_238;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_239;
   // $FF: renamed from: 1 dev.nuker.pyro.f0o
   @NotNull
   public f0o field_240;
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_241;
   // $FF: renamed from: c dev.nuker.pyro.f0z
   @NotNull
   public f0z field_242;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_243;
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_244;
   // $FF: renamed from: c dev.nuker.pyro.far
   @Nullable
   public far field_245;

   public f9T() {
      super("speed", "Speed", "Allows you to run faster than normal");
      this.field_238 = new f0o("ncp", "Mode", (String)null, (Enum)f9Q.field_1910);
      this.field_239 = new f0o("aac", "Mode", (String)null, (Enum)f9O.field_1942);
      this.field_240 = new f0o("vanilla", "Mode", (String)null, (Enum)f9R.field_1924);
      this.field_241 = new DoubleSetting("vanillaSpeed", "Speed", (String)null, 1.0D, 0.1D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null);
      this.field_242 = (f0z)this.register((f0w)(new f0z("anticheat", "AntiCheat", (String)null, (Enum)f9P.field_1906, new List[]{CollectionsKt.listOf(this.field_238), CollectionsKt.listOf(this.field_239), CollectionsKt.listOf(new Setting[]{(Setting)this.field_240, (Setting)this.field_241})})));
      this.field_243 = (BooleanSetting)this.register((f0w)(new BooleanSetting("speedInWater", "SpeedInWater", "Allows speed to function in water", false)));
      this.field_244 = (BooleanSetting)this.register((f0w)(new BooleanSetting("useTimer", "UseTimer", "Modifies the game speed to allow you to move faster", true)));
      this.field_242.method_3334().c((Consumer)(new f9K(this)));
      this.field_238.c((Consumer)(new f9L(this)));
      this.field_239.c((Consumer)(new f9M(this)));
      this.field_240.c((Consumer)(new f9N(this)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.far) void
   public void method_329(@Nullable far var1) {
      this.field_245 = var1;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.f0z
   @NotNull
   public f0z method_330() {
      return this.field_242;
   }

   // $FF: renamed from: 8 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_331() {
      return this.field_238;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_332(@Nullable f4u var1) {
      if (!(Boolean)PyroStatic.field_2519.c.method_3034()) {
         if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
            if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
               if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
                  far var10000 = this.field_245;
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var10000.method_1684(var1);
               }

            }
         }
      }
   }

   // $FF: renamed from: 6 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_333() {
      return this.field_241;
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.far
   @Nullable
   public far method_334() {
      return this.field_245;
   }

   // $FF: renamed from: 2 () void
   public void method_335() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_336(@Nullable f4t var1) {
      if (!(Boolean)PyroStatic.field_2519.c.method_3034()) {
         if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
            if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
               if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
                  far var10000 = this.field_245;
                  if (var10000 == null) {
                     Intrinsics.throwNpe();
                  }

                  var10000.method_1682();
               }

            }
         }
      }
   }

   // $FF: renamed from: 5 () void
   public void method_337() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_338() {
      return this.field_243;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_339(@NotNull f4e var1) {
      if (this.c.player != null && this.c.player.capabilities != null && !this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying && var1.c() == f41.field_2120 && var1.c() instanceof SPacketPlayerPosLook) {
         far var10000 = this.field_245;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.meth0();
      }

   }

   // $FF: renamed from: 7 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_340() {
      return this.field_240;
   }

   // $FF: renamed from: 4 () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_341() {
      return this.field_239;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g
   @LauncherEventHide
   public void method_342(@Nullable f4p var1) {
      if (!this.c.player.isInWater() && !this.c.player.isInLava() || (Boolean)this.field_243.c()) {
         if (!(Boolean)PyroStatic.field_2519.c.method_3034()) {
            if (!(Boolean)PyroStatic.field_2470.c.method_3034() || PyroStatic.field_2470.field_271 <= 0) {
               if (!(Boolean)PyroStatic.field_2523.c.method_3034() || !PyroStatic.field_2523.method_295()) {
                  if (!this.c.player.isElytraFlying() && !this.c.player.capabilities.isFlying) {
                     far var10000 = this.field_245;
                     if (var10000 == null) {
                        Intrinsics.throwNpe();
                     }

                     var10000.method_1681(var1);
                  }

               }
            }
         }
      }
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0z) void
   public void method_343(@NotNull f0z var1) {
      this.field_242 = var1;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_344() {
      return this.field_244;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      this.method_335();
      this.method_337();
      f0b.field_2415.method_3669("speedhax");
      f0b.field_2415.method_3669("speeedupp");
   }
}
