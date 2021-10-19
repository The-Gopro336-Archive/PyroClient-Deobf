/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.gui.ScaledResolution;

public class f5j extends f4P {
   public f5j() {
      this.c = 120;
      this.c.add(new f4U("Combat", (float)this.c(), 10.0F));
      this.c.add(new f4U("General", (float)this.c(), 10.0F));
      this.c.add(new f4U("Misc", (float)this.c(), 10.0F));
   }

   public void mouseReleased(int var1, int var2, int var3) {
      super.mouseReleased(var1, var2, var3);
      class_5.field_1004.method_1467();
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void mouseClicked(int var1, int var2, int var3) {
      super.mouseClicked(var1, var2, var3);
      class_5.field_1004.method_1488(var1, var2, var3);
   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      ScaledResolution var4 = new ScaledResolution(this.mc);
      class_5.field_1004.method_1468(var4, var1, var2, true);
   }
}
