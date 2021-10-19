/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.client.CPacketPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({CPacketPlayer.class})
public interface CPacketPlayerAccessor {
   @Accessor("y")
   void setPosY(double var1);

   @Accessor("y")
   double getPosY();

   @Accessor("x")
   double getPosX();

   @Accessor("z")
   double getPosZ();

   @Accessor("onGround")
   void setOnGround(boolean var1);

   @Accessor("rotating")
   boolean isRotating();

   @Accessor("rotating")
   void setRotating(boolean var1);

   @Accessor("yaw")
   float getYaw();

   @Accessor("pitch")
   float getPitch();

   @Accessor("yaw")
   void setYaw(float var1);

   @Accessor("pitch")
   void setPitch(float var1);
}
