/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f3N implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3N
   public static f3N field_2113 = new f3N();

   public int run(CommandContext var1) {
      if (PyroStatic.field_2488.method_1046().method_2817().isEmpty()) {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("There are no listed xray blocks")));
      } else {
         Iterator var3 = PyroStatic.field_2488.method_1046().method_2817().iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(var2)));
         }
      }

      return 0;
   }
}
