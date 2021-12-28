/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.google.common.base.MoreObjects
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.ItemRenderer
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.EnumHandSide
 *  net.minecraftforge.client.ForgeHooksClient
 */
package dev.nuker.pyro.mixin;

import com.google.common.base.MoreObjects;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fb2;
import dev.nuker.pyro.fbm;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
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
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ItemRenderer.class})
public class ItemRendererMixin {
    @Shadow
    @Final
    private Minecraft Field6066;
    @Shadow
    private float Field6067;
    @Shadow
    private float Field6068;
    @Shadow
    private float Field6069;
    @Shadow
    private float Field6070;
    @Shadow
    private ItemStack Field6071;
    @Shadow
    private ItemStack Field6072;

    @Shadow
    private void Method8786(float angle, float angleY) {
    }

    @Shadow
    private void Method8787() {
    }

    @Shadow
    private void Method8788(float p_187458_1_) {
    }

    @Shadow
    public void Method8789(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_) {
    }

    @Inject(method={"renderFireInFirstPerson"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8790(CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method282().Method7979()).booleanValue()) {
            ci.Method9034();
        }
    }

    @Inject(method={"renderWaterOverlayTexture"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8791(CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method280().Method7979()).booleanValue()) {
            ci.Method9034();
        }
    }

    @Inject(method={"renderSuffocationOverlay"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8792(CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6443.Method269().Method7979()).booleanValue()) {
            ci.Method9034();
        }
    }

    @Inject(method={"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method8793(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_, CallbackInfo ci) {
        if (((Boolean)PyroStatic.Field6417.Field5236.Method5264()).booleanValue() && PyroStatic.Field6417.Field1714.Method7991().Method7979() == fb2.CAMERA) {
            ci.Method9034();
        }
    }

    @Inject(method={"Lnet/minecraft/client/renderer/ItemRenderer;renderItemInFirstPerson(F)V"}, at={@Class0(value="HEAD")}, cancellable=true)
    public void Method8794(float partialTicks, CallbackInfo info) {
        float f6;
        float f4;
        float f5;
        float f3;
        ItemStack itemstack;
        if (!((Boolean)PyroStatic.Field6478.Field5236.Method5264()).booleanValue()) {
            return;
        }
        info.Method9034();
        EntityPlayerSP abstractclientplayer = this.Field6066.player;
        float f = abstractclientplayer.getSwingProgress(partialTicks);
        EnumHand enumhand = (EnumHand)MoreObjects.firstNonNull((Object)abstractclientplayer.swingingHand, (Object)EnumHand.MAIN_HAND);
        float f1 = abstractclientplayer.prevRotationPitch + (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * partialTicks;
        float f2 = abstractclientplayer.prevRotationYaw + (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * partialTicks;
        boolean flag = true;
        boolean flag1 = true;
        if (abstractclientplayer.isHandActive() && !(itemstack = abstractclientplayer.getActiveItemStack()).isEmpty() && itemstack.getItem() == Items.BOW) {
            EnumHand enumhand1 = abstractclientplayer.getActiveHand();
            flag = enumhand1 == EnumHand.MAIN_HAND;
            flag1 = !flag;
        }
        this.Method8786(f1, f2);
        this.Method8787();
        this.Method8788(partialTicks);
        GlStateManager.enableRescaleNormal();
        if (flag && !ForgeHooksClient.renderSpecificFirstPersonHand((EnumHand)EnumHand.MAIN_HAND, (float)partialTicks, (float)f1, (float)(f3 = enumhand == EnumHand.MAIN_HAND ? f : 0.0f), (float)(f5 = 1.0f - (this.Field6068 + (this.Field6067 - this.Field6068) * partialTicks)), (ItemStack)this.Field6071)) {
            this.Method8789((AbstractClientPlayer)abstractclientplayer, partialTicks, f1, EnumHand.MAIN_HAND, f3, this.Field6071, f5);
        }
        if (flag1 && !ForgeHooksClient.renderSpecificFirstPersonHand((EnumHand)EnumHand.OFF_HAND, (float)partialTicks, (float)f1, (float)(f4 = enumhand == EnumHand.OFF_HAND ? f : 0.0f), (float)(f6 = (float)((Double)PyroStatic.Field6478.Field1910.Method7979()).doubleValue()), (ItemStack)this.Field6072)) {
            this.Method8789((AbstractClientPlayer)abstractclientplayer, partialTicks, f1, EnumHand.OFF_HAND, f4, this.Field6072, f6);
        }
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }

    @Inject(method={"renderItemInFirstPerson(Lnet/minecraft/client/entity/AbstractClientPlayer;FFLnet/minecraft/util/EnumHand;FLnet/minecraft/item/ItemStack;F)V"}, at={@Class0(value="INVOKE", target="Lnet/minecraft/client/renderer/ItemRenderer;renderItemSide(Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemCameraTransforms$TransformType;Z)V")})
    private void Method8795(AbstractClientPlayer player, float p_187457_2_, float p_187457_3_, EnumHand hand, float p_187457_5_, ItemStack stack, float p_187457_7_, CallbackInfo ci) {
        fbm mod = PyroStatic.Field6528;
        if (((Boolean)mod.Field5236.Method5264()).booleanValue()) {
            boolean flag = hand == EnumHand.MAIN_HAND;
            EnumHandSide enumhandside = flag ? player.getPrimaryHand() : player.getPrimaryHand().opposite();
            mod.Method237(enumhandside);
        }
    }
}

