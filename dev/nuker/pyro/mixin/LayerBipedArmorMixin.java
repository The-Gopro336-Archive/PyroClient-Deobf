/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({LayerBipedArmor.class})
public abstract class LayerBipedArmorMixin {
   @Inject(
      method = {"setModelSlotVisible"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void setModelSlotVisible(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn, CallbackInfo info) {
      if ((Boolean)PyroStatic.field_2507.c.method_3034() && (Boolean)PyroStatic.field_2507.method_1327().c()) {
         info.cancel();
         p_188359_1_.setVisible(false);
         if (slotIn == EntityEquipmentSlot.HEAD) {
            p_188359_1_.bipedHead.showModel = false;
            p_188359_1_.bipedHeadwear.showModel = false;
         } else if (slotIn == EntityEquipmentSlot.CHEST) {
            p_188359_1_.bipedBody.showModel = false;
            p_188359_1_.bipedRightArm.showModel = false;
            p_188359_1_.bipedLeftArm.showModel = false;
         } else if (slotIn == EntityEquipmentSlot.LEGS) {
            p_188359_1_.bipedBody.showModel = false;
            p_188359_1_.bipedRightLeg.showModel = false;
            p_188359_1_.bipedLeftLeg.showModel = false;
         } else if (slotIn == EntityEquipmentSlot.FEET) {
            p_188359_1_.bipedRightLeg.showModel = false;
            p_188359_1_.bipedLeftLeg.showModel = false;
         }
      }

   }
}
