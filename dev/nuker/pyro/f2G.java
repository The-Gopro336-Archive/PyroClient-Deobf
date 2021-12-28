/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.Class12;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.f1s;
import java.util.Collection;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f2g
implements Command {
    public static f2g Field3879 = new f2g();

    public int Method152(@NotNull CommandContext commandContext) {
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Friends:"));
        ITextComponent iTextComponent = (ITextComponent)new TextComponentString("");
        int n = ((Collection)FriendManager.Field2145.Method8942().Method2781()).size();
        for (int i = 0; i < n; ++i) {
            iTextComponent.appendSibling(new TextComponentString(((Class12)FriendManager.Field2145.Method8942().Method2781().get(i)).Method4896()).setStyle(new Style().setColor(TextFormatting.DARK_AQUA)));
            if (i >= FriendManager.Field2145.Method8942().Method2781().size() - 1) continue;
            iTextComponent.appendSibling((ITextComponent)new TextComponentString(", "));
        }
        ((f1s)commandContext.Method6876()).Method5489(iTextComponent);
        return 0;
    }
}

