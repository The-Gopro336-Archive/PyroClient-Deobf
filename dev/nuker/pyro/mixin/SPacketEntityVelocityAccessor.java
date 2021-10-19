/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.network.play.server.SPacketEntityVelocity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({SPacketEntityVelocity.class})
public interface SPacketEntityVelocityAccessor {
   @Accessor("motionX")
   int getMotionX();

   @Accessor("motionX")
   void setMotionX(int var1);

   @Accessor("motionY")
   int getMotionY();

   @Accessor("motionY")
   void setMotionY(int var1);

   @Accessor("motionZ")
   int getMotionZ();

   @Accessor("motionZ")
   void setMotionZ(int var1);

   @Accessor("entityID")
   int getEntityID();
}
