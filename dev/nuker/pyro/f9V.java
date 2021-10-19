/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.NotNull;

public class f9V extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_211;
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_212;

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(-1)
   @LauncherEventHide
   public void method_303(@NotNull f4p var1) {
      if (var1.c() == f41.field_2120 && !var1.c() && (f9U)this.field_211.c() == f9U.field_1958 && !(Boolean)PyroStatic.field_2494.c.method_3034() && this.method_305() && fec.method_1758()) {
         this.c.player.setSprinting(true);
         var1.0();
         fec.method_1774(var1, far.method_1680());
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g(2)
   @LauncherEventHide
   public void method_304(@NotNull f4u var1) {
      if (var1.c() == f41.field_2120) {
         this.5(((f9U)this.field_211.c()).toString());
         if (!this.method_305()) {
            return;
         }

         if ((f9U)this.field_211.c() == f9U.field_1956) {
            KeyBinding.setKeyBindState(this.c.gameSettings.keyBindSprint.getKeyCode(), true);
         } else if ((f9U)this.field_211.c() == f9U.field_1957 && (this.c.player.movementInput.moveForward != 0.0F || this.c.player.movementInput.moveStrafe != 0.0F)) {
            this.c.player.setSprinting(true);
         }
      }

   }

   // $FF: renamed from: c () boolean
   public boolean method_305() {
      if ((Boolean)this.field_212.c() || !this.c.player.isInLava() && !this.c.player.isInWater()) {
         return !this.c.player.isSneaking() && !this.c.player.collidedHorizontally && (float)this.c.player.getFoodStats().getFoodLevel() >= 6.0F;
      } else {
         return false;
      }
   }

   public f9V() {
      super("sprint", "Sprint", "Always be sprinting while moving");
      this.field_211 = (f0o)this.register((f0w)(new f0o("sprintmode", "Mode", "Mode to use for sprinting", (Enum)f9U.field_1958)));
      this.field_212 = (BooleanSetting)this.register((f0w)(new BooleanSetting("inWater", "InWater", (String)null, false)));
   }
}
