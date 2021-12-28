/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5M
extends f5q {
    @NotNull
    public PotionEffect Field4154;

    @Override
    public float Method4873() {
        return 13.0f;
    }

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        GlStateManager.pushMatrix();
        boolean bl = n < 2;
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.disableLighting();
        Potion potion = this.Field4154.getPotion();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        fdZ.Field313.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
        if (potion.hasStatusIcon()) {
            int n2 = potion.getStatusIconIndex();
            float f3 = 0.7f;
            GlStateManager.enableAlpha();
            GlStateManager.disableDepth();
            GlStateManager.pushMatrix();
            GlStateManager.translate((double)(bl ? (double)(this.Method4871() - (float)13) : 0.0), (double)0.0, (double)0.0);
            GlStateManager.scale((float)f3, (float)f3, (float)f3);
            Gui gui = fdZ.Field313.currentScreen != null ? (Gui)fdZ.Field313.currentScreen : (Gui)fdZ.Field313.ingameGUI;
            if (gui == null) {
                Intrinsics.Method6551();
            }
            gui.drawTexturedModalRect(0, 0, n2 % 8 * 18, 198 + n2 / 8 * 18, 18, 18);
            GlStateManager.popMatrix();
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
        }
        potion.renderInventoryEffect(0, 0, this.Field4154, fdZ.Field313);
        String string = I18n.format((String)potion.getName(), (Object[])new Object[0]);
        if (this.Field4154.getAmplifier() > 0) {
            string = string + " " + I18n.format((String)("enchantment.level." + (this.Field4154.getAmplifier() + 1)), (Object[])new Object[0]);
        }
        String string2 = Potion.getPotionDurationString((PotionEffect)this.Field4154, (float)1.0f);
        String string3 = string2 + ' ' + string;
        float f4 = PyroRenderUtil.Method12311(string3);
        string3 = string + ' ' + string2;
        f4 = PyroRenderUtil.Method12311(string3) + (float)2;
        PyroRenderUtil.Method12313(string + ' ' + string2, bl ? 0.0f : 15.0f, 3.0f, -1);
        GlStateManager.popMatrix();
    }

    @NotNull
    public PotionEffect Method5790() {
        return this.Field4154;
    }

    @Override
    public float Method4871() {
        String string = I18n.format((String)this.Field4154.getPotion().getName(), (Object[])new Object[0]);
        if (this.Field4154.getAmplifier() > 0) {
            string = string + " " + I18n.format((String)("enchantment.level." + (this.Field4154.getAmplifier() + 1)), (Object[])new Object[0]);
        }
        String string2 = Potion.getPotionDurationString((PotionEffect)this.Field4154, (float)1.0f);
        String string3 = string2 + ' ' + string + ' ';
        return PyroRenderUtil.Method12311(string3) + this.Method4873();
    }

    @Override
    public boolean Method4872() {
        return true;
    }

    public f5M(@NotNull PotionEffect potionEffect) {
        super("", null, 2, null);
        this.Field4154 = potionEffect;
    }

    public void Method5791(@NotNull PotionEffect potionEffect) {
        this.Field4154 = potionEffect;
    }
}

