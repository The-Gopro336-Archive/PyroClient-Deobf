/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiIngameMenu
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiYesNo
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.realms.RealmsBridge
 */
package dev.nuker.pyro.mixin;

import dev.nuker.pyro.PyroStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.realms.RealmsBridge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Class0;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiIngameMenu.class})
public class GuiIngameMenuMixin {
    @Inject(method={"actionPerformed"}, at={@Class0(value="HEAD")}, cancellable=true)
    private void Method3257(GuiButton button, CallbackInfo ci) {
        if (button.id == 1 && ((Boolean)PyroStatic.Field6414.Field5236.Method5264()).booleanValue() && ((Boolean)PyroStatic.Field6414.Field3320.Method7979()).booleanValue()) {
            GuiYesNo g = new GuiYesNo((result, id) -> {
                if (result) {
                    boolean flag = Minecraft.getMinecraft().isIntegratedServerRunning();
                    boolean flag1 = Minecraft.getMinecraft().isConnectedToRealms();
                    button.enabled = false;
                    Minecraft.getMinecraft().world.sendQuittingDisconnectingPacket();
                    Minecraft.getMinecraft().loadWorld((WorldClient)null);
                    if (flag) {
                        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMainMenu());
                    } else if (flag1) {
                        RealmsBridge realmsbridge = new RealmsBridge();
                        realmsbridge.switchToRealms((GuiScreen)new GuiMainMenu());
                    } else {
                        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
                    }
                } else {
                    Minecraft.getMinecraft().displayGuiScreen((GuiScreen)((GuiIngameMenu)this));
                }
            }, "Do you really want to disconnect?", "", 0);
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)g);
            ci.Method9034();
        }
    }
}

