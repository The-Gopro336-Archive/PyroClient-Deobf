/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderGlobal
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.shader.Shader
 *  net.minecraft.client.shader.ShaderGroup
 *  net.minecraft.client.shader.ShaderUniform
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.boss.EntityDragon
 *  net.minecraft.entity.boss.EntityWither
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.tileentity.TileEntityBed
 *  net.minecraft.tileentity.TileEntityChest
 *  net.minecraft.tileentity.TileEntityEnderChest
 *  net.minecraft.tileentity.TileEntityShulkerBox
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.DoubleSetting;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.PyroRenderUtil;
import dev.nuker.pyro.f00;
import dev.nuker.pyro.f0d;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0l;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f0t;
import dev.nuker.pyro.f4J;
import dev.nuker.pyro.faT;
import dev.nuker.pyro.faU;
import dev.nuker.pyro.faV;
import dev.nuker.pyro.faW;
import dev.nuker.pyro.faX;
import dev.nuker.pyro.faY;
import dev.nuker.pyro.faZ;
import dev.nuker.pyro.fdN;
import dev.nuker.pyro.fdY;
import dev.nuker.pyro.fdZ;
import dev.nuker.pyro.fe2;
import dev.nuker.pyro.fep;
import dev.nuker.pyro.mixin.RenderGlobalAccessor;
import dev.nuker.pyro.mixin.ShaderGroupAccessor;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fbc
extends Module {
    @NotNull
    public f0o<faV> Field2050 = (f0o)this.Method7264(new f0o("mode", "Mode", null, faV.Glow));
    @NotNull
    public BooleanSetting Field2051 = new BooleanSetting("players", "Players", null, true);
    @NotNull
    public BooleanSetting Field2052 = new BooleanSetting("friends", "Friends", null, true);
    @NotNull
    public BooleanSetting Field2053 = new BooleanSetting("bosses", "Bosses", null, true);
    @NotNull
    public BooleanSetting Field2054 = new BooleanSetting("hostiles", "Hostiles", null, true);
    @NotNull
    public BooleanSetting Field2055 = new BooleanSetting("passives", "Passives", null, true);
    @NotNull
    public BooleanSetting Field2056 = new BooleanSetting("tamed", "Tamed", null, true);
    @NotNull
    public BooleanSetting Field2057 = new BooleanSetting("items", "Items", null, false);
    @NotNull
    public BooleanSetting Field2058 = new BooleanSetting("other", "Other", null, false);
    @NotNull
    public BooleanSetting Field2059 = new BooleanSetting("chests", "Chest", null, true);
    @NotNull
    public BooleanSetting Field2060 = new BooleanSetting("shulkers", "Shulker", null, true);
    @NotNull
    public BooleanSetting Field2061 = new BooleanSetting("enderchests", "EnderChest", null, true);
    @NotNull
    public BooleanSetting Field2062 = new BooleanSetting("beds", "Beds", null, true);
    @NotNull
    public BooleanSetting Field2063 = (BooleanSetting)this.Method7264(new BooleanSetting("maxDist", "MaxDist", "Overrides vanilla max tile entity distance, Causes FPS drops", false));
    @NotNull
    public f0t Field2064 = (f0t)this.Method7264(new f0t(this.Field2051, new f0l("color", "Color", null, f00.Field5379.Method7931(255, 255, 255, 255))));
    @NotNull
    public f0t Field2065 = (f0t)this.Method7264(new f0t(this.Field2052, new f0l("color", "Color", null, f00.Field5379.Method7931(5, 255, 240, 255))));
    @NotNull
    public f0t Field2066 = (f0t)this.Method7264(new f0t(this.Field2053, new f0l("color", "Color", null, new f00(0, 1, 1, 1))));
    @NotNull
    public f0t Field2067 = (f0t)this.Method7264(new f0t(this.Field2054, new f0l("color", "Color", null, new f00(0.08f, 1.0f, 1.0f, 1.0f))));
    @NotNull
    public f0t Field2068 = (f0t)this.Method7264(new f0t(this.Field2055, new f0l("color", "Color", null, new f00(0.33f, 0.6f, 1.0f, 1.0f))));
    @NotNull
    public BooleanSetting Field2069 = (BooleanSetting)this.Method7264(new BooleanSetting("entityId", "EntityId", null, false));
    @NotNull
    public f0t Field2070;
    @NotNull
    public f0t Field2071;
    @NotNull
    public BooleanSetting Field2072;
    @NotNull
    public f0t Field2073;
    @NotNull
    public f0t Field2074;
    @NotNull
    public f0t Field2075;
    @NotNull
    public f0t Field2076;
    @NotNull
    public f0t Field2077;
    @NotNull
    public DoubleSetting Field2078;
    public boolean Field2079;

    @NotNull
    public f0t Method2708() {
        return this.Field2067;
    }

    @Nullable
    public f00 Method2709(@NotNull Entity entity) {
        f00 f002;
        f0t f0t2;
        block7: {
            block6: {
                if (this.Field5233.player == null) {
                    return null;
                }
                if (Intrinsics.Method6572((Object)entity, (Object)this.Field5233.player)) break block6;
                if (!this.Field5233.player.isRiding()) break block7;
                if (!Intrinsics.Method6572((Object)entity, (Object)this.Field5233.player.getRidingEntity())) break block7;
            }
            return null;
        }
        if ((f0t2 = this.Method2733(entity)) != null) {
            f0l f0l2 = (f0l)this.Method7258(f0t2.Method7977() + ".color");
            f002 = f0l2 != null ? (f00)f0l2.Method7979() : null;
        } else {
            f002 = null;
        }
        return f002;
    }

    @NotNull
    public f0o Method2544() {
        return this.Field2050;
    }

    @NotNull
    public f0t Method2710() {
        return this.Field2070;
    }

    @NotNull
    public f0t Method2711() {
        return this.Field2068;
    }

    @NotNull
    public BooleanSetting Method276() {
        return this.Field2056;
    }

    @NotNull
    public BooleanSetting Method283() {
        return this.Field2059;
    }

    @NotNull
    public BooleanSetting Method280() {
        return this.Field2063;
    }

    @NotNull
    public BooleanSetting Method273() {
        return this.Field2057;
    }

    @NotNull
    public BooleanSetting Method282() {
        return this.Field2069;
    }

    @NotNull
    public BooleanSetting Method274() {
        return this.Field2055;
    }

    @NotNull
    public BooleanSetting Method2712() {
        return this.Field2058;
    }

    @NotNull
    public f0t Method2713() {
        return this.Field2073;
    }

    @NotNull
    public BooleanSetting Method2714() {
        return this.Field2072;
    }

    @Override
    public void Method195(@Nullable Vec3d vec3d, float f) {
        Entity entity;
        this.Field2079 = false;
        boolean bl = this.Field5233.gameSettings.fancyGraphics;
        float f2 = this.Field5233.gameSettings.gammaSetting;
        this.Field5233.gameSettings.fancyGraphics = false;
        this.Field5233.gameSettings.gammaSetting = 100.0f;
        fe2.Method462();
        if (fdZ.Field313.getRenderViewEntity() == null) {
            entity = (Entity)fdZ.Field313.player;
        } else {
            entity = fdZ.Field313.getRenderViewEntity();
            if (entity == null) {
                Intrinsics.Method6551();
            }
        }
        Entity entity2 = entity;
        double d = entity2.lastTickPosX + (entity2.posX - entity2.lastTickPosX) * (double)f;
        double d2 = entity2.lastTickPosY + (entity2.posY - entity2.lastTickPosY) * (double)f;
        double d3 = entity2.lastTickPosZ + (entity2.posZ - entity2.lastTickPosZ) * (double)f;
        PyroRenderUtil.Field7388.setPosition(d, d2, d3);
        if ((faV)((Object)this.Field2050.Method7979()) == faV.Model) {
            fep.Method456();
            fep.Method737(f);
            fep.Method461();
            fep.Method737(f);
            fep.Method462();
            fep.Method865();
            fep.Method737(f);
            fep.Method455();
        }
        if (((Boolean)this.Field2072.Method7979()).booleanValue()) {
            RenderHelper.enableStandardItemLighting();
            fep.Method456();
            fep.Method458(f);
            fep.Method461();
            fep.Method458(f);
            fep.Method462();
            fep.Method865();
            fep.Method458(f);
            fep.Method455();
            RenderHelper.disableStandardItemLighting();
        }
        this.Field5233.gameSettings.gammaSetting = f2;
        this.Field5233.gameSettings.fancyGraphics = bl;
        fep.Method457(new Color(255, 255, 255, 255));
        this.Field2079 = true;
        if (!((Boolean)this.Field2056.Method7979()).booleanValue()) {
            return;
        }
        List list = new ArrayList();
        this.Field5233.world.loadedEntityList.stream().filter(faX.Field1734).forEach(new faY(this, list));
        CollectionsKt.Method9276(list, new faZ(this));
        for (Entity entity3 : list) {
            Entity entity4;
            UUID uUID = null;
            if (entity3 instanceof EntityWolf) {
                entity4 = entity3;
                if (!((EntityWolf)entity4).isTamed()) continue;
                uUID = ((EntityWolf)entity4).getOwnerId();
            } else if (entity3 instanceof AbstractHorse) {
                entity4 = entity3;
                if (!((AbstractHorse)entity4).isTame()) continue;
                uUID = ((AbstractHorse)entity4).getOwnerUniqueId();
            }
            entity4 = this.Field5233.getRenderViewEntity();
            Vec3d vec3d2 = fdY.Method364(entity3, f);
            double d4 = vec3d2.x;
            double d5 = vec3d2.y + 0.65;
            double d6 = vec3d2.z;
            double d7 = d5 - 0.58;
            vec3d2 = fdY.Method364(entity4, f);
            Entity entity5 = entity4;
            if (entity5 == null) {
                Intrinsics.Method6551();
            }
            double d8 = entity5.posX;
            double d9 = entity4.posY;
            double d10 = entity4.posZ;
            entity4.posX = vec3d2.x;
            entity4.posY = vec3d2.y;
            entity4.posZ = vec3d2.z;
            d5 = entity4.getDistance(d4, d5, d6);
            double d11 = 0.04;
            if (d5 > 0.0) {
                d11 = 0.02 + (double)0.003f * d5;
            }
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
            GlStateManager.disableLighting();
            GlStateManager.translate((float)((float)d4), (float)((float)d7 + 1.4f), (float)((float)d6));
            float f3 = -this.Field5233.getRenderManager().playerViewY;
            float f4 = 1.0f;
            float f5 = 0.0f;
            GlStateManager.rotate((float)f3, (float)f5, (float)f4, (float)f5);
            GlStateManager.rotate((float)this.Field5233.getRenderManager().playerViewX, (float)(this.Field5233.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
            GlStateManager.scale((double)(-d11), (double)(-d11), (double)d11);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            String string = this.Method2724(entity3, uUID);
            if (((Boolean)this.Field2069.Method7979()).booleanValue()) {
                string = string + " " + entity3.getEntityId();
            }
            float f6 = PyroRenderUtil.Method12314(string) / (float)2;
            float f7 = PyroRenderUtil.Method740();
            float f8 = 0.0f;
            float f9 = f6 + (float)2;
            PyroRenderUtil.Method5741(string, -f6 + 1.0f, -f8 - f7 + (float)3, -1);
            GlStateManager.enableDepth();
            GlStateManager.disableBlend();
            GlStateManager.disablePolygonOffset();
            GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
            GlStateManager.popMatrix();
            entity4.posX = d8;
            entity4.posY = d9;
            entity4.posZ = d10;
        }
    }

    public boolean Method2715() {
        return this.Field2079;
    }

    @f0g
    @LauncherEventHide
    public void Method187(@NotNull f4J f4J2) {
    }

    @Override
    public void Method205(boolean bl, @Nullable EntityPlayerSP entityPlayerSP, @Nullable World world) {
        super.Method205(bl, entityPlayerSP, world);
        this.Method2731();
    }

    @NotNull
    public DoubleSetting Method227() {
        return this.Field2078;
    }

    @NotNull
    public f0t Method2716() {
        return this.Field2075;
    }

    public fbc() {
        super("esp", "ESP", "Outlines entities");
        this.Method7264(new f0t(this.Field2056, this.Field2069));
        this.Field2070 = (f0t)this.Method7264(new f0t(this.Field2057, new f0l("color", "Color", null, new f00(0.5f, 1.0f, 1.0f, 1.0f))));
        this.Field2071 = (f0t)this.Method7264(new f0t(this.Field2058, new f0l("color", "Color", null, new f00(0.6f, 1.0f, 1.0f, 1.0f))));
        this.Field2072 = new BooleanSetting("storages", "Storages", null, true);
        this.Field2073 = new f0t(this.Field2059, new f0l("color", "Color", null, f00.Field5379.Method7931(255, 252, 99, 255)));
        this.Field2074 = new f0t(this.Field2060, new f0l("color", "Color", null, f00.Field5379.Method7931(255, 0, 151, 255)));
        this.Field2075 = new f0t(this.Field2061, new f0l("color", "Color", null, f00.Field5379.Method7931(166, 0, 238, 255)));
        this.Field2076 = new f0t(this.Field2062, new f0l("color", "Color", null, f00.Field5379.Method7931(255, 255, 255, 255)));
        this.Field2077 = (f0t)this.Method7264(new f0t(this.Field2072, this.Field2073, this.Field2074, this.Field2075, this.Field2076));
        this.Field2078 = (DoubleSetting)this.Method7264(new DoubleSetting("width", "Width", "Changes the width of the outline", 3.0, 1.0, 10.0, 0.0, 64, null));
        this.Field2079 = true;
        this.Field2078.Method7980(new faT(this));
        this.Field2050.Method7980((Consumer)new faU(this));
    }

    @NotNull
    public f0t Method2717() {
        return this.Field2071;
    }

    @NotNull
    public f0t Method2718() {
        return this.Field2066;
    }

    @NotNull
    public f0t Method2719() {
        return this.Field2077;
    }

    @NotNull
    public BooleanSetting Method2720() {
        return this.Field2060;
    }

    @NotNull
    public BooleanSetting Method269() {
        return this.Field2062;
    }

    public boolean Method2721(@NotNull TileEntity tileEntity) {
        TileEntity tileEntity2 = tileEntity;
        return tileEntity2 instanceof TileEntityShulkerBox ? (Boolean)this.Field2060.Method7979() : (tileEntity2 instanceof TileEntityChest ? (Boolean)this.Field2059.Method7979() : (tileEntity2 instanceof TileEntityEnderChest ? (Boolean)this.Field2061.Method7979() : (tileEntity2 instanceof TileEntityBed ? (Boolean)this.Field2062.Method7979() : false)));
    }

    public static Minecraft Method2722(fbc fbc2) {
        return fbc2.Field5233;
    }

    @NotNull
    public BooleanSetting Method2723() {
        return this.Field2061;
    }

    @NotNull
    public String Method2724(@NotNull Entity entity, @Nullable UUID uUID) {
        return f0d.Field5595.Method7943(StringsKt.Method9968(String.valueOf(uUID), "-", "", false, 4, null));
    }

    @NotNull
    public f0t Method2725() {
        return this.Field2064;
    }

    @NotNull
    public f0t Method2726() {
        return this.Field2076;
    }

    @NotNull
    public BooleanSetting Method2727() {
        return this.Field2051;
    }

    @NotNull
    public BooleanSetting Method2424() {
        return this.Field2052;
    }

    @NotNull
    public BooleanSetting Method281() {
        return this.Field2054;
    }

    @NotNull
    public f0t Method2728() {
        return this.Field2074;
    }

    @Nullable
    public f00 Method2729(@NotNull TileEntity tileEntity) {
        TileEntity tileEntity2 = tileEntity;
        f0l f0l2 = (f0l)this.Method7258(tileEntity2 instanceof TileEntityShulkerBox ? "storages.shulkers.color" : (tileEntity2 instanceof TileEntityChest ? "storages.chests.color" : (tileEntity2 instanceof TileEntityEnderChest ? "storages.enderchests.color" : (tileEntity2 instanceof TileEntityBed ? "storages.beds.color" : null))));
        return f0l2 != null ? (f00)f0l2.Method7979() : null;
    }

    public static void Method2730(fbc fbc2, Minecraft minecraft) {
        fbc2.Field5233 = minecraft;
    }

    public void Method557(boolean bl) {
        this.Field2079 = bl;
    }

    public void Method2731() {
        if (this.Field5233.renderGlobal == null) {
            return;
        }
        RenderGlobal renderGlobal = this.Field5233.renderGlobal;
        if (renderGlobal == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.RenderGlobalAccessor");
        }
        ShaderGroup shaderGroup = ((RenderGlobalAccessor)renderGlobal).Method12598();
        if (shaderGroup == null) {
            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.ShaderGroupAccessor");
        }
        List list = ((ShaderGroupAccessor)shaderGroup).Method6772();
        ShaderUniform shaderUniform = ((Shader)list.get(1)).getShaderManager().getShaderUniform("Radius");
        if (shaderUniform == null) {
            Intrinsics.Method6551();
        }
        ShaderUniform shaderUniform2 = shaderUniform;
        ShaderUniform shaderUniform3 = ((Shader)list.get(1)).getShaderManager().getShaderUniform("BlurDir");
        if (shaderUniform3 == null) {
            Intrinsics.Method6551();
        }
        ShaderUniform shaderUniform4 = shaderUniform3;
        ShaderUniform shaderUniform5 = ((Shader)list.get(2)).getShaderManager().getShaderUniform("Radius");
        if (shaderUniform5 == null) {
            Intrinsics.Method6551();
        }
        ShaderUniform shaderUniform6 = shaderUniform5;
        ShaderUniform shaderUniform7 = ((Shader)list.get(2)).getShaderManager().getShaderUniform("BlurDir");
        if (shaderUniform7 == null) {
            Intrinsics.Method6551();
        }
        ShaderUniform shaderUniform8 = shaderUniform7;
        if (((Boolean)this.Field5236.Method5264()).booleanValue()) {
            f0o<faV> f0o2 = this.Field2050;
            if (f0o2 == null) {
                Intrinsics.Method6551();
            }
            switch (faW.Field1751[((faV)((Object)f0o2.Method7979())).ordinal()]) {
                case 1: {
                    this.Method7263("Model");
                    shaderUniform2.set(2.0f);
                    shaderUniform6.set(2.0f);
                    shaderUniform4.set(0.0f, 1.0f);
                    shaderUniform8.set(1.0f, 0.0f);
                    break;
                }
                case 2: {
                    this.Method7263("Glow");
                    float f = (float)((Number)this.Field2078.Method7979()).doubleValue() / 2.5f;
                    boolean bl = false;
                    float f2 = (float)Math.floor(f) / 5.0f * 2.5f;
                    shaderUniform2.set(f2);
                    shaderUniform6.set(f2);
                    shaderUniform4.set(0.0f, 1.0f);
                    shaderUniform8.set(1.0f, 0.0f);
                    break;
                }
            }
        } else {
            String string;
            shaderUniform2.set(2.0f);
            shaderUniform6.set(2.0f);
            shaderUniform4.set(0.0f, 1.0f);
            shaderUniform8.set(1.0f, 0.0f);
            f0o<faV> f0o3 = this.Field2050;
            if (f0o3 == null) {
                Intrinsics.Method6551();
            }
            switch (faW.Field1752[((faV)((Object)f0o3.Method7979())).ordinal()]) {
                case 1: {
                    string = "Model";
                    break;
                }
                case 2: {
                    string = "Glow";
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            this.Method7263(string);
        }
    }

    @NotNull
    public BooleanSetting Method275() {
        return this.Field2053;
    }

    @NotNull
    public f0t Method2732() {
        return this.Field2065;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public f0t Method2733(@NotNull Entity entity) {
        block9: {
            block8: {
                if (entity instanceof EntityPlayer) {
                    if (((Boolean)this.Field2052.Method7979()).booleanValue() && FriendManager.Field2145.Method8960((EntityPlayer)entity)) {
                        return this.Field2065;
                    }
                    if (!((Boolean)this.Field2051.Method7979()).booleanValue()) return null;
                    return this.Field2064;
                }
                if (entity instanceof EntityDragon) break block8;
                if (!(entity instanceof EntityWither)) break block9;
            }
            if (!((Boolean)this.Field2053.Method7979()).booleanValue()) return null;
            return this.Field2066;
        }
        if (fdN.Method363(entity)) {
            if (!((Boolean)this.Field2055.Method7979()).booleanValue()) return null;
            return this.Field2068;
        }
        if (entity.isCreatureType(EnumCreatureType.MONSTER, false)) {
            if (!((Boolean)this.Field2054.Method7979()).booleanValue()) return null;
            return this.Field2067;
        }
        if (entity instanceof EntityItem) {
            if (!((Boolean)this.Field2057.Method7979()).booleanValue()) return null;
            return this.Field2070;
        }
        if (!((Boolean)this.Field2058.Method7979()).booleanValue()) return null;
        return this.Field2071;
    }
}

