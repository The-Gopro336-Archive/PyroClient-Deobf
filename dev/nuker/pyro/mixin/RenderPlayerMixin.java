/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.renderer.entity.RenderPlayer
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Class48;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={RenderPlayer.class})
public class RenderPlayerMixin {
    private float Field4508;
    private float Field4509;
    private float Field4510;
    private float Field4511;
    private float Field4512 = 0.0f;
    private float Field4513;
    private float Field4514 = 0.0f;
    private float Field4515;
    private float Field4516;

    @Inject(method={"doRender"}, at={@Class0(value="HEAD")})
    private void Method6434(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (entity == Minecraft.getMinecraft().player) {
            this.Field4511 = entity.prevRotationYawHead;
            this.Field4513 = entity.prevRotationPitch;
            this.Field4508 = entity.rotationPitch;
            this.Field4509 = entity.rotationYaw;
            this.Field4510 = entity.rotationYawHead;
            this.Field4516 = entity.prevRenderYawOffset;
            this.Field4515 = entity.renderYawOffset;
            if (Pyro.Method8979().Method7540() != -1337.0f) {
                entity.rotationPitch = Pyro.Method8979().Method7540();
                entity.prevRotationPitch = this.Field4514;
            }
            if (Pyro.Method8979().Method7537() != -1337.0f) {
                entity.rotationYaw = Pyro.Method8979().Method7537();
                entity.rotationYawHead = Pyro.Method8979().Method7537();
                entity.prevRotationYawHead = Pyro.Method8979().Method7537();
                entity.prevRenderYawOffset = Pyro.Method8979().Method7537();
                entity.renderYawOffset = Pyro.Method8979().Method7537();
            }
        }
    }

    @Inject(method={"doRender"}, at={@Class0(value="RETURN")})
    private void Method6435(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (entity == Minecraft.getMinecraft().player) {
            this.Field4512 = entity.rotationYawHead;
            this.Field4514 = entity.rotationPitch;
            entity.rotationPitch = this.Field4508;
            entity.rotationYaw = this.Field4509;
            entity.rotationYawHead = this.Field4510;
            entity.prevRotationYawHead = this.Field4511;
            entity.prevRotationPitch = this.Field4513;
            entity.prevRotationYawHead = this.Field4511;
            entity.renderYawOffset = this.Field4515;
            entity.prevRenderYawOffset = this.Field4516;
        }
    }

    @Inject(method={"renderEntityName"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method6436(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo info) {
        if (((Boolean)PyroStatic.Field6433.Field5236.Method5264()).booleanValue()) {
            info.Method9034();
        }
    }

    @Inject(method={"renderEntityName"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method6437(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo ci) {
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof Class48) {
            ci.Method9034();
        }
    }

    @Inject(method={"doRender"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method6438(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA && entity.getEntityId() == -6969) {
            ci.Method9034();
        }
    }
}

