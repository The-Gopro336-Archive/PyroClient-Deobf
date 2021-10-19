/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ModelBoat.class})
public class ModelBoatMixin {
   @Inject(
      method = {"render"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/model/ModelBoat;setRotationAngles(FFFFFFLnet/minecraft/entity/Entity;)V"
)},
      cancellable = true
   )
   private void onRender(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2582.c.method_3034() && entityIn == Minecraft.getMinecraft().player.getRidingEntity()) {
         double scale_ = (Double)PyroStatic.field_2582.method_260().c();
         if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && scale_ != 1.0D) {
            GlStateManager.scale(scale_, scale_, scale_);
         }
      }

   }

   @Inject(
      method = {"renderMultipass"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/GlStateManager;colorMask(ZZZZ)V",
   ordinal = 0
)}
   )
   private void onRenderMultipass(Entity entityIn, float partialTicks, float p_187054_3_, float p_187054_4_, float p_187054_5_, float p_187054_6_, float scale, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2582.c.method_3034() && entityIn == Minecraft.getMinecraft().player.getRidingEntity()) {
         double scale_ = (Double)PyroStatic.field_2582.method_260().c();
         if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && scale_ != 1.0D) {
            GlStateManager.scale(scale_, scale_, scale_);
         }
      }

   }
}
