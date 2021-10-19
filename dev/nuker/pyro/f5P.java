/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class f5P extends f5q {
   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      int var6 = fdX.field_1227.method_1834(Items.TOTEM_OF_UNDYING);
      int var7 = fdX.field_1227.method_1834(Items.EXPERIENCE_BOTTLE);
      int var8 = fdX.field_1227.method_1834(Items.END_CRYSTAL);
      int var9 = fdX.field_1227.method_1834(Items.GOLDEN_APPLE);
      List var10 = (List)(new ArrayList());
      if (var6 > 0) {
         var10.add(new ItemStack(Items.TOTEM_OF_UNDYING, var6));
      }

      if (var7 > 0) {
         var10.add(new ItemStack(Items.EXPERIENCE_BOTTLE, var7));
      }

      if (var8 > 0) {
         var10.add(new ItemStack(Items.END_CRYSTAL, var8));
      }

      if (var9 > 0) {
         var10.add(new ItemStack(Items.GOLDEN_APPLE, var9, 1));
      }

      int var11 = 0;

      for(int var12 = ((Collection)var10).size(); var11 < var12; ++var11) {
         GlStateManager.pushMatrix();
         GlStateManager.depthMask(true);
         GlStateManager.clear(256);
         RenderHelper.enableStandardItemLighting();
         fdZ.field_976.getRenderItem().zLevel = -150.0F;
         GlStateManager.disableAlpha();
         GlStateManager.enableDepth();
         GlStateManager.disableCull();
         boolean var13 = false;
         boolean var14 = false;
         ItemStack var15 = (ItemStack)var10.get(var11);
         int var16 = var11 % 2 * 20;
         int var17 = var11 / 2 * 20;
         fdZ.field_976.getRenderItem().renderItemAndEffectIntoGUI(var15, var16 + 2, var17 + 2);
         fdZ.field_976.getRenderItem().renderItemOverlays(fdZ.field_976.fontRenderer, var15, var16 + 2, var17 + 2);
         fdZ.field_976.getRenderItem().zLevel = 0.0F;
         RenderHelper.disableStandardItemLighting();
         GlStateManager.enableCull();
         GlStateManager.enableAlpha();
         GlStateManager.popMatrix();
      }

      PyroRenderUtil.method_1428(0.0F, 0.0F, this.method_1526(), this.method_1531(), 1.0F, f0H.field_2338.method_3505());
      PyroRenderUtil.meth0(this.method_1526() / (float)2, 0.0F, this.method_1526() / (float)2, this.method_1531(), 1.0F, f0H.field_2338.method_3505());
      PyroRenderUtil.meth0(0.0F, this.method_1531() / (float)2, this.method_1526(), this.method_1531() / (float)2, 1.0F, f0H.field_2338.method_3505());
   }

   public f5P() {
      super("potionHud", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 40.0F;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 40.0F;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }
}
