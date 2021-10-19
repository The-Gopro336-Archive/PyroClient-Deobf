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

public class f2x implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2x
   public static f2x field_2135 = new f2x();

   public int run(CommandContext var1) {
      Iterator var3 = class_37.field_2633.method_3981().iterator();

      while(var3.hasNext()) {
         Module var2 = (Module)var3.next();
         var2.field_89.method_3033(false);
      }

      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("All modules turned off.")));
      return 0;
   }
}
