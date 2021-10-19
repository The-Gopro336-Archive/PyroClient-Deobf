/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.security.inject.LauncherEventHide;

public class f89 extends Module {
   // $FF: renamed from: c dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_468 = new BooleanSetting("showEnabled", "ShowEnabled", (String)null, true);
   // $FF: renamed from: 0 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_469 = new BooleanSetting("showDisabled", "ShowDisabled", (String)null, true);
   // $FF: renamed from: 1 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_470 = new BooleanSetting("combat", "Combat", (String)null, true);
   // $FF: renamed from: 2 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_471 = new BooleanSetting("exploit", "Exploit", (String)null, true);
   // $FF: renamed from: 3 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_472 = new BooleanSetting("movement", "Movement", (String)null, true);
   // $FF: renamed from: 4 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_473 = new BooleanSetting("misc", "Misc", (String)null, true);
   // $FF: renamed from: 5 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_474 = new BooleanSetting("render", "Render", (String)null, true);
   // $FF: renamed from: 6 dev.nuker.pyro.BooleanSetting
   public BooleanSetting field_475 = new BooleanSetting("world", "World", (String)null, true);

   // $FF: renamed from: c (dev.nuker.pyro.f44) void
   @f0g
   @LauncherEventHide
   public void method_689(f44 var1) {
      if (this.c.player != null && this.c.ingameGUI != null) {
         if ((Boolean)this.field_468.c() || !(Boolean)var1.method_3187().field_89.method_3034()) {
            if ((Boolean)this.field_469.c() || (Boolean)var1.method_3187().field_89.method_3034()) {
               if (var1.method_3187().method_129() != null) {
                  if (!var1.method_3187().method_129().equals("Combat") || (Boolean)this.field_470.c()) {
                     if (!var1.method_3187().method_129().equals("Exploit") || (Boolean)this.field_471.c()) {
                        if (!var1.method_3187().method_129().equals("Movement") || (Boolean)this.field_472.c()) {
                           if (!var1.method_3187().method_129().equals("Misc") || (Boolean)this.field_473.c()) {
                              if (!var1.method_3187().method_129().equals("Render") || (Boolean)this.field_474.c()) {
                                 if (!var1.method_3187().method_129().equals("World") || (Boolean)this.field_475.c()) {
                                    if ((Boolean)var1.method_3187().field_89.method_3034()) {
                                       Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + var1.method_3187().method_127() + " has been enabled.");
                                    } else {
                                       Pyro.INSTANCE.sendMessage(ChatFormatting.RED + var1.method_3187().method_127() + " has been disabled.");
                                    }

                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public f89() {
      super("chatnotifier", "ChatNotifier", "Notifies you in chat when a module is enabled/disabled depending on what is filtered", true);
      this.register(this.field_468);
      this.register(this.field_469);
      this.register(this.field_470);
      this.register(this.field_471);
      this.register(this.field_472);
      this.register(this.field_473);
      this.register(this.field_474);
      this.register(this.field_475);
   }
}
