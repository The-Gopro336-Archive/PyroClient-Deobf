/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Waypoint;
import dev.nuker.pyro.WaypointManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

public class f3K
implements Command {
    public static f3K Field3868 = new f3K();

    /*
     * Enabled aggressive block sorting
     */
    public int Method152(CommandContext commandContext) {
        boolean bl;
        Waypoint waypoint;
        Object t2;
        boolean bl2;
        boolean bl3;
        Iterable iterable;
        String string;
        block5: {
            string = StringArgumentType.Method5880(commandContext, "name");
            iterable = WaypointManager.Field6777.Method9798();
            bl3 = false;
            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                bl2 = false;
            } else {
                for (Object t2 : iterable) {
                    waypoint = (Waypoint)t2;
                    bl = false;
                    if (!Intrinsics.Method6572(waypoint.Method9897(), string)) continue;
                    bl2 = true;
                    break block5;
                }
                bl2 = false;
            }
        }
        if (!bl2) {
            Pyro.Field6182.Method8986((Object)ChatFormatting.RED + "The waypoint '" + string + "' does not exist");
            return 0;
        }
        iterable = WaypointManager.Field6777.Method9798();
        WaypointManager waypointManager = WaypointManager.Field6777;
        bl3 = false;
        Iterator iterator2 = iterable.iterator();
        do {
            if (!iterator2.hasNext()) throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
            t2 = iterator2.next();
            waypoint = (Waypoint)t2;
            bl = false;
        } while (!Intrinsics.Method6572(waypoint.Method9897(), string));
        Object t3 = t2;
        waypointManager.Method9800((Waypoint)t3);
        Pyro.Field6182.Method8986((Object)ChatFormatting.GREEN + "Removed waypoint '" + string + '\'');
        return 0;
    }
}

