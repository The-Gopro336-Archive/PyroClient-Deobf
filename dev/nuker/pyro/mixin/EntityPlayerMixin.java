/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.EnumPlayerModelParts
 *  net.minecraft.inventory.Container
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Class48;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f4o;
import dev.nuker.pyro.mixin.EntityLivingBaseMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityPlayer.class})
public abstract class EntityPlayerMixin
extends EntityLivingBaseMixin {
    @Shadow
    public Container Field1298;

    @Redirect(method={"getEyeHeight"}, at=@Class0(value="INVOKE", target="Lnet/minecraft/entity/player/EntityPlayer;isSneaking()Z"))
    private boolean Method1834(EntityPlayer player) {
        return false;
    }

    @Inject(method={"isPushedByWater"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1835(CallbackInfoReturnable info) {
        if (Minecraft.getMinecraft().player == (EntityPlayer)this && ((Boolean)PyroStatic.Field6431.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6431.Method284().Method7979()).booleanValue()) {
            info.Method521(false);
        }
    }

    @Inject(method={"isEntityInsideOpaqueBlock"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1836(CallbackInfoReturnable callback) {
        if (Minecraft.getMinecraft().player == (EntityPlayer)this && (((Boolean)PyroStatic.Field6449.Field5236.Method5264()).booleanValue() || ((Boolean)PyroStatic.Field6547.Field5236.Method5264()).booleanValue())) {
            callback.Method9034();
        }
    }

    @Inject(method={"applyEntityCollision"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method1837(Entity e, CallbackInfo info) {
        if (Minecraft.getMinecraft().player == (EntityPlayer)this && ((Boolean)PyroStatic.Field6431.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6431.Method284().Method7979()).booleanValue()) {
            info.Method9034();
        }
    }

    @Inject(method={"isWearing"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1838(EnumPlayerModelParts part, CallbackInfoReturnable cir) {
        if (Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof Class48) {
            cir.Method521(true);
        }
    }

    @Inject(method={"jump"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method1839(CallbackInfo ci) {
        if (Minecraft.getMinecraft().player == (EntityPlayer)this) {
            f4o event = new f4o();
            Pyro.Method8978().Method7918(event);
            if (event.Method7947()) {
                ci.Method9034();
            }
        }
    }
}

