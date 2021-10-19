/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import java.util.Optional;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// $FF: renamed from: dev.nuker.pyro.fl
public class class_53 extends GuiScreen {
   // $FF: renamed from: c org.apache.logging.log4j.Logger
   public static Logger field_2689 = LogManager.getLogger();
   // $FF: renamed from: c dev.nuker.pyro.fq
   public class_44 field_2690 = new class_44();
   // $FF: renamed from: c net.minecraft.client.gui.GuiScreen
   public GuiScreen field_2691;
   // $FF: renamed from: c net.minecraft.client.gui.GuiButton
   public GuiButton field_2692;
   // $FF: renamed from: 0 net.minecraft.client.gui.GuiButton
   public GuiButton field_2693;
   // $FF: renamed from: 1 net.minecraft.client.gui.GuiButton
   public GuiButton field_2694;
   // $FF: renamed from: c dev.nuker.pyro.fm
   public class_48 field_2695;
   // $FF: renamed from: c boolean
   public boolean field_2696;
   // $FF: renamed from: 0 boolean
   public boolean field_2697;
   // $FF: renamed from: c java.lang.String
   public String field_2698 = "";
   // $FF: renamed from: c dev.nuker.pyro.fp
   public class_47 field_2699;

   public void actionPerformed(GuiButton var1) {
      if (var1.enabled) {
         class_49 var2 = this.field_2695.method_4051();
         switch(var1.id) {
         case 0:
            this.mc.displayGuiScreen(new GuiMainMenu());
            break;
         case 1:
            var2.method_4052();
            break;
         case 2:
            AltManager.INSTANCE.removeAlt(var2.field_2679);
            this.field_2695.field_2673.remove(var2);
            this.method_4060(this.field_2695.method_4051());
            break;
         case 3:
            this.field_2698 = "";
            this.mc.displayGuiScreen(new class_52(this, this, "Login"));
            break;
         case 4:
            this.field_2698 = "";
            this.mc.displayGuiScreen(new class_51(this, this, "Add Account"));
         }
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.field_2695.drawScreen(var1, var2, var3);
      this.drawCenteredString(this.fontRenderer, "Select account", this.width / 2, 20, 16777215);
      EntityOtherPlayerMP var4 = this.field_2699.field_2671;
      Alt var5 = null;
      if (this.field_2695.method_4051() != null) {
         var4 = this.field_2695.method_4051().field_2680.field_2671;
         var5 = this.field_2695.method_4051().field_2679;
      }

      int var6;
      String var7;
      String var10000;
      label470: {
         label469: {
            var6 = this.width / 4 * 3 + this.width / 8;
            this.field_2690.method_4006(var6, this.height - 95 - this.height / 20, (int)((double)this.height / 4.6D), var4);
            var7 = var4.getGameProfile().getName();
            if (var4 != this.field_2699.field_2671) {
               if (var5.isCracked()) {
                  if (!var5.getGameProfile().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName())) {
                     break label469;
                  }
               } else if (!var5.getGameProfile().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
                  break label469;
               }
            }

            var10000 = AltLogic.isOffline() ? TextFormatting.RED + "Cracked" : (this.field_2697 ? (this.field_2696 ? TextFormatting.GREEN + "Premium" : TextFormatting.YELLOW + "Invalid Session") : TextFormatting.GRAY + "Unknown Status");
            break label470;
         }

         var10000 = var5.isCracked() ? TextFormatting.RED + "Cracked" : TextFormatting.GREEN + "Authenticated";
      }

      String var8;
      label476: {
         var8 = var10000;
         if (var4 != this.field_2699.field_2671) {
            label475: {
               if (var5.isCracked()) {
                  if (var5.getGameProfile().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName())) {
                     break label475;
                  }
               } else if (var5.getGameProfile().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
                  break label475;
               }

               var10000 = "";
               break label476;
            }
         }

         var10000 = TextFormatting.BLUE + "In Use";
      }

      String var9 = var10000;
      int var10 = this.fontRenderer.getStringWidth(var7);
      int var11 = this.fontRenderer.getStringWidth(var8);
      int var12 = this.fontRenderer.getStringWidth(var9);
      this.fontRenderer.drawString(var7, var6 - var10 / 2, this.height - 90, -1);
      this.fontRenderer.drawString(var8, var6 - var11 / 2, this.height - 90 + this.fontRenderer.FONT_HEIGHT + 1, -1);
      this.fontRenderer.drawString(var9, var6 - var12 / 2, this.height - 90 + this.fontRenderer.FONT_HEIGHT * 2 + 2, -1);
      this.drawCenteredString(this.fontRenderer, TextFormatting.DARK_RED + this.field_2698, this.width / 2, this.height - 64, -1);
      super.drawScreen(var1, var2, var3);
   }

   public void handleMouseInput() {
      super.handleMouseInput();
      this.field_2695.handleMouseInput();
   }

   // $FF: renamed from: c () void
   public void method_4058() {
      this.field_2693 = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 150, 20, I18n.format("Login", new Object[0])));
      this.addButton(new GuiButton(3, this.width / 2 + 4, this.height - 52, 150, 20, I18n.format("Direct Login", new Object[0])));
      this.field_2694 = this.addButton(new GuiButton(4, this.width / 2 - 154, this.height - 28, 72, 20, "Add"));
      this.field_2692 = this.addButton(new GuiButton(2, this.width / 2 - 76, this.height - 28, 72, 20, "Remove"));
      this.addButton(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
      this.method_4060(this.field_2695.method_4051());
   }

   // $FF: renamed from: 0 () void
   public void method_4059() {
      this.field_2696 = !AltLogic.isOffline() && AltLogic.sessionValid();
      this.field_2697 = true;
   }

   // $FF: renamed from: 0 (dev.nuker.pyro.fn) void
   public void method_4060(@Nullable class_49 var1) {
      boolean var2 = var1 != null;
      this.field_2693.enabled = var2;
      this.field_2692.enabled = var2;
   }

   // $FF: renamed from: c (dev.nuker.pyro.fl) dev.nuker.pyro.fm
   public static class_48 method_4061(class_53 var0) {
      return var0.field_2695;
   }

   public void mouseReleased(int var1, int var2, int var3) {
      super.mouseReleased(var1, var2, var3);
      this.field_2695.mouseReleased(var1, var2, var3);
   }

   public void mouseClicked(int var1, int var2, int var3) {
      super.mouseClicked(var1, var2, var3);
      this.field_2695.mouseClicked(var1, var2, var3);
   }

   public void initGui() {
      this.field_2695 = new class_48(this, this.mc, this.width / 4 * 3, this.height, 32, this.height - 68, 46);
      Optional var1 = this.field_2695.field_2673.stream().filter(fl::c).findFirst();
      var1.ifPresent(this::1);
      this.method_4058();
      this.field_2699 = this.field_2690.method_4004(this.mc.getSession().getProfile());
   }

   public class_53(GuiScreen var1) {
      this.field_2691 = var1;
      this.field_2696 = false;
      this.field_2697 = false;
      (new Thread(this::0)).start();
   }

   // $FF: renamed from: c (dev.nuker.pyro.fn) boolean
   public static boolean method_4062(class_49 var0) {
      return var0.field_2679.getGameProfile().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId());
   }

   // $FF: renamed from: 1 (dev.nuker.pyro.fn) void
   public void method_4063(class_49 var1) {
      this.field_2695.method_4049(this.field_2695.field_2673.indexOf(var1));
   }
}
