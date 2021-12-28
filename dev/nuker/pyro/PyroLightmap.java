/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.MobEffects
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraft.world.WorldProvider
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import dev.nuker.pyro.PyroLightmap$Companion;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.mixin.EntityRendererAccessor;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 15}, bv={1, 0, 3}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2={"Ldev/nuker/pyro/PyroLightmap;", "", "mc", "Lnet/minecraft/client/Minecraft;", "(Lnet/minecraft/client/Minecraft;)V", "lightmapColors", "", "getLightmapColors", "()[I", "lightmapTexture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "getLightmapTexture", "()Lnet/minecraft/client/renderer/texture/DynamicTexture;", "locationLightMap", "Lnet/minecraft/util/ResourceLocation;", "getLocationLightMap", "()Lnet/minecraft/util/ResourceLocation;", "getMc", "()Lnet/minecraft/client/Minecraft;", "enableLightmap", "", "modifyColor", "", "r", "g", "b", "updateLightmap", "partialTicks", "", "Companion", "pyroclient"})
public final class PyroLightmap {
    @NotNull
    private final DynamicTexture Field16;
    @NotNull
    private final int[] Field17;
    @NotNull
    private final ResourceLocation Field18;
    @NotNull
    private final Minecraft Field19;
    @NotNull
    public static PyroLightmap Field20;
    public static final PyroLightmap$Companion Field21;

    @NotNull
    public final DynamicTexture Method47() {
        return this.Field16;
    }

    @NotNull
    public final int[] Method48() {
        return this.Field17;
    }

    @NotNull
    public final ResourceLocation Method49() {
        return this.Field18;
    }

    /*
     * WARNING - void declaration
     */
    public final void Method50(float partialTicks) {
        this.Field19.mcProfiler.startSection("lightTex");
        World world = (World)this.Field19.world;
        if (world != null) {
            float f = world.getSunBrightness(1.0f);
            float f1 = f * 0.95f + 0.05f;
            int n = 0;
            int n2 = 256;
            while (n < n2) {
                void i;
                WorldProvider worldProvider = world.provider;
                Intrinsics.Method6561((Object)worldProvider, "world.provider");
                float f2 = worldProvider.getLightBrightnessTable()[i / 16] * f1;
                WorldProvider worldProvider2 = world.provider;
                Intrinsics.Method6561((Object)worldProvider2, "world.provider");
                EntityRenderer entityRenderer = Minecraft.getMinecraft().entityRenderer;
                if (entityRenderer == null) {
                    throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                }
                float f3 = worldProvider2.getLightBrightnessTable()[i % 16] * (((EntityRendererAccessor)entityRenderer).Method4468() * 0.1f + 1.5f);
                if (world.getLastLightningBolt() > 0) {
                    WorldProvider worldProvider3 = world.provider;
                    Intrinsics.Method6561((Object)worldProvider3, "world.provider");
                    f2 = worldProvider3.getLightBrightnessTable()[i / 16];
                }
                float f4 = f2 * (f * 0.65f + 0.35f);
                float f5 = f2 * (f * 0.65f + 0.35f);
                float f6 = f3 * ((f3 * 0.6f + 0.4f) * 0.6f + 0.4f);
                float f7 = f3 * (f3 * f3 * 0.6f + 0.4f);
                float f8 = f4 + f3;
                float f9 = f5 + f6;
                float f102 = f2 + f7;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f102 = f102 * 0.96f + 0.03f;
                if (!((Boolean)PyroStatic.Field6443.Field5236.Method5264()).booleanValue() || !((Boolean)PyroStatic.Field6443.Method271().Method7979()).booleanValue()) {
                    EntityRenderer entityRenderer2 = Minecraft.getMinecraft().entityRenderer;
                    if (entityRenderer2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                    }
                    if (((EntityRendererAccessor)entityRenderer2).Method4469() > 0.0f) {
                        EntityRenderer entityRenderer3 = Minecraft.getMinecraft().entityRenderer;
                        if (entityRenderer3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                        }
                        EntityRenderer entityRenderer4 = Minecraft.getMinecraft().entityRenderer;
                        if (entityRenderer4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                        }
                        EntityRenderer entityRenderer5 = Minecraft.getMinecraft().entityRenderer;
                        if (entityRenderer5 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                        }
                        float f112 = ((EntityRendererAccessor)entityRenderer3).Method4470() + (((EntityRendererAccessor)entityRenderer4).Method4469() - ((EntityRendererAccessor)entityRenderer5).Method4470()) * partialTicks;
                        f8 = f8 * (1.0f - f112) + f8 * 0.7f * f112;
                        f9 = f9 * (1.0f - f112) + f9 * 0.6f * f112;
                        f102 = f102 * (1.0f - f112) + f102 * 0.6f * f112;
                    }
                }
                WorldProvider worldProvider4 = world.provider;
                Intrinsics.Method6561((Object)worldProvider4, "world.provider");
                DimensionType dimensionType = worldProvider4.getDimensionType();
                Intrinsics.Method6561((Object)dimensionType, "world.provider.dimensionType");
                if (dimensionType.getId() == 1) {
                    f8 = 0.22f + f3 * 0.75f;
                    f9 = 0.28f + f6 * 0.75f;
                    f102 = 0.25f + f7 * 0.75f;
                }
                float[] colors = new float[]{f8, f9, f102};
                world.provider.getLightmapColors(partialTicks, f, f2, f3, colors);
                f8 = colors[0];
                f9 = colors[1];
                f102 = colors[2];
                f8 = MathHelper.clamp((float)f8, (float)0.0f, (float)1.0f);
                f9 = MathHelper.clamp((float)f9, (float)0.0f, (float)1.0f);
                f102 = MathHelper.clamp((float)f102, (float)0.0f, (float)1.0f);
                if (this.Field19.player.isPotionActive(MobEffects.NIGHT_VISION)) {
                    EntityRenderer entityRenderer6 = Minecraft.getMinecraft().entityRenderer;
                    if (entityRenderer6 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                    }
                    float f152 = ((EntityRendererAccessor)entityRenderer6).Method4471((EntityLivingBase)this.Field19.player, partialTicks);
                    float f122 = 1.0f / f8;
                    if (f122 > 1.0f / f9) {
                        f122 = 1.0f / f9;
                    }
                    if (f122 > 1.0f / f102) {
                        f122 = 1.0f / f102;
                    }
                    f8 = f8 * (1.0f - f152) + f8 * f122 * f152;
                    f9 = f9 * (1.0f - f152) + f9 * f122 * f152;
                    f102 = f102 * (1.0f - f152) + f102 * f122 * f152;
                }
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f102 > 1.0f) {
                    f102 = 1.0f;
                }
                float f162 = this.Field19.gameSettings.gammaSetting;
                float f172 = 1.0f - f8;
                float f132 = 1.0f - f9;
                float f142 = 1.0f - f102;
                f172 = 1.0f - f172 * f172 * f172 * f172;
                f132 = 1.0f - f132 * f132 * f132 * f132;
                f142 = 1.0f - f142 * f142 * f142 * f142;
                f8 = f8 * (1.0f - f162) + f172 * f162;
                f9 = f9 * (1.0f - f162) + f132 * f162;
                f102 = f102 * (1.0f - f162) + f142 * f162;
                f8 = f8 * 0.96f + 0.03f;
                f9 = f9 * 0.96f + 0.03f;
                f102 = f102 * 0.96f + 0.03f;
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (f9 > 1.0f) {
                    f9 = 1.0f;
                }
                if (f102 > 1.0f) {
                    f102 = 1.0f;
                }
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                if (f9 < 0.0f) {
                    f9 = 0.0f;
                }
                if (f102 < 0.0f) {
                    f102 = 0.0f;
                }
                int j = 255;
                int k = (int)(f8 * 255.0f);
                int l = (int)(f9 * 255.0f);
                int i1 = (int)(f102 * 255.0f);
                this.Field17[i] = this.Method51(k, l, i1);
                ++i;
            }
            this.Field16.updateDynamicTexture();
            this.Field19.mcProfiler.endSection();
        }
    }

    private final int Method51(int r, int g, int b) {
        return new Color(r, g, b, PyroStatic.Field6424.Method2614()).getRGB();
    }

    public final void Method52() {
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode((int)5890);
        GlStateManager.loadIdentity();
        float f = 0.00390625f;
        GlStateManager.scale((float)0.00390625f, (float)0.00390625f, (float)0.00390625f);
        GlStateManager.translate((float)8.0f, (float)8.0f, (float)8.0f);
        GlStateManager.matrixMode((int)5888);
        this.Field19.getTextureManager().bindTexture(this.Field18);
        GlStateManager.glTexParameteri((int)3553, (int)10241, (int)9729);
        GlStateManager.glTexParameteri((int)3553, (int)10240, (int)9729);
        GlStateManager.glTexParameteri((int)3553, (int)10242, (int)10496);
        GlStateManager.glTexParameteri((int)3553, (int)10243, (int)10496);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
    }

    @NotNull
    public final Minecraft Method53() {
        return this.Field19;
    }

    public PyroLightmap(@NotNull Minecraft mc) {
        Intrinsics.Method6567((Object)mc, "mc");
        this.Field19 = mc;
        this.Field16 = new DynamicTexture(16, 16);
        int[] arrn = this.Field16.getTextureData();
        Intrinsics.Method6561(arrn, "this.lightmapTexture.textureData");
        this.Field17 = arrn;
        ResourceLocation resourceLocation = this.Field19.getTextureManager().getDynamicTextureLocation("pyroBlockLightMap", this.Field16);
        Intrinsics.Method6561((Object)resourceLocation, "mc.textureManager.getDyn\u2026p\", this.lightmapTexture)");
        this.Field18 = resourceLocation;
    }

    static {
        Field21 = new PyroLightmap$Companion(null);
    }

    public static final /* synthetic */ PyroLightmap Method54() {
        return Field20;
    }

    public static final /* synthetic */ void Method55(PyroLightmap pyroLightmap) {
        Field20 = pyroLightmap;
    }
}

