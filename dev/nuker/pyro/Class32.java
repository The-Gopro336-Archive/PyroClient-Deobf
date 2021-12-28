/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.registry.EntityEntry
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Class32 {
    public static Class Method6733(String string) {
        for (EntityEntry entityEntry : ForgeRegistries.ENTITIES) {
            if (!entityEntry.getName().equals(string)) continue;
            return entityEntry.getEntityClass();
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public static float Method6734(EntityLivingBase entityLivingBase) {
        Render render = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject((Entity)entityLivingBase);
        if (render instanceof RenderLivingBase) {
            RenderLivingBase renderLivingBase = (RenderLivingBase)render;
        }
        return 1.8f;
    }

    public static void Method6735(Minecraft minecraft, World world) {
        float f = world.getSunBrightness(1.0f);
        float f2 = f * 0.95f + 0.05f;
        for (int i = 0; i < 256; ++i) {
            float f3 = world.provider.getLightBrightnessTable()[i / 16] * f2;
            float f4 = world.provider.getLightBrightnessTable()[i % 16];
            float f5 = f3 * (f * 0.65f + 0.35f);
            float f6 = f3 * (f * 0.65f + 0.35f);
            float f7 = f4 * ((f4 * 0.6f + 0.4f) * 0.6f + 0.4f);
            float f8 = f4 * (f4 * f4 * 0.6f + 0.4f);
            float f9 = f5 + f4;
            float f64 = f6 + f7;
            float f100 = f3 + f8;
            f9 = f9 * 0.96f + 0.03f;
            f64 = f64 * 0.96f + 0.03f;
            f100 = f100 * 0.96f + 0.03f;
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            if (f64 > 1.0f) {
                f64 = 1.0f;
            }
            if (f100 > 1.0f) {
                f100 = 1.0f;
            }
            float f101 = minecraft.gameSettings.gammaSetting;
            float f102 = 1.0f - f9;
            float f103 = 1.0f - f64;
            float f104 = 1.0f - f100;
            f102 = 1.0f - f102 * f102 * f102 * f102;
            f103 = 1.0f - f103 * f103 * f103 * f103;
            f104 = 1.0f - f104 * f104 * f104 * f104;
            f9 = f9 * (1.0f - f101) + f102 * f101;
            f64 = f64 * (1.0f - f101) + f103 * f101;
            f100 = f100 * (1.0f - f101) + f104 * f101;
            f9 = f9 * 0.96f + 0.03f;
            f64 = f64 * 0.96f + 0.03f;
            f100 = f100 * 0.96f + 0.03f;
            if (f9 > 1.0f) {
                f9 = 1.0f;
            }
            if (f64 > 1.0f) {
                f64 = 1.0f;
            }
            if (f100 > 1.0f) {
                f100 = 1.0f;
            }
            if (f9 < 0.0f) {
                f9 = 0.0f;
            }
            if (f64 < 0.0f) {
                f64 = 0.0f;
            }
            if (f100 < 0.0f) {
                f100 = 0.0f;
            }
            int n = 255;
            int n2 = (int)(f9 * 255.0f);
            int n3 = (int)(f64 * 255.0f);
            int n4 = (int)(f100 * 255.0f);
            ((EntityRendererAccessor)minecraft.entityRenderer).Method4466()[i] = 0xFF000000 | n2 << 16 | n3 << 8 | n4;
        }
        ((EntityRendererAccessor)minecraft.entityRenderer).Method4467().updateDynamicTexture();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @SideOnly(value=Side.CLIENT)
    public static void Method6736(int n, int n2, float f, float f2, float f3, EntityLivingBase entityLivingBase) {
        GlStateManager.disableBlend();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((float)n, (float)n2, (float)50.0f);
        GlStateManager.scale((float)(-f), (float)f, (float)f);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f4 = entityLivingBase.renderYawOffset;
        float f5 = entityLivingBase.rotationYaw;
        float f6 = entityLivingBase.rotationPitch;
        float f7 = entityLivingBase.prevRotationYawHead;
        float f8 = entityLivingBase.rotationYawHead;
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-((float)Math.atan(f3 / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        entityLivingBase.renderYawOffset = (float)Math.atan(f2 / 40.0f) * 20.0f;
        entityLivingBase.rotationYaw = (float)Math.atan(f2 / 40.0f) * 40.0f;
        entityLivingBase.rotationPitch = -((float)Math.atan(f3 / 40.0f)) * 20.0f;
        entityLivingBase.rotationYawHead = entityLivingBase.rotationYaw;
        entityLivingBase.prevRotationYawHead = entityLivingBase.rotationYaw;
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        if (entityLivingBase instanceof EntityPlayer) {
            // empty if block
        }
        try {
            RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
            renderManager.setPlayerViewY(180.0f);
            renderManager.setRenderShadow(false);
            renderManager.renderEntity((Entity)entityLivingBase, 0.0, 0.0, 0.0, 0.0f, 1.0f, true);
            renderManager.setRenderShadow(true);
        }
        finally {
            entityLivingBase.renderYawOffset = f4;
            entityLivingBase.rotationYaw = f5;
            entityLivingBase.rotationPitch = f6;
            entityLivingBase.prevRotationYawHead = f7;
            entityLivingBase.rotationYawHead = f8;
            GlStateManager.popMatrix();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
            GlStateManager.disableTexture2D();
            GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)20.0f);
            GlStateManager.resetColor();
        }
    }
}

