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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import org.jetbrains.annotations.NotNull;

public class f1Y implements Command {
   // $FF: renamed from: c dev.nuker.pyro.f1Y
   public static f1Y field_2447 = new f1Y();

   public int run(@NotNull CommandContext var1) {
      String var2 = StringArgumentType.getString(var1, "name");
      List var3 = StringsKt.split$default((CharSequence)var2, new String[]{" "}, false, 0, 6, (Object)null);
      if (var3 != null && var3.size() > 1) {
         if (FriendManager.Companion.isFriend((String)var3.get(0))) {
            ((f1s)var1.getSource()).method_3083((new TextComponentString("Already friend: ")).appendSibling((new TextComponentString((String)var3.get(0))).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
         } else {
            ((f1s)var1.getSource()).method_3083((new TextComponentString("Added friend: ")).appendSibling((new TextComponentString((String)var3.get(0))).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))).appendSibling((ITextComponent)(new TextComponentString(" with alias "))).appendSibling((new TextComponentString((String)var3.get(1))).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
            FriendManager.Companion.addFriend((String)var3.get(0), (String)var3.get(1));
         }
      } else if (FriendManager.Companion.isFriend(var2)) {
         ((f1s)var1.getSource()).method_3083((new TextComponentString("Already friend: ")).appendSibling((new TextComponentString(var2)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
      } else {
         ((f1s)var1.getSource()).method_3083((new TextComponentString("Added friend: ")).appendSibling((new TextComponentString(var2)).setStyle((new Style()).setColor(TextFormatting.DARK_AQUA))));
         FriendManager.Companion.addFriend(var2);
      }

      return 0;
   }
}
