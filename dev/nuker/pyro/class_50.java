/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

// $FF: renamed from: dev.nuker.pyro.fi
public class class_50 extends GuiScreen {
   // $FF: renamed from: c net.minecraft.client.gui.GuiTextField
   public GuiTextField field_2682;
   // $FF: renamed from: c dev.nuker.pyro.fo
   public class_46 field_2683;
   // $FF: renamed from: c java.lang.String
   public String field_2684;
   // $FF: renamed from: c net.minecraft.client.gui.GuiScreen
   public GuiScreen field_2685;
   // $FF: renamed from: 0 java.lang.String
   public String field_2686 = "";

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawString(this.fontRenderer, "Email/Username", this.width / 2 - 100, 38, 10526880);
      this.drawString(this.fontRenderer, "Password (Leave blank for cracked)", this.width / 2 - 100, 79, 10526880);
      this.drawCenteredString(this.fontRenderer, TextFormatting.DARK_RED + this.field_2686, this.width / 2, this.height / 4 + 70, -1);

      try {
         this.field_2682.drawTextBox();
         this.field_2683.method_4038();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      super.drawScreen(var1, var2, var3);
   }

   public void mouseClicked(int var1, int var2, int var3) {
      this.field_2682.mouseClicked(var1, var2, var3);
      this.field_2683.method_4011(var1, var2, var3);
      super.mouseClicked(var1, var2, var3);
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void keyTyped(char var1, int var2) {
      this.field_2682.textboxKeyTyped(var1, var2);
      this.field_2683.method_4039(var1, var2);
      if (var1 == '\t') {
         if (this.field_2682.isFocused()) {
            this.field_2682.setFocused(false);
            this.field_2683.method_4037(true);
         } else if (this.field_2683.method_4024()) {
            this.field_2682.setFocused(false);
            this.field_2683.method_4037(false);
         }
      }

      if (var1 == '\r') {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

   }

   public void updateScreen() {
      this.field_2682.updateCursorCounter();
      this.field_2683.method_4046();
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) void
   public void method_4054(String var1, String var2) {
      throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
   }

   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96 + 12, this.field_2684));
      this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96 + 36, "Cancel"));
      this.field_2682 = new GuiTextField(0, this.fontRenderer, this.width / 2 - 100, 51, 200, 20);
      this.field_2683 = new class_46(2, this.fontRenderer, this.width / 2 - 100, 91, 200, 20);
      this.field_2682.setMaxStringLength(200);
      this.field_2683.method_4020(200);
   }

   public void actionPerformed(GuiButton var1) {
      if (var1.id == 1) {
         if (!this.field_2682.getText().isEmpty()) {
            this.method_4054(this.field_2682.getText(), this.field_2683.method_4010());
         }
      } else if (var1.id == 2) {
         Minecraft.getMinecraft().displayGuiScreen(this.field_2685);
      }

   }

   public class_50(GuiScreen var1, String var2) {
      this.field_2684 = var2;
      this.field_2685 = var1;
   }
}
