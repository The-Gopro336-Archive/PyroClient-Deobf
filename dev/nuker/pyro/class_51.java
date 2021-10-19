/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import dev.nuker.pyro.alt.Alt;
import dev.nuker.pyro.alt.AltLogic;
import dev.nuker.pyro.alt.AltManager;
import net.minecraft.client.gui.GuiScreen;

// $FF: renamed from: dev.nuker.pyro.fj
public class class_51 extends class_50 {
   // $FF: renamed from: c dev.nuker.pyro.fl
   public class_53 field_2687;

   // $FF: renamed from: c (java.lang.String, dev.nuker.pyro.alt.Alt) boolean
   public static boolean method_4055(String var0, Alt var1) {
      return var1.getEmail().equals(var0);
   }

   // $FF: renamed from: 0 (java.lang.String, dev.nuker.pyro.alt.Alt) boolean
   public static boolean method_4056(String var0, Alt var1) {
      return var1.getUsername().equals(var0) && var1.isCracked();
   }

   // $FF: renamed from: c (dev.nuker.pyro.alt.Alt) void
   public void method_4057(Alt var1) {
      AltManager.INSTANCE.addAlt(var1);
      class_53.method_4061(this.field_2687).method_4048();
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) void
   public void method_4054(String var1, String var2) {
      if (var2.isEmpty()) {
         if (AltManager.INSTANCE.getAlts().stream().anyMatch(fj::0)) {
            this.0 = "There is already an account with that name";
         } else {
            this.method_4057(new Alt(var1));
            this.mc.displayGuiScreen(this.c);
         }
      } else {
         switch(AltLogic.verifyCredentials(var1, var2)) {
         case 0:
            if (AltManager.INSTANCE.getAlts().stream().anyMatch(fj::c)) {
               this.0 = "There is already an account with that email";
            }

            this.method_4057(new Alt(var1, AltLogic.yua.getSelectedProfile().getName(), var2, AltLogic.yua.getSelectedProfile().getId().toString()));
            AltLogic.yua.logOut();
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

   public class_51(class_53 var1, GuiScreen var2, String var3) {
      this.field_2687 = var1;
      super(var2, var3);
   }
}
