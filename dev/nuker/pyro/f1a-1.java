/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class f1a implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1a
   public static f1a field_1973 = new f1a();

   public int run(CommandContext var1) {
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempting to connect to port " + IntegerArgumentType.getInteger(var1, "port"))));
      PyroStatic.field_2605.method_784("localhost", IntegerArgumentType.getInteger(var1, "port"));
      return 0;
   }
}
