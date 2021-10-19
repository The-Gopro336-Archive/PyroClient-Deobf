/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class f5n extends ScaledResolution {
   // $FF: renamed from: c int
   public int field_1693;
   // $FF: renamed from: 0 int
   public int field_1694;

   public int getScaledWidth() {
      return this.field_1693;
   }

   public f5n(int var1, int var2, Minecraft var3) {
      this.field_1693 = var1;
      this.field_1694 = var2;
      super(var3);
   }

   public int getScaledHeight() {
      return this.field_1694;
   }
}
