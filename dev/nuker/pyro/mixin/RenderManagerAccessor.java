/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({RenderManager.class})
public interface RenderManagerAccessor {
   @Accessor("renderPosX")
   double getRenderPosX();

   @Accessor("renderPosY")
   double getRenderPosY();

   @Accessor("renderPosZ")
   double getRenderPosZ();
}
