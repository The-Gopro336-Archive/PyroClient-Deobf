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

public class f19 implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f19
   public static f19 field_2404 = new f19();

   public int run(CommandContext var1) {
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Attempting to start server with port " + IntegerArgumentType.getInteger(var1, "port"))));
      PyroStatic.field_2605.method_779(IntegerArgumentType.getInteger(var1, "port"));
      return 0;
   }
}
