/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import com.google.common.base.MoreObjects;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import dev.nuker.pyro.fbm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.ForgeHooksClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ItemRenderer.class})
public class ItemRendererMixin {
   // $FF: renamed from: mc net.minecraft.client.Minecraft
   @Shadow
   @Final
   private Minecraft field_2462;
   @Shadow
   private float equippedProgressMainHand;
   @Shadow
   private float prevEquippedProgressMainHand;
   @Shadow
   private float equippedProgressOffHand;
   @Shadow
   private float prevEquippedProgressOffHand;
   @Shadow
   private ItemStack itemStackMainHand;
   @Shadow
   private ItemStack itemStackOffHand;

   @Shadow
   private void rotateArroundXAndY(float angle, float angleY) {
   }

   @Shadow
   private void setLightmap() {
   }

   @Shadow
   private void rotateArm(float p_187458_1_) {
   }

   @Shadow
   public void renderItemInFirstPerson(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_) {
   }

   @Inject(
      method = {"renderFireInFirstPerson"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void stopFireRender(CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1334().c()) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"renderWaterOverlayTexture"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void stopWaterRender(CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1332().c()) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"renderSuffocationOverlay"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void stopBlocksRender(CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1317().c()) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void cancelFreecamHandRender(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2481.c.method_3034() && PyroStatic.field_2481.field_777.method_3334().c() == fb2.field_1471) {
         ci.cancel();
      }

   }

   @Inject(
      method = {"Lnet/minecraft/client/renderer/ItemRenderer;renderItemInFirstPerson(F)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void renderItemInFirstPerson(float partialTicks, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2542.c.method_3034()) {
         info.cancel();
         AbstractClientPlayer abstractclientplayer = this.field_2462.player;
         float f = abstractclientplayer.getSwingProgress(partialTicks);
         EnumHand enumhand = (EnumHand)MoreObjects.firstNonNull(abstractclientplayer.swingingHand, EnumHand.MAIN_HAND);
         float f1 = abstractclientplayer.prevRotationPitch + (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * partialTicks;
         float f2 = abstractclientplayer.prevRotationYaw + (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * partialTicks;
         boolean flag = true;
         boolean flag1 = true;
         if (abstractclientplayer.isHandActive()) {
            ItemStack itemstack = abstractclientplayer.getActiveItemStack();
            if (!itemstack.isEmpty() && itemstack.getItem() == Items.BOW) {
               EnumHand enumhand1 = abstractclientplayer.getActiveHand();
               flag = enumhand1 == EnumHand.MAIN_HAND;
               flag1 = !flag;
            }
         }

         this.rotateArroundXAndY(f1, f2);
         this.setLightmap();
         this.rotateArm(partialTicks);
         GlStateManager.enableRescaleNormal();
         float f4;
         float f6;
         if (flag) {
            f4 = enumhand == EnumHand.MAIN_HAND ? f : 0.0F;
            f6 = 1.0F - (this.prevEquippedProgressMainHand + (this.equippedProgressMainHand - this.prevEquippedProgressMainHand) * partialTicks);
            if (!ForgeHooksClient.renderSpecificFirstPersonHand(EnumHand.MAIN_HAND, partialTicks, f1, f4, f6, this.itemStackMainHand)) {
               this.renderItemInFirstPerson(abstractclientplayer, partialTicks, f1, EnumHand.MAIN_HAND, f4, this.itemStackMainHand, f6);
            }
         }

         if (flag1) {
            f4 = enumhand == EnumHand.OFF_HAND ? f : 0.0F;
            f6 = (float)(Double)PyroStatic.field_2542.field_720.c();
            if (!ForgeHooksClient.renderSpecificFirstPersonHand(EnumHand.OFF_HAND, partialTicks, f1, f4, f6, this.itemStackOffHand)) {
               this.renderItemInFirstPerson(abstractclientplayer, partialTicks, f1, EnumHand.OFF_HAND, f4, this.itemStackOffHand, f6);
            }
         }

         GlStateManager.disableRescaleNormal();
         RenderHelper.disableStandardItemLighting();
      }
   }

   @Inject(
      method = {"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/renderer/ItemRenderer;renderItemSide(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;Z)V"
)}
   )
   private void doItemModelTransforms(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_, CallbackInfo ci) {
      fbm mod = PyroStatic.field_2592;
      if ((Boolean)mod.c.method_3034()) {
         boolean flag = hand == EnumHand.MAIN_HAND;
         EnumHandSide enumhandside = flag ? player.getPrimaryHand() : player.getPrimaryHand().opposite();
         mod.method_1368(enumhandside);
      }

   }
}
