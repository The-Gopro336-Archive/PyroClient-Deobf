/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.entity.passive.EntityWolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({EntityWolf.class})
public interface EntityWolfAccessor {
   @Accessor("isWet")
   boolean getIsWet();

   @Accessor("isWet")
   void setIsWet(boolean var1);
}
