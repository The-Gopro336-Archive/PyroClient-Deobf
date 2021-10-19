/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;

public class f38 implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f38
   public static f38 field_2031 = new f38();

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
         if (Intrinsics.areEqual((Object)f67.field_2201.method_3277().method_3273(), (Object)var2)) {
            f67.field_2201.method_3276(f67.field_2201.method_3281());
         }

         FileUtils.deleteDirectory(var4.method_3272());
         Pyro.INSTANCE.sendMessage(ChatFormatting.GREEN + "Deleted profile " + var2);
      } else {
         Pyro.INSTANCE.sendMessage(ChatFormatting.RED + "Profile " + var2 + " does not exist");
      }

      return 0;
   }
}
