/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class faS extends Module {
   // $FF: renamed from: c dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_784 = (IntegerSetting)this.register((f0w)(new IntegerSetting("maxRenderHp", "Max Render HP", (String)null, 15, 0, 20, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting field_785 = (DoubleSetting)this.register((f0w)(new DoubleSetting("multiplier", "Multiplier", (String)null, 1.0D, 0.0D, 1.0D, 0.0D, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: 0 dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting field_786 = (IntegerSetting)this.register((f0w)(new IntegerSetting("maxFadeHp", "Max Pulse HP", (String)null, 10, 0, 20, 0, 64, (DefaultConstructorMarker)null)));
   // $FF: renamed from: c net.minecraft.util.ResourceLocation
   public ResourceLocation field_787 = new ResourceLocation("textures/misc/vignette.png");

   // $FF: renamed from: c () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1168() {
      return this.field_786;
   }

   public faS() {
      super("damage_hud", "DamageHUD", "Show a red overlay at screen corners based on health", true);
   }

   // $FF: renamed from: c (net.minecraft.client.gui.ScaledResolution) void
   public void method_1169(@NotNull ScaledResolution var1) {
      float var2 = (this.c.player.getHealth() + this.c.player.getAbsorptionAmount() - (float)((Number)this.field_784.c()).intValue()) / 20.0F * -1.0F * (float)((Number)this.field_785.c()).doubleValue() * ((float)((Number)this.field_784.c()).intValue() / 20.0F);
      float var3 = this.c.player.getHealth() + this.c.player.getAbsorptionAmount() <= ((Number)this.field_786.c()).floatValue() ? this.method_1172() : 0.0F;
      float var4 = var2 + (var3 - 1.0F) * var2 * 0.2F;
      float var5 = var2 + (var3 - 1.0F) * var2 * 0.6F;
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      byte var6 = 3;
      this.c.getTextureManager().bindTexture(this.field_787);
      Tessellator var7 = Tessellator.getInstance();
      BufferBuilder var8 = var7.getBuffer();
      faR var9 = new faR(var6, var8, var1, var7);
      GlStateManager.tryBlendFuncSeparate(SourceFactor.ONE_MINUS_DST_COLOR, DestFactor.ONE_MINUS_SRC_COLOR, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.color(var5, 0.0F, 0.0F, 1.0F);
      var9.method_96();
      GlStateManager.tryBlendFuncSeparate(SourceFactor.ONE_MINUS_SRC_ALPHA, DestFactor.ONE_MINUS_SRC_COLOR, SourceFactor.ONE, DestFactor.ZERO);
      GlStateManager.color(0.0F, var4, var4, 1.0F);
      var9.method_96();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.tryBlendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
   }

   // $FF: renamed from: 0 () dev.nuker.pyro.IntegerSetting
   @NotNull
   public IntegerSetting method_1170() {
      return this.field_784;
   }

   // $FF: renamed from: 2 () dev.nuker.pyro.DoubleSetting
   @NotNull
   public DoubleSetting method_1171() {
      return this.field_785;
   }

   // $FF: renamed from: 1 () float
   public float method_1172() {
      float var1 = (float)((int)((double)(System.currentTimeMillis() % (long)1048576) * 0.1D) % 255) / 255.0F;
      if (var1 > 0.5F) {
         var1 = 0.5F - (var1 - 0.5F);
      }

      return var1 * 2.0F;
   }
}
