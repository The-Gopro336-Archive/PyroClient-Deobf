/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.realms.RealmsBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({GuiIngameMenu.class})
public class GuiIngameMenuMixin {
   @Inject(
      method = {"actionPerformed"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onDisconnectPressed(GuiButton button, CallbackInfo ci) {
      if (button.id == 1 && (Boolean)PyroStatic.field_2478.c.method_3034() && (Boolean)PyroStatic.field_2478.field_457.c()) {
         GuiYesNo g = new GuiYesNo((result, id) -> {
            if (result) {
               boolean flag = Minecraft.getMinecraft().isIntegratedServerRunning();
               boolean flag1 = Minecraft.getMinecraft().isConnectedToRealms();
               button.enabled = false;
               Minecraft.getMinecraft().world.sendQuittingDisconnectingPacket();
               Minecraft.getMinecraft().loadWorld((WorldClient)null);
               if (flag) {
                  Minecraft.getMinecraft().displayGuiScreen(new GuiMainMenu());
               } else if (flag1) {
                  RealmsBridge realmsbridge = new RealmsBridge();
                  realmsbridge.switchToRealms(new GuiMainMenu());
               } else {
                  Minecraft.getMinecraft().displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
               }
            } else {
               Minecraft.getMinecraft().displayGuiScreen((GuiIngameMenu)this);
            }

         }, "Do you really want to disconnect?", "", 0);
         Minecraft.getMinecraft().displayGuiScreen(g);
         ci.cancel();
      }

   }
}
