/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f7b;
import dev.nuker.pyro.fe3;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class f79
implements Consumer {
    public f7b Field3076;

    public void accept(Object object) {
        this.Method4952((fe3)object);
    }

    public void Method4952(@NotNull fe3 fe32) {
        float f = ((Number)fe32.Method466()).floatValue() * (float)16;
        float f2 = ((Number)fe32.Method465()).floatValue() * (float)16;
        Entity entity = f7b.Method5203(this.Field3076).getRenderViewEntity();
        if (entity == null) {
            Intrinsics.Method6551();
        }
        Entity entity2 = f7b.Method5203(this.Field3076).getRenderViewEntity();
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        Entity entity3 = f7b.Method5203(this.Field3076).getRenderViewEntity();
        if (entity3 == null) {
            Intrinsics.Method6551();
        }
        PyroRenderUtil.Field7388.setPosition(entity.posX, entity2.posY, entity3.posZ);
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)f - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosX, 0.0 - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosY, (double)f2 - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosZ, (double)(f + (float)16) - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosX, 1.0 - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosY, (double)(f2 + (float)16) - f7b.Method5203((f7b)this.Field3076).getRenderManager().viewerPosZ);
        AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB((double)f, 0.0, (double)f2, (double)(f + (float)16), 1.0, (double)(f2 + (float)16));
        if (PyroRenderUtil.Field7388.isBoundingBoxInFrustum(axisAlignedBB2)) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            GL11.glLineWidth((float)1.5f);
            RenderGlobal.renderFilledBox((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ, (double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ, (float)((f00)this.Field3076.Method239().Method7979()).Method7514(), (float)((f00)this.Field3076.Method239().Method7979()).Method7517(), (float)((f00)this.Field3076.Method239().Method7979()).Method7531(), (float)((f00)this.Field3076.Method239().Method7979()).Method7522());
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public f79(f7b f7b2) {
        this.Field3076 = f7b2;
    }
}

