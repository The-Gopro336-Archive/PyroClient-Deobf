/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import kotlin.text.StringsKt;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f3C implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3C
   public static f3C field_2037 = new f3C();

   public int run(CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "module");
      Iterator var4 = class_37.field_2633.method_3981().iterator();

      while(var4.hasNext()) {
         Module var3 = (Module)var4.next();
         String var5 = var3.method_127();
         if (StringsKt.startsWith(var5, var2, true)) {
            var3.method_115(-1);
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Set the bind of " + var3.method_127() + " to NONE")));
            break;
         }
      }

      return 0;
   }
}
