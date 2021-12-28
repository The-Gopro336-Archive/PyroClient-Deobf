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
 *  net.minecraft.util.math.MathHelper
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f4Q;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;

public class f5a
extends f4Q {
    public f0l Field2917;
    public f00 Field2918;
    public int Field2919 = 0;

    public void Method4807(BufferBuilder bufferBuilder, int n, int n2, int n3, int n4, float f, float[] arrf) {
        float f2 = (float)n + f * (float)n3 - 0.5f;
        bufferBuilder.pos((double)f2 - 1.0, (double)(n2 + n4) + 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)(f2 + 2.0f), (double)(n2 + n4) + 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)(f2 + 2.0f), (double)n2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)f2 - 1.0, (double)n2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        this.Method4815(bufferBuilder, f2, n2, 1, n4, 1, 2);
        bufferBuilder.pos((double)f2, (double)(n2 + n4), 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)f2 + 1.0, (double)(n2 + n4), 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)f2 + 1.0, (double)n2, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)f2, (double)n2, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
    }

    public void Method4808(BufferBuilder bufferBuilder) {
        GlStateManager.shadeModel((int)7425);
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
    }

    public void Method4809(int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, int n5) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        this.Method4808(bufferBuilder);
        this.Method4815(bufferBuilder, n, n2, n3, n4, n3 / n4 / 2, 2);
        float f5 = n5 == 0 ? f : (n5 == 1 ? f2 : (n5 == 2 ? f3 : f4));
        float f6 = 0.0f;
        int n6 = n + n3;
        for (int i = n; i < n6; ++i) {
            float f7 = (float)(i - n) / (float)n3;
            float[] arrf = new float[4];
            float f8 = arrf[0] = n5 == 0 ? f6 : f;
            float f9 = n5 == 1 ? f6 : (arrf[1] = f2);
            arrf[2] = n5 == 2 ? f6 : f3;
            arrf[3] = n5 == 3 ? f6 : f4;
            float[] arrf2 = arrf;
            float[] arrf3 = new float[]{n5 == 0 ? f7 : f, n5 == 1 ? f7 : f2, n5 == 2 ? f7 : f3, n5 == 3 ? f7 : f4};
            bufferBuilder.pos((double)i, (double)(n2 + n4), 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
            bufferBuilder.pos((double)i + 1.0, (double)(n2 + n4), 0.0).color(arrf3[0], arrf3[1], arrf3[2], arrf3[3]).endVertex();
            bufferBuilder.pos((double)i + 1.0, (double)n2, 0.0).color(arrf3[0], arrf3[1], arrf3[2], arrf3[3]).endVertex();
            bufferBuilder.pos((double)i, (double)n2, 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
            f6 = f7;
        }
        this.Method4807(bufferBuilder, n, n2, n3, n4, f5, new float[]{f, f2, f3, f4});
        tessellator.draw();
        this.Method455();
    }

    @Override
    public void Method4810(int n, int n2, int n3) {
        super.Method4810(n, n2, n3);
        this.Field2919 = 0;
        this.Field2917.Method7975(this.Field2918.Method7513());
    }

    @Override
    public boolean Method4797(float f, float f2, float f3) {
        int n = 8;
        int n2 = 1;
        int n3 = (int)((float)(n2 * 2 + n) + this.Method4906()) - 10;
        int n4 = n + n2;
        float[] arrf = this.Field2918.Method7511();
        int n5 = (int)((this.Method5094() - (float)(n2 * 2)) * 0.41666666f);
        int n6 = (int)((float)(n5 + n2 * 2) + PyroRenderUtil.Method4908() + 3.0f);
        int n7 = (int)(this.Method5094() - (float)(n2 * 3) - (float)n5 - PyroRenderUtil.Method4908() - 3.0f);
        this.Method4813(n2, n3, n5, n5, arrf[0], arrf[1], arrf[2]);
        this.Method4811(n2 + n5 + 3, n3, n, n5, arrf[0]);
        float[] arrf2 = f00.Field5379.Method7933(arrf[0], arrf[1], arrf[2], arrf[3]);
        int n8 = n7 - n;
        PyroRenderUtil.Method12313("R", n6, n3 + 1, -1);
        this.Method4809(n6 + n, n3, n8, n, arrf2[0], arrf2[1], arrf2[2], arrf2[3], 0);
        PyroRenderUtil.Method12313("G", n6, n3 + 1 + n4, -1);
        this.Method4809(n6 + n, n3 + n4, n8, n, arrf2[0], arrf2[1], arrf2[2], arrf2[3], 1);
        PyroRenderUtil.Method12313("B", n6, n3 + 1 + n4 * 2, -1);
        this.Method4809(n6 + n, n3 + n4 * 2, n8, n, arrf2[0], arrf2[1], arrf2[2], arrf2[3], 2);
        PyroRenderUtil.Method12313("A", n6, n3 + 1 + n4 * 3, -1);
        this.Method4809(n6 + n, n3 + n4 * 3, n8, n, arrf2[0], arrf2[1], arrf2[2], arrf2[3], 3);
        PyroRenderUtil.Method12313("R", n6, n3 + n4 * 4, -1);
        this.Method4812(n6 + n, n3 + n4 * 4, n8, n, this.Field2918.Method7523());
        n3 = (int)((float)n3 - this.Method4906());
        switch (this.Field2919) {
            case 1: {
                float f4 = MathHelper.clamp((float)((f - (float)n2) / (float)n5), (float)0.0f, (float)1.0f);
                float f5 = MathHelper.clamp((float)(1.0f - (f2 - this.Method4906() - (float)n3) / (float)n5), (float)0.0f, (float)1.0f);
                this.Field2918.Method7534(f4);
                this.Field2918.Method7532(f5);
                break;
            }
            case 2: {
                float f6 = MathHelper.clamp((float)((f2 - this.Method4906() - (float)n3) / (float)n5), (float)0.0f, (float)1.0f);
                this.Field2918.Method7507(f6);
                break;
            }
            case 3: {
                float f7 = MathHelper.clamp((float)((f - (float)n6 - (float)n) / (float)n8), (float)0.0f, (float)1.0f);
                this.Field2918.Method7512(f7);
                break;
            }
            case 4: {
                float f8 = MathHelper.clamp((float)((f - (float)n6 - (float)n) / (float)n8), (float)0.0f, (float)1.0f);
                this.Field2918.Method7527(f8);
                break;
            }
            case 5: {
                float f9 = MathHelper.clamp((float)((f - (float)n6 - (float)n) / (float)n8), (float)0.0f, (float)1.0f);
                this.Field2918.Method7508(f9);
                break;
            }
            case 6: {
                float f64 = MathHelper.clamp((float)((f - (float)n6 - (float)n) / (float)n8), (float)0.0f, (float)1.0f);
                this.Field2918.Method7516(f64);
                break;
            }
            case 7: {
                float f100 = MathHelper.clamp((float)((f - (float)n6 - (float)n) / (float)n8), (float)0.0f, (float)1.0f);
                this.Field2918.Method7521(f100);
                break;
            }
        }
        return false;
    }

    public f5a(f0l f0l2, float f) {
        super(f0l2.Method7977(), 0.0f, 0.0f, f, 48.0f);
        this.Field2917 = f0l2;
        this.Field2918 = (f00)f0l2.Method7979();
    }

    public void Method4811(int n, int n2, int n3, int n4, float f) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        this.Method4808(bufferBuilder);
        float f2 = 0.0f;
        int n5 = n2 + n4;
        for (int i = n2; i < n5; ++i) {
            float f3 = (float)(i - n2) / (float)n4;
            float[] arrf = f00.Field5379.Method7933(f2, 1.0f, 1.0f, 1.0f);
            float[] arrf2 = f00.Field5379.Method7933(f3, 1.0f, 1.0f, 1.0f);
            bufferBuilder.pos((double)n, (double)i + 1.0, 0.0).color(arrf2[0], arrf2[1], arrf2[2], 1.0f).endVertex();
            bufferBuilder.pos((double)(n + n3), (double)i + 1.0, 0.0).color(arrf2[0], arrf2[1], arrf2[2], 1.0f).endVertex();
            bufferBuilder.pos((double)(n + n3), (double)i, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
            bufferBuilder.pos((double)n, (double)i, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
            f2 = f3;
        }
        this.Method4814(bufferBuilder, n, n2, n3, n4, f, f00.Field5379.Method7933(f, 1.0f, 1.0f, 1.0f));
        tessellator.draw();
        this.Method455();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void Method4796(int n, int n2, int n3) {
        super.Method4796(n, n2, n3);
        int n4 = 8;
        int n5 = 1;
        int n6 = (int)((float)(n5 * 2 + n4) + this.Method4906()) - 10;
        int n7 = n4 + n5;
        int n8 = (int)((this.Method5094() - (float)(n5 * 2)) * 0.41666666f);
        int n9 = (int)((float)(n8 + n5 * 2) + PyroRenderUtil.Method4908() + 3.0f);
        int n10 = (int)(this.Method5094() - (float)(n5 * 3) - (float)n8 - PyroRenderUtil.Method4908() - 3.0f);
        int n11 = n10 - n4;
        if (n >= n5 && n <= n5 + n8) {
            this.Field2919 = 1;
            return;
        }
        if (n >= n5 + n8 + 3 && n <= n5 + n8 + 3 + n4) {
            this.Field2919 = 2;
            return;
        }
        if (n >= n9 + n4 && n <= n9 + n4 + n11 && n2 >= n6 && n2 <= n6 + n4) {
            this.Field2919 = 3;
            return;
        }
        if (n >= n9 + n4 && n <= n9 + n4 + n11 && n2 >= n6 + n7 && n2 <= n6 + n4 + n7) {
            this.Field2919 = 4;
            return;
        }
        if (n >= n9 + n4 && n <= n9 + n4 + n11 && n2 >= n6 + n7 * 2 && n2 <= n6 + n4 + n7 * 2) {
            this.Field2919 = 5;
            return;
        }
        if (n >= n9 + n4 && n <= n9 + n4 + n11 && n2 >= n6 + n7 * 3 && n2 <= n6 + n4 + n7 * 3) {
            this.Field2919 = 6;
            return;
        }
        if (n < n9 + n4) return;
        if (n > n9 + n4 + n11) return;
        if (n2 < n6 + n7 * 4) return;
        if (n2 > n6 + n4 + n7 * 4) return;
        this.Field2919 = 7;
    }

    public void Method4812(int n, int n2, int n3, int n4, float f) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        this.Method4808(bufferBuilder);
        float f2 = 0.0f;
        int n5 = n + n3;
        for (int i = n; i < n5; ++i) {
            float f3 = (float)(i - n) / (float)n3;
            float[] arrf = f00.Field5379.Method7933(f2, 1.0f, 1.0f, 1.0f);
            float[] arrf2 = f00.Field5379.Method7933(f3, 1.0f, 1.0f, 1.0f);
            bufferBuilder.pos((double)i, (double)(n2 + n4), 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
            bufferBuilder.pos((double)i + 1.0, (double)(n2 + n4), 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
            bufferBuilder.pos((double)i + 1.0, (double)((float)(n2 + n4) - (float)(i - n + 1) / (float)n3 * (float)n4), 0.0).color(arrf2[0], arrf2[1], arrf2[2], arrf2[3]).endVertex();
            bufferBuilder.pos((double)i, (double)((float)(n2 + n4) - (float)(i - n) / (float)n3 * (float)n4), 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
            f2 = f3;
        }
        float f4 = (float)n + f * (float)n3 - 0.5f;
        bufferBuilder.pos((double)f4, (double)(n2 + n4) + 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)f4 + 1.0, (double)(n2 + n4) + 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)f4 + 1.0, (double)n2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)f4, (double)n2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        tessellator.draw();
        this.Method455();
    }

    public void Method4813(int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        this.Method4808(bufferBuilder);
        float f4 = 0.0f;
        int n5 = n + n3;
        for (int i = n; i < n5; ++i) {
            float f5 = (float)(i - n) / (float)n3;
            float f6 = 1.0f;
            int n6 = n2 + n4;
            for (int j = n2; j < n6; ++j) {
                float f7 = 1.0f - (float)(j - n2) / (float)n4;
                float[] arrf = f00.Field5379.Method7933(f, f4, f6, 1.0f);
                float[] arrf2 = f00.Field5379.Method7933(f, f4, f7, 1.0f);
                float[] arrf3 = f00.Field5379.Method7933(f, f5, f6, 1.0f);
                float[] arrf4 = f00.Field5379.Method7933(f, f5, f7, 1.0f);
                bufferBuilder.pos((double)i, (double)j + 1.0, 0.0).color(arrf2[0], arrf2[1], arrf2[2], 1.0f).endVertex();
                bufferBuilder.pos((double)i + 1.0, (double)j + 1.0, 0.0).color(arrf4[0], arrf4[1], arrf4[2], 1.0f).endVertex();
                bufferBuilder.pos((double)i + 1.0, (double)j, 0.0).color(arrf3[0], arrf3[1], arrf3[2], 1.0f).endVertex();
                bufferBuilder.pos((double)i, (double)j, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
                f6 = f7;
            }
            f4 = f5;
        }
        float f8 = (float)n + f2 * (float)n3 - 0.5f;
        float f9 = (float)n2 + (1.0f - f3) * (float)n4 - 0.5f;
        int n7 = (double)f3 > 0.5 && (double)f2 < 0.5 ? 0 : 255;
        bufferBuilder.pos((double)f8 - 1.0, (double)(f9 + 2.0f), 0.0).color(n7, n7, n7, 255).endVertex();
        bufferBuilder.pos((double)(f8 + 2.0f), (double)(f9 + 2.0f), 0.0).color(n7, n7, n7, 255).endVertex();
        bufferBuilder.pos((double)(f8 + 2.0f), (double)f9 - 1.0, 0.0).color(n7, n7, n7, 255).endVertex();
        bufferBuilder.pos((double)f8 - 1.0, (double)f9 - 1.0, 0.0).color(n7, n7, n7, 255).endVertex();
        float[] arrf = f00.Field5379.Method7933(f, f2, f3, 1.0f);
        bufferBuilder.pos((double)f8, (double)f9 + 1.0, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
        bufferBuilder.pos((double)f8 + 1.0, (double)f9 + 1.0, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
        bufferBuilder.pos((double)f8 + 1.0, (double)f9, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
        bufferBuilder.pos((double)f8, (double)f9, 0.0).color(arrf[0], arrf[1], arrf[2], 1.0f).endVertex();
        tessellator.draw();
        this.Method455();
    }

    public void Method4814(BufferBuilder bufferBuilder, int n, int n2, int n3, int n4, float f, float[] arrf) {
        float f2 = (float)n2 + f * (float)n4 - 0.5f;
        bufferBuilder.pos((double)n - 1.0, (double)(f2 + 2.0f), 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)(n + n3) + 1.0, (double)(f2 + 2.0f), 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)(n + n3) + 1.0, (double)f2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)n - 1.0, (double)f2 - 1.0, 0.0).color(255, 255, 255, 255).endVertex();
        bufferBuilder.pos((double)n, (double)f2 + 1.0, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)(n + n3), (double)f2 + 1.0, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)(n + n3), (double)f2, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
        bufferBuilder.pos((double)n, (double)f2, 0.0).color(arrf[0], arrf[1], arrf[2], arrf[3]).endVertex();
    }

    public void Method4815(BufferBuilder bufferBuilder, float f, float f2, int n, int n2, int n3, int n4) {
        float[] arrf = new float[]{240.0f, 240.0f, 240.0f};
        float[] arrf2 = new float[]{130.0f, 130.0f, 130.0f};
        int n5 = n / n3;
        int n6 = n2 / n4;
        int n7 = n3;
        for (int n8 = 0; n8 < n7; n8 = (int)((byte)(n8 + 1))) {
            int n9 = n4;
            for (int n10 = 0; n10 < n9; n10 = (int)((byte)(n10 + 1))) {
                float[] arrf3 = (n8 + (n10 % 2 == 0 ? 1 : 0)) % 2 == 0 ? arrf : arrf2;
                float f3 = (float)(n8 * n5) + f;
                float f4 = (float)(n10 * n6) + f2;
                float f5 = Math.max((float)(n8 + n5), (float)n + f);
                float f6 = Math.max((float)(n10 + n6), (float)n2 + f2);
                bufferBuilder.pos((double)f3, (double)f6, 0.0).color(arrf3[0], arrf3[1], arrf3[2], 1.0f).endVertex();
                bufferBuilder.pos((double)f5, (double)f6, 0.0).color(arrf3[0], arrf3[1], arrf3[2], 1.0f).endVertex();
                bufferBuilder.pos((double)f5, (double)f4, 0.0).color(arrf3[0], arrf3[1], arrf3[2], 1.0f).endVertex();
                bufferBuilder.pos((double)f3, (double)f4, 0.0).color(arrf3[0], arrf3[1], arrf3[2], 1.0f).endVertex();
            }
        }
    }

    public void Method455() {
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.shadeModel((int)7424);
    }
}

