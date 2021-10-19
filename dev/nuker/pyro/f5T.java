/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class f5T extends f5q {
   // $FF: renamed from: 5 () float
   public float method_1526() {
      return this.method_1559() == null ? 0.0F : PyroRenderUtil.method_1439(this.method_1559()) + (float)3;
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution, float, float) int
   public int method_1558(@Nullable ScaledResolution var1, float var2, float var3) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   // $FF: renamed from: 4 () java.lang.String
   @Nullable
   public String method_1559() {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   public f5T(@NotNull String var1) {
      super(var1, (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      String var6 = this.method_1559();
      GlStateManager.translate(2.0F, 2.0F, 0.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      if (var6 != null) {
         PyroRenderUtil.meth1(var6, 0.0F, 0.0F, this.method_1558(var3, var4, var5));
      }

   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return PyroRenderUtil.meth1();
   }
}
