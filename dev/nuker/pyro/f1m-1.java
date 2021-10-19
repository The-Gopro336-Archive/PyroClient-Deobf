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

public class f1m implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1m
   public static f1m field_2010 = new f1m();

   public int run(CommandContext var1) {
      if (PyroStatic.field_2595.method_472().method_3048().isEmpty()) {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("There are no listed cheststealer blocks")));
      } else {
         Iterator var3 = PyroStatic.field_2595.method_472().method_3048().iterator();

         while(var3.hasNext()) {
            String var2 = (String)var3.next();
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(var2)));
         }
      }

      return 0;
   }
}
