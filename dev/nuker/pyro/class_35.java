/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.mixin.EntityRendererAccessor;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// $FF: renamed from: dev.nuker.pyro.fb
public class class_35 {
   // $FF: renamed from: c (java.lang.String) java.lang.Class
   public static Class method_3968(String var0) {
      Iterator var1 = ForgeRegistries.ENTITIES.iterator();

      EntityEntry var2;
      do {
         if (!var1.hasNext()) {
            return null;
         }

         var2 = (EntityEntry)var1.next();
      } while(!var2.getName().equals(var0));

      return var2.getEntityClass();
   }

   // $FF: renamed from: c (net.minecraft.entity.EntityLivingBase) float
   @SideOnly(Side.CLIENT)
   public static float method_3969(EntityLivingBase var0) {
      Render var1 = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(var0);
      if (var1 instanceof RenderLivingBase) {
         RenderLivingBase var2 = (RenderLivingBase)var1;
      }

      return 1.8F;
   }

   // $FF: renamed from: c (net.minecraft.client.Minecraft, net.minecraft.world.World) void
   public static void method_3970(Minecraft var0, World var1) {
      float var2 = var1.getSunBrightness(1.0F);
      float var3 = var2 * 0.95F + 0.05F;

      for(int var4 = 0; var4 < 256; ++var4) {
         float var5 = var1.provider.getLightBrightnessTable()[var4 / 16] * var3;
         float var6 = var1.provider.getLightBrightnessTable()[var4 % 16];
         float var7 = var5 * (var2 * 0.65F + 0.35F);
         float var8 = var5 * (var2 * 0.65F + 0.35F);
         float var9 = var6 * ((var6 * 0.6F + 0.4F) * 0.6F + 0.4F);
         float var10 = var6 * (var6 * var6 * 0.6F + 0.4F);
         float var11 = var7 + var6;
         float var12 = var8 + var9;
         float var13 = var5 + var10;
         var11 = var11 * 0.96F + 0.03F;
         var12 = var12 * 0.96F + 0.03F;
         var13 = var13 * 0.96F + 0.03F;
         if (var11 > 1.0F) {
            var11 = 1.0F;
         }

         if (var12 > 1.0F) {
            var12 = 1.0F;
         }

         if (var13 > 1.0F) {
            var13 = 1.0F;
         }

         float var14 = var0.gameSettings.gammaSetting;
         float var15 = 1.0F - var11;
         float var16 = 1.0F - var12;
         float var17 = 1.0F - var13;
         var15 = 1.0F - var15 * var15 * var15 * var15;
         var16 = 1.0F - var16 * var16 * var16 * var16;
         var17 = 1.0F - var17 * var17 * var17 * var17;
         var11 = var11 * (1.0F - var14) + var15 * var14;
         var12 = var12 * (1.0F - var14) + var16 * var14;
         var13 = var13 * (1.0F - var14) + var17 * var14;
         var11 = var11 * 0.96F + 0.03F;
         var12 = var12 * 0.96F + 0.03F;
         var13 = var13 * 0.96F + 0.03F;
         if (var11 > 1.0F) {
            var11 = 1.0F;
         }

         if (var12 > 1.0F) {
            var12 = 1.0F;
         }

         if (var13 > 1.0F) {
            var13 = 1.0F;
         }

         if (var11 < 0.0F) {
            var11 = 0.0F;
         }

         if (var12 < 0.0F) {
            var12 = 0.0F;
         }

         if (var13 < 0.0F) {
            var13 = 0.0F;
         }

         boolean var18 = true;
         int var19 = (int)(var11 * 255.0F);
         int var20 = (int)(var12 * 255.0F);
         int var21 = (int)(var13 * 255.0F);
         ((EntityRendererAccessor)var0.entityRenderer).getLightmapColors()[var4] = -16777216 | var19 << 16 | var20 << 8 | var21;
      }

      ((EntityRendererAccessor)var0.entityRenderer).getLightmapTexture().updateDynamicTexture();
   }

   // $FF: renamed from: c (int, int, float, float, float, net.minecraft.entity.EntityLivingBase) void
   @SideOnly(Side.CLIENT)
   public static void method_3971(int var0, int var1, float var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.disableBlend();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale(-var2, var2, var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      if (var5 instanceof EntityPlayer) {
      }

      try {
         RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
         var11.setPlayerViewY(180.0F);
         var11.setRenderShadow(false);
         var11.renderEntity(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, true);
         var11.setRenderShadow(true);
      } finally {
         var5.renderYawOffset = var6;
         var5.rotationYaw = var7;
         var5.rotationPitch = var8;
         var5.prevRotationYawHead = var9;
         var5.rotationYawHead = var10;
         GlStateManager.popMatrix();
         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableRescaleNormal();
         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.disableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.translate(0.0F, 0.0F, 20.0F);
         GlStateManager.resetColor();
      }

   }
}
