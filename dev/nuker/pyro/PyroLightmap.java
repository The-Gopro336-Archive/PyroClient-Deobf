/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
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

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"},
   d2 = {"Ldev/nuker/pyro/PyroLightmap;", "", "mc", "Lnet/minecraft/client/Minecraft;", "(Lnet/minecraft/client/Minecraft;)V", "lightmapColors", "", "getLightmapColors", "()[I", "lightmapTexture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "getLightmapTexture", "()Lnet/minecraft/client/renderer/texture/DynamicTexture;", "locationLightMap", "Lnet/minecraft/util/ResourceLocation;", "getLocationLightMap", "()Lnet/minecraft/util/ResourceLocation;", "getMc", "()Lnet/minecraft/client/Minecraft;", "enableLightmap", "", "modifyColor", "", "r", "g", "b", "updateLightmap", "partialTicks", "", "Companion", "pyroclient"}
)
public final class PyroLightmap {
   @NotNull
   private final DynamicTexture lightmapTexture;
   @NotNull
   private final int[] lightmapColors;
   @NotNull
   private final ResourceLocation locationLightMap;
   // $FF: renamed from: mc net.minecraft.client.Minecraft
   @NotNull
   private final Minecraft field_79;
   @NotNull
   public static PyroLightmap INSTANCE;
   public static final PyroLightmap$Companion Companion = new PyroLightmap$Companion((DefaultConstructorMarker)null);

   @NotNull
   public final DynamicTexture getLightmapTexture() {
      return this.lightmapTexture;
   }

   @NotNull
   public final int[] getLightmapColors() {
      return this.lightmapColors;
   }

   @NotNull
   public final ResourceLocation getLocationLightMap() {
      return this.locationLightMap;
   }

   public final void updateLightmap(float partialTicks) {
      this.field_79.mcProfiler.startSection("lightTex");
      World world = (World)this.field_79.world;
      if (world != null) {
         float f = world.getSunBrightness(1.0F);
         float f1 = f * 0.95F + 0.05F;
         int i = 0;
         short var6 = 256;

         while(true) {
            if (i >= var6) {
               this.lightmapTexture.updateDynamicTexture();
               this.field_79.mcProfiler.endSection();
               break;
            }

            WorldProvider var10000 = world.provider;
            Intrinsics.checkExpressionValueIsNotNull(var10000, "world.provider");
            float f2 = var10000.getLightBrightnessTable()[i / 16] * f1;
            var10000 = world.provider;
            Intrinsics.checkExpressionValueIsNotNull(var10000, "world.provider");
            float var26 = var10000.getLightBrightnessTable()[i % 16];
            EntityRenderer var10001 = Minecraft.getMinecraft().entityRenderer;
            if (var10001 == null) {
               throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
            }

            float f3 = var26 * (((EntityRendererAccessor)var10001).getTorchFlickerX() * 0.1F + 1.5F);
            if (world.getLastLightningBolt() > 0) {
               var10000 = world.provider;
               Intrinsics.checkExpressionValueIsNotNull(var10000, "world.provider");
               f2 = var10000.getLightBrightnessTable()[i / 16];
            }

            float f4 = f2 * (f * 0.65F + 0.35F);
            float f5 = f2 * (f * 0.65F + 0.35F);
            float f6 = f3 * ((f3 * 0.6F + 0.4F) * 0.6F + 0.4F);
            float f7 = f3 * (f3 * f3 * 0.6F + 0.4F);
            float f8 = f4 + f3;
            float f9 = f5 + f6;
            float f10 = f2 + f7;
            f8 = f8 * 0.96F + 0.03F;
            f9 = f9 * 0.96F + 0.03F;
            f10 = f10 * 0.96F + 0.03F;
            EntityRenderer var27;
            if (!(Boolean)PyroStatic.field_2507.c.method_3034() || !(Boolean)PyroStatic.field_2507.method_1321().c()) {
               var27 = Minecraft.getMinecraft().entityRenderer;
               if (var27 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
               }

               if (((EntityRendererAccessor)var27).getBossColorModifier() > 0.0F) {
                  var27 = Minecraft.getMinecraft().entityRenderer;
                  if (var27 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                  }

                  var26 = ((EntityRendererAccessor)var27).getBossColorModifierPrev();
                  var10001 = Minecraft.getMinecraft().entityRenderer;
                  if (var10001 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                  }

                  float var28 = ((EntityRendererAccessor)var10001).getBossColorModifier();
                  EntityRenderer var10002 = Minecraft.getMinecraft().entityRenderer;
                  if (var10002 == null) {
                     throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
                  }

                  float f11 = var26 + (var28 - ((EntityRendererAccessor)var10002).getBossColorModifierPrev()) * partialTicks;
                  f8 = f8 * (1.0F - f11) + f8 * 0.7F * f11;
                  f9 = f9 * (1.0F - f11) + f9 * 0.6F * f11;
                  f10 = f10 * (1.0F - f11) + f10 * 0.6F * f11;
               }
            }

            var10000 = world.provider;
            Intrinsics.checkExpressionValueIsNotNull(var10000, "world.provider");
            DimensionType var29 = var10000.getDimensionType();
            Intrinsics.checkExpressionValueIsNotNull(var29, "world.provider.dimensionType");
            if (var29.getId() == 1) {
               f8 = 0.22F + f3 * 0.75F;
               f9 = 0.28F + f6 * 0.75F;
               f10 = 0.25F + f7 * 0.75F;
            }

            float[] colors = new float[]{f8, f9, f10};
            world.provider.getLightmapColors(partialTicks, f, f2, f3, colors);
            f8 = colors[0];
            f9 = colors[1];
            f10 = colors[2];
            f8 = MathHelper.clamp(f8, 0.0F, 1.0F);
            f9 = MathHelper.clamp(f9, 0.0F, 1.0F);
            f10 = MathHelper.clamp(f10, 0.0F, 1.0F);
            float f16;
            float f17;
            if (this.field_79.player.isPotionActive(MobEffects.NIGHT_VISION)) {
               var27 = Minecraft.getMinecraft().entityRenderer;
               if (var27 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type dev.nuker.pyro.mixin.EntityRendererAccessor");
               }

               f16 = ((EntityRendererAccessor)var27).invokeGetNightVisionBrightness((EntityLivingBase)this.field_79.player, partialTicks);
               f17 = 1.0F / f8;
               if (f17 > 1.0F / f9) {
                  f17 = 1.0F / f9;
               }

               if (f17 > 1.0F / f10) {
                  f17 = 1.0F / f10;
               }

               f8 = f8 * (1.0F - f16) + f8 * f17 * f16;
               f9 = f9 * (1.0F - f16) + f9 * f17 * f16;
               f10 = f10 * (1.0F - f16) + f10 * f17 * f16;
            }

            if (f8 > 1.0F) {
               f8 = 1.0F;
            }

            if (f9 > 1.0F) {
               f9 = 1.0F;
            }

            if (f10 > 1.0F) {
               f10 = 1.0F;
            }

            f16 = this.field_79.gameSettings.gammaSetting;
            f17 = 1.0F - f8;
            float f13 = 1.0F - f9;
            float f14 = 1.0F - f10;
            f17 = 1.0F - f17 * f17 * f17 * f17;
            f13 = 1.0F - f13 * f13 * f13 * f13;
            f14 = 1.0F - f14 * f14 * f14 * f14;
            f8 = f8 * (1.0F - f16) + f17 * f16;
            f9 = f9 * (1.0F - f16) + f13 * f16;
            f10 = f10 * (1.0F - f16) + f14 * f16;
            f8 = f8 * 0.96F + 0.03F;
            f9 = f9 * 0.96F + 0.03F;
            f10 = f10 * 0.96F + 0.03F;
            if (f8 > 1.0F) {
               f8 = 1.0F;
            }

            if (f9 > 1.0F) {
               f9 = 1.0F;
            }

            if (f10 > 1.0F) {
               f10 = 1.0F;
            }

            if (f8 < 0.0F) {
               f8 = 0.0F;
            }

            if (f9 < 0.0F) {
               f9 = 0.0F;
            }

            if (f10 < 0.0F) {
               f10 = 0.0F;
            }

            int j = true;
            int k = (int)(f8 * 255.0F);
            int l = (int)(f9 * 255.0F);
            int i1 = (int)(f10 * 255.0F);
            this.lightmapColors[i] = this.modifyColor(k, l, i1);
            ++i;
         }
      }

   }

   private final int modifyColor(int r, int g, int b) {
      return (new Color(r, g, b, PyroStatic.field_2488.method_1047())).getRGB();
   }

   public final void enableLightmap() {
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.matrixMode(5890);
      GlStateManager.loadIdentity();
      float f = 0.00390625F;
      GlStateManager.scale(0.00390625F, 0.00390625F, 0.00390625F);
      GlStateManager.translate(8.0F, 8.0F, 8.0F);
      GlStateManager.matrixMode(5888);
      this.field_79.getTextureManager().bindTexture(this.locationLightMap);
      GlStateManager.glTexParameteri(3553, 10241, 9729);
      GlStateManager.glTexParameteri(3553, 10240, 9729);
      GlStateManager.glTexParameteri(3553, 10242, 10496);
      GlStateManager.glTexParameteri(3553, 10243, 10496);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   @NotNull
   public final Minecraft getMc() {
      return this.field_79;
   }

   public PyroLightmap(@NotNull Minecraft mc) {
      Intrinsics.checkParameterIsNotNull(mc, "mc");
      super();
      this.field_79 = mc;
      this.lightmapTexture = new DynamicTexture(16, 16);
      int[] var10001 = this.lightmapTexture.getTextureData();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "this.lightmapTexture.textureData");
      this.lightmapColors = var10001;
      ResourceLocation var2 = this.field_79.getTextureManager().getDynamicTextureLocation("pyroBlockLightMap", this.lightmapTexture);
      Intrinsics.checkExpressionValueIsNotNull(var2, "mc.textureManager.getDyn…p\", this.lightmapTexture)");
      this.locationLightMap = var2;
   }

   // $FF: synthetic method
   public static final PyroLightmap access$getINSTANCE$cp() {
      return INSTANCE;
   }

   // $FF: synthetic method
   public static final void access$setINSTANCE$cp(PyroLightmap var0) {
      INSTANCE = var0;
   }
}
