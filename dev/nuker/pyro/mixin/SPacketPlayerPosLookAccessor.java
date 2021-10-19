/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({SPacketPlayerPosLook.class})
public interface SPacketPlayerPosLookAccessor {
   @Accessor("yaw")
   void setYaw(float var1);

   @Accessor("pitch")
   void setPitch(float var1);

   @Accessor("teleportId")
   int getTeleportId();
}
