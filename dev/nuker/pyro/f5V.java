/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.item.ItemStack
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class f5v
extends f5q {
    @Override
    public float Method4873() {
        return 27.0f;
    }

    @Override
    public boolean Method4872() {
        return false;
    }

    public f5v() {
        super("armor", null);
    }

    @Override
    public void Method4875(f5t f5t2, int n, ScaledResolution scaledResolution, float f, float f2) {
        Iterator iterator2 = f5v.Field313.player.getArmorInventoryList().iterator();
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        while (iterator2.hasNext()) {
            ItemStack itemStack = (ItemStack)iterator2.next();
            if (itemStack.isEmpty()) continue;
            arrayList.add(itemStack);
        }
        Collections.reverse(arrayList);
        int n2 = 0;
        int n3 = 0;
        for (ItemStack itemStack : arrayList) {
            GlStateManager.pushMatrix();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.clear((int)256);
            RenderHelper.enableStandardItemLighting();
            f5v.Field313.getRenderItem().zLevel = -150.0f;
            GlStateManager.disableAlpha();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            float f3 = (float)(itemStack.getMaxDamage() - itemStack.getItemDamage()) / (float)itemStack.getMaxDamage() * 100.0f;
            Field313.getRenderItem().renderItemAndEffectIntoGUI(itemStack, n2, 10);
            Field313.getRenderItem().renderItemOverlays(f5v.Field313.fontRenderer, itemStack, n2, 10);
            int n4 = 0x1FFF00;
            if (f3 > 30.0f && f3 < 70.0f) {
                n4 = 0xFFFF00;
            } else if (f3 <= 30.0f) {
                n4 = 0xFF0000;
            }
            String string = String.valueOf((int)f3);
            int n5 = 15;
            if (string.length() == 2) {
                n5 -= 2;
            } else if (string.length() == 1) {
                n5 -= 4;
            }
            PyroRenderUtil.Method12313(string, (float)(n2 + n5 + 2) - PyroRenderUtil.Method12314(string), 2.0f, n4);
            n2 += 22;
            n3 += 22;
            f5v.Field313.getRenderItem().zLevel = 0.0f;
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
        }
    }

    @Override
    public float Method4871() {
        return 83.0f;
    }
}

