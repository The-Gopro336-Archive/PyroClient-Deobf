/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.google.common.collect.Lists;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
public class f4K extends GuiScreen {
   // $FF: renamed from: c java.util.List
   public List field_2145;
   // $FF: renamed from: c net.minecraft.client.gui.GuiScreen
   @NotNull
   public GuiScreen field_2146;

   public void initGui() {
      this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 155 + 80, this.height / 6 + 110, "OK"));
      this.field_2145.clear();
      this.field_2145.addAll((Collection)this.fontRenderer.listFormattedStringToWidth("The default GUI Bind is Right Control. You can change it in the minecraft options menu.", this.width - 50));
      this.field_2145.add("");
      this.field_2145.addAll((Collection)this.fontRenderer.listFormattedStringToWidth("The default chat prefix is $. You can change it using $prefix", this.width - 50));
   }

   public f4K(@NotNull GuiScreen var1) {
      this.field_2146 = var1;
      this.field_2145 = (List)Lists.newArrayList();
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRenderer, "Pyro Client", this.width / 2, 70, -1);
      int var4 = 90;

      for(Iterator var6 = this.field_2145.iterator(); var6.hasNext(); var4 += this.fontRenderer.FONT_HEIGHT + 2) {
         String var5 = (String)var6.next();
         this.drawCenteredString(this.fontRenderer, ChatFormatting.GRAY + var5, this.width / 2, var4, -1);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void actionPerformed(@NotNull GuiButton var1) {
      Minecraft.getMinecraft().displayGuiScreen(this.field_2146);
      Config.INSTANCE.seenInitialScreen = true;
      Config.Companion.save();
   }

   // $FF: renamed from: c () net.minecraft.client.gui.GuiScreen
   @NotNull
   public GuiScreen method_3220() {
      return this.field_2146;
   }
}
