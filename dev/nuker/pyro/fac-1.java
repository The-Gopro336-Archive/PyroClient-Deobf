/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fac extends Module {
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_738 = (IntegerSetting)this.register((f0w)(new IntegerSetting("directions", "Directions", "Number of snap directions. A multiple of 2 is recommended", 8, 2, 16, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_739 = (BooleanSetting)this.register((f0w)(new BooleanSetting("lock_mouse", "Lock Mouse", "You can't move the mouse at all..", false)));
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_740 = (IntegerSetting)this.register((f0w)(new IntegerSetting("snap_ticks", "Snap Ticks", "Delay between mouse movement and snapping to yaw", 10, 0, 200, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 1 int
   public int field_741;
   // $FF: renamed from: c float
   public float field_742;

   // $FF: renamed from: 1 () int
   public int method_1085() {
      return this.field_741;
   }

   // $FF: renamed from: c (float, int) float
   public float method_1086(float var1, int var2) {
      return (float)MathKt.roundToInt(var1 / (360.0F / (float)var2)) * (360.0F / (float)var2);
   }

   // $FF: renamed from: c () float
   public float method_1087() {
      return this.field_742;
   }

   // $FF: renamed from: 3 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1088() {
      return this.field_740;
   }

   // $FF: renamed from: 3 (int) void
   public void method_1089(int var1) {
      this.field_741 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f43) void
   @f0g
   @LauncherEventHide
   public void method_1090(@NotNull f43 var1) {
      if (this.c.player != null) {
         if (var1.c() == f41.field_2120 && (Boolean)this.field_739.c()) {
            this.c.player.rotationYaw = this.field_742;
         }

         if ((Boolean)this.field_739.c()) {
            this.c.player.rotationYaw = this.field_742;
         } else {
            if (this.c.player.rotationYaw != this.field_742) {
               this.field_741 = ((Number)this.field_740.c()).intValue();
               this.field_742 = this.c.player.rotationYaw;
            }

            if (this.field_741 <= 0) {
               this.c.player.rotationYaw = this.method_1086(this.c.player.rotationYaw, ((Number)this.field_738.c()).intValue());
               this.field_742 = this.c.player.rotationYaw;
            }

            if (this.field_741 > 0) {
               this.field_741 += -1;
            }
         }

      }
   }

   // $FF: renamed from: c (float) void
   public void method_1091(float var1) {
      this.field_742 = var1;
   }

   public fac() {
      super("yaw_lock", "YawLock", "Lock your yaw so you can fly straight down a highway");
      this.field_742 = FloatCompanionObject.INSTANCE.getMIN_VALUE();
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_1092() {
      return this.field_739;
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (var2 != null) {
         this.field_742 = var1 && (Boolean)this.field_739.c() ? this.method_1086(var2.rotationYaw, ((Number)this.field_738.c()).intValue()) : FloatCompanionObject.INSTANCE.getMIN_VALUE();
         this.field_741 = 0;
      }
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1093() {
      return this.field_738;
   }
}
