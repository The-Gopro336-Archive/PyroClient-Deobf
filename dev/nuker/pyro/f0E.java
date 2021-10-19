/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class f0E {
   // $FF: renamed from: c (int, int, int, int, int) void
   public void method_3570(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1;
      int var7 = var2;
      int var8 = var3;
      int var9 = var4;
      if (var1 < var3) {
         var6 = var3;
         var8 = var1;
      }

      if (var2 < var4) {
         var7 = var4;
         var9 = var2;
      }

      float var10 = (float)(var5 >> 24 & 255) / 255.0F;
      float var11 = (float)(var5 >> 16 & 255) / 255.0F;
      float var12 = (float)(var5 >> 8 & 255) / 255.0F;
      float var13 = (float)(var5 & 255) / 255.0F;
      Tessellator var14 = Tessellator.getInstance();
      BufferBuilder var15 = var14.getBuffer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.color(var11, var12, var13, var10);
      var15.begin(7, DefaultVertexFormats.POSITION);
      var15.pos((double)var6, (double)var9, 0.0D).endVertex();
      var15.pos((double)var8, (double)var9, 0.0D).endVertex();
      var15.pos((double)var8, (double)var7, 0.0D).endVertex();
      var15.pos((double)var6, (double)var7, 0.0D).endVertex();
      var14.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public f0E() {
   }

   public f0E(DefaultConstructorMarker var1) {
      this();
   }
}
