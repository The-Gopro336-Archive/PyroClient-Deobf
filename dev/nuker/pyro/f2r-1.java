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

public class f2r implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2r
   public static f2r field_2103 = new f2r();

   public int run(CommandContext var1) {
      int var2 = IntegerArgumentType.getInteger(var1, "distance");
      double var3 = fec.method_1749();
      boolean var7 = false;
      double var5 = -Math.sin(var3) * (double)var2;
      boolean var9 = false;
      double var10 = Math.cos(var3) * (double)var2;
      fdZ.field_976.player.setPosition(fdZ.field_976.player.posX + var5, fdZ.field_976.player.posY, fdZ.field_976.player.posZ + var10);
      ((f1s)var1.getSource()).method_3083((ITextComponent)(new TextComponentString("Teleported you " + var2 + " blocks forward.")));
      return 0;
   }
}
