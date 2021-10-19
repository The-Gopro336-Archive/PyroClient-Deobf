/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class f5v extends f5q {
   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 27.0F;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   public f5v() {
      super("armor", (String)null);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(f5t var1, int var2, ScaledResolution var3, float var4, float var5) {
      Iterator var6 = c.player.getArmorInventoryList().iterator();
      ArrayList var7 = new ArrayList();

      while(var6.hasNext()) {
         ItemStack var8 = (ItemStack)var6.next();
         if (!var8.isEmpty()) {
            var7.add(var8);
         }
      }

      Collections.reverse(var7);
      int var16 = 0;
      int var9 = 0;
      Iterator var10 = var7.iterator();

      while(var10.hasNext()) {
         ItemStack var11 = (ItemStack)var10.next();
         GlStateManager.pushMatrix();
         GlStateManager.depthMask(true);
         GlStateManager.clear(256);
         RenderHelper.enableStandardItemLighting();
         c.getRenderItem().zLevel = -150.0F;
         GlStateManager.disableAlpha();
         GlStateManager.enableDepth();
         GlStateManager.disableCull();
         float var12 = (float)(var11.getMaxDamage() - var11.getItemDamage()) / (float)var11.getMaxDamage() * 100.0F;
         c.getRenderItem().renderItemAndEffectIntoGUI(var11, var16, 10);
         c.getRenderItem().renderItemOverlays(c.fontRenderer, var11, var16, 10);
         int var13 = 2096896;
         if (var12 > 30.0F && var12 < 70.0F) {
            var13 = 16776960;
         } else if (var12 <= 30.0F) {
            var13 = 16711680;
         }

         String var14 = String.valueOf((int)var12);
         int var15 = 15;
         if (var14.length() == 2) {
            var15 -= 2;
         } else if (var14.length() == 1) {
            var15 -= 4;
         }

         PyroRenderUtil.meth1(var14, (float)(var16 + var15 + 2) - PyroRenderUtil.method_1439(var14), 2.0F, var13);
         var16 += 22;
         var9 += 22;
         c.getRenderItem().zLevel = 0.0F;
         RenderHelper.disableStandardItemLighting();
         GlStateManager.enableCull();
         GlStateManager.enableAlpha();
         GlStateManager.popMatrix();
      }

   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 83.0F;
   }
}
