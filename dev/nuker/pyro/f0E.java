/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class f0E {
    public void Method7799(int n, int n2, int n3, int n4, int n5) {
        int n6;
        int n7 = n;
        int n8 = n2;
        int n9 = n3;
        int n10 = n4;
        if (n7 < n9) {
            n6 = n7;
            n7 = n9;
            n9 = n6;
        }
        if (n8 < n10) {
            n6 = n8;
            n8 = n10;
            n10 = n6;
        }
        float f = (float)(n5 >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n5 >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n5 >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n5 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)f2, (float)f3, (float)f4, (float)f);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos((double)n7, (double)n10, 0.0).endVertex();
        bufferBuilder.pos((double)n9, (double)n10, 0.0).endVertex();
        bufferBuilder.pos((double)n9, (double)n8, 0.0).endVertex();
        bufferBuilder.pos((double)n7, (double)n8, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public f0E() {
    }

    public f0E(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}

