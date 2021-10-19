/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

public class f3L implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3L
   public static f3L field_2045 = new f3L();

   public int run(CommandContext var1) {
      Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.YELLOW + "Waypoints (" + WaypointManager.INSTANCE.getWaypoints().size() + "):");
      Iterable var2 = (Iterable)WaypointManager.INSTANCE.getWaypoints();
      boolean var3 = false;
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         Waypoint var6 = (Waypoint)var5;
         boolean var7 = false;
         Pyro.INSTANCE.sendAndKeepMessage(ChatFormatting.GRAY + "- " + ChatFormatting.YELLOW + var6.getName() + " (Dimensions: " + CollectionsKt.joinToString$default((Iterable)var6.getDimensions(), (CharSequence)", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null) + ')');
      }

      return 0;
   }
}
