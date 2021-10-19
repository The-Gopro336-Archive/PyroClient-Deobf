/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5M extends f5q {
   // $FF: renamed from: c net.minecraft.potion.PotionEffect
   @NotNull
   public PotionEffect field_1047;

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 13.0F;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      GlStateManager.pushMatrix();
      boolean var6 = var2 < 2;
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableLighting();
      Potion var7 = this.field_1047.getPotion();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      fdZ.field_976.getTextureManager().bindTexture(GuiContainer.INVENTORY_BACKGROUND);
      if (var7.hasStatusIcon()) {
         int var8 = var7.getStatusIconIndex();
         float var9 = 0.7F;
         GlStateManager.enableAlpha();
         GlStateManager.disableDepth();
         GlStateManager.pushMatrix();
         GlStateManager.translate(var6 ? (double)(this.method_1526() - (float)13) : 0.0D, 0.0D, 0.0D);
         GlStateManager.scale(var9, var9, var9);
         Gui var10000 = fdZ.field_976.currentScreen != null ? (Gui)fdZ.field_976.currentScreen : (Gui)fdZ.field_976.ingameGUI;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         var10000.drawTexturedModalRect(0, 0, var8 % 8 * 18, 198 + var8 / 8 * 18, 18, 18);
         GlStateManager.popMatrix();
         GlStateManager.disableAlpha();
         GlStateManager.enableDepth();
      }

      var7.renderInventoryEffect(0, 0, this.field_1047, fdZ.field_976);
      String var12 = I18n.format(var7.getName(), new Object[0]);
      if (this.field_1047.getAmplifier() > 0) {
         var12 = var12 + " " + I18n.format("enchantment.level." + (this.field_1047.getAmplifier() + 1), new Object[0]);
      }

      String var13 = Potion.getPotionDurationString(this.field_1047, 1.0F);
      String var10 = var13 + ' ' + var12;
      float var11 = PyroRenderUtil.meth0(var10);
      var10 = var12 + ' ' + var13;
      var11 = PyroRenderUtil.meth0(var10) + (float)2;
      PyroRenderUtil.meth1(var12 + ' ' + var13, var6 ? 0.0F : 15.0F, 3.0F, -1);
      GlStateManager.popMatrix();
   }

   // $FF: renamed from: c () net.minecraft.potion.PotionEffect
   @NotNull
   public PotionEffect method_1548() {
      return this.field_1047;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      String var1 = I18n.format(this.field_1047.getPotion().getName(), new Object[0]);
      if (this.field_1047.getAmplifier() > 0) {
         var1 = var1 + " " + I18n.format("enchantment.level." + (this.field_1047.getAmplifier() + 1), new Object[0]);
      }

      String var2 = Potion.getPotionDurationString(this.field_1047, 1.0F);
      String var3 = var2 + ' ' + var1 + ' ';
      return PyroRenderUtil.meth0(var3) + this.method_1531();
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return true;
   }

   public f5M(@NotNull PotionEffect var1) {
      super("", (String)null, 2, (DefaultConstructorMarker)null);
      this.field_1047 = var1;
   }

   // $FF: renamed from: c (net.minecraft.potion.PotionEffect) void
   public void method_1549(@NotNull PotionEffect var1) {
      this.field_1047 = var1;
   }
}
