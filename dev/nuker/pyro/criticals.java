/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class criticals extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_564;

   public criticals() {
      super("criticals", "Criticals", "Deal a critical hit on every attack");
      this.field_564 = (f0o)this.register((f0w)(new f0o("mode", "Mode", "The mode of criticals to do", (Enum)mode.packet)));
   }

   // $FF: renamed from: c (net.minecraft.entity.Entity) void
   public void method_846(@Nullable Entity var1) {
      if (this.c.player.fallDistance == 1337.0F) {
         this.c.player.fallDistance = 0.0F;
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4h) void
   @f0g
   @LauncherEventHide
   public void method_847(@NotNull f4h var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_848(@Nullable f4t var1) {
      this.5(((mode)this.field_564.c()).toString());
   }
}
