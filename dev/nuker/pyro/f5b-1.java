/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

public class f5b extends GuiScreen {
   // $FF: renamed from: c net.minecraft.client.gui.GuiScreen
   public GuiScreen field_1677;
   // $FF: renamed from: c dev.nuker.pyro.f5d
   public f5d field_1678;
   // $FF: renamed from: c java.lang.String
   public String field_1679;
   // $FF: renamed from: c dev.nuker.pyro.f5g
   public f5g field_1680;

   public void drawScreen(int var1, int var2, float var3) {
      this.field_1677.drawScreen(-1337, -1337, var3);
      this.field_1680.method_1639((float)var1, (float)var2, var3);
   }

   public f5b(String var1, GuiScreen var2, f5d var3) {
      this.field_1679 = var1;
      this.field_1677 = var2;
      this.field_1678 = var3;
      ScaledResolution var4 = new ScaledResolution(Minecraft.getMinecraft());
      float var5 = (float)(var4.getScaledWidth() / 2);
      float var6 = (float)(var4.getScaledHeight() / 2 + 40);
      this.field_1680 = new f5g(var1, var5, var6);
      f0w var7 = this.field_1678.method_1679().method_1654();
      if (var7 instanceof DoubleSetting) {
         DoubleSetting var8 = (DoubleSetting)var7;
         this.field_1680.method_1677().method_1624(String.valueOf(var8.c()));
      } else if (var7 instanceof IntegerSetting) {
         IntegerSetting var9 = (IntegerSetting)var7;
         this.field_1680.method_1677().method_1624(String.valueOf(var9.c()));
      }

   }

   public void mouseReleased(int var1, int var2, int var3) {
      this.field_1680.c(var1, var2, var3);
   }

   public void mouseClicked(int var1, int var2, int var3) {
      this.field_1680.method_1622(var1, var2, var3);
   }

   public void keyTyped(char var1, int var2) {
      if (Keyboard.getKeyName(var2).equals("ESCAPE")) {
         this.mc.displayGuiScreen(this.field_1677);
         Pyro.INSTANCE.sendMessage(this.field_1680.method_1677().method_1678());
      } else {
         if (Keyboard.getKeyName(var2).equals("RETURN")) {
            this.method_2944(true);
         } else {
            this.field_1680.method_1632(var1, var2);
         }

      }
   }

   // $FF: renamed from: c (boolean) void
   public void method_2944(boolean var1) {
      if (!var1) {
         this.mc.displayGuiScreen(this.field_1677);
      } else {
         try {
            f0w var2 = this.field_1678.method_1679().method_1654();
            if (var2 instanceof DoubleSetting) {
               DoubleSetting var3 = (DoubleSetting)var2;
               double var4 = Double.parseDouble(this.field_1680.method_1677().method_1678());
               var3.c(var4);
            } else if (var2 instanceof IntegerSetting) {
               IntegerSetting var7 = (IntegerSetting)var2;
               int var8 = Integer.parseInt(this.field_1680.method_1677().method_1678());
               var7.c(var8);
            }
         } catch (Exception var6) {
         }

         this.mc.displayGuiScreen(this.field_1677);
      }

   }
}
