/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketChat
 *  net.minecraft.util.text.ChatType
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextComponentTranslation
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro;

import dev.nuker.pyro.BooleanSetting;
import dev.nuker.pyro.Class12;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.Module;
import dev.nuker.pyro.f0g;
import dev.nuker.pyro.f41;
import dev.nuker.pyro.f4e;
import dev.nuker.pyro.security.inject.LauncherEventHide;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class fbo
extends Module {
    public BooleanSetting Field157 = new BooleanSetting("color", "Color", null, true);

    public fbo() {
        super("nameprotect", "NameProtect", "Displays friends names with their aliases in nametags and chat", true);
        this.Method7264(this.Field157);
    }

    @f0g
    @LauncherEventHide
    public void Method244(f4e f4e2) {
        TextComponentString textComponentString;
        TextComponentTranslation textComponentTranslation;
        ITextComponent iTextComponent;
        SPacketChat sPacketChat;
        if (f4e2.Method5619() == f41.Pre && f4e2.Method5784() instanceof SPacketChat && (sPacketChat = (SPacketChat)f4e2.Method5784()).getType() == ChatType.CHAT && (iTextComponent = sPacketChat.getChatComponent()) instanceof TextComponentTranslation && (textComponentTranslation = (TextComponentTranslation)iTextComponent).getFormatArgs().length > 0 && textComponentTranslation.getFormatArgs()[0] instanceof TextComponentString && !(textComponentString = (TextComponentString)textComponentTranslation.getFormatArgs()[0]).getSiblings().isEmpty()) {
            TextComponentString textComponentString2;
            Class12 class12;
            if (textComponentString.getSiblings().get(0) instanceof TextComponentString && (class12 = FriendManager.Field2145.Method8948((textComponentString2 = (TextComponentString)textComponentString.getSiblings().get(0)).getText())) != null) {
                if (((Boolean)this.Field157.Method7979()).booleanValue()) {
                    textComponentString.getSiblings().set(0, new TextComponentString(class12.Method4889()).setStyle(new Style().setColor(TextFormatting.DARK_AQUA)));
                } else {
                    textComponentString.getSiblings().set(0, new TextComponentString(class12.Method4889()));
                }
            }
        }
    }
}

