/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import org.jetbrains.annotations.NotNull;

public class f7R extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting field_464 = (BooleanSetting)this.register((f0w)(new BooleanSetting("stats", "Stats", "Runs the /stats command", true)));
   // $FF: renamed from: c dev.nuker.pyro.fe8
   @NotNull
   public fe8 field_465 = new fe8();

   public f7R() {
      super("antiafk", "AntiAFK", "Attemps to prevent you from getting kicked for AFK.");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_685(@NotNull f4t var1) {
      if ((Boolean)this.field_464.c() && this.field_465.method_1980(120000.0D)) {
         this.field_465.method_1979();
         this.c.player.sendChatMessage("/stats");
      }

   }

   // $FF: renamed from: 0 () dev.nuker.pyro.BooleanSetting
   @NotNull
   public BooleanSetting method_686() {
      return this.field_464;
   }

   // $FF: renamed from: c () dev.nuker.pyro.fe8
   @NotNull
   public fe8 method_687() {
      return this.field_465;
   }
}
