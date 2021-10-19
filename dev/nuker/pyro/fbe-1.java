/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class fbe extends Module {
   public fbe() {
      super("HUDEditor", "HUDEditor", (String)null, true);
   }

   // $FF: renamed from: c (boolean, net.minecraft.client.entity.EntityPlayerSP, net.minecraft.world.World) void
   public void method_116(boolean var1, @Nullable EntityPlayerSP var2, @Nullable World var3) {
      if (var1) {
         this.c.method_3033(false);
      }

      this.c.displayGuiScreen((GuiScreen)(new f5j()));
   }
}
