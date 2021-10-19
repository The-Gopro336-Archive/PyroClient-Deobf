/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.alt.AltLogic;
import net.minecraft.client.gui.GuiScreen;

// $FF: renamed from: dev.nuker.pyro.fk
public class class_52 extends class_50 {
   // $FF: renamed from: c dev.nuker.pyro.fl
   public class_53 field_2688;

   public class_52(class_53 var1, GuiScreen var2, String var3) {
      this.field_2688 = var1;
      super(var2, var3);
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) void
   public void method_4054(String var1, String var2) {
      if (var2.isEmpty()) {
         AltLogic.loginOffline(var1);
         this.mc.displayGuiScreen(this.c);
      } else {
         switch(AltLogic.login(var1, var2)) {
         case 0:
            this.mc.displayGuiScreen(this.c);
            break;
         case 1:
            this.0 = "Invalid email or password";
            break;
         case 2:
            this.0 = "Unable to connect to authentication servers";
         }
      }

   }
}
