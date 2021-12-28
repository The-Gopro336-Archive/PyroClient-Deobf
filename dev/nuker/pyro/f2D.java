/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 *  org.jetbrains.annotations.NotNull
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.FriendManager;
import dev.nuker.pyro.f1s;
import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f2d
implements Command {
    public static f2d Field3822 = new f2d();

    public int Method152(@NotNull CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "name");
        List list = StringsKt.Method11514(string, new String[]{" "}, false, 0, 6, null);
        if (list != null) {
            if (list.size() > 1 && FriendManager.Field2145.Method8964((String)list.get(0), (String)list.get(1))) {
                ((f1s)commandContext.Method6876()).Method5489(new TextComponentString("Set friend " + (String)list.get(0) + " alias to: ").appendSibling(new TextComponentString((String)list.get(1)).setStyle(new Style().setColor(TextFormatting.DARK_AQUA))));
            }
        }
        return 0;
    }
}

