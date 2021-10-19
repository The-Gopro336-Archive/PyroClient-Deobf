/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class f5D extends f5q {
   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      GlStateManager.pushMatrix();
      RenderHelper.enableGUIStandardItemLighting();
      int var6 = 0;

      for(byte var7 = 26; var6 <= var7; ++var6) {
         ItemStack var8 = (ItemStack)fdZ.field_976.player.inventory.mainInventory.get(var6 + 9);
         int var9 = var6 % 9 * 16;
         int var10 = var6 / 9 * 16;
         fdZ.field_976.getRenderItem().renderItemAndEffectIntoGUI(var8, var9, var10);
         fdZ.field_976.getRenderItem().renderItemOverlayIntoGUI(fdZ.field_976.fontRenderer, var8, var9, var10, (String)null);
      }

      PyroRenderUtil.method_1428(0.0F, 0.0F, this.method_1526(), this.method_1531(), 1.0F, f0H.field_2338.method_3505());
      RenderHelper.disableStandardItemLighting();
      fdZ.field_976.getRenderItem().zLevel = 0.0F;
      GlStateManager.popMatrix();
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return true;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 144.0F;
   }

   public f5D() {
      super("inventory", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 48.0F;
   }
}
