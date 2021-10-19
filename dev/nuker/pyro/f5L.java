/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.Nullable;

public class f5L extends f5q {
   // $FF: renamed from: c float
   public float field_1048 = 128.0F;
   // $FF: renamed from: 0 float
   public float field_1049 = 64.0F;

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      if (fdZ.field_976.world != null && fdZ.field_976.player != null) {
         this.field_1048 = 50.0F;
         this.field_1049 = 100.0F;

         try {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GuiInventory.drawEntityOnScreen((int)this.field_1048 / 2, (int)this.field_1049, 50, var4, var5, (EntityLivingBase)fdZ.field_976.player);
         } catch (Exception var7) {
         }

      }
   }

   // $FF: renamed from: c () float
   public float method_1550() {
      return this.field_1049;
   }

   // $FF: renamed from: 0 (float) void
   public void method_1551(float var1) {
      this.field_1049 = var1;
   }

   // $FF: renamed from: c (float) void
   public void method_1552(float var1) {
      this.field_1048 = var1;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return this.field_1049;
   }

   public float meth1() {
      return this.field_1048;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return this.field_1048;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   public f5L() {
      super("playerModel", (String)null, 2, (DefaultConstructorMarker)null);
   }
}
