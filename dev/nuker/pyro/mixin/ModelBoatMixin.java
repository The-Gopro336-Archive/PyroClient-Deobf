/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBoat
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ModelBoat.class})
public class ModelBoatMixin {
    @Inject(method={"render"}, at={@Class0(value="INVOKE", target="Lnet/minecraft/client/model/ModelBoat;setRotationAngles(FFFFFFLnet/minecraft/entity/Entity;)V")}, cancellable=true)
    private void Method4445(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6518.Field5236.Method5264()).booleanValue() && entityIn == Minecraft.getMinecraft().player.getRidingEntity()) {
            double scale_ = (Double)PyroStatic.Field6518.Method5279().Method7979();
            if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && scale_ != 1.0) {
                GlStateManager.scale((double)scale_, (double)scale_, (double)scale_);
            }
        }
    }

    @Inject(method={"renderMultipass"}, at={@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;colorMask(ZZZZ)V", ordinal=0)})
    private void Method4446(Entity entityIn, float partialTicks, float p_187054_3_, float p_187054_4_, float p_187054_5_, float p_187054_6_, float scale, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6518.Field5236.Method5264()).booleanValue() && entityIn == Minecraft.getMinecraft().player.getRidingEntity()) {
            double scale_ = (Double)PyroStatic.Field6518.Method5279().Method7979();
            if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && scale_ != 1.0) {
                GlStateManager.scale((double)scale_, (double)scale_, (double)scale_);
            }
        }
    }
}

