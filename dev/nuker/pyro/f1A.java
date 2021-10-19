/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1A implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1A
   public static f1A field_2408 = new f1A();

   public int run(CommandContext var1) {
      if (!(Boolean)PyroStatic.field_2612.c.method_3034()) {
         if (fdZ.field_976.player.isRiding()) {
            PyroStatic.field_2612.c.method_3033(true);
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Forced a dismount.")));
         } else {
            ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You are not riding an entity.")));
         }
      } else {
         ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("You have already forced a dismount.")));
      }

      return 0;
   }
}
