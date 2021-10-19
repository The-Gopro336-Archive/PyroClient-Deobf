/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public class f9q extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_165 = (BooleanSetting)this.register((f0w)(new BooleanSetting("inAir", "InAir", (String)null, false)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_166 = (DoubleSetting)this.register((f0w)(new DoubleSetting("height", "Height", (String)null, 0.5D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null)));

   // $FF: renamed from: c (dev.nuker.pyro.f4p) void
   @f0g(-1)
   @LauncherEventHide
   public void method_251(@NotNull f4p var1) {
      if (!var1.c() && var1.c() == f41.field_2120 && this.c.player.movementInput.jump && ((Boolean)this.field_165.c() || this.c.player.onGround)) {
         var1.0();
         var1.method_3120(((Number)this.field_166.c()).doubleValue());
         this.c.player.motionY = var1.method_3119();
      }

   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_252() {
      return this.field_166;
   }

   public f9q() {
      super("HighJump", "HighJump", "Allows you to jump higher than normal");
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_253() {
      return this.field_165;
   }
}
