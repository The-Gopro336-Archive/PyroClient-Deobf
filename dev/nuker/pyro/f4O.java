/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

public class f4O extends f4P {
   public void mouseClicked(int var1, int var2, int var3) {
      super.mouseClicked(var1, var2, var3);
   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
   }

   public f4O() {
      this.c.add(new f4Y("Combat", 10.0F, 10.0F));
      this.c.add(new f4Y("Exploit", (float)this.c(), 10.0F));
      this.c.add(new f4Y("Movement", (float)this.c(), 10.0F));
      this.c.add(new f4Y("Misc", (float)this.c(), 10.0F));
      this.c.add(new f4Y("Render", (float)this.c(), 10.0F));
      this.c.add(new f4Y("World", (float)this.c(), 10.0F));
      this.c.add(new f4Y("Advanced", (float)this.c(), 10.0F));
   }
}
