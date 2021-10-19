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

public class f3G implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3G
   public static f3G field_2050 = new f3G();

   public int run(@NotNull CommandContext var1) {
      Config.INSTANCE.watermark = StringArgumentType.getString(var1, "watermark");
      Config.Companion.save();
      ((f1s)var1.getSource()).method_3083((new TextComponentString("Changed the watermark to ")).appendSibling((new TextComponentString(Config.INSTANCE.watermark)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      return 0;
   }
}
