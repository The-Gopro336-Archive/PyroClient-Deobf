/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1b implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1b
   public static f1b field_1975 = new f1b();

   public int run(CommandContext var1) {
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempting to connect to " + StringArgumentType.getString(var1, "host") + IntegerArgumentType.getInteger(var1, "port"))));
      PyroStatic.field_2605.method_784(StringArgumentType.getString(var1, "host"), IntegerArgumentType.getInteger(var1, "port"));
      return 0;
   }
}
