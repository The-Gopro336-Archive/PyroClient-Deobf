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

public class f3u implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3u
   public static f3u field_2173 = new f3u();

   public int run(CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "pitch");
      fdZ.field_976.player.rotationPitch = (float)var2;
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Set your pitch to " + var2)));
      return 0;
   }
}
