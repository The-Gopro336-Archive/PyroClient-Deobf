/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

// $FF: renamed from: dev.nuker.pyro.fB
public class class_14 extends TimerTask {
   // $FF: renamed from: c net.minecraft.client.Minecraft
   public Minecraft field_2276;

   public void run() {
      if (this.field_2276.world != null && Display.isCreated() && Display.isVisible()) {
         class_5.field_1004.method_1471();
      }

   }

   public class_14() {
      this.field_2276 = fdZ.field_976;
   }
}
