/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.MoverType;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer.Position;
import org.jetbrains.annotations.NotNull;

public class f9Z extends Module {
   public f9Z() {
      super("webtp", "WebTP", "Ports you to the bottom of a web");
   }

   // $FF: renamed from: c (dev.nuker.pyro.f4t) void
   @f0g
   @LauncherEventHide
   public void method_376(@NotNull f4t var1) {
      EntityPlayerSP var10000 = this.c.player;
      if (var10000 == null) {
         throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityAccessor");
      } else {
         NetHandlerPlayClient var2;
         if (((EntityAccessor)var10000).isInWeb() && !this.c.player.collidedVertically && !this.c.player.isElytraFlying() && !(Boolean)PyroStatic.field_2511.c.method_3034()) {
            for(; !this.c.player.collidedVertically; var2.sendPacket((Packet)(new Position(this.c.player.posX, this.c.player.posY, this.c.player.posZ, false)))) {
               this.c.player.move(MoverType.SELF, 0.0D, -0.2D, 0.0D);
               var2 = this.c.getConnection();
               if (var2 == null) {
                  Intrinsics.throwNpe();
               }
            }
         }

      }
   }
}
