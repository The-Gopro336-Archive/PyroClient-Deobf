/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.lwjgl.opengl.GL11
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.Waypoint;
import dev.nuker.pyro.WaypointManager;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f4b;
import dev.nuker.pyro.f4d;
import dev.nuker.pyro.f4t;
import dev.nuker.pyro.fbV;
import dev.nuker.pyro.fbW;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

public class fbX
extends Module {
    @NotNull
    public f0o<fbV> Field2035 = (f0o)this.Method7264(new f0o("mode", "Modes", null, fbV.Coords));
    @NotNull
    public DoubleSetting Field2036 = (DoubleSetting)this.Method7264(new DoubleSetting("width", "Width", null, 1.8, 0.1, 5.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field2037 = (BooleanSetting)this.Method7264(new BooleanSetting("lines", "Lines", null, false));
    @NotNull
    public DoubleSetting Field2038 = (DoubleSetting)this.Method7264(new DoubleSetting("scaling", "Scaling", null, 3.0, 1.0, 10.0, 0.0, 64, null));
    @NotNull
    public BooleanSetting Field2039 = (BooleanSetting)this.Method7264(new BooleanSetting("logoutSpots", "LogoutSpots", null, true));
    @NotNull
    public BooleanSetting Field2040 = (BooleanSetting)this.Method7264(new BooleanSetting("deathPoints", "DeathPoints", null, false));
    public boolean Field2041 = true;

    @f0g
    @LauncherEventHide
    public void Method2685(@NotNull f4d f4d2) {
        if (((Boolean)this.Field2039.Method7979()).booleanValue()) {
            Iterator iterator2 = this.Field5233.world.playerEntities.iterator();
            while (iterator2.hasNext()) {
                EntityPlayer entityPlayer = (EntityPlayer)iterator2.next();
                if (!Intrinsics.Method6572(entityPlayer.getName(), f4d2.Method5798())) continue;
                String string = entityPlayer.getName();
                Waypoint waypoint = new Waypoint(string + " logout spot", entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, CollectionsKt.Method9007(entityPlayer.dimension));
                WaypointManager.Field6777.Method9801(waypoint);
                break;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @f0g
    @LauncherEventHide
    public void Method183(@NotNull f4t f4t2) {
        if ((Boolean)this.Field2040.Method7979() == false) return;
        if (this.Field5233.currentScreen instanceof GuiGameOver && this.Field2041) {
            this.Field2041 = false;
            WaypointManager.Field6777.Method9801(new Waypoint("death point", this.Field5233.player.posX, this.Field5233.player.posY, this.Field5233.player.posZ, CollectionsKt.Method9007(this.Field5233.player.dimension)));
            return;
        }
        if (this.Field5233.currentScreen != null) return;
        this.Field2041 = true;
    }

    public void Method2686(Waypoint waypoint, double d, double d2, double d3, float f, double d4, double d5) {
        Entity entity = this.Field5233.getRenderViewEntity();
        if (entity == null) {
            entity = (Entity)this.Field5233.player;
        }
        Entity entity2 = entity;
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        double d6 = entity2.getDistance(d + this.Field5233.getRenderManager().viewerPosX, d2 + this.Field5233.getRenderManager().viewerPosY, d3 + this.Field5233.getRenderManager().viewerPosZ);
        double d7 = 0.0018 + this.Method230() * d6;
        if (d6 <= 8.0) {
            d7 = 0.0245;
        }
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((float)((float)d), (float)((float)d2 + 1.4f), (float)((float)d3));
        float f2 = -this.Field5233.getRenderManager().playerViewY;
        float f3 = 1.0f;
        float f4 = 0.0f;
        GlStateManager.rotate((float)f2, (float)f4, (float)f3, (float)f4);
        GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-d7), (double)(-d7), (double)d7);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        String string = null;
        switch (fbW.Field2030[((fbV)((Object)this.Field2035.Method7979())).ordinal()]) {
            case 1: {
                string = new StringBuilder().insert(0, waypoint.Method9897()).append(" ").append(MathKt.Method9393(d6)).append("m").toString();
                break;
            }
            case 2: {
                string = String.format("%s XYZ %.1f %.1f %.1f", waypoint.Method9897(), d4, waypoint.Method9901(), d5);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        float f5 = PyroRenderUtil.Method12314(string) / (float)2;
        PyroRenderUtil.Method12306(-f5 - 1.0f, -PyroRenderUtil.Method4908(), f5 + 1.0f, 1.0f, 1.8f, 0x55000400, 0x33000000);
        PyroRenderUtil.Method12313(string, -f5, -(PyroRenderUtil.Method4908() - 1.0f), -5592406);
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
    }

    public double Method230() {
        return ((Number)this.Field2038.Method7979()).doubleValue() / (double)1000;
    }

    public fbX() {
        super("waypoints", "Waypoints", "Shows a marker for positions you set");
    }

    @NotNull
    public DoubleSetting Method218() {
        return this.Field2038;
    }

    @f0g
    @LauncherEventHide
    public void Method2687(@NotNull f4b f4b2) {
        if (((Boolean)this.Field2039.Method7979()).booleanValue()) {
            for (Waypoint waypoint : WaypointManager.Field6777.Method9798()) {
                if (!Intrinsics.Method6572(StringsKt.Method9968(waypoint.Method9897(), " logout spot", "", false, 4, null), f4b2.Method5798())) continue;
                WaypointManager.Field6777.Method9800(waypoint);
                String string = f4b2.Method5798();
                Pyro.Field6182.Method8989("Deleting " + string + " logoutspot as they logged back in");
            }
        }
    }

    public void Method557(boolean bl) {
        this.Field2041 = bl;
    }

    public void Method2688(Waypoint waypoint, double d, double d2, double d3, float f, double d4, double d5) {
        Entity entity = this.Field5233.getRenderViewEntity();
        if (entity == null) {
            entity = (Entity)this.Field5233.player;
        }
        Entity entity2 = entity;
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        double d6 = entity2.getDistance(d4, waypoint.Method9901(), d5);
        String string = String.format("%s XYZ %.1f %.1f %.1f", waypoint.Method9897(), d4, waypoint.Method9901(), d5);
        double d7 = this.Method2695(0.0018 + this.Method230() * d6, 0.1, this.Method230() * 100.0);
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((float)((float)d), (float)((float)d2 + 1.4f), (float)((float)d3));
        float f2 = -this.Field5233.getRenderManager().playerViewY;
        float f3 = 1.0f;
        float f4 = 0.0f;
        GlStateManager.rotate((float)f2, (float)f4, (float)f3, (float)f4);
        GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-d7), (double)(-d7), (double)d7);
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        String string2 = new StringBuilder().insert(0, waypoint.Method9897()).append(" ").append(Math.round(d6)).append("m").toString();
        float f5 = PyroRenderUtil.Method12314(string) / (float)2;
        float f6 = -PyroRenderUtil.Method4908();
        float f7 = PyroRenderUtil.Method12314(string2) / (float)2;
        switch (fbW.Field2031[((fbV)((Object)this.Field2035.Method7979())).ordinal()]) {
            case 1: {
                GlStateManager.enableBlend();
                PyroRenderUtil.Method12306(-f5 - 1.0f, f6, f5 + 1.5f, 1.0f, 1.8f, 0x55000400, 0x33000000);
                GlStateManager.disableBlend();
                PyroRenderUtil.Method12313(string, -f5, -(PyroRenderUtil.Method4908() - 1.0f), -5592406);
                break;
            }
            case 2: {
                GlStateManager.enableBlend();
                PyroRenderUtil.Method12306(-f7 - 1.0f, f6, f7 + 1.5f, 1.0f, 1.8f, 0x55000400, 0x33000000);
                GlStateManager.disableBlend();
                PyroRenderUtil.Method12313(string2, -f7, -(PyroRenderUtil.Method4908() - 1.0f), -5592406);
                break;
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
    }

    @NotNull
    public DoubleSetting Method228() {
        return this.Field2036;
    }

    @NotNull
    public f0o Method2544() {
        return this.Field2035;
    }

    public void Method2373(@NotNull DoubleSetting doubleSetting) {
        this.Field2038 = doubleSetting;
    }

    public boolean Method2689() {
        return this.Field2041;
    }

    @NotNull
    public List Method2690() {
        ArrayList<Waypoint> arrayList = new ArrayList<Waypoint>();
        Iterable iterable = WaypointManager.Field6777.Method9798();
        boolean bl = false;
        for (Object t : iterable) {
            Waypoint waypoint = (Waypoint)t;
            boolean bl2 = false;
            if (StringsKt.Method11503(waypoint.Method9897(), "logout spot", false, 2, null)) {
                if (((Boolean)this.Field2039.Method7979()).booleanValue()) {
                    arrayList.add(waypoint);
                    continue;
                }
            }
            if (StringsKt.Method11503(waypoint.Method9897(), "death point", false, 2, null)) {
                if (((Boolean)this.Field2040.Method7979()).booleanValue()) {
                    arrayList.add(waypoint);
                    continue;
                }
            }
            arrayList.add(waypoint);
        }
        return arrayList;
    }

    public void Method2691(@NotNull BooleanSetting booleanSetting) {
        this.Field2040 = booleanSetting;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field2039;
    }

    public void Method2692(@NotNull BooleanSetting booleanSetting) {
        this.Field2037 = booleanSetting;
    }

    @NotNull
    public BooleanSetting Method270() {
        return this.Field2040;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        super.Method195(vec3d, f);
        Entity entity = this.Field5233.getRenderViewEntity();
        if (entity == null) {
            entity = (Entity)this.Field5233.player;
        }
        Iterable iterable = this.Method2690();
        boolean bl = false;
        for (Object t : iterable) {
            double d;
            Waypoint waypoint = (Waypoint)t;
            boolean bl2 = false;
            double d2 = d = this.Field5233.player.dimension == -1 ? waypoint.Method9899() / 8.0 : waypoint.Method9899();
            double d3 = this.Field5233.player.dimension == -1 ? waypoint.Method9901() / 8.0 : waypoint.Method9901();
            double d4 = this.Field5233.player.dimension == -1 ? waypoint.Method9903() / 8.0 : waypoint.Method9903();
            PyroRenderUtil.Method455();
            GlStateManager.pushMatrix();
            RenderManager renderManager = this.Field5233.getRenderManager();
            if (renderManager == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }
            double d5 = d - ((RenderManagerAccessor)renderManager).Method2421();
            RenderManager renderManager2 = this.Field5233.getRenderManager();
            if (renderManager2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }
            double d6 = d3 - ((RenderManagerAccessor)renderManager2).Method2422();
            RenderManager renderManager3 = this.Field5233.getRenderManager();
            if (renderManager3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
            }
            double d7 = d4 - ((RenderManagerAccessor)renderManager3).Method2423();
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(d5 - 0.25, d6, d7 - 0.25, d5 + 0.25, d6 + 2.0, d7 + 0.25);
            GlStateManager.color((float)1.0f, (float)0.0f, (float)0.0f, (float)0.7f);
            GL11.glLoadIdentity();
            GL11.glLineWidth((float)((float)((Number)this.Field2036.Method7979()).doubleValue()));
            EntityRenderer entityRenderer = this.Field5233.entityRenderer;
            if (entityRenderer == null) {
                throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
            }
            ((EntityRendererAccessor)entityRenderer).Method4472(f, 0);
            if (((Boolean)this.Field2037.Method7979()).booleanValue()) {
                double d8 = 0.0;
                Vec3d vec3d2 = new Vec3d(d8, d8, 1.0);
                Entity entity2 = entity;
                if (entity2 == null) {
                    Intrinsics.Method6551();
                }
                Vec3d vec3d3 = vec3d2.rotatePitch((float)(-Math.toRadians(entity2.rotationPitch)));
                Entity entity3 = entity;
                if (entity3 == null) {
                    Intrinsics.Method6551();
                }
                Vec3d vec3d4 = vec3d3.rotateYaw((float)(-Math.toRadians(entity3.rotationYaw)));
                Entity entity4 = entity;
                if (entity4 == null) {
                    Intrinsics.Method6551();
                }
                GL11.glVertex3d((double)vec3d4.x, (double)((double)entity4.getEyeHeight() + vec3d4.y), (double)vec3d4.z);
                GL11.glVertex3d((double)d5, (double)d6, (double)d7);
                GL11.glEnd();
            }
            GL11.glTranslated((double)d5, (double)d6, (double)d7);
            GL11.glTranslated((double)(-d5), (double)(-d6), (double)(-d7));
            PyroRenderUtil.Method12309(axisAlignedBB);
            GlStateManager.popMatrix();
            PyroRenderUtil.Method456();
            GlStateManager.pushMatrix();
            Vec3d vec3d5 = this.Method2694(d, d3, d4);
            if (vec3d5 != null) {
                if (this.Field5233.player.getDistance(d, d3, d4) > 150.0) {
                    RenderManager renderManager4 = this.Field5233.getRenderManager();
                    if (renderManager4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
                    }
                    RenderManager renderManager5 = this.Field5233.getRenderManager();
                    if (renderManager5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
                    }
                    RenderManager renderManager6 = this.Field5233.getRenderManager();
                    if (renderManager6 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
                    }
                    this.Method2688(waypoint, vec3d5.x - ((RenderManagerAccessor)renderManager4).Method2421(), vec3d5.y - ((RenderManagerAccessor)renderManager5).Method2422() + 0.7, vec3d5.z - ((RenderManagerAccessor)renderManager6).Method2423(), f, d, d4);
                } else {
                    this.Method2686(waypoint, d5, d6 + 0.7, d7, f, d, d4);
                }
            }
            GlStateManager.popMatrix();
        }
    }

    public void Method2693(@NotNull BooleanSetting booleanSetting) {
        this.Field2039 = booleanSetting;
    }

    public Vec3d Method2694(double d, double d2, double d3) {
        double d4 = d;
        double d5 = d2;
        double d6 = d3;
        Entity entity = this.Field5233.getRenderViewEntity();
        if (entity == null) {
            entity = (Entity)this.Field5233.player;
        }
        Entity entity2 = entity;
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        Vec3d vec3d = new Vec3d(entity2.posX, entity.posY, entity.posZ);
        double d7 = entity.getDistance(d4, d5, d6);
        d4 = vec3d.x - 150.0 * (vec3d.x - d4) / d7;
        d5 = vec3d.y - 150.0 * (vec3d.y - d5) / d7;
        d6 = vec3d.z - 150.0 * (vec3d.z - d6) / d7;
        return new Vec3d(d4, d5, d6);
    }

    public double Method2695(double d, double d2, double d3) {
        return RangesKt.Method4261(d2, RangesKt.Method4268(d3, d));
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field2037;
    }

    public void Method2371(@NotNull DoubleSetting doubleSetting) {
        this.Field2036 = doubleSetting;
    }
}

