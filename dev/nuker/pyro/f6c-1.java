/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiUtils;
import org.jetbrains.annotations.Nullable;

public class f6c extends f5q {
   // $FF: renamed from: c net.minecraft.util.ResourceLocation
   public ResourceLocation field_1051 = new ResourceLocation("pyro:assets/textures/logotext.png");
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_1052 = (BooleanSetting)this.c((f0w)(new BooleanSetting("simple", "Simple", "Renders the watermark as a single string", false)));
   // $FF: renamed from: c float
   public float field_1053 = 128.0F;
   // $FF: renamed from: 0 float
   public float field_1054 = 64.0F;

   // $FF: renamed from: c (dev.nuker.pyro.f5t, int, net.minecraft.client.gui.ScaledResolution, float, float) void
   public void method_1528(@Nullable f5t var1, int var2, @Nullable ScaledResolution var3, float var4, float var5) {
      if ((Boolean)this.field_1052.c()) {
         this.field_1053 = PyroRenderUtil.method_1439(Config.INSTANCE.watermark + " " + "Release" + " " + "1.4.1") + (float)3;
         this.field_1054 = PyroRenderUtil.meth1();
         PyroRenderUtil.meth1(Config.INSTANCE.watermark + " " + ChatFormatting.WHITE + "Release" + " " + "1.4.1", 0.0F, 2.0F, 15492635);
      } else {
         this.field_1053 = 128.0F;
         this.field_1054 = 64.0F;
         GlStateManager.pushMatrix();
         GlStateManager.enableBlend();
         GlStateManager.enableAlpha();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5D, 0.25D, 0.0D);
         fdZ.field_976.getTextureManager().bindTexture(this.field_1051);
         GuiUtils.drawTexturedModalRect(0, 0, 0, 0, 256, 256, 0.0F);
         GlStateManager.popMatrix();
         PyroRenderUtil.meth1("Release 1.4.1", 56.0F, 43.0F, 16777215);
         GlStateManager.popMatrix();
      }

   }

   public float meth1() {
      return this.field_1054;
   }

   // $FF: renamed from: 1 () boolean
   public boolean method_1535() {
      return false;
   }

   // $FF: renamed from: 0 () float
   public float method_1531() {
      return this.field_1054;
   }

   // $FF: renamed from: 5 () float
   public float method_1526() {
      return this.field_1053;
   }

   // $FF: renamed from: c (float) void
   public void method_1555(float var1) {
      this.field_1054 = var1;
   }

   public f6c() {
      super("watermark", (String)null, 2, (DefaultConstructorMarker)null);
   }

   // $FF: renamed from: 0 (float) void
   public void method_1556(float var1) {
      this.field_1053 = var1;
   }

   // $FF: renamed from: c () float
   public float method_1557() {
      return this.field_1053;
   }
}
