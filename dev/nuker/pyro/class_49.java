/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

// $FF: renamed from: dev.nuker.pyro.fn
public class class_49 implements IGuiListEntry {
   // $FF: renamed from: c net.minecraft.util.ResourceLocation
   public static ResourceLocation field_2675 = new ResourceLocation("textures/gui/world_selection.png");
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2676;
   // $FF: renamed from: c dev.nuker.pyro.fl
   public class_53 field_2677;
   // $FF: renamed from: c dev.nuker.pyro.fm
   public class_48 field_2678;
   // $FF: renamed from: c dev.nuker.pyro.alt.Alt
   public Alt field_2679;
   // $FF: renamed from: c dev.nuker.pyro.fp
   public class_47 field_2680;
   // $FF: renamed from: c long
   public long field_2681;

   public void drawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, float var9) {
      String var10000;
      String var10;
      String var11;
      label331: {
         label330: {
            Minecraft.getMinecraft().player = this.field_2677.field_2690.field_2647;
            var10 = this.field_2679.getUsername();
            var11 = this.field_2679.isCracked() ? TextFormatting.RED + "Cracked" : TextFormatting.GRAY + this.field_2679.getEmail();
            if (this.field_2679.isCracked()) {
               if (this.field_2679.getGameProfile().getName().equals(Minecraft.getMinecraft().getSession().getProfile().getName())) {
                  break label330;
               }
            } else if (this.field_2679.getGameProfile().getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
               break label330;
            }

            var10000 = "";
            break label331;
         }

         var10000 = TextFormatting.BLUE + "In Use";
      }

      String var12 = var10000;
      String var13 = this.field_2679.isCracked() ? var12 : TextFormatting.GREEN + "Premium";
      this.field_2676.fontRenderer.drawString(var10, var2 + 32 + 3, var3 + 1, -1);
      this.field_2676.fontRenderer.drawString(var11, var2 + 32 + 3, var3 + this.field_2676.fontRenderer.FONT_HEIGHT + 3, -1);
      this.field_2676.fontRenderer.drawString(var13, var2 + 32 + 3, var3 + this.field_2676.fontRenderer.FONT_HEIGHT + this.field_2676.fontRenderer.FONT_HEIGHT + 3, -1);
      this.field_2676.fontRenderer.drawString(this.field_2679.isCracked() ? "" : var12, var2 + 32 + 3, var3 + this.field_2676.fontRenderer.FONT_HEIGHT * 3 + 3, -1);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_2677.field_2690.method_4006(var2 + 16, var3 + var5 - 2, 20, this.field_2680.field_2671);
      if (this.field_2676.gameSettings.touchscreen || var8) {
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, 0.0F, 100.0F);
         Gui.drawRect(var2, var3, var2 + 32, var3 + 42, (new Color(255, 255, 255, 30)).getRGB());
         GlStateManager.popMatrix();
      }

   }

   public void updatePosition(int var1, int var2, int var3, float var4) {
   }

   public void mouseReleased(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public boolean mousePressed(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.field_2678.method_4049(var1);
      this.field_2677.method_4060(this);
      if (var5 <= 32) {
         this.method_4052();
         return true;
      } else if (Minecraft.getSystemTime() - this.field_2681 < 250L) {
         this.method_4052();
         return true;
      } else {
         this.field_2681 = Minecraft.getSystemTime();
         return false;
      }
   }

   // $FF: renamed from: c () void
   public void method_4052() {
      AltManager.INSTANCE.makeFirst(this.field_2679);
      if (this.field_2679.isCracked()) {
         AltLogic.loginOffline(this.field_2679.getUsername());
      } else {
         switch(AltLogic.login(this.field_2679.getEmail(), this.field_2679.getPassword())) {
         case 0:
            this.field_2677.field_2697 = false;
            (new Thread(this::0)).start();
            this.field_2677.field_2698 = "";
            break;
         case 1:
            this.field_2677.field_2698 = "Invalid email or password";
            break;
         case 2:
            this.field_2677.field_2698 = "Unable to connect to authentication servers";
         }
      }

   }

   // $FF: renamed from: 0 () void
   public void method_4053() {
      this.field_2677.field_2696 = !AltLogic.isOffline() && AltLogic.sessionValid();
      this.field_2677.field_2697 = true;
   }

   public class_49(class_48 var1, Alt var2) {
      this.field_2678 = var1;
      this.field_2677 = var1.method_4047();
      this.field_2676 = Minecraft.getMinecraft();
      this.field_2679 = var2;
      this.field_2680 = this.field_2677.field_2690.method_4005(var2);
   }
}
