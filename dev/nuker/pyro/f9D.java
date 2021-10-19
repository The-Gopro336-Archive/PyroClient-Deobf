/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.CPacketPlayerAccessor;
import dev.nuker.pyro.mixin.SPacketPlayerPosLookAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.Set;
import net.minecraft.network.play.client.CPacketPlayer.PositionRotation;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.network.play.server.SPacketPlayerPosLook.EnumFlags;
import net.minecraft.util.math.BlockPos;

public class f9D extends Module {
   // $FF: renamed from: c float
   public float field_292 = 1337.0F;
   // $FF: renamed from: 0 float
   public float field_293 = 1337.0F;

   public f9D() {
      super("norotate", "NoRotate", "Doesn't allow the server to change your rotations. May cause rubberbanding.", true);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f49) void
   @f0g
   @LauncherEventHide
   public void method_429(f49 var1) {
      if (this.c.player != null && var1.c() == f41.field_2120 && var1.c() instanceof PositionRotation) {
         CPacketPlayerAccessor var2 = (CPacketPlayerAccessor)var1.c();
         if (this.field_292 != 1337.0F) {
            var2.setYaw(this.field_292);
            this.field_292 = 1337.0F;
         }

         if (this.field_293 != 1337.0F) {
            var2.setPitch(this.field_293);
            this.field_293 = 1337.0F;
         }
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.f4e) void
   @f0g
   @LauncherEventHide
   public void method_430(f4e var1) {
      if (this.c.player != null && var1.c() == f41.field_2120 && var1.c() instanceof SPacketPlayerPosLook) {
         SPacketPlayerPosLook var2 = (SPacketPlayerPosLook)var1.c();
         if (!this.c.world.isBlockLoaded(new BlockPos(this.c.player.lastTickPosX, this.c.player.lastTickPosY, this.c.player.lastTickPosZ), false) || !this.c.world.isBlockLoaded(new BlockPos(this.c.player.posX, this.c.player.posY, this.c.player.posZ), false)) {
            return;
         }

         this.field_292 = var2.getYaw();
         this.field_293 = var2.getPitch();
         Set var3 = var2.getFlags();
         if (var3.remove(EnumFlags.Y_ROT)) {
            this.field_292 += this.c.player.rotationYaw;
         }

         if (var3.remove(EnumFlags.X_ROT)) {
            this.field_293 += this.c.player.rotationPitch;
         }

         ((SPacketPlayerPosLookAccessor)var2).setYaw(this.c.player.rotationYaw);
         ((SPacketPlayerPosLookAccessor)var2).setPitch(this.c.player.rotationPitch);
      }

   }
}
