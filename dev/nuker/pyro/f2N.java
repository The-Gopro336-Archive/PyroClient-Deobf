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

public class f2N implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2N
   public static f2N field_2011 = new f2N();

   public int run(CommandContext var1) {
      String var2 = "[";
      boolean var3 = true;
      Iterator var5 = class_37.field_2633.method_3981().iterator();

      while(var5.hasNext()) {
         Module var4 = (Module)var5.next();
         String var6 = var4.method_127();
         if (var3) {
            var3 = false;
            var2 = var2 + var6;
         } else {
            var2 = var2 + ' ' + var6;
         }
      }

      var2 = var2 + "]";
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString(var2)));
      return 0;
   }
}
