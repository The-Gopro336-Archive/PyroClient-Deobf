/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f4D;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.Profile;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({RenderLivingBase.class})
public abstract class RenderLivingBaseMixin extends Render {
   @Shadow
   protected ModelBase mainModel;

   @Shadow
   protected abstract boolean isVisible(EntityLivingBase var1);

   protected RenderLivingBaseMixin(RenderManager renderManager) {
      super(renderManager);
   }

   @Inject(
      method = {"isVisible"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void isFreecam(EntityLivingBase entity, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472 && entity == Minecraft.getMinecraft().player) {
         cir.setReturnValue(PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472);
      }

   }

   @Inject(
      method = {"renderModel"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderModel(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, CallbackInfo ci) {
      f4D event = new f4D((RenderLivingBase)this, entitylivingbaseIn, this.mainModel, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
      Pyro.getEventManager().method_32(event);
      if (!event.c()) {
         if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472 && entitylivingbaseIn == Minecraft.getMinecraft().player) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.25F);
            GlStateManager.depthMask(false);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.alphaFunc(516, 0.003921569F);
         }

      } else {
         ci.cancel();
         boolean flag = this.isVisible(entitylivingbaseIn);
         boolean flag1 = !flag && !entitylivingbaseIn.isInvisibleToPlayer(Minecraft.getMinecraft().player);
         if (flag || flag1) {
            if (!this.bindEntityTexture(entitylivingbaseIn)) {
               return;
            }

            if (flag1) {
               GlStateManager.enableBlendProfile(Profile.TRANSPARENT_MODEL);
            }

            if (flag1) {
               GlStateManager.disableBlendProfile(Profile.TRANSPARENT_MODEL);
            }
         }

      }
   }

   @Inject(
      method = {"renderModel"},
      at = {@At("RETURN")}
   )
   private void clearFreecamBlend(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1472 && entitylivingbaseIn == Minecraft.getMinecraft().player) {
         GlStateManager.disableBlend();
         GlStateManager.alphaFunc(516, 0.1F);
         GlStateManager.depthMask(true);
      }

   }

   @Inject(
      method = {"getColorMultiplier"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getAdditionalColorMultiplier(EntityLivingBase entitylivingbaseIn, float lightBrightness, float partialTickTime, CallbackInfoReturnable cir) {
      if ((Boolean)PyroStatic.field_2480.c.method_3034() && (Boolean)PyroStatic.field_2480.method_151().c() && entitylivingbaseIn == PyroStatic.field_2480.method_230()) {
         cir.setReturnValue(((f00)PyroStatic.field_2480.method_164().c()).meth1());
      }

   }

   @Inject(
      method = {"renderLayers"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderLayers(CallbackInfo var1) {
      if (!PyroStatic.field_2498.method_986()) {
         var1.cancel();
      }

   }

   @Inject(
      method = {"renderName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderName(EntityLivingBase entity, double x, double y, double z, CallbackInfo info) {
      if (entity instanceof EntityPlayer && (Boolean)PyroStatic.field_2497.c.method_3034()) {
         info.cancel();
      }

      if (!PyroStatic.field_2498.method_986()) {
         info.cancel();
      }

   }
}
