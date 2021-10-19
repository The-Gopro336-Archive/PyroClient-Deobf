/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class f3c implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3c
   public static f3c field_2139 = new f3c();

   public int run(CommandContext var1) {
      PyroStatic.field_2467.method_1219(new BlockPos(IntegerArgumentType.getInteger(var1, "x"), IntegerArgumentType.getInteger(var1, "y"), IntegerArgumentType.getInteger(var1, "z")));
      ((f1s)var1.getSource()).method_3083((new TextComponentString("Set goal to ")).appendSibling((new TextComponentString(PyroStatic.field_2467.method_1212().toString())).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      return 0;
   }
}
