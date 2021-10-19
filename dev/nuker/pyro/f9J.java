/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketEntityAction.Action;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f9J extends Module {
   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_435(@NotNull f49 var1) {
      if (var1.c() == f41.field_2120 && var1.c() instanceof CPacketPlayerTryUseItemOnBlock && !this.c.player.isSneaking()) {
         this.method_436(true);
      }

   }

   public f9J() {
      super("sneak", "Sneak", "Makes you always sneaking serverside");
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      super.method_116(var1, var2, var3);
      if (!var1 && this.c.player != null && !this.c.player.movementInput.sneak) {
         this.method_436(true);
      }

   }

   // $FF: renamed from: c (boolean) void
   public void method_436(boolean var1) {
      NetHandlerPlayClient var10000 = this.c.getConnection();
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      var10000.sendPacket((Packet)(new CPacketEntityAction((Entity)this.c.player, var1 ? Action.STOP_SNEAKING : Action.START_SNEAKING)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4u) void
   @f0g
   @LauncherEventHide
   public void method_437(@NotNull f4u var1) {
      // $FF: Couldn't be decompiled
   }
}
