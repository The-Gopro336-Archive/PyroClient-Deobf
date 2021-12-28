/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractHorse
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import dev.nuker.pyro.f0d;
import dev.nuker.pyro.f1s;
import dev.nuker.pyro.fdZ;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f2n
implements Command {
    public static f2n Field3907 = new f2n();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int Method152(CommandContext commandContext) {
        block16: {
            block17: {
                String string;
                block18: {
                    String string2;
                    String string3 = StringArgumentType.Method5880(commandContext, "type");
                    boolean bl = false;
                    String string4 = string3;
                    if (string4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    string3 = string2 = string4.toLowerCase();
                    switch (string3.hashCode()) {
                        case -666719309: {
                            if (!string3.equals("mobowner")) return 0;
                            break block16;
                        }
                        case 806538016: {
                            if (!string3.equals("mobowners")) return 0;
                            break block16;
                        }
                        case 3367: {
                            if (!string3.equals("ip")) return 0;
                            break;
                        }
                        case 3373707: {
                            if (!string3.equals("name")) return 0;
                            break block17;
                        }
                        case -1354750946: {
                            if (!string3.equals("coords")) return 0;
                            break block18;
                        }
                    }
                    if (fdZ.Field313.isSingleplayer()) {
                        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("You are in singleplayer!"));
                        return 0;
                    }
                    if (fdZ.Field313.getCurrentServerData() == null) return 0;
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    ServerData serverData = fdZ.Field313.getCurrentServerData();
                    if (serverData == null) {
                        Intrinsics.Method6551();
                    }
                    clipboard.setContents(new StringSelection(serverData.serverIP), null);
                    ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Copied the server IP"));
                    return 0;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.Field4618;
                String string5 = "X: %s, Y: %s, Z: %s";
                Object[] arrobject = new Object[]{(int)fdZ.Field313.player.posX, (int)fdZ.Field313.player.posY, (int)fdZ.Field313.player.posZ};
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                boolean bl = false;
                String string6 = string = String.format(string5, Arrays.copyOf(arrobject, arrobject.length));
                clipboard.setContents(new StringSelection(string6), null);
                return 0;
            }
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(String.valueOf(fdZ.Field313.player.getName())), null);
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Copied the player name"));
            return 0;
        }
        if (fdZ.Field313.objectMouseOver != RayTraceResult.Type.ENTITY) {
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("No entity found in crosshair."));
            return 0;
        }
        Entity entity = fdZ.Field313.objectMouseOver.entityHit;
        if (entity == null) return 0;
        UUID uUID = null;
        if (entity instanceof EntityWolf) {
            if (((EntityWolf)entity).isTamed()) {
                uUID = ((EntityWolf)entity).getOwnerId();
            }
        } else if (entity instanceof AbstractHorse && ((AbstractHorse)entity).isTame()) {
            uUID = ((AbstractHorse)entity).getOwnerUniqueId();
        }
        if (uUID != null) {
            String string = f0d.Field5595.Method7942(StringsKt.Method9968(uUID.toString(), "-", "", false, 4, null));
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), null);
            ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("Owner: " + string));
            return 0;
        }
        ((f1s)commandContext.Method6876()).Method5489((ITextComponent)new TextComponentString("This entity has no owner."));
        return 0;
    }
}

