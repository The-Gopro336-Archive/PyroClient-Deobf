/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import kotlin.jvm.functions.Function1;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f2b implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2b
   public static f2b field_2036 = new f2b();

   public int run(CommandContext var1) {
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.GREEN + "Attempting to overwrite other clients' friend lists")));
      f3e.field_2142.method_3218((ITextComponent)(new TextComponentString(TextFormatting.YELLOW + "Most clients cannot reload friends lists ingame. You will have to restart minecraft to see the change.")));
      f25 var2 = f25.field_7;
      var2.method_50("future", (Function1)f26.field_6);
      var2.method_50("impact", (Function1)f27.field_5);
      var2.method_50("summit", (Function1)f28.field_4);
      var2.method_50("salhack", (Function1)f29.field_9);
      var2.method_50("ares", (Function1)f2a.field_20);
      return 0;
   }
}
