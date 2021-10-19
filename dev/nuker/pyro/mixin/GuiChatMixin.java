/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.Config;
import dev.nuker.pyro.class_5;
import dev.nuker.pyro.f4N;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiChat.class})
public abstract class GuiChatMixin extends GuiScreen {
   @Shadow
   protected GuiTextField inputField;
   @Shadow
   private String historyBuffer;
   @Shadow
   private int sentHistoryCursor;

   @Inject(
      method = {"Lnet/minecraft/client/gui/GuiChat;keyTyped(CI)V"},
      at = {@At("RETURN")}
   )
   public void returnKeyTyped(char typedChar, int keyCode, CallbackInfo info) {
      if (Minecraft.getMinecraft().currentScreen instanceof GuiChat && !(Minecraft.getMinecraft().currentScreen instanceof f4N)) {
         if (this.inputField.getText().startsWith(Config.INSTANCE.chatPrefix)) {
            Minecraft.getMinecraft().displayGuiScreen(new f4N(this.inputField.getText(), this.historyBuffer, this.sentHistoryCursor));
         }

      }
   }

   @Inject(
      method = {"drawScreen"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo info) {
      if (class_5.field_1004.field_1002 != 0) {
         info.cancel();
         drawRect(2, this.height - class_5.field_1004.field_1002, this.width - 2, this.height - 2, Integer.MIN_VALUE);
         this.inputField.drawTextBox();
         ITextComponent itextcomponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());
         if (itextcomponent != null && itextcomponent.getStyle().getHoverEvent() != null) {
            this.handleComponentHover(itextcomponent, mouseX, mouseY);
         }

         super.drawScreen(mouseX, mouseY, partialTicks);
      }

   }
}
