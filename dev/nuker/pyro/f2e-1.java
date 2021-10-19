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

public class f2e implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2e
   public static f2e field_2047 = new f2e();

   public int run(@NotNull CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      if (FriendManager.Companion.isFriend(var2)) {
         ((f1s)var1.getSource()).method_3083((new TextComponentString("Removed friend: ")).appendSibling((new TextComponentString(var2)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
         FriendManager.Companion.removeFriend(var2);
      } else {
         ((f1s)var1.getSource()).method_3083((new TextComponentString("Not friend: ")).appendSibling((new TextComponentString(var2)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      }

      return 0;
   }
}
