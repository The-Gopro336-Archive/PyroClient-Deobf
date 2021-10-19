/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({PlayerControllerMP.class})
public interface PlayerControllerMPAccessor {
   @Accessor("isHittingBlock")
   void setIsHittingBlock(boolean var1);

   @Accessor("curBlockDamageMP")
   void setCurBlockDamageMP(float var1);

   @Accessor("curBlockDamageMP")
   float getCurBlockDamageMP();

   @Accessor("blockHitDelay")
   void setBlockHitDelay(int var1);
}
