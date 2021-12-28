/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.renderer.entity.layers.LayerBipedArmor
 *  net.minecraft.inventory.EntityEquipmentSlot
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LayerBipedArmor.class})
public abstract class LayerBipedArmorMixin {
    @Inject(method={"setModelSlotVisible"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method7124(ModelBiped p_188359_1_, EntityEquipmentSlot slotIn, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method276().Method7979()).booleanValue()) {
            info.Method9034();
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

