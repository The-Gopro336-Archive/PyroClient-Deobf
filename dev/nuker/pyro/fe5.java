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
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class fe5
extends Tessellator {
    public static fe5 Field252;

    public fe5() {
        super(0x200000);
    }

    public void Method393(@NotNull BlockPos blockPos, int n, int n2, int n3, int n4, int n5) {
        this.Method418(this.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n, n2, n3, n4, n5);
    }

    public void Method394(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method418(this.getBuffer(), f, f2, f3, f4, f5, f6, n4, n5, n6, n3, n2);
    }

    public void Method395(float f, float f2, float f3, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method396(this.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n4, n5, n6, n3, n2);
    }

    public void Method396(@NotNull BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 1) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 2) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 4) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 8) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x10) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x20) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
    }

    public void Method397(@NotNull BufferBuilder bufferBuilder, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2) {
        this.Method407(bufferBuilder, d, d2, d3, d4, d5, d6, n >>> 16 & 0xFF, n >>> 8 & 0xFF, n & 0xFF, n >>> 24 & 0xFF, n2 >>> 16 & 0xFF, n2 >>> 8 & 0xFF, n2 & 0xFF, n2 >>> 24 & 0xFF);
    }

    public void Method398(float f, float f2, float f3, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method418(this.getBuffer(), f, f2, f3, 0.25f, 0.25f, 0.25f, n4, n5, n6, n3, n2);
    }

    public void Method399(@NotNull BlockPos blockPos, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method404(blockPos, n4, n5, n6, n3, n2);
    }

    public void Method400() {
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth((float)1.5f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
    }

    public void Method401() {
        GlStateManager.enableCull();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
    }

    public void Method402(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        this.Method396(this.getBuffer(), f, f2, f3, f4, f5, f6, n, n2, n3, n4, n5);
    }

    public void Method403(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        this.Method418(this.getBuffer(), f, f2, f3, f4, f5, f6, n, n2, n3, n4, n5);
    }

    public void Method404(@NotNull BlockPos blockPos, int n, int n2, int n3, int n4, int n5) {
        this.Method396(this.getBuffer(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1.0f, 1.0f, 1.0f, n, n2, n3, n4, n5);
    }

    public void Method405() {
        this.Method412();
        this.Method401();
    }

    public void Method406(float f, float f2, float f3, float f4, float f5, float f6, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method396(this.getBuffer(), f, f2, f3, f4, f5, f6, n4, n5, n6, n3, n2);
    }

    public void Method407(@NotNull BufferBuilder bufferBuilder, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        bufferBuilder.pos(d, d2, d3).color(n, n2, n3, n4).endVertex();
        bufferBuilder.pos(d4, d5, d6).color(n5, n6, n7, n8).endVertex();
    }

    public void Method408(int n) {
        this.Method400();
        this.Method415(n);
    }

    static {
        fe5 fe52;
        Field252 = fe52 = new fe5();
    }

    public void Method409(@NotNull BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 0x11) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x12) != 0) {
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x21) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x22) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 5) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 6) != 0) {
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 9) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0xA) != 0) {
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x14) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x24) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x18) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x28) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
    }

    public void Method410(@NotNull BlockPos blockPos, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method393(blockPos, n4, n5, n6, n3, n2);
    }

    public void Method411(@NotNull AxisAlignedBB axisAlignedBB, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method396(this.getBuffer(), (float)axisAlignedBB.minX, (float)axisAlignedBB.minY, (float)axisAlignedBB.minZ, (float)(axisAlignedBB.maxX - axisAlignedBB.minX), (float)(axisAlignedBB.maxY - axisAlignedBB.minY), (float)(axisAlignedBB.maxZ - axisAlignedBB.minZ), n4, n5, n6, n3, n2);
    }

    public void Method412() {
        this.draw();
    }

    public void Method413(float f, float f2, float f3, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method418(this.getBuffer(), f, f2, f3, 1.0f, 1.0f, 1.0f, n4, n5, n6, n3, n2);
    }

    @NotNull
    public BufferBuilder Method414() {
        return this.getBuffer();
    }

    public void Method415(int n) {
        this.getBuffer().begin(n, DefaultVertexFormats.POSITION_COLOR);
    }

    public void Method416(@NotNull AxisAlignedBB axisAlignedBB, int n, int n2) {
        int n3 = n >>> 24 & 0xFF;
        int n4 = n >>> 16 & 0xFF;
        int n5 = n >>> 8 & 0xFF;
        int n6 = n & 0xFF;
        this.Method418(this.getBuffer(), (float)axisAlignedBB.minX, (float)axisAlignedBB.minY, (float)axisAlignedBB.minZ, (float)(axisAlignedBB.maxX - axisAlignedBB.minX), (float)(axisAlignedBB.maxY - axisAlignedBB.minY), (float)(axisAlignedBB.maxZ - axisAlignedBB.minZ), n4, n5, n6, n3, n2);
    }

    public void Method417(float f, float f2, float f3, float f4, int n) {
        float f5 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(n & 0xFF) / 255.0f;
        float f8 = (float)(n >> 24 & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f4, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double)f3, (double)f2, 0.0).color(f5, f6, f7, f8).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f5, f6, f7, f8).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public void Method418(@NotNull BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, int n, int n2, int n3, int n4, int n5) {
        if ((n5 & 1) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 2) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 4) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 8) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x10) != 0) {
            bufferBuilder.pos((double)f, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
        }
        if ((n5 & 0x20) != 0) {
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3).color(n, n2, n3, n4).endVertex();
            bufferBuilder.pos((double)f + (double)f4, (double)f2 + (double)f5, (double)f3 + (double)f6).color(n, n2, n3, n4).endVertex();
        }
    }
}

