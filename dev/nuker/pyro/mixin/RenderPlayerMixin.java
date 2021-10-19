/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.class_53;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderPlayer.class})
public class RenderPlayerMixin {
   private float renderPitch;
   private float renderYaw;
   private float renderHeadYaw;
   private float prevRenderHeadYaw;
   private float lastRenderHeadYaw = 0.0F;
   private float prevRenderPitch;
   private float lastRenderPitch = 0.0F;
   private float prevRenderYawOffset;
   private float prevPrevRenderYawOffset;

   @Inject(
      method = {"doRender"},
      at = {@At("HEAD")}
   )
   private void rotateBegin(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
      if (entity == Minecraft.getMinecraft().player) {
         this.prevRenderHeadYaw = entity.prevRotationYawHead;
         this.prevRenderPitch = entity.prevRotationPitch;
         this.renderPitch = entity.rotationPitch;
         this.renderYaw = entity.rotationYaw;
         this.renderHeadYaw = entity.rotationYawHead;
         this.prevPrevRenderYawOffset = entity.prevRenderYawOffset;
         this.prevRenderYawOffset = entity.renderYawOffset;
         if (Pyro.getRotationManager().method_3458() != -1337.0F) {
            entity.rotationPitch = Pyro.getRotationManager().method_3458();
            entity.prevRotationPitch = this.lastRenderPitch;
         }

         if (Pyro.getRotationManager().method_3455() != -1337.0F) {
            entity.rotationYaw = Pyro.getRotationManager().method_3455();
            entity.rotationYawHead = Pyro.getRotationManager().method_3455();
            entity.prevRotationYawHead = Pyro.getRotationManager().method_3455();
            entity.prevRenderYawOffset = Pyro.getRotationManager().method_3455();
            entity.renderYawOffset = Pyro.getRotationManager().method_3455();
         }
      }

   }

   @Inject(
      method = {"doRender"},
      at = {@At("RETURN")}
   )
   private void rotateEnd(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
      if (entity == Minecraft.getMinecraft().player) {
         this.lastRenderHeadYaw = entity.rotationYawHead;
         this.lastRenderPitch = entity.rotationPitch;
         entity.rotationPitch = this.renderPitch;
         entity.rotationYaw = this.renderYaw;
         entity.rotationYawHead = this.renderHeadYaw;
         entity.prevRotationYawHead = this.prevRenderHeadYaw;
         entity.prevRotationPitch = this.prevRenderPitch;
         entity.prevRotationYawHead = this.prevRenderHeadYaw;
         entity.renderYawOffset = this.prevRenderYawOffset;
         entity.prevRenderYawOffset = this.prevPrevRenderYawOffset;
      }

   }

   @Inject(
      method = {"renderEntityName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void renderLivingLabel(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2497.c.method_3034()) {
         info.cancel();
      }

   }

   @Inject(
      method = {"renderEntityName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void dontRenderNameOnMenu(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo ci) {
      if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof class_53) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"doRender"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void cancelFreecamRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471 && entity.getEntityId() == -6969) {
         ci.cancel();
      }

   }
}
