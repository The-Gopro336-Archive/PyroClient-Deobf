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

public class f3E implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f3E
   public static f3E field_2040 = new f3E();

   public int run(CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "distance");
      fdZ.field_976.player.setPosition(fdZ.field_976.player.posX, fdZ.field_976.player.posY + (double)var2, fdZ.field_976.player.posZ);
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Teleported you " + var2 + " blocks in the air.")));
      return 0;
   }
}
