/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({Minecraft.class})
public interface MinecraftAccessor {
   @Accessor("timer")
   Timer getTimer();

   @Accessor("rightClickDelayTimer")
   int getRightClickDelayTimer();

   @Accessor("rightClickDelayTimer")
   void setRightClickDelayTimer(int var1);

   @Accessor("session")
   void setSession(Session var1);

   @Accessor("renderPartialTicksPaused")
   float getRenderPartialTicksPaused();

   @Accessor("leftClickCounter")
   void setLeftClickCounter(int var1);
}
