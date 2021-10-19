/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Timer.class})
public interface TimerAccessor {
   @Accessor("tickLength")
   float getTickLength();

   @Accessor("tickLength")
   void setTickLength(float var1);
}
