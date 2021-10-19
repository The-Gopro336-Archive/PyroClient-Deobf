/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f33 implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f33
   public static f33 field_2001 = new f33();

   public int run(@NotNull CommandContext var1) {
      Config.INSTANCE.chatPrefix = StringArgumentType.getString(var1, "prefix");
      Config.Companion.save();
      ((f1s)var1.getSource()).method_3083((new TextComponentString("Changed prefix to ")).appendSibling((new TextComponentString(Config.INSTANCE.chatPrefix)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      return 0;
   }
}
