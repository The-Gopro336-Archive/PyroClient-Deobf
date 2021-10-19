/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerTryUseItemOnBlockAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;

public class f8k extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_407(f49 var1) {
      if (var1.c() instanceof CPacketPlayerTryUseItemOnBlock && var1.c() == f41.field_2120) {
         CPacketPlayerTryUseItemOnBlock var2 = (CPacketPlayerTryUseItemOnBlock)var1.c();
         if (var2.getPos().getY() >= 255 && var2.getDirection() == EnumFacing.UP) {
            ((CPacketPlayerTryUseItemOnBlockAccessor)var2).setPlacedBlockDirection(EnumFacing.DOWN);
         }
      }

   }

   public f8k() {
      super("maxheightinteract", "MaxHeightInteract", "Allows you to interact with blocks at build height");
   }
}
