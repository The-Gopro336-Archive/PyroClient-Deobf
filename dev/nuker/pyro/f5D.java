/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class f5D
extends f5q {
    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        int n2 = 26;
        for (int i = 0; i <= n2; ++i) {
            ItemStack itemStack = (ItemStack)fdZ.Field313.player.inventory.mainInventory.get(i + 9);
            int n3 = i % 9 * 16;
            int n4 = i / 9 * 16;
            fdZ.Field313.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n3, n4);
            fdZ.Field313.getRenderItem().renderItemOverlayIntoGUI(fdZ.Field313.fontRenderer, itemStack, n3, n4, null);
        }
        PyroRenderUtil.Method12300(0.0f, 0.0f, this.Method4871(), this.Method4873(), 1.0f, f0H.Field5479.Method7719());
        RenderHelper.disableStandardItemLighting();
        fdZ.Field313.getRenderItem().zLevel = 0.0f;
        GlStateManager.popMatrix();
    }

    @Override
    public boolean Method4872() {
        return true;
    }

    @Override
    public float Method4871() {
        return 144.0f;
    }

    public f5D() {
        super("inventory", null, 2, null);
    }

    @Override
    public float Method4873() {
        return 48.0f;
    }
}

