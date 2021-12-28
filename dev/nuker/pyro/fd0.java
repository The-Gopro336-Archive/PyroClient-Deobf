/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.fdc;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class fd0
extends Module {
    @NotNull
    public f0l Field152 = (f0l)this.Method7264(new f0l("lineColor", "Line Color", null, f00.Field5379.Method7931(255, 0, 0, 255)));
    @NotNull
    public f0l Field153 = (f0l)this.Method7264(new f0l("textColor", "Text Color", null, f00.Field5379.Method7931(255, 255, 255, 255)));
    @NotNull
    public f0o<fdc> Field154 = (f0o)this.Method7264(new f0o("mode", "Mode", null, fdc.BELOW));
    @NotNull
    public DoubleSetting Field155 = (DoubleSetting)this.Method7264(new DoubleSetting("distance", "Distance", "Length of yaw lines", 1.0, 0.4, 5.0, 0.0, 64, null));

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        if ((fdc)((Object)this.Field154.Method7979()) == fdc.BELOW) {
            Vec3d vec3d2 = vec3d;
            if (vec3d2 == null) {
                Intrinsics.Method6551();
            }
            this.Method243("S", 0.0, vec3d2);
            this.Method243("N", 180.0, vec3d);
            this.Method243("E", -90.0, vec3d);
            this.Method243("W", 90.0, vec3d);
            this.Method243("SE", -45.0, vec3d);
            this.Method243("NE", -135.0, vec3d);
            this.Method243("SW", 45.0, vec3d);
            this.Method243("NW", 135.0, vec3d);
        } else if ((fdc)((Object)this.Field154.Method7979()) == fdc.INLINE) {
            Vec3d vec3d3 = vec3d;
            if (vec3d3 == null) {
                Intrinsics.Method6551();
            }
            this.Method240("S", 0.0, vec3d3);
            this.Method240("N", 180.0, vec3d);
            this.Method240("E", -90.0, vec3d);
            this.Method240("W", 90.0, vec3d);
            this.Method240("SE", -45.0, vec3d);
            this.Method240("NE", -135.0, vec3d);
            this.Method240("SW", 45.0, vec3d);
            this.Method240("NW", 135.0, vec3d);
        }
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field155;
    }

    public void Method240(@NotNull String string, double d, @NotNull Vec3d vec3d) {
        f00 f002 = (f00)this.Field152.Method7979();
        Vec3d vec3d2 = new Vec3d(0.0, -1.0, ((Number)this.Field155.Method7979()).doubleValue()).rotateYaw(-((float)Math.toRadians(d)));
        Vec3d vec3d3 = new Vec3d(0.0, 1.0, ((Number)this.Field155.Method7979()).doubleValue()).rotateYaw(-((float)Math.toRadians(d)));
        Vec3d vec3d4 = new Vec3d(0.0, -0.0, ((Number)this.Field155.Method7979()).doubleValue()).rotateYaw(-((float)Math.toRadians(d)));
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.glLineWidth((float)2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        GlStateManager.color((float)f002.Method7514(), (float)f002.Method7517(), (float)f002.Method7531(), (float)f002.Method7522());
        GlStateManager.disableLighting();
        GlStateManager.loadIdentity();
        EntityRenderer entityRenderer = this.Field5233.entityRenderer;
        if (entityRenderer == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
        }
        ((EntityRendererAccessor)entityRenderer).Method4464(this.Field5233.getRenderPartialTicks());
        GlStateManager.glBegin((int)1);
        fd0 fd02 = this;
        boolean bl = false;
        boolean bl2 = false;
        fd0 fd03 = fd02;
        boolean bl3 = false;
        Entity entity = fd03.Field5233.getRenderViewEntity();
        if (entity == null) {
            Intrinsics.Method6551();
        }
        GL11.glVertex3d((double)vec3d2.x, (double)(vec3d2.y + (double)entity.getEyeHeight()), (double)vec3d2.z);
        Entity entity2 = fd03.Field5233.getRenderViewEntity();
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        GL11.glVertex3d((double)vec3d3.x, (double)(vec3d3.y + (double)entity2.getEyeHeight()), (double)vec3d3.z);
        Vec3d vec3d5 = vec3d4;
        Entity entity3 = fd03.Field5233.getRenderViewEntity();
        if (entity3 == null) {
            Intrinsics.Method6551();
        }
        GL11.glVertex3d((double)vec3d5.x, (double)(vec3d5.y + (double)entity3.getEyeHeight()), (double)vec3d5.z);
        GlStateManager.glEnd();
        GlStateManager.enableTexture2D();
        float f = (float)vec3d.x + (float)vec3d4.x;
        float f2 = (float)vec3d.y + (float)vec3d4.y;
        Entity entity4 = this.Field5233.getRenderViewEntity();
        if (entity4 == null) {
            Intrinsics.Method6551();
        }
        PyroRenderUtil.Method12315(f, f2 + entity4.getEyeHeight(), (float)vec3d.z + (float)vec3d4.z, this.Field5233.getRenderViewEntity(), 0.1f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double)(-((double)PyroRenderUtil.Method12314(string) / 2.0)), (double)0.0, (double)0.0);
        PyroRenderUtil.Method12313(string, 0.0f, 0.0f, ((f00)this.Field153.Method7979()).Method7515());
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableLighting();
    }

    public fd0() {
        super("compass", "Compass", "Shows cardinal directions in the world");
    }

    @NotNull
    public f0o Method241() {
        return this.Field154;
    }

    @NotNull
    public f0l Method242() {
        return this.Field152;
    }

    public void Method243(@NotNull String string, double d, @NotNull Vec3d vec3d) {
        f00 f002 = (f00)this.Field152.Method7979();
        Vec3d vec3d2 = new Vec3d(0.0, 0.0, 0.0);
        Entity entity = this.Field5233.getRenderViewEntity();
        if (entity == null) {
            Intrinsics.Method6551();
        }
        Vec3d vec3d3 = vec3d2.rotateYaw((float)Math.toRadians(entity.rotationYaw));
        Vec3d vec3d4 = new Vec3d(0.0, -0.8, 0.0);
        Entity entity2 = this.Field5233.getRenderViewEntity();
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        Vec3d vec3d5 = vec3d4.rotateYaw((float)Math.toRadians(entity2.rotationYaw));
        Vec3d vec3d6 = new Vec3d(0.0, -0.8, ((Number)this.Field155.Method7979()).doubleValue()).rotateYaw(-((float)Math.toRadians(d)));
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.glLineWidth((float)2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        GlStateManager.color((float)f002.Method7514(), (float)f002.Method7517(), (float)f002.Method7531(), (float)f002.Method7522());
        GlStateManager.disableLighting();
        GlStateManager.loadIdentity();
        EntityRenderer entityRenderer = this.Field5233.entityRenderer;
        if (entityRenderer == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
        }
        ((EntityRendererAccessor)entityRenderer).Method4464(this.Field5233.getRenderPartialTicks());
        GlStateManager.glBegin((int)1);
        fd0 fd02 = this;
        boolean bl = false;
        boolean bl2 = false;
        fd0 fd03 = fd02;
        boolean bl3 = false;
        Entity entity3 = fd03.Field5233.getRenderViewEntity();
        if (entity3 == null) {
            Intrinsics.Method6551();
        }
        GL11.glVertex3d((double)vec3d5.x, (double)(vec3d5.y + (double)entity3.getEyeHeight()), (double)vec3d5.z);
        Vec3d vec3d7 = vec3d6;
        Entity entity4 = fd03.Field5233.getRenderViewEntity();
        if (entity4 == null) {
            Intrinsics.Method6551();
        }
        GL11.glVertex3d((double)vec3d7.x, (double)(vec3d7.y + (double)entity4.getEyeHeight()), (double)vec3d7.z);
        GlStateManager.glEnd();
        GlStateManager.enableTexture2D();
        float f = (float)vec3d3.x + (float)vec3d.x + (float)vec3d6.x;
        float f2 = (float)vec3d3.y + (float)vec3d.y + (float)vec3d6.y;
        Entity entity5 = this.Field5233.getRenderViewEntity();
        if (entity5 == null) {
            Intrinsics.Method6551();
        }
        PyroRenderUtil.Method12315(f, f2 + entity5.getEyeHeight(), (float)vec3d3.z + (float)vec3d.z + (float)vec3d6.z, this.Field5233.getRenderViewEntity(), 0.1f);
        GlStateManager.disableDepth();
        GlStateManager.translate((double)(-((double)PyroRenderUtil.Method12314(string) / 2.0)), (double)0.0, (double)0.0);
        PyroRenderUtil.Method12313(string, 0.0f, 0.0f, ((f00)this.Field153.Method7979()).Method7515());
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableLighting();
    }

    @NotNull
    public f0l Method239() {
        return this.Field153;
    }
}

