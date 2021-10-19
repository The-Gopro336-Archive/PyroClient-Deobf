/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class f39 implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f39
   public static f39 field_2034 = new f39();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      List var3 = f67.field_2201.method_3278();
      Iterable var5 = (Iterable)var3;
      boolean var6 = false;
      Iterator var7 = var5.iterator();

      Object var10000;
      while(true) {
         if (var7.hasNext()) {
            Object var8 = var7.next();
            f66 var9 = (f66)var8;
            boolean var10 = false;
            if (!Intrinsics.areEqual((Object)var9.method_3273(), (Object)var2)) {
               continue;
            }

            var10000 = var8;
            break;
         }

         var10000 = null;
         break;
      }

      f66 var4 = (f66)var10000;
      if (var4 == null) {
         f67.field_2201.method_3276(new f66(new File(Pyro.FOLDER, "profiles/" + var2), var2));
         Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Created profile " + var2);
      } else {
         Pyro.INSTANCE.sendMessage(ChatFormatting.RED + "Profile " + var2 + " already exists");
      }

      return 0;
   }
}
