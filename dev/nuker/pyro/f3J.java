/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;

public class f3J implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3J
   public static f3J field_2043 = new f3J();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      Vec3d var3 = new Vec3d(DoubleArgumentType.getDouble(var1, "x"), DoubleArgumentType.getDouble(var1, "y"), DoubleArgumentType.getDouble(var1, "z"));
      Iterable var4 = (Iterable)WaypointManager.INSTANCE.getWaypoints();
      boolean var5 = false;
      boolean var10000;
      if (var4 instanceof Collection && ((Collection)var4).isEmpty()) {
         var10000 = false;
      } else {
         Iterator var6 = var4.iterator();

         while(true) {
            if (!var6.hasNext()) {
               var10000 = false;
               break;
            }

            Object var7 = var6.next();
            Waypoint var8 = (Waypoint)var7;
            boolean var9 = false;
            if (Intrinsics.areEqual((Object)var8.getName(), (Object)var2)) {
               var10000 = true;
               break;
            }
         }
      }

      if (var10000) {
         Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.RED + "The waypoint '" + var2 + "' already exists");
      } else {
         WaypointManager.INSTANCE.saveWaypoint(new Waypoint(var2, var3.x, var3.y, var3.z, CollectionsKt.listOf(Minecraft.getMinecraft().player.dimension)));
         Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.GREEN + "Added waypoint '" + var2 + '\'');
      }

      return 0;
   }
}
