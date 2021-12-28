/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.EntityLivingBase
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.f5q;
import dev.nuker.pyro.f5t;
import dev.nuker.pyro.fdZ;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.Nullable;

public class f5L
extends f5q {
    public float Field4150 = 128.0f;
    public float Field4151 = 64.0f;

    @Override
    public void Method4875(@Nullable f5t f5t2, int n, @Nullable ScaledResolution scaledResolution, float f, float f2) {
        if (fdZ.Field313.world == null || fdZ.Field313.player == null) {
            return;
        }
        this.Field4150 = 50.0f;
        this.Field4151 = 100.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        GlStateManager.color((float)f3, (float)f4, (float)f5, (float)f6);
        int n2 = (int)this.Field4150 / 2;
        int n3 = (int)this.Field4151;
        int n4 = 50;
        float f7 = f;
        float f8 = f2;
        EntityLivingBase entityLivingBase = (EntityLivingBase)fdZ.Field313.player;
        try {
            GuiInventory.drawEntityOnScreen((int)n2, (int)n3, (int)n4, (float)f7, (float)f8, (EntityLivingBase)entityLivingBase);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public float Method5094() {
        return this.Field4151;
    }

    public void Method737(float f) {
        this.Field4151 = f;
    }

    public void Method458(float f) {
        this.Field4150 = f;
    }

    @Override
    public float Method4873() {
        return this.Field4151;
    }

    public float Method740() {
        return this.Field4150;
    }

    @Override
    public float Method4871() {
        return this.Field4150;
    }

    @Override
    public boolean Method4872() {
        return false;
    }

    public f5L() {
        super("playerModel", null, 2, null);
    }
}

