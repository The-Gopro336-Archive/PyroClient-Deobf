/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({EntityPlayerSP.class})
public interface EntityPlayerSPAccessor {
   @Accessor("prevOnGround")
   boolean getPrevOnGround();

   @Accessor("handActive")
   void setHandActive(boolean var1);

   @Accessor("horseJumpPower")
   void setHorseJumpPower(float var1);
}
