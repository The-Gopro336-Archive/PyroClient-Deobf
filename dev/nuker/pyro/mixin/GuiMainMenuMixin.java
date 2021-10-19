/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Config;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.class_44;
import dev.nuker.pyro.class_47;
import dev.nuker.pyro.class_53;
import dev.nuker.pyro.f0J;
import dev.nuker.pyro.f4K;
import dev.nuker.pyro.alt.AltLogic;
import java.awt.Color;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiMainMenu.class})
public abstract class GuiMainMenuMixin extends GuiScreen {
   private boolean valid;
   private boolean checkedValid;
   // $FF: renamed from: rt dev.nuker.pyro.fq
   private class_44 field_2116;
   // $FF: renamed from: pl dev.nuker.pyro.fp
   private class_47 field_2117;
   private int lowestButtonY = 0;
   private static final ResourceLocation WATERMARK = new ResourceLocation("pyro:assets/textures/logosmall.png");

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void onInit(CallbackInfo ci) {
      this.valid = false;
      this.checkedValid = false;
      (new Thread(() -> {
         this.valid = !AltLogic.isOffline() && AltLogic.sessionValid();
         this.checkedValid = true;
      })).start();
      this.field_2116 = new class_44();
   }

   // $FF: renamed from: e (org.spongepowered.asm.mixin.injection.callback.CallbackInfo) void
   @Inject(
      method = {"initGui"},
      at = {@At("RETURN")}
   )
   private void method_3198(CallbackInfo ci) {
      this.lowestButtonY = 0;
      Iterator var2 = this.buttonList.iterator();

      while(var2.hasNext()) {
         GuiButton guiButton = (GuiButton)var2.next();
         if (guiButton.y > this.lowestButtonY) {
            this.lowestButtonY = guiButton.y;
         }
      }

      this.buttonList.add(new GuiButton(-1337, this.width / 2 + 104, this.lowestButtonY, 98, 20, "Alt Manager"));
      this.field_2117 = this.field_2116.method_4004(this.mc.getSession().getProfile());
   }

   @Inject(
      method = {"drawScreen"},
      at = {@At("RETURN")}
   )
   private void drawPyroWatermark(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
      Pyro.drawWMMain();
   }

   @Inject(
      method = {"actionPerformed"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void catchActions(GuiButton button, CallbackInfo ci) {
      if (button.id == -1337) {
         Minecraft.getMinecraft().displayGuiScreen(new class_53(new GuiMainMenu()));
         ci.cancel();
      }

   }

   @Inject(
      method = {"drawScreen"},
      at = {@At("RETURN")}
   )
   private void onRender(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
      int y = this.lowestButtonY - 4;
      int x = this.width / 2 + 104 + 47;
      int height = 47;
      this.field_2116.method_4006(x, y, height, this.field_2117.field_2671);
      this.renderStats(x, y - 92);
      if (!Config.INSTANCE.seenInitialScreen) {
         Minecraft.getMinecraft().displayGuiScreen(new f4K(this));
      }

   }

   private void renderStats(int x, int y) {
      String line1 = this.mc.getSession().getUsername();
      String line2 = AltLogic.isOffline() ? TextFormatting.RED + "Cracked" : (this.checkedValid ? (this.valid ? TextFormatting.GREEN + "Premium" : TextFormatting.YELLOW + "Invalid Session") : TextFormatting.GRAY + "Unknown Status");
      int width1 = this.fontRenderer.getStringWidth(line1);
      int width2 = this.fontRenderer.getStringWidth(line2);
      int width = Math.max(width1, width2) + 2;
      GuiScreen.drawRect(x - width / 2, y - this.fontRenderer.FONT_HEIGHT * 2 - 2, x + width / 2, y, (new Color(0, 0, 0, 70)).getRGB());
      f0J.field_2340.method_3553(this.fontRenderer, line1, x - width1 / 2, y - this.fontRenderer.FONT_HEIGHT * 2 - 1, -1);
      f0J.field_2340.method_3553(this.fontRenderer, line2, x - width2 / 2, y - this.fontRenderer.FONT_HEIGHT, -1);
   }
}
