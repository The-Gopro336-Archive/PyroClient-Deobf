/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import org.jetbrains.annotations.NotNull;

public class f7d extends Module {
   public f7d() {
      super("nomineanimation", "NoMineAnimation", "Cancels the mining animation visual for other players on your current mined block");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_601(@NotNull f49 var1) {
      if (this.c.player != null && var1.c() == f41.field_2120 && var1.c() instanceof CPacketPlayerDigging) {
         Packet var10000 = var1.c();
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.network.play.client.CPacketPlayerDigging");
         }

         CPacketPlayerDigging var2 = (CPacketPlayerDigging)var10000;
         if (var2.getAction() == Action.START_DESTROY_BLOCK) {
            NetHandlerPlayClient var3 = this.c.getConnection();
            if (var3 == null) {
               Intrinsics.throwNpe();
            }

            var3.sendPacket((Packet)(new CPacketPlayerDigging(Action.ABORT_DESTROY_BLOCK, var2.getPosition(), var2.getFacing())));
         }
      }

   }
}
