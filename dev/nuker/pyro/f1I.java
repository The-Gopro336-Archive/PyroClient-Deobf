/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1I implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1I
   public static f1I field_2422 = new f1I();

   public int run(CommandContext var1) {
      f1R.field_2437.method_3706();
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.GREEN + "Deleted all fake players")));
      return 0;
   }
}
