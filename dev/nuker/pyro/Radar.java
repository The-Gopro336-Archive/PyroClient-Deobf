/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.IntegerSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.Rotation;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f0w;
import dev.nuker.pyro.fbv;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import dev.nuker.pyro.mixin.RenderManagerAccessor;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Radar
extends Module {
    public BooleanSetting Field1007 = new BooleanSetting("players", "Players", null, true);
    public BooleanSetting Field1008 = new BooleanSetting("friends", "Friends", null, true);
    public BooleanSetting Field1009 = new BooleanSetting("bosses", "Bosses", null, true);
    public BooleanSetting Field1010 = new BooleanSetting("hostiles", "Hostiles", null, true);
    public BooleanSetting Field1011 = new BooleanSetting("passives", "Passives", null, true);
    public BooleanSetting Field1012 = new BooleanSetting("items", "Items", null, false);
    public BooleanSetting Field1013 = new BooleanSetting("other", "Other", null, false);
    public f0t Field1014;
    public f0t Field1015;
    public f0t Field1016;
    public f0t Field1017;
    public f0t Field1018;
    public f0t Field1019;
    public f0t Field1020;
    public DoubleSetting Field1021;
    public DoubleSetting Field1022;
    public DoubleSetting Field1023;
    public BooleanSetting Field1024;
    public IntegerSetting Field1025;
    public BooleanSetting Field1026;
    public static fbv Field1027 = new fbv(null);

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        block14: {
            if (this.Field5233.player == null) break block14;
            Entity entity = this.Field5233.getRenderViewEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
            Entity entity2 = this.Field5233.getRenderViewEntity();
            if (entity2 == null) {
                Intrinsics.Method6551();
            }
            Entity entity3 = this.Field5233.getRenderViewEntity();
            if (entity3 == null) {
                Intrinsics.Method6551();
            }
            PyroRenderUtil.Field7388.setPosition(entity.posX, entity2.posY, entity3.posZ);
            GlStateManager.pushMatrix();
            WorldClient worldClient = this.Field5233.world;
            if (worldClient == null) {
                Intrinsics.Method6551();
            }
            for (Entity entity4 : worldClient.loadedEntityList) {
                block16: {
                    block15: {
                        if (entity4 == this.Field5233.getRenderViewEntity()) continue;
                        if (((Boolean)this.Field1024.Method7979()).booleanValue()) {
                            if (PyroRenderUtil.Field7388.isBoundingBoxInFrustum(entity4.getEntityBoundingBox())) continue;
                        }
                        if (entity4 instanceof EntityPlayer) {
                            if (((Boolean)this.Field1008.Method7979()).booleanValue() && FriendManager.Field2145.Method8960((EntityPlayer)entity4)) {
                                this.Method1715(entity4, vec3d, this.Field1015);
                                continue;
                            }
                            if (!((Boolean)this.Field1007.Method7979()).booleanValue()) continue;
                            this.Method1715(entity4, vec3d, this.Field1014);
                            continue;
                        }
                        if (entity4 instanceof EntityDragon) break block15;
                        if (!(entity4 instanceof EntityWither)) break block16;
                    }
                    if (!((Boolean)this.Field1009.Method7979()).booleanValue()) continue;
                    this.Method1715(entity4, vec3d, this.Field1016);
                    continue;
                }
                if (Field1027.Method288(entity4)) {
                    if (!((Boolean)this.Field1011.Method7979()).booleanValue()) continue;
                    this.Method1715(entity4, vec3d, this.Field1018);
                    continue;
                }
                if (entity4.isCreatureType(EnumCreatureType.MONSTER, false)) {
                    if (!((Boolean)this.Field1010.Method7979()).booleanValue()) continue;
                    this.Method1715(entity4, vec3d, this.Field1017);
                    continue;
                }
                if (entity4 instanceof EntityItem) {
                    if (!((Boolean)this.Field1012.Method7979()).booleanValue()) continue;
                    this.Method1715(entity4, vec3d, this.Field1019);
                    continue;
                }
                if (!((Boolean)this.Field1013.Method7979()).booleanValue()) continue;
                this.Method1715(entity4, vec3d, this.Field1020);
            }
            GlStateManager.popMatrix();
        }
    }

    @NotNull
    public Rotation Method1713(@NotNull Vec3d vec3d, @NotNull Vec3d vec3d2) {
        double d = vec3d2.x - vec3d.x;
        double d2 = vec3d2.y - vec3d.y;
        double d3 = vec3d2.z - vec3d.z;
        double d4 = MathHelper.sqrt((double)(d * d + d3 * d3));
        return new Rotation(MathHelper.wrapDegrees((float)((float)Math.toDegrees(MathHelper.atan2((double)d3, (double)d)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(MathHelper.atan2((double)d2, (double)d4))))));
    }

    @NotNull
    public Vec3d Method260(@NotNull Entity entity) {
        RenderManager renderManager = this.Field5233.getRenderManager();
        if (renderManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
        }
        double d = this.Method259(entity.posX, entity.lastTickPosX) - ((RenderManagerAccessor)renderManager).Method2421();
        RenderManager renderManager2 = this.Field5233.getRenderManager();
        if (renderManager2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
        }
        double d2 = this.Method259(entity.posY, entity.lastTickPosY) - ((RenderManagerAccessor)renderManager2).Method2422();
        RenderManager renderManager3 = this.Field5233.getRenderManager();
        if (renderManager3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderManagerAccessor");
        }
        double d3 = this.Method259(entity.posZ, entity.lastTickPosZ) - ((RenderManagerAccessor)renderManager3).Method2423();
        return new Vec3d(d, d2, d3);
    }

    public void Method1714(float f, float f2, float f3, float f4) {
        GlStateManager.glBegin((int)6);
        GlStateManager.glVertex3f((float)f, (float)f2, (float)f3);
        GlStateManager.glVertex3f((float)(f + 0.1f * f4), (float)f2, (float)(f3 - 0.2f * f4));
        GlStateManager.glVertex3f((float)f, (float)f2, (float)(f3 - 0.12f * f4));
        GlStateManager.glVertex3f((float)(f - 0.1f * f4), (float)f2, (float)(f3 - 0.2f * f4));
        GlStateManager.glEnd();
    }

    public void Method1715(Entity entity, Vec3d vec3d, f0t f0t2) {
        f00 f002;
        if (this.Field5233.entityRenderer == null) {
            return;
        }
        f0w f0w2 = this.Method7258(f0t2.Method7977() + ".far_color");
        if (f0w2 == null) {
            Intrinsics.Method6551();
        }
        f00 f003 = (f00)((f0l)f0w2).Method7979();
        f0w f0w3 = this.Method7258(f0t2.Method7977() + ".flat_color");
        if (f0w3 == null) {
            Intrinsics.Method6551();
        }
        if (((Boolean)((BooleanSetting)f0w3).Method7979()).booleanValue()) {
            f002 = f003;
        } else {
            f0w f0w4 = this.Method7258(f0t2.Method7977() + ".near_color");
            if (f0w4 == null) {
                Intrinsics.Method6551();
            }
            f002 = (f00)((f0l)f0w4).Method7979();
        }
        f00 f004 = f002;
        Rotation rotation = this.Method1713(Vec3d.ZERO, this.Method260(entity));
        float f = rotation.Method6938();
        float f2 = rotation.Method6933();
        float f3 = (float)180 - f;
        Entity entity2 = this.Field5233.getRenderViewEntity();
        if (entity2 == null) {
            Intrinsics.Method6551();
        }
        f = f3 + entity2.rotationYaw;
        rotation = new Vec3d(0.0, 0.0, 1.0).rotateYaw((float)Math.toRadians(f)).rotatePitch((float)Math.toRadians(180.0));
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        float f4 = (float)((double)entity.getDistance(this.Field5233.getRenderViewEntity()) / ((Number)this.Field1023.Method7979()).doubleValue());
        GlStateManager.color((float)(f003.Method7514() * f4 + f004.Method7514() * (1.0f - f4)), (float)(f003.Method7517() * f4 + f004.Method7517() * (1.0f - f4)), (float)(f003.Method7531() * f4 + f004.Method7531() * (1.0f - f4)), (float)(f003.Method7522() * f4 + f004.Method7522() * (1.0f - f4)));
        GlStateManager.disableLighting();
        GlStateManager.loadIdentity();
        EntityRenderer entityRenderer = this.Field5233.entityRenderer;
        if (entityRenderer == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
        }
        ((EntityRendererAccessor)entityRenderer).Method4464(this.Field5233.getRenderPartialTicks());
        float f5 = (float)((Number)this.Field1021.Method7979()).doubleValue() * 0.2f;
        float f6 = (float)((Number)this.Field1022.Method7979()).doubleValue() * 0.2f;
        Entity entity3 = this.Field5233.getRenderViewEntity();
        if (entity3 == null) {
            Intrinsics.Method6551();
        }
        GlStateManager.translate((float)0.0f, (float)entity3.getEyeHeight(), (float)0.0f);
        Entity entity4 = this.Field5233.getRenderViewEntity();
        if (entity4 == null) {
            Intrinsics.Method6551();
        }
        GlStateManager.rotate((float)(-entity4.rotationYaw), (float)0.0f, (float)1.0f, (float)0.0f);
        Entity entity5 = this.Field5233.getRenderViewEntity();
        if (entity5 == null) {
            Intrinsics.Method6551();
        }
        GlStateManager.rotate((float)entity5.rotationPitch, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)1.0f);
        float f7 = ((Number)this.Field1025.Method7979()).intValue();
        if (((Boolean)this.Field1026.Method7979()).booleanValue()) {
            float f8 = 90;
            Entity entity6 = this.Field5233.getRenderViewEntity();
            if (entity6 == null) {
                Intrinsics.Method6551();
            }
            if (f8 - entity6.rotationPitch < f7) {
                float f9 = 90;
                Entity entity7 = this.Field5233.getRenderViewEntity();
                if (entity7 == null) {
                    Intrinsics.Method6551();
                }
                f7 = f9 - entity7.rotationPitch;
            }
        }
        GlStateManager.rotate((float)f7, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.rotate((float)f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)f6);
        f0w f0w5 = this.Method7258(f0t2.Method7977() + ".scale");
        if (f0w5 == null) {
            Intrinsics.Method6551();
        }
        float f64 = (float)((Number)((DoubleSetting)f0w5).Method7979()).doubleValue() * (f5 * 2.0f);
        this.Method1714((float)((Vec3d)rotation).x, (float)((Vec3d)rotation).y, (float)((Vec3d)rotation).z, f64);
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableDepth();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableLighting();
    }

    public double Method259(double d, double d2) {
        return d2 + (d - d2) * (double)this.Field5233.getRenderPartialTicks();
    }

    public Radar() {
        super("radar", "Radar", "See nearby entities");
        f0w[] arrf0w = fbv.Method289(Field1027, new f00(0.43f, 1.0f, 1.0f, 1.0f), new f00(0.8f, 1.0f, 1.0f, 1.0f), 0.75);
        this.Field1014 = (f0t)this.Method7264(new f0t(this.Field1007, Arrays.copyOf(arrf0w, arrf0w.length)));
        f0w[] arrf0w2 = fbv.Method289(Field1027, new f00(0.51f, 1.0f, 1.0f, 1.0f), new f00(0.62f, 1.0f, 1.0f, 1.0f), 0.75);
        this.Field1015 = (f0t)this.Method7264(new f0t(this.Field1008, Arrays.copyOf(arrf0w2, arrf0w2.length)));
        f0w[] arrf0w3 = fbv.Method289(Field1027, new f00(0.0f, 1.0f, 0.56f, 0.56f), new f00(0, 1, 1, 1), 0.75);
        this.Field1016 = (f0t)this.Method7264(new f0t(this.Field1009, Arrays.copyOf(arrf0w3, arrf0w3.length)));
        f0w[] arrf0w4 = fbv.Method289(Field1027, new f00(0.16f, 1.0f, 1.0f, 0.17f), new f00(0.08f, 1.0f, 1.0f, 0.88f), 0.5);
        this.Field1017 = (f0t)this.Method7264(new f0t(this.Field1010, Arrays.copyOf(arrf0w4, arrf0w4.length)));
        f0w[] arrf0w5 = fbv.Method289(Field1027, new f00(0.33f, 0.55f, 1.0f, 0.1f), new f00(0.33f, 0.6f, 1.0f, 0.44f), 0.5);
        this.Field1018 = (f0t)this.Method7264(new f0t(this.Field1011, Arrays.copyOf(arrf0w5, arrf0w5.length)));
        f0w[] arrf0w6 = fbv.Method289(Field1027, new f00(0.5f, 1.0f, 1.0f, 0.3f), new f00(0.5f, 1.0f, 1.0f, 1.0f), 0.3);
        this.Field1019 = (f0t)this.Method7264(new f0t(this.Field1012, Arrays.copyOf(arrf0w6, arrf0w6.length)));
        f0w[] arrf0w7 = fbv.Method289(Field1027, new f00(0.6f, 1.0f, 1.0f, 0.17f), new f00(0.6f, 1.0f, 1.0f, 1.0f), 0.5);
        this.Field1020 = (f0t)this.Method7264(new f0t(this.Field1013, Arrays.copyOf(arrf0w7, arrf0w7.length)));
        this.Field1021 = (DoubleSetting)this.Method7264(new DoubleSetting("scale", "Scale", null, 1.0, 0.0, 10.0, 0.0, 64, null));
        this.Field1022 = (DoubleSetting)this.Method7264(new DoubleSetting("distance", "Distance", null, 1.0, 0.0, 10.0, 0.0, 64, null));
        this.Field1023 = (DoubleSetting)this.Method7264(new DoubleSetting("change_radius", "Color Change Radius", null, 75.0, 0.0, 1000.0, 0.0, 64, null));
        this.Field1024 = (BooleanSetting)this.Method7264(new BooleanSetting("hide_frustrum", "Hide In Frustrum", "Hide entities you can see", false));
        this.Field1025 = (IntegerSetting)this.Method7264(new IntegerSetting("tilt", "Tilt", null, 50, -90, 90, 0, 64, null));
        this.Field1026 = (BooleanSetting)this.Method7264(new BooleanSetting("unlockTilt", "Unlock Tilt", "Unlock tilt when you look down", false));
    }
}

