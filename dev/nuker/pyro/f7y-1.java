/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import org.jetbrains.annotations.NotNull;

public class f7y extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   @NotNull
   public f0o field_357;

   // $FF: renamed from: c () dev.nuker.pyro.f0o
   @NotNull
   public f0o method_525() {
      return this.field_357;
   }

   public f7y() {
      super("swing", "Swing", (String)null);
      this.field_357 = (f0o)this.register((f0w)(new f0o("mode", "Mode", (String)null, (Enum)f7w.field_1878)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_526(@NotNull f49 var1) {
      // $FF: Couldn't be decompiled
   }
}
