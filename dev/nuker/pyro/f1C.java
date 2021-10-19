/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1C implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1C
   public static f1C field_2417 = new f1C();

   public int run(CommandContext var1) {
      if ((Boolean)PyroStatic.field_2612.c.method_3034()) {
         PyroStatic.field_2612.method_734((Entity)null);
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Reset the riding entity")));
      } else {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You have not forced a dismount.")));
      }

      return 0;
   }
}
