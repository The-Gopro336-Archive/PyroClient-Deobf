/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f83;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiDisconnected.class})
public class GuiDisconnectedMixin extends GuiScreen {
   @Shadow
   private int textHeight;
   @Shadow
   @Final
   private GuiScreen parentScreen;
   private long startTime = -5L;
   private GuiButton reconnectButton;

   @Inject(
      method = {"<init>"},
      at = {@At("RETURN")}
   )
   private void startTimer(GuiScreen screen, String reasonLocalizationKey, ITextComponent chatComp, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2479.c.method_3034() && (Boolean)PyroStatic.field_2479.method_684().c()) {
         this.startTime = (new Date()).getTime() + (long)((int)((Double)PyroStatic.field_2479.method_682().c() * 1000.0D));
      }

   }

   @Inject(
      method = {"initGui"},
      at = {@At("RETURN")}
   )
   private void addButtons(CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2479.method_684().c()) {
         this.buttonList.add(new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.textHeight / 2 + this.fontRenderer.FONT_HEIGHT, this.height - 30) + 21, "Reconnect"));
         this.reconnectButton = new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.textHeight / 2 + this.fontRenderer.FONT_HEIGHT, this.height - 30) + 42, "Auto Reconnect");
         this.buttonList.add(this.reconnectButton);
      }

   }

   @Inject(
      method = {"actionPerformed"},
      at = {@At("INVOKE")},
      cancellable = true
   )
   private void handleButtons(GuiButton button, CallbackInfo ci) {
      if ((Boolean)PyroStatic.field_2479.method_684().c()) {
         if (this.buttonList.indexOf(button) == 1 && f83.field_462 != null) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiConnecting(this.parentScreen, Minecraft.getMinecraft(), f83.field_462));
            ci.cancel();
         } else if (this.buttonList.indexOf(button) == 2) {
            PyroStatic.field_2479.c.method_3033(!(Boolean)PyroStatic.field_2479.c.method_3034());
            if ((Boolean)PyroStatic.field_2479.c.method_3034()) {
               this.startTime = (new Date()).getTime() + (long)((int)((Double)PyroStatic.field_2479.method_682().c() * 1000.0D));
            } else {
               this.startTime = -5L;
            }

            ci.cancel();
         }
      }

   }

   public void updateScreen() {
      super.updateScreen();
      if ((Boolean)PyroStatic.field_2479.c.method_3034() && (Boolean)PyroStatic.field_2479.method_684().c() && f83.field_462 != null && this.startTime != -5L) {
         long timeDiff = this.startTime - (new Date()).getTime();
         this.reconnectButton.displayString = "Auto Reconnect (" + timeDiff / 1000L + ")";
         if (timeDiff < 0L) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiConnecting(this.parentScreen, Minecraft.getMinecraft(), f83.field_462));
         }
      }

   }
}
