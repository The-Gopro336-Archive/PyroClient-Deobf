/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f0H;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdX;
import dev.nuker.pyro.fdZ;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class f5P
extends f5q {
    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        int n2 = fdX.Field311.Method492(Items.TOTEM_OF_UNDYING);
        int n3 = fdX.Field311.Method492(Items.EXPERIENCE_BOTTLE);
        int n4 = fdX.Field311.Method492(Items.END_CRYSTAL);
        int n5 = fdX.Field311.Method492(Items.GOLDEN_APPLE);
        List list = new ArrayList();
        if (n2 > 0) {
            list.add(new ItemStack(Items.TOTEM_OF_UNDYING, n2));
        }
        if (n3 > 0) {
            list.add(new ItemStack(Items.EXPERIENCE_BOTTLE, n3));
        }
        if (n4 > 0) {
            list.add(new ItemStack(Items.END_CRYSTAL, n4));
        }
        if (n5 > 0) {
            list.add(new ItemStack(Items.GOLDEN_APPLE, n5, 1));
        }
        int n6 = ((Collection)list).size();
        for (int i = 0; i < n6; ++i) {
            GlStateManager.pushMatrix();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.clear((int)256);
            RenderHelper.enableStandardItemLighting();
            fdZ.Field313.getRenderItem().zLevel = -150.0f;
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            int n7 = 0;
            int n8 = 0;
            ItemStack itemStack = (ItemStack)list.get(i);
            n7 = i % 2 * 20;
            n8 = i / 2 * 20;
            fdZ.Field313.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n7 + 2, n8 + 2);
            fdZ.Field313.getRenderItem().renderItemOverlays(fdZ.Field313.fontRenderer, itemStack, n7 + 2, n8 + 2);
            fdZ.Field313.getRenderItem().zLevel = 0.0f;
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
        }
        PyroRenderUtil.Method12300(0.0f, 0.0f, this.Method4871(), this.Method4873(), 1.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12302(this.Method4871() / (float)2, 0.0f, this.Method4871() / (float)2, this.Method4873(), 1.0f, f0H.Field5479.Method7719());
        PyroRenderUtil.Method12302(0.0f, this.Method4873() / (float)2, this.Method4871(), this.Method4873() / (float)2, 1.0f, f0H.Field5479.Method7719());
    }

    public f5P() {
        super("potionHud", null, 2, null);
    }

    @Override
    public float Method4871() {
        return 40.0f;
    }

    @Override
    public float Method4873() {
        return 40.0f;
    }

    @Override
    public boolean Method4872() {
        return false;
    }
}

