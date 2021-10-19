/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class faI extends Module {
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_806 = (DoubleSetting)this.register((f0w)(new DoubleSetting("sizeMultiplier", "SizeMultiplier", (String)null, 1.0D, 1.0D, 20.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.f0l
   @NotNull
   public f0l field_807 = (f0l)this.register((f0w)(new f0l("color", "OutlineColor", (String)null, new f00(0.0F, 1.0F, 0.5F, 0.5F))));
   // $FF: renamed from: 0 dev.nuker.pyro.f0l
   @NotNull
   public f0l field_808;
   // $FF: renamed from: 0 dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_809;

   // $FF: renamed from: 0 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1182() {
      return this.field_807;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.f0l
   @NotNull
   public f0l method_1183() {
      return this.field_808;
   }

   // $FF: renamed from: 1 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1184() {
      return this.field_806;
   }

   // $FF: renamed from: c (net.minecraft.entity.player.EntityPlayer, net.minecraft.util.math.RayTraceResult, int, float) void
   public void method_1185(@NotNull EntityPlayer var1, @NotNull RayTraceResult var2, int var3, float var4) {
      if (var3 == 0 && var2.typeOfHit == Type.BLOCK) {
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
         double var5 = ((Number)this.field_809.c()).doubleValue();
         GlStateManager.glLineWidth((float)var5);
         GlStateManager.disableTexture2D();
         GlStateManager.depthMask(false);
         BlockPos var7 = var2.getBlockPos();
         IBlockState var8 = this.c.world.getBlockState(var7);
         if (var8.getMaterial() != Material.AIR && this.c.world.getWorldBorder().contains(var7)) {
            double var9 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var4;
            double var11 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var4;
            double var13 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var4;
            float var15 = ((f00)this.field_808.c()).meth7();
            float var16 = ((f00)this.field_808.c()).method_3446();
            float var17 = ((f00)this.field_808.c()).meth22();
            float var18 = ((f00)this.field_808.c()).meth9();
            RenderGlobal.renderFilledBox(var8.getSelectedBoundingBox((World)this.c.world, var7).grow(0.0020000000949949026D * ((Number)this.field_806.c()).doubleValue()).offset(-var9, -var11, -var13), var15, var16, var17, var18);
            var15 = ((f00)this.field_807.c()).meth7();
            var16 = ((f00)this.field_807.c()).method_3446();
            var17 = ((f00)this.field_807.c()).meth22();
            var18 = ((f00)this.field_807.c()).meth9();
            RenderGlobal.drawSelectionBoundingBox(var8.getSelectedBoundingBox((World)this.c.world, var7).grow(0.0020000000949949026D * ((Number)this.field_806.c()).doubleValue()).offset(-var9, -var11, -var13), var15, var16, var17, var18);
         }

         GlStateManager.depthMask(true);
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
      }

   }

   // $FF: renamed from: c (dev.nuker.pyro.DoubleSetting) void
   public void method_1186(@NotNull DoubleSetting var1) {
      this.field_809 = var1;
   }

   // $FF: renamed from: c () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1187() {
      return this.field_809;
   }

   public faI() {
      super("blockhighlight", "BlockHighlight", "Allows you to customize how blocks are highlighted", true);
      this.field_808 = (f0l)this.register((f0w)(new f0l("colorOverlay", "OverlayColor", (String)null, f00.field_2296.method_3685())));
      this.field_809 = (DoubleSetting)this.register((f0w)(new DoubleSetting("lineWidth", "LineWidth", (String)null, 8.0D, 1.0D, 10.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   }

   // $FF: renamed from: c (dev.nuker.pyro.f0l) void
   public void method_1188(@NotNull f0l var1) {
      this.field_807 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.DoubleSetting) void
   public void method_1189(@NotNull DoubleSetting var1) {
      this.field_806 = var1;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.f0l) void
   public void method_1190(@NotNull f0l var1) {
      this.field_808 = var1;
   }
}
