/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.TextFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.PyroStatic;
import dev.nuker.pyro.f1s;
import kotlin.text.StringsKt;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1p
implements Command {
    public static f1p Field3760 = new f1p();

    public int Method152(CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "block");
        if (!StringsKt.Method11503(string, ":", false, 2, null)) {
            string = "minecraft:" + string;
        }
        if (Item.REGISTRY.containsKey((Object)new ResourceLocation(string))) {
            if (!PyroStatic.Field6531.Method5348().Method5367().contains(string)) {
                ((f1s)commandContext.Method6876()).Method5489(new TextComponentString(string + " is not an cheststealer block").setStyle(new Style().setColor(TextFormatting.RED)));
            } else {
                PyroStatic.Field6531.Method5348().Method5367().remove(string);
                ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Removed cheststealer block " + string));
                PyroStatic.Field6531.Method2486();
                if (((Boolean)PyroStatic.Field6531.Field5236.Method5264()).booleanValue()) {
                    PyroStatic.Field6531.Method205(true, null, null);
                }
            }
        } else {
            ((f1s)commandContext.Method6876()).Method5489(new TextComponentString(string + " is not a valid block").setStyle(new Style().setColor(TextFormatting.RED)));
        }
        return 0;
    }
}

