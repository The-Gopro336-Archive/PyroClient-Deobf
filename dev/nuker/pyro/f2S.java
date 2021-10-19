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

public class f2S implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2S
   public static f2S field_2003 = new f2S();

   public int run(CommandContext var1) {
      if (PyroStatic.field_2568.method_1243().method_1983().isEmpty()) {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("There are no listed nuker blocks")));
      } else {
         Iterator var3 = PyroStatic.field_2568.method_1243().method_1983().iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(var2)));
         }
      }

      return 0;
   }
}
