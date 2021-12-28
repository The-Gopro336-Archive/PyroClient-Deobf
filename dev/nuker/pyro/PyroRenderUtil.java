/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.culling.Frustum
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.Class55;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.feg;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.awt.Color;
import java.util.Objects;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class PyroRenderUtil
extends fdZ {
    public static ICamera Field7388 = new Frustum();

    public static void Method865() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void Method12298(BlockPos blockPos, int n, boolean bl, int n2, float f, boolean bl2, boolean bl3, int n3, boolean bl4) {
        if (bl3) {
            PyroRenderUtil.Method12318(blockPos, new Color(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, n3));
        }
        if (bl2) {
            PyroRenderUtil.Method12305(blockPos, bl ? n2 : n, f, bl4);
        }
    }

    public static void Method12299(AxisAlignedBB axisAlignedBB) {
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int)7);
        int n = 7;
        int n2 = 7;
        int n3 = 7;
        int n4 = 7;
        int n5 = 7;
        int n6 = 7;
        int n7 = 7;
        int n8 = 7;
        int n9 = 7;
        int n10 = 7;
        int n11 = 7;
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
    }

    public static void Method12300(float f, float f2, float f3, float f4, float f5, int n) {
        PyroRenderUtil.Method12316(f, f2, f + f5, f4, n);
        PyroRenderUtil.Method12316(f, f2, f3, f2 + f5, n);
        PyroRenderUtil.Method12316(f, f4, f3, f4 + f5, n);
        PyroRenderUtil.Method12316(f3 - f5, f2, f3, f4, n);
    }

    public static void Method12301(double d, double d2, double d3, double d4, float f) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)f);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    public static void Method12302(float f, float f2, float f3, float f4, float f5, int n) {
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        float f9 = (float)(n >> 24 & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GL11.glLineWidth((float)f5);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f6, f7, f8, f9).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f6, f7, f8, f9).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GL11.glDisable((int)2848);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void Method2377(int n) {
        GL11.glColor4f((float)((float)(n >> 16 & 0xFF) / 255.0f), (float)((float)(n >> 8 & 0xFF) / 255.0f), (float)((float)(n & 0xFF) / 255.0f), (float)((float)(n >> 24 & 0xFF) / 255.0f));
    }

    public static void Method456() {
        GL11.glEnable((int)2896);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)3008);
        GL11.glDepthMask((boolean)true);
        GL11.glCullFace((int)1029);
        GL11.glPopMatrix();
        GL11.glPopAttrib();
    }

    public static void Method12303(AxisAlignedBB axisAlignedBB) {
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int)7);
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB3 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB4 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB5 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB6 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB7 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB8 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB9 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB10 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB11 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB12 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB13 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB13.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB14 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB13.minX, (double)axisAlignedBB14.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB14.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB13.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB13.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB13.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB12.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB12.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB12.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB15 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB11.maxX, (double)axisAlignedBB15.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB15.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB11.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB11.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB11.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB11.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB10.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB10.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB10.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB9.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB9.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB9.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB16 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB8.maxX, (double)axisAlignedBB16.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB16.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB8.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB8.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB8.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB7.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB7.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB7.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB17 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB6.maxX, (double)axisAlignedBB17.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB17.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB6.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB6.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB6.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB5.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB5.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB5.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB18 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB4.minX, (double)axisAlignedBB18.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB18.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB4.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB4.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB4.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB3.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB3.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB3.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        AxisAlignedBB axisAlignedBB19 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB2.minX, (double)axisAlignedBB19.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB19.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
    }

    public static void Method12304(AxisAlignedBB axisAlignedBB, float f, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glLineWidth((float)f);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        PyroRenderUtil.Method12309(axisAlignedBB);
        GL11.glLineWidth((float)1.0f);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static Vec3d Method364(Entity entity, float f) {
        return new Vec3d(entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f, entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f, entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f);
    }

    public static void Method12305(BlockPos blockPos, int n, float f, boolean bl) {
        IBlockState iBlockState = feg.Method701(blockPos);
        if (bl || iBlockState.getMaterial() != Material.AIR) {
            if (PyroRenderUtil.Field313.world.getWorldBorder().contains(blockPos)) {
                Vec3d vec3d = PyroRenderUtil.Method364((Entity)PyroRenderUtil.Field313.player, Field313.getRenderPartialTicks());
                PyroRenderUtil.Method12310(iBlockState.getSelectedBoundingBox((World)PyroRenderUtil.Field313.world, blockPos).grow((double)0.002f).offset(-vec3d.x, -vec3d.y, -vec3d.z), n, f);
            }
        }
    }

    public static void Method12306(float f, float f2, float f3, float f4, float f5, int n, int n2) {
        PyroRenderUtil.Method461();
        PyroRenderUtil.Method12308(f, f2, f3, f4, n);
        PyroRenderUtil.Method2377(n2);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glLineWidth((float)f5);
        GL11.glBegin((int)3);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glVertex2f((float)f, (float)f4);
        GL11.glVertex2f((float)f3, (float)f4);
        GL11.glVertex2f((float)f3, (float)f2);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        PyroRenderUtil.Method865();
    }

    public static void Method12307(float f, float f2, float f3, float f4) {
        GL11.glBegin((int)7);
        GL11.glVertex2f((float)f, (float)f4);
        GL11.glVertex2f((float)f3, (float)f4);
        GL11.glVertex2f((float)f3, (float)f2);
        GL11.glVertex2f((float)f, (float)f2);
        GL11.glEnd();
    }

    public static void Method12308(float f, float f2, float f3, float f4, int n) {
        PyroRenderUtil.Method461();
        PyroRenderUtil.Method2377(n);
        PyroRenderUtil.Method12307(f, f2, f3, f4);
        PyroRenderUtil.Method865();
    }

    public static float Method4908() {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            return Class55.Field4429.Method6335().Method5667();
        }
        return PyroRenderUtil.Field313.fontRenderer.FONT_HEIGHT;
    }

    public static void Method12309(AxisAlignedBB axisAlignedBB) {
        if (axisAlignedBB == null) {
            return;
        }
        GL11.glBegin((int)3);
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB3 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB4 = axisAlignedBB;
        AxisAlignedBB axisAlignedBB5 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB5.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB6 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB5.maxX, (double)axisAlignedBB6.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB6.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB4.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB4.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)3);
        GL11.glVertex3d((double)axisAlignedBB4.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB7 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB4.maxX, (double)axisAlignedBB7.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB7.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB3.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB3.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glEnd();
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)axisAlignedBB3.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        AxisAlignedBB axisAlignedBB8 = axisAlignedBB;
        GL11.glVertex3d((double)axisAlignedBB2.minX, (double)axisAlignedBB8.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB8.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.minZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB2.maxX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB2.minX, (double)axisAlignedBB.minY, (double)axisAlignedBB.maxZ);
        GL11.glVertex3d((double)axisAlignedBB2.minX, (double)axisAlignedBB.maxY, (double)axisAlignedBB.maxZ);
        GL11.glEnd();
    }

    public static void Method12310(AxisAlignedBB axisAlignedBB, int n, float f) {
        float f2 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n & 0xFF) / 255.0f;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)f);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        bufferBuilder.pos(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ).color(f3, f4, f5, f2).endVertex();
        tessellator.draw();
        GL11.glDisable((int)2848);
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static float Method12311(String string) {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            return Class55.Field4429.Method6335().getStringWidth(string);
        }
        return PyroRenderUtil.Field313.fontRenderer.getStringWidth(string);
    }

    public static void Method12312(AxisAlignedBB axisAlignedBB, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        PyroRenderUtil.Method12303(axisAlignedBB);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void Method12313(String string, float f, float f2, int n) {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            Class55.Field4429.Method6335().drawStringWithShadow(string, f, f2, n);
        } else {
            PyroRenderUtil.Field313.fontRenderer.drawStringWithShadow(string, f, f2, n);
        }
    }

    public static float Method12314(String string) {
        if (string == null) {
            return 0.0f;
        }
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            return Class55.Field4429.Method6335().getStringWidth(string);
        }
        return PyroRenderUtil.Field313.fontRenderer.getStringWidth(string);
    }

    public static void Method12315(float f, float f2, float f3, Entity entity, float f4) {
        PyroRenderUtil.Method12317(f, f2, f3);
        int n = (int)entity.getDistance((double)f, (double)f2, (double)f3);
        float f5 = (float)n / 2.0f / (2.0f + (2.0f - f4));
        if (f5 < 1.0f) {
            f5 = 1.0f;
        }
        GlStateManager.scale((float)f5, (float)f5, (float)f5);
    }

    public static void Method455() {
        GL11.glPushAttrib((int)1048575);
        GL11.glPushMatrix();
        GL11.glDisable((int)3008);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4353);
        GL11.glDisable((int)2896);
    }

    public static void Method12316(float f, float f2, float f3, float f4, int n) {
        float f5 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static float Method740() {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            return Class55.Field4429.Method6335().Method5667();
        }
        return PyroRenderUtil.Field313.fontRenderer.FONT_HEIGHT + 2;
    }

    public static void Method12317(float f, float f2, float f3) {
        float f4 = 0.02666667f;
        RenderManagerAccessor renderManagerAccessor = (RenderManagerAccessor)Field313.getRenderManager();
        GlStateManager.translate((double)((double)f - renderManagerAccessor.Method2421()), (double)((double)f2 - renderManagerAccessor.Method2422()), (double)((double)f3 - renderManagerAccessor.Method2423()));
        GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-PyroRenderUtil.Field313.getRenderViewEntity().rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)PyroRenderUtil.Field313.getRenderViewEntity().rotationPitch, (float)(PyroRenderUtil.Field313.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((float)(-f4), (float)(-f4), (float)f4);
    }

    public static void Method12318(BlockPos blockPos, Color color) {
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)blockPos.getX() - PyroRenderUtil.Field313.getRenderManager().viewerPosX, (double)blockPos.getY() - PyroRenderUtil.Field313.getRenderManager().viewerPosY, (double)blockPos.getZ() - PyroRenderUtil.Field313.getRenderManager().viewerPosZ, (double)(blockPos.getX() + 1) - PyroRenderUtil.Field313.getRenderManager().viewerPosX, (double)(blockPos.getY() + 1) - PyroRenderUtil.Field313.getRenderManager().viewerPosY, (double)(blockPos.getZ() + 1) - PyroRenderUtil.Field313.getRenderManager().viewerPosZ);
        Field7388.setPosition(Objects.requireNonNull(PyroRenderUtil.Field313.getRenderViewEntity()).posX, PyroRenderUtil.Field313.getRenderViewEntity().posY, PyroRenderUtil.Field313.getRenderViewEntity().posZ);
        if (Field7388.isBoundingBoxInFrustum(new AxisAlignedBB(axisAlignedBB.minX + PyroRenderUtil.Field313.getRenderManager().viewerPosX, axisAlignedBB.minY + PyroRenderUtil.Field313.getRenderManager().viewerPosY, axisAlignedBB.minZ + PyroRenderUtil.Field313.getRenderManager().viewerPosZ, axisAlignedBB.maxX + PyroRenderUtil.Field313.getRenderManager().viewerPosX, axisAlignedBB.maxY + PyroRenderUtil.Field313.getRenderManager().viewerPosY, axisAlignedBB.maxZ + PyroRenderUtil.Field313.getRenderManager().viewerPosZ))) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GL11.glEnable((int)2848);
            GL11.glHint((int)3154, (int)4354);
            RenderGlobal.renderFilledBox((AxisAlignedBB)axisAlignedBB, (float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
            GL11.glDisable((int)2848);
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public static void Method5741(String string, float f, float f2, int n) {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            Class55.Field4429.Method6335().Method5669(string, f, f2, n);
        } else {
            PyroRenderUtil.Field313.fontRenderer.drawString(string, (int)f, (int)f2, n);
        }
    }

    public static void Method5735(String string, float f, float f2, int n) {
        if (((Boolean)PyroStatic.Field6420.Method274().Method7979()).booleanValue()) {
            Class55.Field4429.Method6335().Method5671(string, f, f2, n);
        } else {
            PyroRenderUtil.Field313.fontRenderer.drawString(string, (int)((float)((int)f) - PyroRenderUtil.Method12314(string) / 2.0f), (int)f2, n);
        }
    }

    public static void Method12319(double d, double d2, double d3, double d4, int n) {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glPushMatrix();
        GL11.glColor4f((float)f2, (float)f3, (float)f4, (float)f);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)d, (double)d4);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glVertex2d((double)d3, (double)d2);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    public static void Method12320(Entity entity, double d, double d2, double d3, int n) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2 + entity.height + 0.5f), (float)((float)d3));
        float f = 1.0f;
        float f2 = 0.0f;
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        float f3 = -PyroRenderUtil.Field313.getRenderManager().playerViewY;
        float f4 = 1.0f;
        float f5 = 0.0f;
        GL11.glRotatef((float)f3, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glScalef((float)-0.017f, (float)-0.017f, (float)0.017f);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        int n2 = 0;
        if (entity.isSneaking()) {
            n2 = 4;
        }
        GL11.glDisable((int)3553);
        GL11.glPushMatrix();
        GL11.glPopMatrix();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2848);
        GlStateManager.disableLighting();
        PyroRenderUtil.Method12319(0.0, n2 + 19, 0.0, n2 + 21, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 21, 0.0, n2 + 46, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 21, 0.0, n2 + 25, n);
        PyroRenderUtil.Method12319(0.0, n2 + 25, 0.0, n2 + 48, n);
        PyroRenderUtil.Method12319(0.0, n2 + 19, 0.0, n2 + 21, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 21, 0.0, n2 + 46, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 21, 0.0, n2 + 25, n);
        PyroRenderUtil.Method12319(0.0, n2 + 25, 0.0, n2 + 48, n);
        PyroRenderUtil.Method12319(0.0, n2 + 140, 0.0, n2 + 142, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 115, 0.0, n2 + 140, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 136, 0.0, n2 + 140, n);
        PyroRenderUtil.Method12319(0.0, n2 + 113, 0.0, n2 + 140, n);
        PyroRenderUtil.Method12319(0.0, n2 + 140, 0.0, n2 + 142, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 115, 0.0, n2 + 140, -16777216);
        PyroRenderUtil.Method12319(0.0, n2 + 136, 0.0, n2 + 140, n);
        PyroRenderUtil.Method12319(0.0, n2 + 113, 0.0, n2 + 140, n);
        GlStateManager.enableLighting();
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        float f6 = 1.0f;
        boolean bl = true;
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    public static void Method461() {
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }
}

