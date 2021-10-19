/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

public class f79 implements Consumer {
   // $FF: renamed from: c dev.nuker.pyro.f7b
   public f7b field_1723;

   public void accept(Object var1) {
      this.method_2968((fe3)var1);
   }

   // $FF: renamed from: c (dev.nuker.pyro.fe3) void
   public void method_2968(@NotNull fe3 var1) {
      float var2 = ((Number)var1.method_1960()).floatValue() * (float)16;
      float var3 = ((Number)var1.method_1959()).floatValue() * (float)16;
      ICamera var10000 = PyroRenderUtil.field_983;
      Entity var10001 = f7b.method_610(this.field_1723).getRenderViewEntity();
      if (var10001 == null) {
         Intrinsics.throwNpe();
      }

      double var6 = var10001.posX;
      Entity var10002 = f7b.method_610(this.field_1723).getRenderViewEntity();
      if (var10002 == null) {
         Intrinsics.throwNpe();
      }

      double var7 = var10002.posY;
      Entity var10003 = f7b.method_610(this.field_1723).getRenderViewEntity();
      if (var10003 == null) {
         Intrinsics.throwNpe();
      }

      var10000.setPosition(var6, var7, var10003.posZ);
      AxisAlignedBB var4 = new AxisAlignedBB((double)var2 - f7b.method_610(this.field_1723).getRenderManager().viewerPosX, (double)0 - f7b.method_610(this.field_1723).getRenderManager().viewerPosY, (double)var3 - f7b.method_610(this.field_1723).getRenderManager().viewerPosZ, (double)(var2 + (float)16) - f7b.method_610(this.field_1723).getRenderManager().viewerPosX, (double)1 - f7b.method_610(this.field_1723).getRenderManager().viewerPosY, (double)(var3 + (float)16) - f7b.method_610(this.field_1723).getRenderManager().viewerPosZ);
      AxisAlignedBB var5 = new AxisAlignedBB((double)var2, 0.0D, (double)var3, (double)(var2 + (float)16), 1.0D, (double)(var3 + (float)16));
      if (PyroRenderUtil.field_983.isBoundingBoxInFrustum(var5)) {
         GlStateManager.pushMatrix();
         GlStateManager.enableBlend();
         GlStateManager.disableDepth();
         GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
         GlStateManager.disableTexture2D();
         GlStateManager.depthMask(false);
         GL11.glEnable(2848);
         GL11.glHint(3154, 4354);
         GL11.glLineWidth(1.5F);
         RenderGlobal.renderFilledBox(var4.minX, var4.minY, var4.minZ, var4.maxX, var4.minY, var4.maxZ, ((f00)this.field_1723.method_616().c()).meth7(), ((f00)this.field_1723.method_616().c()).method_3446(), ((f00)this.field_1723.method_616().c()).meth22(), ((f00)this.field_1723.method_616().c()).meth9());
         GL11.glDisable(2848);
         GlStateManager.depthMask(true);
         GlStateManager.enableDepth();
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
         GlStateManager.popMatrix();
      }

   }

   public f79(f7b var1) {
      this.field_1723 = var1;
      super();
   }
}
