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
import org.apache.commons.io.FileUtils;

public class f3b implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3b
   public static f3b field_2137 = new f3b();

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
      if (var4 != null) {
         FileUtils.deleteDirectory(var4.method_3272());
      }

      f66 var11 = new f66(new File(Pyro.FOLDER, "profiles/" + var2), var2);
      var11.method_3272().mkdirs();
      FileUtils.copyDirectory(f67.field_2201.method_3277().method_3272(), var11.method_3272());
      Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Force copied profile " + f67.field_2201.method_3277().method_3273() + " into " + var2);
      f67.field_2201.method_3276(var11);
      return 0;
   }
}
