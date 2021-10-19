/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import kotlin.NoWhenBranchMatchedException;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f1G implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1G
   public static f1G field_2432 = new f1G();

   public int run(CommandContext var1) {
      f3e var10000 = f3e.field_2142;
      TextComponentString var10001 = new TextComponentString;
      boolean var2 = f1R.method_3707(f1R.field_2437, StringArgumentType.getString(var1, "name"));
      String var10003;
      if (var2) {
         var10003 = TextFormatting.GREEN + "Removed fake player";
      } else {
         if (var2) {
            throw new NoWhenBranchMatchedException();
         }

         var10003 = TextFormatting.RED + "That fake player does not exist";
      }

      var10001.<init>(var10003);
      var10000.method_3218((ITextComponent)var10001);
      return 0;
   }
}
