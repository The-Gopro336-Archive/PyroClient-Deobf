/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.Nullable;

public class f5K extends f5q {
   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      if (fdZ.field_976.world != null && fdZ.field_976.player != null) {
         try {
            float var6 = fdZ.field_976.player.getHealth() / fdZ.field_976.player.getMaxHealth() * (float)100;
            float var7 = (float)100 - var6;
            float var8 = fdZ.field_976.player.getAbsorptionAmount() / (float)16 * (float)100;
            float var9 = (float)100 - var8;
            PyroRenderUtil.method_1428(0.0F, 0.0F, this.method_1526(), this.method_1531(), 1.0F, f0H.field_2338.method_3505());
            PyroRenderUtil.meth1(fdZ.field_976.player.getName(), this.method_1526() - (float)128, this.method_1531() - (float)47, -1);
            GuiInventory.drawEntityOnScreen((int)this.method_1526() - 116, (int)this.method_1531() - 4, 18, var4, var5, (EntityLivingBase)fdZ.field_976.player);
            PyroRenderUtil.meth0(31.0F, 16.0F, this.method_1526() - var7 - (float)4, 29.0F, -1720975536);
            PyroRenderUtil.meth1("Health: " + (int)var6 + "%", 34.0F, 19.0F, -1);
            PyroRenderUtil.meth0(31.0F, 33.0F, this.method_1526() - var9 - (float)4, 46.0F, -1711295152);
            PyroRenderUtil.meth1("Absorption: " + (int)var8 + "%", 34.0F, 36.0F, -1);
         } catch (Exception var10) {
         }

      }
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 132.0F;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return true;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 51.0F;
   }

   public f5K() {
      super("PlayerInfo", (String)null, 2, (DefaultConstructorMarker)null);
   }
}
