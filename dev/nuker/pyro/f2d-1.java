/**
 * Obfuscator: Binsecure  Decompiler: FernFlower
 * De-obfuscated by Gopro336
 */
package dev.nuker.pyro;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f2d implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f2d
   public static f2d field_2039 = new f2d();

   public int run(@NotNull CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      List var3 = StringsKt.split$default((CharSequence)var2, new String[]{" "}, false, 0, 6, (Object)null);
      if (var3 != null && var3.size() > 1 && FriendManager.Companion.setAlias((String)var3.get(0), (String)var3.get(1))) {
         ((f1s)var1.getSource()).method_3083((new TextComponentString("Set friend " + (String)var3.get(0) + " alias to: ")).appendSibling((new TextComponentString((String)var3.get(1))).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      }

      return 0;
   }
}
