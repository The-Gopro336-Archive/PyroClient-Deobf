/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Waypoint;
import dev.nuker.pyro.WaypointManager;
import kotlin.collections.CollectionsKt;

public class f3L
implements Command {
    public static f3L Field3870 = new f3L();

    public int Method152(CommandContext commandContext) {
        Pyro.Field6182.Method8986((Object)ChatFormatting.YELLOW + "Waypoints (" + WaypointManager.Field6777.Method9798().size() + "):");
        Iterable iterable = WaypointManager.Field6777.Method9798();
        boolean bl = false;
        for (Object t : iterable) {
            Waypoint waypoint = (Waypoint)t;
            boolean bl2 = false;
            Pyro.Field6182.Method8986((Object)ChatFormatting.GRAY + "- " + (Object)ChatFormatting.YELLOW + waypoint.Method9897() + " (Dimensions: " + CollectionsKt.Method3238(waypoint.Method9905(), ", ", null, null, 0, null, null, 62, null) + ')');
        }
        return 0;
    }
}

