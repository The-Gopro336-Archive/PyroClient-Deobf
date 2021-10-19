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
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

public class f1y implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1y
   public static f1y field_2020 = new f1y();

   public int run(@Nullable CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "module");
      Iterator var4 = class_37.field_2633.method_3981().iterator();

      while(var4.hasNext()) {
         Module var3 = (Module)var4.next();
         String var5 = var3.method_127();
         if (StringsKt.startsWith(var5, var2, true)) {
            var3.method_131().method_3033(!(Boolean)var3.method_131().method_3034());
            if ((Boolean)var3.method_131().method_3034()) {
               Pyro.INSTANCE.sendMessage("" + var3.method_127() + " is now " + ChatFormatting.RED + "hidden.");
            } else {
               Pyro.INSTANCE.sendMessage(var3.method_127() + " is now " + ChatFormatting.GREEN + "shown.");
            }

            class_5.field_1004.method_1466(var3);
            break;
         }
      }

      return 0;
   }
}
