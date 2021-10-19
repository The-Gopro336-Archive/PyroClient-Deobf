/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

public class f3K implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3K
   public static f3K field_2044 = new f3K();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      Iterable var3 = (Iterable)WaypointManager.INSTANCE.getWaypoints();
      boolean var4 = false;
      boolean var10000;
      Iterator var5;
      Object var6;
      Waypoint var7;
      boolean var8;
      if (var3 instanceof Collection && ((Collection)var3).isEmpty()) {
         var10000 = false;
      } else {
         var5 = var3.iterator();

         while(true) {
            if (!var5.hasNext()) {
               var10000 = false;
               break;
            }

            var6 = var5.next();
            var7 = (Waypoint)var6;
            var8 = false;
            if (Intrinsics.areEqual((Object)var7.getName(), (Object)var2)) {
               var10000 = true;
               break;
            }
         }
      }

      if (var10000) {
         WaypointManager var11 = WaypointManager.INSTANCE;
         var3 = (Iterable)WaypointManager.INSTANCE.getWaypoints();
         WaypointManager var9 = var11;
         var4 = false;
         var5 = var3.iterator();

         do {
            if (!var5.hasNext()) {
               throw (Throwable)(new NoSuchElementException("Collection contains no element matching the predicate."));
            }

            var6 = var5.next();
            var7 = (Waypoint)var6;
            var8 = false;
         } while(!Intrinsics.areEqual((Object)var7.getName(), (Object)var2));

         var9.deleteWaypoint((Waypoint)var6);
         Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.GREEN + "Removed waypoint '" + var2 + '\'');
      } else {
         Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.RED + "The waypoint '" + var2 + "' does not exist");
      }

      return 0;
   }
}
