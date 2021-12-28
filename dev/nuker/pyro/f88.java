/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.text.ChatType
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f0o;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.f86;
import dev.nuker.pyro.f87;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f88
extends Module {
    public BooleanSetting Field3276 = new BooleanSetting("prefix", "Prefix", null, true);
    public f0o<f87> Field3277 = new f0o("self", "Self", null, f87.Red);
    public f0o<f87> Field3278 = new f0o("players", "Players", null, f87.Gray);
    public f0o<f87> Field3279 = new f0o("brackets", "Brackets", null, f87.DarkGray);
    public static boolean Field3280 = !f88.class.desiredAssertionStatus();

    public ChatFormatting Method5147(f0o f0o2) {
        switch (f86.Field3324[((f87)((Object)f0o2.Method7979())).ordinal()]) {
            case 1: {
                return ChatFormatting.WHITE;
            }
            case 2: {
                return ChatFormatting.GRAY;
            }
            case 3: {
                return ChatFormatting.DARK_GRAY;
            }
            case 4: {
                return ChatFormatting.RED;
            }
            case 5: {
                return ChatFormatting.DARK_RED;
            }
            case 6: {
                return ChatFormatting.GREEN;
            }
            case 7: {
                return ChatFormatting.DARK_GREEN;
            }
            case 8: {
                return ChatFormatting.BLUE;
            }
            case 9: {
                return ChatFormatting.DARK_BLUE;
            }
            case 10: {
                return ChatFormatting.AQUA;
            }
            case 11: {
                return ChatFormatting.YELLOW;
            }
            case 12: {
                return ChatFormatting.GOLD;
            }
        }
        return ChatFormatting.RESET;
    }

    @f0g
    @LauncherEventHide
    public void Method244(f4e f4e2) {
        block9: {
            String string;
            TextComponentString textComponentString;
            block11: {
                block10: {
                    if (f4e2.Method5619() != f41.Pre) {
                        return;
                    }
                    if (!(f4e2.Method5784() instanceof SPacketChat)) break block9;
                    SPacketChat sPacketChat = (SPacketChat)f4e2.Method5784();
                    if (!(sPacketChat.getChatComponent() instanceof TextComponentString) || sPacketChat.getType() == ChatType.GAME_INFO) {
                        return;
                    }
                    textComponentString = (Boolean)this.Field3276.Method7979() != false ? Pyro.Method8977() : new TextComponentString("");
                    string = sPacketChat.getChatComponent().getFormattedText();
                    if (!string.toLowerCase().contains("to")) break block10;
                    if (!string.toLowerCase().contains("whisper")) break block10;
                    if (string.toLowerCase().contains(":")) break block11;
                }
                if (this.Field3277 != null) {
                    if (this.Field3278 != null && (string = string.replaceAll("(?i)" + this.Field5233.player.getName(), (Object)this.Method5147(this.Field3277) + this.Field5233.player.getName() + (Object)ChatFormatting.RESET)).contains("<") && string.contains(">")) {
                        string = string.replaceFirst("<", (Object)this.Method5147(this.Field3279) + "[" + (Object)this.Method5147(this.Field3278)).replaceFirst(">", (Object)this.Method5147(this.Field3279) + "]" + (Object)ChatFormatting.RESET);
                    }
                }
            }
            f4e2.Method7948();
            if (Minecraft.getMinecraft().ingameGUI != null || this.Field5233.player == null) {
                if (!Field3280 && Minecraft.getMinecraft().ingameGUI == null) {
                    throw new AssertionError();
                }
                Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("").appendSibling((ITextComponent)textComponentString).appendSibling((ITextComponent)new TextComponentString(string + (Object)ChatFormatting.RESET)));
            }
        }
    }

    public f88() {
        super("betterchat", "BetterChat", "Makes chat more customizable.", true);
        this.Method7264(this.Field3276);
        this.Method7264(this.Field3277);
        this.Method7264(this.Field3278);
        this.Method7264(this.Field3279);
    }
}

