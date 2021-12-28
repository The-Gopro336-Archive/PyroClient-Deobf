/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.Vec3d
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import dev.nuker.pyro.Pyro;
import dev.nuker.pyro.Waypoint;
import dev.nuker.pyro.WaypointManager;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;

public class f3J
implements Command {
    public static f3J Field3866 = new f3J();

    public int Method152(CommandContext commandContext) {
        boolean bl;
        Vec3d vec3d;
        String string;
        block5: {
            string = StringArgumentType.Method5880(commandContext, "name");
            vec3d = new Vec3d(DoubleArgumentType.Method8094(commandContext, "x"), DoubleArgumentType.Method8094(commandContext, "y"), DoubleArgumentType.Method8094(commandContext, "z"));
            Iterable iterable = WaypointManager.Field6777.Method9798();
            boolean bl2 = false;
            if (iterable instanceof Collection && ((Collection)iterable).isEmpty()) {
                bl = false;
            } else {
                for (Object t : iterable) {
                    Waypoint waypoint = (Waypoint)t;
                    boolean bl3 = false;
                    if (!Intrinsics.Method6572(waypoint.Method9897(), string)) continue;
                    bl = true;
                    break block5;
                }
                bl = false;
            }
        }
        if (bl) {
            Pyro.Field6182.Method8986((Object)ChatFormatting.RED + "The waypoint '" + string + "' already exists");
        } else {
            WaypointManager.Field6777.Method9801(new Waypoint(string, vec3d.x, vec3d.y, vec3d.z, CollectionsKt.Method9007(Minecraft.getMinecraft().player.dimension)));
            Pyro.Field6182.Method8986((Object)ChatFormatting.GREEN + "Added waypoint '" + string + '\'');
        }
        return 0;
    }
}

