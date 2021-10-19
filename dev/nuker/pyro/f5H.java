/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5H extends f5q {
   // $FF: renamed from: c dev.nuker.pyro.f5h[]
   @NotNull
   public f5h[] field_1046 = new f5h[]{(f5h)null, (f5h)null, (f5h)null, (f5h)null};

   // $FF: renamed from: c () dev.nuker.pyro.f5h[]
   @NotNull
   public f5h[] method_1545() {
      return this.field_1046;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   public f5H() {
      super("Notifications", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return 40.0F;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return 160.0F;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5h[]) void
   public void method_1546(@NotNull f5h[] var1) {
      this.field_1046 = var1;
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5h, int) void
   public void method_1547(f5h var1, int var2) {
      if (var1 == null) {
         Intrinsics.throwNpe();
      }

      int var3 = var1.method_2952();
      int var4 = var1.method_2950();
      if (var3 == 0) {
         var1.method_2953(var4 + 1);
      }

      if (var3 > 0 && var4 < 300) {
         var1.method_2949(var3 - 2);
      } else if (var4 >= 300) {
         if ((float)var3 < this.method_1526()) {
            var1.method_2949(var3 + 3);
         } else {
            var1.method_2953(var4 + 1);
            if (var4 >= 330) {
               f5i.method_2956().field_1703.remove(var1);
            }
         }
      }

      byte var5 = 8;
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var3, (float)var2, 0.0F);
      PyroRenderUtil.meth0(0.0F, 0.0F, this.method_1526(), this.method_1531(), -1728053248);
      PyroRenderUtil.meth0(0.0F, 0.0F, (float)var5, this.method_1531(), var1.method_2951());
      GlStateManager.pushMatrix();
      GlStateManager.scale(1.1D, 1.1D, 1.1D);
      PyroRenderUtil.meth1(var1.method_2954(), (float)var5 + (float)2, 4.0F, -1);
      GlStateManager.popMatrix();
      PyroRenderUtil.meth1(var1.method_2948(), (float)var5 + (float)4, 18.0F, -1);
      GlStateManager.popMatrix();
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      if (fdZ.field_976.world != null && fdZ.field_976.player != null) {
         if (fdZ.field_976.currentScreen instanceof f5j) {
            PyroRenderUtil.meth0(0.0F, 0.0F, this.method_1526(), this.method_1531(), -1728053248);
            PyroRenderUtil.meth0(0.0F, 0.0F, 8.0F, this.method_1531(), -1234904);
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.1D, 1.1D, 1.1D);
            PyroRenderUtil.meth1("Notifications", 10.0F, 4.0F, -1);
            GlStateManager.popMatrix();
            PyroRenderUtil.meth1("This is an example!", 12.0F, 18.0F, -1);
         } else {
            int var6 = 0;

            for(int var7 = this.field_1046.length; var6 < var7; ++var6) {
               if (f5i.method_2956().field_1703.size() >= var6 + 1) {
                  if (f5i.method_2956().field_1703.size() >= var6 + 1) {
                     this.field_1046[var6] = (f5h)f5i.method_2956().field_1703.get(var6);
                  }

                  int var8 = (int)(this.method_1531() * (float)var6 + (float)(6 * var6));
                  if (this.field_1046[var6] != null) {
                     this.method_1547(this.field_1046[var6], var8);
                  }
               }
            }

         }
      } else {
         f5i.method_2956().field_1703.clear();
      }
   }
}
