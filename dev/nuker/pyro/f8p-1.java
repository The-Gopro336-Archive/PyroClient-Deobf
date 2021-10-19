/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class f8p extends Module {
   // $FF: renamed from: c dev.nuker.pyro.f0o
   public f0o field_280;
   // $FF: renamed from: 0 dev.nuker.pyro.f0o
   public f0o field_281;
   // $FF: renamed from: c boolean
   public boolean field_282;

   public f8p() {
      super("noInteract", "NoInteract", "Disallows specific player interactions");
      this.field_280 = new f0o("mode", "Mode", (String)null, f8o.field_1904);
      this.field_281 = new f0o("hand", "Hand", (String)null, f8n.field_1940);
      this.field_282 = false;
      this.register(this.field_280);
      this.register(this.field_281);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_409(f49 var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4w) void
   @f0g
   @LauncherEventHide
   public void method_410(f4w var1) {
      // $FF: Couldn't be decompiled
   }
}
