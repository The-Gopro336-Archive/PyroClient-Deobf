/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketExplosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({SPacketExplosion.class})
public interface SPacketExplosionAccessor {
   @Accessor("motionX")
   float getMotionX();

   @Accessor("motionX")
   void setMotionX(float var1);

   @Accessor("motionY")
   float getMotionY();

   @Accessor("motionY")
   void setMotionY(float var1);

   @Accessor("motionZ")
   float getMotionZ();

   @Accessor("motionZ")
   void setMotionZ(float var1);
}
