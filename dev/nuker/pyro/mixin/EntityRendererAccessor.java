/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({EntityRenderer.class})
public interface EntityRendererAccessor {
   @Invoker("orientCamera")
   void orientCam(float var1);

   @Invoker("applyBobbing")
   void viewBob(float var1);

   @Accessor("lightmapColors")
   int[] getLightmapColors();

   @Accessor("lightmapTexture")
   DynamicTexture getLightmapTexture();

   @Accessor("torchFlickerX")
   float getTorchFlickerX();

   @Accessor("bossColorModifier")
   float getBossColorModifier();

   @Accessor("bossColorModifierPrev")
   float getBossColorModifierPrev();

   @Invoker("getNightVisionBrightness")
   float invokeGetNightVisionBrightness(EntityLivingBase var1, float var2);

   @Invoker("setupCameraTransform")
   void invokeSetupCameraTransform(float var1, int var2);
}
