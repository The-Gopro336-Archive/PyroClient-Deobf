/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1B implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1B
   public static f1B field_2410 = new f1B();

   public int run(CommandContext var1) {
      if ((Boolean)PyroStatic.field_2612.c.method_3034()) {
         PyroStatic.field_2612.c.method_3033(false);
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Forced a remount.")));
      } else {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You have not forced a dismount.")));
      }

      return 0;
   }
}
