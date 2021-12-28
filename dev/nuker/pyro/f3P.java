/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
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
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f3p
implements Command {
    public static f3p Field4082 = new f3p();

    public int Method152(CommandContext commandContext) {
        String string = StringArgumentType.Method5880(commandContext, "block");
        if (!StringsKt.Method11503(string, ":", false, 2, null)) {
            string = "minecraft:" + string;
        }
        if (Block.REGISTRY.containsKey((Object)new ResourceLocation(string))) {
            if (PyroStatic.Field6520.Method2488().Method2451().contains(string)) {
                ((f1s)commandContext.Method6876()).Method5489(new TextComponentString(string + " is already an search block").setStyle(new Style().setColor(TextFormatting.RED)));
            } else {
                PyroStatic.Field6520.Method2488().Method2451().add(string);
                ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Added search block " + string));
                PyroStatic.Field6520.Method2491();
                if (((Boolean)PyroStatic.Field6520.Field5236.Method5264()).booleanValue()) {
                    PyroStatic.Field6520.Method205(true, null, null);
                }
            }
        } else {
            ((f1s)commandContext.Method6876()).Method5489(new TextComponentString(string + " is not a valid block").setStyle(new Style().setColor(TextFormatting.RED)));
        }
        return 0;
    }
}

